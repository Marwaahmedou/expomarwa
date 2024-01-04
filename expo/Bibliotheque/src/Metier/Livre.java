package Metier;

public class Livre {
	
//les donnes
	private int ISBN;
	private String Titre;
	private int IdAut;
	

//constructeur	
	public Livre() {}
	public Livre(int iSBN, String titre, int IdAut) {
		super();
		this.ISBN = iSBN;
		this.Titre = titre;
		this.IdAut = IdAut;
	}

//getters setters
	public int getISBN() {
		return ISBN;
	}


	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}


	public String getTitre() {
		return Titre;
	}


	public void setTitre(String titre) {
		Titre = titre;
	}
	


public int getIdAut() {
		return IdAut;
	}

	public void setIdAut(int idAut) {
		IdAut = idAut;
	}

	//tostring
	@Override
	public String toString() {
		return "Livre [ISBN=" + ISBN + ", Titre=" + Titre + ", IdAut=" + IdAut + "]";
	}

	
	

}
