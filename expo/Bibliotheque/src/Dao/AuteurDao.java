package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import BDD.DbConnection;
import Metier.Auteur;

public class AuteurDao implements dao<Auteur> {
	
//les attribut 
//la conexion avec la base de donnes
	
    private Connection connection = null;
    
 //les statement(les commande)
     private Statement state = null;
     private Auteur auteur = null;
     private String requette = null;
     
 //les constructeur
     public AuteurDao() {
      try {
    	connection = DbConnection.getConnection();
		state =  connection.createStatement();
		//affieche erreur sql
	} catch (SQLException e) {
		e.printStackTrace();
	}
     }
     
//les methodes crud

	public Auteur get(long id) {
		
		requette = "SELECT * FROM Auteur where IdAut = " + id;
		System.out.println(requette);
		
		//execute la requette 
		 
		try {
		ResultSet rs = state.executeQuery(requette);
		
		
		//afficher la resut
		if(rs.next()) 
			do {
				int IdAut = rs.getInt("IdAut");
				String Prenom =  rs.getString("Prenom");
				String Nom =  rs.getString("Nom");
			    String Adresse =  rs.getString("Adresse");
			    String Region =  rs.getString("Region");
			    
			    //4ou les donne jayin mn linstance
				auteur = new Auteur(IdAut , Prenom , Nom , Adresse , Region);
				
				//4i linstance lhi najoutuhe v la liste
				
				//affichge dinstance
				System.out.println(auteur.toString());
				
			}
			while(rs.next());
		else throw new SQLException();
		
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		return auteur;
	}
	
	
//methode select tt la table 
	public List<Auteur> getAll() {
		ArrayList<Auteur> arraylist = new ArrayList<>();
		requette = "SELECT * FROM Auteur";
		System.out.println(requette);
		
		//execute la requette 
		 
		try {
		ResultSet rs = state.executeQuery(requette);
		
		
		//afficher la resut
		if(rs.next()) 
			do {
				int IdAut = rs.getInt("IdAut");
				String Prenom =  rs.getString("Prenom");
				String Nom =  rs.getString("Nom");
			    String Adresse =  rs.getString("Adresse");
			    String Region =  rs.getString("Region");
			    
			    //4ou les donne jayin mn linstance
				auteur = new Auteur(IdAut , Prenom , Nom , Adresse , Region);
				
				//4i linstance lhi najoutuhe v la liste
				arraylist.add(auteur);
				//affichge dinstance
				System.out.println(auteur.toString());
				
			}
			while(rs.next());
		else throw new SQLException();
		
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		return arraylist;
	}

	@Override
	public void save(Auteur t) {
		requette = "INSERT INTO Auteur VALUES('" + t.getIdAut() +"','" + t.getPrenom() + "','" + t.getNom() + "','" + t.getAdresse() + "','" + t.getRegion() + "')";
		System.out.println(requette);
		
		try {
			int rs = state.executeUpdate(requette);
			if(rs>0)
				System.out.println("Auteur enregistre");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Auteur t, String[] params) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void delete(Auteur t) {
		// TODO Auto-generated method stub
		
	}
	

//main (execution du programme)
	public static void main(String[]args) {
		AuteurDao auteurDao = new AuteurDao();
//		auteur autHassan = new Auteur (11, "Hassan","MEd","Rue des livres, Boghe","Trarza");
//		auteurDao.save(autHassan);
//		auteurDao.get(3);
//		auteurDao.getAll();
		
	}
}
