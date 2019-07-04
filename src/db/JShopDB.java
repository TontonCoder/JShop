package db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;



public class JShopDB {
	
	private String url = "jdbc:sqlite:C:/sqlite/db/test.db";
	private Connection conn;
	
	public JShopDB()
	{
		Init();
	}
	
	public Connection getConnection()
	{
		return this.conn;
	}
	
    private void Init() {
  
        try {
        	conn = DriverManager.getConnection(url);
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());                
            }
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void Close()
    {
    	try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


}
