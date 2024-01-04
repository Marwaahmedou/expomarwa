package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import BDD.DbConnection;
import Metier.Associer;

public class AssocierDao implements dao<Associer> {
	//les attribut 
	//la conexion avec la base de donnes
		
	    private Connection connection = null;
	    
	 //les statement(les commande)
	     private Statement state = null;
	     private Associer associer = null;
	     private String requette = null;
	     
	 //les constructeur
	     public AssocierDao() {
	      try {
	    	connection = DbConnection.getConnection();
			state =  connection.createStatement();
			//affieche erreur sql
		} catch (SQLException e) {
			e.printStackTrace();
		}
	     }

	
	public Associer get(int Idbib, int IdAut) {
		
		requette = "SELECT * FROM Associer WHERE Idbib = '" + Idbib + "' and IdAut = '" + IdAut +"'";
		System.out.println(requette);
		
		//execute la requette 
		 
		try {
		ResultSet rs = state.executeQuery(requette);
		
		
		//afficher la resut
		if(rs.next()) 
			do {
				int Idbib1 =  rs.getInt("Idbib");
				int IdAut1 = rs.getInt("IdAut");
				
			    
			    //4ou les donne jayin mn linstance
				associer = new Associer(Idbib1 , IdAut1);
				
				//4i linstance lhi najoutuhe v la liste
				
				//affichge dinstance
				System.out.println(associer.toString());
				
			}
			while(rs.next());
		else throw new SQLException();
		
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		return associer;
	}

	
	

	//methode select tt la table 
		public List<Associer> getAll() {
			ArrayList<Associer> arraylist = new ArrayList<>();
			requette = "SELECT * FROM Associer";
			System.out.println(requette);
			
			//execute la requette 
			 
			try {
			ResultSet rs = state.executeQuery(requette);
			
			
			//afficher la resut
			if(rs.next()) 
				do {
					int Idbib =  rs.getInt("Idbib");
					int IdAut = rs.getInt("IdAut");
					
				    
				    //4ou les donne jayin mn linstance
					associer = new Associer(Idbib , IdAut);
					
					//4i linstance lhi najoutuhe v la liste
					arraylist.add(associer);
					//affichge dinstance
					System.out.println(associer.toString());
					
				}
				while(rs.next());
			else throw new SQLException();
			
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
			
			return arraylist;
		}
	

	@Override
	public void save(Associer t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Associer t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Associer t) {
		requette = "INSERT INTO Associer VALUES('" + t.getIdbib() +"','" + t.getIdAut() + "')";
		System.out.println(requette);
		
		try {
			int rs = state.executeUpdate(requette);
			if(rs>0)
				System.out.println("Associer enregistre");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	//main (execution du programme)
		public static void main(String[]args) {
			AssocierDao associerDao = new AssocierDao();
			
			//Associer assoc11 = new Associer(11,11);
			//associerDao.save(assoc11);
			//associerDao.get(7,5);
			//associerDao.getAll();
			
		}


	@Override
	public Associer get(long id) {
		
		return null;
	}

}
