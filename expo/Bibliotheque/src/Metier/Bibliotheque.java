package Metier;

public class Bibliotheque { 
	
//les donnes 
	private int Idbib;
	private String Nom;
	private String Emplacement ;

//constructeur
	
	public Bibliotheque(int Idbib, String nom, String Emplacement) {
		super();
		this.Idbib = Idbib;
		this.Nom = nom;
		this.Emplacement = Emplacement;
	}

public Bibliotheque() {
}

//getters setters
	public int getIdbib() {
		return Idbib;
	}


	public void setIdbib(int idbib) {
		Idbib = idbib;
	}


	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getEmplacement() {
		return Emplacement;
	}


	public void setEmplacement(String emplacement) {
		Emplacement = emplacement;
	}


//tostring
	public String toString() {
		return "Bibliotheque [Idbib=" + Idbib + ",Nom=" + Nom + ", Emplacement=" + Emplacement + "]";
	}
	
}
