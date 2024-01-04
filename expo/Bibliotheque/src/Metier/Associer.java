package Metier;

public class Associer {
//les donnees
    private int Idbib;
    private int IdAut;
    
//constructeur
 public Associer() {}
    
public Associer(int idbib, int idAut) {
	super();
	this.Idbib = idbib;
	this.IdAut = idAut;
}

//getters setters
public int getIdbib() {
	return Idbib;
}
public void setIdbib(int idbib) {
	Idbib = idbib;
}
public int getIdAut() {
	return IdAut;
}

public void setIdAut(int idAut) {
	IdAut = idAut;
}
 
//tostring
public String toString() {
	return "Associer [Idbib=" + Idbib + ", IdAut=" + IdAut + "]";
}

}
