package serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CompteBancaireInterface extends Remote {

  public String retrait(String id, String cs, double montant) throws RemoteException;

  public String versement(double montant) throws RemoteException;

  public String virement(String id, String cs, double montant, String cbd) throws RemoteException;

  public String consultation(String id, String cs) throws RemoteException;
}
