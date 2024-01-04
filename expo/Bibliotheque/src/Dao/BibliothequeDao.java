package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import BDD.DbConnection;
import Metier.Bibliotheque;

public class BibliothequeDao implements dao<Bibliotheque> {
	//les attribut 
	//la conexion avec la base de donnes
		
	    private Connection connection = null;
	    
	 //les statement(les commande)
	     private Statement state = null;
	     private Bibliotheque bibliotheque = null;
	     private String requette = null;
	     
	 //les constructeur
	     public BibliothequeDao() {
	      try {
	    	connection = DbConnection.getConnection();
			state =  connection.createStatement();
			//affieche erreur sql
		} catch (SQLException e) {
			e.printStackTrace();
		}
	     }
	     
	@Override
	public Bibliotheque get(long id) {
	
		requette = "SELECT * FROM Bibliotheque WHERE IDbib =" +id;
		System.out.println(requette);
		
		//execute la requette 
		 
		try {
		ResultSet rs = state.executeQuery(requette);
		
		
		//afficher la resut
		if(rs.next()) 
			do {
				int Idbib = rs.getInt("Idbib");
				String Nom =  rs.getString("Nom");
			    String Emplacement =  rs.getString("Emplacement");
			   
			    
			    //4ou les donne jayin mn linstance
				bibliotheque = new Bibliotheque(Idbib , Nom , Emplacement);
				
				//4i linstance lhi najoutuhe v la liste
				
				//affichge dinstance
				System.out.println(bibliotheque.toString());
				
			}
			while(rs.next());
		else throw new SQLException();
		
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		return bibliotheque;
	
	}

	//methode select tt la table 
	public List<Bibliotheque> getAll() {
		ArrayList<Bibliotheque> arraylist = new ArrayList<>();
		requette = "SELECT * FROM Bibliotheque";
		System.out.println(requette);
		
		//execute la requette 
		 
		try {
		ResultSet rs = state.executeQuery(requette);
		
		
		//afficher la resut
		if(rs.next()) 
			do {
				int Idbib = rs.getInt("Idbib");
				String Nom =  rs.getString("Nom");
			    String Emplacement =  rs.getString("Emplacement");
			   
			    
			    //4ou les donne jayin mn linstance
				bibliotheque = new Bibliotheque(Idbib , Nom , Emplacement);
				
				//4i linstance lhi najoutuhe v la liste
				arraylist.add(bibliotheque);
				//affichge dinstance
				System.out.println(bibliotheque.toString());
				
			}
			while(rs.next());
		else throw new SQLException();
		
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		return arraylist;
	}
		
		
	

	@Override
	public void save(Bibliotheque t) {
	
		requette = "INSERT INTO Bibliotheque VALUES('" + t.getIdbib() +"','" + t.getNom() + "','" + t.getEmplacement() + "')";
		System.out.println(requette);
		
		try {
			int rs = state.executeUpdate(requette);
			if(rs>0)
				System.out.println("Bibliotheque enregistre");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Bibliotheque t, String[] params) {
		requette = "UPDATE Bibliotheque SET Nom =  '" +params[1]+"', Emplacement = '" +params[2]+"' WHERE Idbib = " + t.getIdbib() + "";
		System.out.println(requette);
		
		try {
			int rs = state.executeUpdate(requette);
			if(rs>0)
				System.out.println("modification reussie");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Bibliotheque t) {
		// TODO Auto-generated method stub
		requette = "DELETE FROM Bibliotheque WHERE Idbib =" + t.getIdbib();
		System.out.println(requette);
		
		try {
			int rs = state.executeUpdate(requette);
			if(rs>0)
				System.out.println("Bibliotheque supprimer");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	//main (execution du programme)
		public static void main(String[]args) {
			//BibliothequeDao bibliothequeDao = new BibliothequeDao();
			//Bibliotheque bib1 = new Bibliotheque(1, "Bibliotheque Nationale", "Nouakchott");
//	Bibliotheque biblioBoghe = new Bibliotheque(11, "Bibliotheque du Village", "Boghe");
//			Bibliotheque bib4 = new Bibliotheque(4, "Bibliotheque Communautaire", "Zouerate");
//			bibliothequeDao.update(bib1, new String[] {"Bibliotheque Centrale", "Nouakchott"});
//			bibliothequeDao.delete(bib4);
//	     	bibliothequeDao.get(1);
//			bibliothequeDao.save(biblioBoghe);
//		bibliothequeDao.getAll();
//	bibliothequeDao.delete(biblioBoghe);
			
			
			
			
			//
			System.out.println("Test get by id");
			new BibliothequeDao().get(1);
			System.out.println("Test get all");
			new BibliothequeDao().getAll();
			System.out.println("Test save = insert ");
			new BibliothequeDao().save(new Bibliotheque(12, "bib liu", "nktt"));
			System.out.println("Test get all");
			new BibliothequeDao().getAll();
			System.out.println("Test update");
			String[] params= {"12","bib fst","ndb"};
			new BibliothequeDao().update(new BibliothequeDao().get(12), params);
			System.out.println("Test get all");
			new BibliothequeDao().getAll();
			System.out.println("Test Suppression");
			new BibliothequeDao().delete(new BibliothequeDao().get(12));
			System.out.println("Test get all");
			new BibliothequeDao().getAll();
			
		}
}
