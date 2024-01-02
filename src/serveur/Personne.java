package serveur;

public class Personne {

  private String nom;
  private String prenom;
  private String identifiant;

  public Personne(String nom, String prenom, String identifiant) {
    this.nom = nom;
    this.prenom = prenom;
    this.identifiant = identifiant;
  }

  public String getIdentifiant() {
    return identifiant;
  }
}
