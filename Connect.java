package main1;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

	
		public class Connect {
		     
		    public static void connect() {
		        Connection conn = null;
		        try {
		           
		            String url = "jdbc:sqlite:C:\\sqlite3\\movies.db";
		           
		            conn = DriverManager.getConnection(url);
		            Statement st = conn.createStatement();
		            ResultSet rs = st.executeQuery("select * from movie");
		            
		            while ( rs.next()){
		            	String mn = rs.getString("moviename");
		            	String hn = rs.getString("hero");
		            	String hen = rs.getString("heroine");
		            	int date = rs.getInt("releasedate");
		            	String d = rs.getString("director");
		            	System.out.println(mn + "  " + hn + "  " + hen + "  " + date + "  " + d );
		            	
		            	
		            }
		            Statement st1 = conn.createStatement();
		            ResultSet rs1 = st1.executeQuery("select moviename from movie where hero = 'NTR'");
		            
		            while ( rs1.next()){
		            	String mn = rs1.getString("moviename");
		            	System.out.println(mn  );
		            }
		    
		       
		            
		        
		        }
		        catch (SQLException e) {
		            System.out.println(e.getMessage());
		        }
		        finally {
		            try {
		                if (conn != null) {
		                    conn.close();  
		                }
		                
		            }
		             catch (SQLException ex) {
		                System.out.println(ex.getMessage());
		            }
		        }
		    }
		
		   
		    public static void main(String[] args) {
		        connect();
		    }
		
	}
