import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class Repository {

	ArrayList<Employee> employees = new ArrayList<>();
	
	final static String connectionString = "jdbc:mysql://localhost:3306/Company";
	static Connection con;
	
public String getResultFromDB(String query) {
		
		try {
			Statement stmt = getStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			rs.next();
			String result = rs.getString(1);
			con.close();
			return result;
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public void showEmployeesDB() {
		
		try {
			Statement stmt = getStatement();
			String query = "SELECT * FROM employees";
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				int employeeId = rs.getInt(1);
				String personalCode = rs.getString(2);
				String firstName = rs.getString(3);
				String lastName = rs.getString(4);
				String position = rs.getString(5);
				String department = rs.getString(6);
				double salary = rs.getDouble(7);
				
				System.out.println(employeeId +  ". " 
							+ personalCode + ", " + firstName + ", " 
							+ lastName + ", " + position + ", " 
							+ department + ", " + salary + " eur/mon");
			}
			//butina uzdaryti
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void workWithEmployeesDB(String query) {
		try {
			
			Statement stmt = getStatement();
			
			int result = stmt.executeUpdate(query);
			System.out.println("Affected " + result + " rows");
			
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Statement getStatement () throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
				
		con = DriverManager.getConnection(connectionString, "root", "password");
				
		return con.createStatement();
	}
	
}
