package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import BDD.DbConnection;
import Metier.Telephone;

public class TelephoneDao implements dao<Telephone> {
	
	//les attribut 
		//la conexion avec la base de donnes
			
		    private Connection connection = null;
		    
		 //les statement(les commande)
		     private Statement state = null;
		     private Telephone telephone = null;
		     private String requette = null;
		     
		 //les constructeur
		     public TelephoneDao() {
		      try {
		    	connection = DbConnection.getConnection();
				state =  connection.createStatement();
				//affieche erreur sql
			} catch (SQLException e) {
				e.printStackTrace();
			}
		     }

	
		    
		 	public Telephone get(long id) {
		    	//methode select tt la table 
					
					requette = "SELECT * FROM Telephone WHERE Numero = "+id;
					System.out.println(requette);
					
					//execute la requette 
					 
					try {
					ResultSet rs = state.executeQuery(requette);
					
					
					//afficher la resut
					if(rs.next()) 
						do {
							int Numero = rs.getInt("Numero");
							String Type =  rs.getString("Type");
							int IdAut =  rs.getInt("IdAut");
						    
						    //4ou les donne jayin mn linstance
							telephone = new Telephone(Numero , Type , IdAut );
							
							//4i linstance lhi najoutuhe v la liste
							
							//affichge dinstance
							System.out.println(telephone.toString());
							
						}
						while(rs.next());
					else throw new SQLException();
					
					} catch (SQLException e) {
					
						e.printStackTrace();
					}
					
					return telephone;
		 		
		 	}

	@Override
	public List<Telephone> getAll() {
		//methode select tt la table 
				ArrayList<Telephone> arraylist = new ArrayList<>();
				requette = "SELECT * FROM Telephone";
				System.out.println(requette);
				
				//execute la requette 
				 
				try {
				ResultSet rs = state.executeQuery(requette);
				
				
				//afficher la resut
				if(rs.next()) 
					do {
						int Numero = rs.getInt("Numero");
						String Type =  rs.getString("Type");
						int IdAut =  rs.getInt("IdAut");
					    
					    //4ou les donne jayin mn linstance
						telephone = new Telephone(Numero , Type , IdAut );
						
						//4i linstance lhi najoutuhe v la liste
						arraylist.add(telephone);
						//affichge dinstance
						System.out.println(telephone.toString());
						
					}
					while(rs.next());
				else throw new SQLException();
				
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
				
				return arraylist;
			}

	@Override

		public void save(Telephone t) {
			
			requette = "INSERT INTO Telephone VALUES('" + t.getNumero() +"','" + t.getType() + "','" + t.getIdAut() + "')";
			System.out.println(requette);
			
			try {
				int rs = state.executeUpdate(requette);
				if(rs>0)
					System.out.println("Telephone enregistre");
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		
	

	@Override
	public void update(Telephone t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Telephone t) {
		// TODO Auto-generated method stub
		
	}



	//main (execution du programme)
		public static void main(String[]args) {
			TelephoneDao telephone = new TelephoneDao();
		//	telephoneDao.getAll();
			//telephoneDao.get(111111);
			Telephone telephoneDao11 = new Telephone(111222,"voyages a travers le savoir",11);
			telephone.save(telephoneDao11);
			
		}
}
