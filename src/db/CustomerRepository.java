package db;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Customer;
import tools.Ln;

public class CustomerRepository 
{
	
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
            
            while (rs.next()) 
            {
                Ln.s(rs.getInt("Id") +" - " + rs.getString("firstName") + " - " + rs.getString("lastName"));
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
		String sql = "INSERT INTO Customer(firstName,lastName) VALUES(?, ?)";
		try
		{
			Connection conn = db.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, c.getFirstName());
            pstmt.setString(2, c.getLastName());
            pstmt.executeUpdate();
        } 
		catch (SQLException e) 
		{
            System.out.println(e.getMessage());
        }
	}
	public Customer getCustomer(int id)
	{
		Customer c = null;
		//Todo: Implements getting Customer by Id statement
		return c;
		
	}
	public void updateCustomer(Customer c)
	{
		//Todo: Implements update statement
	}
	public void deleteCustomer(int id)
	{
		//Todo: Implements delete statement
	}
	public void closeDB()
	{
		db.Close();
	}
	
	public static void main(String[] args)
	{
		CustomerRepository cr = new CustomerRepository();
		Customer c = new Customer("Robberto", "Denirou");
		cr.insertCustomer(c);
		ArrayList<Customer> cs = cr.getCustomers();
		cr.closeDB();
	}

}

