import java.util.List;

public interface Election extends java.rmi.Remote{
    public void vote(String elector, String candidate) throws java.rmi.RemoteException;

    public String result(String candidate) throws java.rmi.RemoteException;

    public List<Candidate> listCandidates() throws java.rmi.RemoteException;
}
