package Metier;

public class Auteur {
	
//les donnes 
   private int IdAut ;
   private String Prenom;
   private String Nom;
   private String Adresse ;
   private String Region;
   
//constructeur
   public Auteur() {}
public Auteur(int idAut, String prenom, String nom, String adresse, String region) {
	super();
    this.IdAut = idAut;
    this.Prenom = prenom;
    this.Nom = nom;
    this.Adresse = adresse;
    this.Region = region;
   
}

//getters setters
    public int getIdAut() {
	  return IdAut;
}
    public void setIdAut(int idAut) {
	   IdAut = idAut;
}
    
    public String getPrenom() {
		return Prenom;
}

	public void setPrenom(String prenom) {
		Prenom = prenom;
}

	public String getNom() {
	   return Nom;
}
    public void setNom(String nom) {
	   Nom = nom;
}
    public String getAdresse() {
	   return Adresse;
}
    public void setAdresse(String adresse) {
	   Adresse = adresse;
}
    public String getRegion() {
	   return Region;
}
    public void setRegion(String region) {
	   Region = region;
}
    

//tostring
public String toString() {
	return "Auteur [IdAut=" + IdAut + ", Prenom=" + Prenom + ", Nom=" + Nom + ", Adresse=" + Adresse + ", Region=" + Region + "]";
}


}
