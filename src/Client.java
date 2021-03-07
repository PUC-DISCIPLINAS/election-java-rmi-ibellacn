import java.math.BigInteger;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Client {
    private static Election election = null;

    public static void main(String[] args) {

        try {
            System.setProperty("java.rmi.server.hostname", "localhost");
            System.setProperty("java.security.policy", "rmi.policy");
            election = (Election) Naming.lookup("rmi://localhost/ElectionServant");
            System.out.println("Remote object ElectionServant has been found in the server.");

            int candidate = 0;
            Scanner scanner = new Scanner(System.in);

            while (true){
                System.out.println("Write the number of the desired option: 1 - List candidates | 2 - Vote | 3 - Result " +
                        "| 4 - Exit ");
                int menu = scanner.nextInt();

                switch (menu){
                    case 1:
                        listCandidates();
                        break;
                    case 2:
                        System.out.println("Inform your candidate number: ");
                        candidate = scanner.nextInt();

                        System.out.println("Inform your name: ");
                        String name = scanner.nextLine();

                        vote(md5Hashing(name), String.valueOf(candidate));
                    case 3:
                        System.out.println("Inform the number of the candidate you want to check: ");
                        candidate = scanner.nextInt();
                        result(String.valueOf(candidate));
                    case 4:
                        System.exit(0);
                }
            }

        } catch (MalformedURLException e) {
            System.out.println("URL mal formatada.");
        } catch (RemoteException e) {
            System.out.println("Erro na invocação remota.");
            e.printStackTrace();
        } catch (NotBoundException e) {
            System.out.println("Remote object is not available.");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void vote(String elector, String candidate) throws RemoteException {
        election.vote(elector, candidate);
    }

    private static void result(String candidate) throws RemoteException {
        System.out.println(election.result(candidate));
    }

    private static void listCandidates() throws RemoteException {
        System.out.println(election.listCandidates().toString());
    }

    private static String md5Hashing(String name){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(name.getBytes());
            byte[] md5 = md.digest();

            BigInteger numMd5 = new BigInteger(1, md5);
            return String.format("%022x", numMd5);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
