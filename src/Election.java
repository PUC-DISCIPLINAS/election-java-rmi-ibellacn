import java.util.List;

public interface Election extends java.rmi.Remote{
    public String vote(String elector, String candidate) throws java.rmi.RemoteException;

    public String result(String candidate) throws java.rmi.RemoteException;

    public String listCandidates() throws java.rmi.RemoteException;
}
