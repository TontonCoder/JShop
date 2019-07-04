package db;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Customer;
import tools.Ln;

public class CustomerRepository {
	
	private JShopDB db;
	
	public CustomerRepository()
	{
		db = new JShopDB();
	}
	
	public ArrayList<Customer> getCustomers()
	{
		ArrayList<Customer> customers = new ArrayList<Customer>();
	    String sql = "SELECT * FROM Customer";
	        
	        try 
	        {
	        	Connection conn = db.getConnection();
	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery(sql);
	            
	            
	            // loop through the result set
	            while (rs.next()) 
	            {
	                Ln.s(rs.getInt("Id") +  "\t" + 
	                                   rs.getString("firstName") + "\t" +
	                                   rs.getString("lastName"));
	                Customer c = new Customer(rs.getString("firstName"), rs.getString("lastName"));
	                customers.add(c);
	            }
	        } 
	        catch (SQLException e) 
	        {
	            System.out.println(e.getMessage());
	        }
		
		return customers;
	}
	
	public void insertCustomer(Customer c)
	{
		
	}
	public void getCustomer(int id)
	{
		
	}
	public void updateCustomer(Customer c)
	{
		
	}
	public void deleteCustomer(int id)
	{
		
	}
	public void closeDB()
	{
		db.Close();
	}
	
	public static void main(String[] args)
	{
		CustomerRepository cr = new CustomerRepository();
		ArrayList<Customer> cs = cr.getCustomers();
	}

}

