package lab_mob_dist;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class ElectionServant extends java.rmi.server.UnicastRemoteObject implements Election{
    private static List<Candidate> candidates = new ArrayList<>();

    public ElectionServant() throws RemoteException {
        super();
    }

    private static void readFile(String path) throws IOException {
        readFile("./senadores.csv");
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
        Candidate candidate = (Candidate) candidates.stream().filter(c -> c.getId().equals(id));
        candidate.setVotesNumber(candidate.getVotesNumber() + 1);
    }

    @Override
    public String result(String id) throws RemoteException {
        Candidate candidate = (Candidate) candidates.stream().filter(c -> c.getId().equals(id));
        return candidate.toString();
    }
}
