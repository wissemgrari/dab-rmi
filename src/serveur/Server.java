package serveur;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

public class Server {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Scanner sc1 = new Scanner(System.in);

    String choix;

    try {
      // On lance l'annuaire des objets distants
      LocateRegistry.createRegistry(1099);

      System.out.println("******* Serveur de compte Bancaire *******\n\n +++++ Saisie des comptes bancaires +++++");

      do {
        // On demande les informations du compte
        System.out.print("Donnez le numéro du compte : ");
        String num = sc.nextLine();
        System.out.print("Donnez le nom du propriétaire : ");
        String n = sc.nextLine();
        System.out.print("Donnez le prénom du propriétaire : ");
        String p = sc.nextLine();
        System.out.print("Donnez l'identifiant du propriétaire : ");
        String id = sc.nextLine();
        System.out.print("Donnez le code secret du compte : ");
        String cs = sc.nextLine();
        System.out.print("Donnez le solde du compte : ");
        double s = sc1.nextDouble();

        // On crée le compte bancaire
        CompteBancaire compte = new CompteBancaire(n, p, id, num, cs, s);

        // On enregistre le compte dans l'annuaire
        Naming.rebind(num, compte);

        // On demande si l'utilisateur veut saisir un nouveau compte
        System.out.print("Voulez-vous saisir un nouveau compte (o/n) ? ");
        choix = sc.nextLine();
      } while (choix.equals("o"));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
