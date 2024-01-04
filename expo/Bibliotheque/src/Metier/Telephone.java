package Metier;
public class Telephone {
	
//les donnes
private int Numero;
private String Type;
private int IdAut;

//constructeur
public Telephone() {}
public Telephone(int numero, String type, int IdAut) {
	super();
	this.Numero = numero;
	this.Type = type;
	this.IdAut = IdAut;
}

//getters setters
public int getNumero() {
	return Numero;
}


public void setNumero(int numero) {
	Numero = numero;
}


public String getType() {
	return Type;
}


public void setType(String type) {
	Type = type;
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
	return "Telephone [Numero=" + Numero + ", Type=" + Type + ", IdAut=" + IdAut + "]";
}




}