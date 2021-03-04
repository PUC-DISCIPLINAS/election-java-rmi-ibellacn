package lab_mob_dist;

public interface Election extends java.rmi.Remote{
    public void vote(String elector, String candidate) throws java.rmi.RemoteException;

    public String result(String candidate) throws java.rmi.RemoteException;
}
