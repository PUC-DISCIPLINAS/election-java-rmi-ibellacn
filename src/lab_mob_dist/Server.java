package lab_mob_dist;

import java.rmi.Naming;
import java.rmi.RemoteException;

public class Server {
    public Server() {
        try {
            Election election = new ElectionServant();
            Naming.rebind("rmi://localhost/ElectionService", election);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) throws RemoteException {
        new ElectionServant();
        System.out.println("Servidor Calculadora em execução.");
    }
}
