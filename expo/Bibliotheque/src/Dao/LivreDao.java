package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import BDD.DbConnection;
import Metier.Livre;

public class LivreDao implements dao<Livre> {
	//les attribut 
	//la conexion avec la base de donnes
		
	    private Connection connection = null;
	    
	 //les statement(les commande)
	     private Statement state = null;
	     private Livre livre = null;
	     private String requette = null;
	     
	 //les constructeur
	     public LivreDao() {
	      try {
	    	connection = DbConnection.getConnection();
			state =  connection.createStatement();
			//affieche erreur sql
		} catch (SQLException e) {
			e.printStackTrace();
		}
	     }

	@Override
	public Livre get(long id) {
		//methode select tt la table 
		requette = "SELECT * FROM Livre WHERE ISBN =" + id;
		System.out.println(requette);
		
		//execute la requette 
		 
		try {
		ResultSet rs = state.executeQuery(requette);
		
		
		//afficher la resut
		if(rs.next()) 
			do {
				int ISBN = rs.getInt("ISBN");
				String Titre =  rs.getString("Titre");
				int IdAut =  rs.getInt("IdAut");
			    
			    //4ou les donne jayin mn linstance
				livre = new Livre(ISBN , Titre , IdAut );
				
				//4i linstance lhi najoutuhe v la liste
				
				//affichge dinstance
				System.out.println(livre.toString());
				
			}
			while(rs.next());
		else throw new SQLException();
		
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		return livre;
		
	}

	@Override
	public List<Livre> getAll() {
		//methode select tt la table 
			ArrayList<Livre> arraylist = new ArrayList<>();
			requette = "SELECT * FROM Livre";
			System.out.println(requette);
			
			//execute la requette 
			 
			try {
			ResultSet rs = state.executeQuery(requette);
			
			
			//afficher la resut
			if(rs.next()) 
				do {
					int ISBN = rs.getInt("ISBN");
					String Titre =  rs.getString("Titre");
					int IdAut =  rs.getInt("IdAut");
				    
				    //4ou les donne jayin mn linstance
					livre = new Livre(ISBN , Titre , IdAut );
					
					//4i linstance lhi najoutuhe v la liste
					arraylist.add(livre);
					//affichge dinstance
					System.out.println(livre.toString());
					
				}
				while(rs.next()); 
			else throw new SQLException();
			
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
			
			return arraylist;
		}

	

	@Override
	
		public void save(Livre t) {
			
			requette = "INSERT INTO Livre VALUES('" + t.getISBN() +"','" + t.getTitre() + "','" + t.getIdAut() + "')";
			System.out.println(requette);
			
			try {
				int rs = state.executeUpdate(requette);
				if(rs>0)
					System.out.println("Livre enregistre");
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		
	

	@Override
	public void update(Livre t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Livre t) {
		// TODO Auto-generated method stub
		
	}
	
	//main (execution du programme)
		public static void main(String[]args) {
			LivreDao livre = new LivreDao();
			livre.getAll();
			livre.get(901234);
		//	Livre livreDao11 = new Livre(111222,"voyages a travers le savoir",11);
		//	livre.save(livreDao11);
		}

}
