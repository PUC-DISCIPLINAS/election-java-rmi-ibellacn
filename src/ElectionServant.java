import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ElectionServant extends java.rmi.server.UnicastRemoteObject implements Election{
    private static final long serialVersionUID = 1L;
    private static List<Candidate> candidates = new ArrayList<>();
    private Set<String> voters = new HashSet<>();

    public ElectionServant() throws IOException {
        super();
        readFile("../senadores.csv");
    }

    private static void readFile(String path) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String line = "";
        while (true) {
            line = buffRead.readLine();

            if (line != null) {
                String[] data = line.split(";");
                candidates.add(new Candidate(data[0], data[1], data[2]));
            }else {
                break;
            }
        }
        buffRead.close();
    }

    @Override
    public void vote(String elector, String id) throws RemoteException {
        if(!voters.contains(elector)){
            for(Candidate candidate : candidates) {
                if (candidate.getId().equals(id)) {
                    candidate.setVotesNumber(candidate.getVotesNumber() + 1);
                    voters.add(elector);
                    return;
                }
            }
        }
        System.out.println("You already have voted!");
    }

    @Override
    public String result(String id) throws RemoteException {
        Candidate candidate = (Candidate) candidates.stream().filter(c -> c.getId().equals(id));
        return candidate.toString();
    }

    @Override
    public List<Candidate> listCandidates() throws RemoteException {
        return candidates;
    }
}
