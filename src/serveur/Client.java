package serveur;

import java.rmi.Naming;
import java.util.Scanner;

public class Client {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Scanner sc1 = new Scanner(System.in);

    String num, num1, choix, id, cs;
    double m;

    System.out.print("Donnez votre numéro de compte bancaire : ");
    num = sc.nextLine();
    System.out.print("Donnez votre identifiant : ");
    id = sc.nextLine();
    System.out.print("Donnez le code secret de votre compte bancaire : ");
    cs = sc.nextLine();

    try {
      CompteBancaireInterface CB = (CompteBancaireInterface) Naming.lookup("rmi://localhost:1099/" + num);

      do {
        System.out.println("******** Menu de gestion du compte ********");
        System.out.println("1 : Consultation");
        System.out.println("2 : Retrait");
        System.out.println("3 : Versement");
        System.out.println("4 : Virement");
        System.out.println("5 : Quitter");
        System.out.print("Donnez votre choix : ");
        choix = sc.nextLine();

        switch (choix) {
          case "1":
            System.out.println(CB.consultation(id, cs));
            break;
          case "2":
            System.out.print("Donnez le montant à retirer : ");
            m = sc1.nextDouble();
            System.out.println(CB.retrait(id, cs, m));
            break;
          case "3":
            System.out.print("Donnez le montant à verser : ");
            m = sc1.nextDouble();
            System.out.println(CB.versement(m));
            break;
          case "4":
            System.out.print("Donnez le numéro du compte bancaire destinataire : ");
            num1 = sc.nextLine();
            System.out.print("Donnez le montant : ");
            m = sc1.nextDouble();
            System.out.println(CB.virement(id, cs, m, num1));
            break;
          case "5":
            System.out.println("Au revoir");
            break;
          default:
            System.out.println("Choix incorrect !");
            break;
        }
      } while (!choix.equals("5"));
    } catch (Exception e) {
      System.out.println("Numéro de compte incorrect !");
    }
  }
}
