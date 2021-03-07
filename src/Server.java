import java.io.IOException;
import java.rmi.Naming;

public class Server {
    public Server() {
        try {
            Election election = new ElectionServant();
            Naming.rebind("rmi://localhost/ElectionServant", election);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) throws IOException {
        new Server();
        System.out.println("The server is running.");
    }
}
