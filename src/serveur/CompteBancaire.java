package serveur;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CompteBancaire extends UnicastRemoteObject implements CompteBancaireInterface {

  private Personne proprietaire;
  private String numero;
  private String codeSecret;
  private double solde;

  public CompteBancaire(String nom, String prenom, String identifiant, String numero, String codeSecret, double solde) throws RemoteException {
    this.proprietaire = new Personne(nom, prenom, identifiant);
    this.numero = numero;
    this.codeSecret = codeSecret;
    this.solde = solde;
  }

  public boolean verification(String id, String cs) throws RemoteException {
    return this.codeSecret.equals(cs) && this.proprietaire.getIdentifiant().equals(id);
  }

  @Override
  public String retrait(String id, String cs, double montant) throws RemoteException {
    if (verification(id, cs)) {
      if (montant <= solde) {
        solde -= montant;
        return "Retrait effectué avec succès !!\nNouveau solde = " + solde + " DT";
      } else {
        return "Opération échouée !! Solde insuffisant !";
      }
    } else {
      return "Opération échouée !! Données d'identification incorrectes";
    }
  }

  @Override
  public String versement(double montant) throws RemoteException {
    solde += montant;
    return "Versement effectué avec succès !!\nNouveau solde = " + solde + " DT";
  }

  @Override
  public String virement(String id, String cs, double montant, String cbd) throws RemoteException {
    if (verification(id, cs)) {
      if (montant <= solde) {
        solde -= montant;
        try {
          CompteBancaireInterface CBI = (CompteBancaireInterface) Naming.lookup("rmi://localhost:1099/" + cbd);
          CBI.versement(montant);
          return "Virement effectué avec succès !!\nNouveau solde = " + solde + " DT";
        } catch (Exception e) {
          return "Opération échouée !! Numéro du compte destinataire incorrect !";
        }
      } else {
        return "Opération échouée !! Solde insuffisant !";
      }
    } else {
      return "Opération échouée !! Données d'identification incorrectes";
    }
  }

  @Override
  public String consultation(String id, String cs) throws RemoteException {
    if (verification(id, cs)) {
      return ("Votre solde est = " + this.solde + " DT");
    }
    return ("Opération échouée !! Données d'identification incorrects");

  }

}
