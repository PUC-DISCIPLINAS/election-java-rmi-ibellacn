package lab_mob_dist;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Client {
    private static Election election = null;

    public static void main(String[] args) {
        String hashMd5 = md5Hashing("Isabella Carine");

        String servidor = "rmi://localhost/";
        String nome = "CalculadoraService";

        try {
            election = (Election) Naming.lookup(servidor + nome);
            System.out.println("Objeto remoto \'"+ nome + "\' encontrado no servidor.");

        } catch (MalformedURLException e) {
            System.out.println("URL \'" + servidor + nome + "\' mal formatada.");
        } catch (RemoteException e) {
            System.out.println("Erro na invocação remota.");
            e.printStackTrace();
        } catch (NotBoundException e) {
            System.out.println("Objeto remoto \'" + nome + "\' não está disponível.");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void vote(String elector, String candidate) throws RemoteException {
        election.vote(elector, candidate);
    }

    private void result(String candidate) throws RemoteException {
        System.out.println(election.result(candidate));
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
