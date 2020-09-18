package CRUD.SpringBoot.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DAO {
	String driver = "com.mysql.jdbc.Driver";
	String connectionUrl = "jdbc:mysql://localhost:3306/project1";
	
	private String userid = "root";
	private String password = "root";
	
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	public void connect() throws SQLException {
		try {
			Class.forName(driver);
			} catch (ClassNotFoundException e) {
			e.printStackTrace();
			}
		connection = DriverManager.getConnection(connectionUrl, userid, password);
		statement=connection.createStatement();
	}

	
	public boolean check(String username, String password2) throws SQLException {
		// TODO Auto-generated method stub
		connect();
		String sql = "SELECT * from project1.admin where username='"+username.trim()+"' and password='"+password2.trim()+"';";
		//System.out.println(sql);
		resultSet = statement.executeQuery(sql);
		//System.out.println(resultSet);
		while(resultSet.next()) {
			//System.out.println("Inside while");
			//System.out.println(resultSet.getString("username")+" "+resultSet.getString("password"));
			return true;
		}
		return false;
	}
	public ArrayList<ArrayList<String>> getData() throws SQLException{
		 connect();
		 ArrayList<ArrayList<String>> arr=new ArrayList<ArrayList<String>>();
		 ArrayList<String> ei=new ArrayList<String>();
		 ArrayList<String> en=new ArrayList<String>();
		 ArrayList<String> des=new ArrayList<String>();
		 ArrayList<String> sal=new ArrayList<String>();
		 String sql ="select * from employee";
		//System.out.println(sql);
		resultSet = statement.executeQuery(sql);
			
		while(resultSet.next()){
			ei.add(Integer.toString(resultSet.getInt("employeeid")));
			en.add(resultSet.getString("employeename"));
			des.add(resultSet.getString("designation"));
			sal.add(Double.toString(resultSet.getDouble("salary")));
			}
		arr.add(ei);
		arr.add(en);
		arr.add(des);
		arr.add(sal);
		return arr;
		}


	public void add(int employeeid, String employeename, String designation, double salary) throws SQLException {
		// TODO Auto-generated method stub
		connect();
		String sql = "insert into employee values("+employeeid+",'"+employeename+"','"+designation+"',"+salary+");";
		statement.execute(sql);
	}


	public void delete(int employeeid) throws SQLException {
		// TODO Auto-generated method stub
		connect();
		String sql = "delete from employee where employeeid="+employeeid+";";
		statement.execute(sql);
	}


	public void update(int employeeid, String employeename, String designation, double salary) throws SQLException {
		// TODO Auto-generated method stub
		connect();
		if(employeename.trim().isEmpty()==false) {
			String sql = "update employee set employeename='"+employeename+"' where employeeid="+employeeid+";";
			statement.execute(sql);
		}
		if(designation.trim().isEmpty()==false) {
			String sql = "update employee set designation='"+designation+"' where employeeid="+employeeid+";";
			statement.execute(sql);
		}
		if(salary!=0.0) {
			String sql = "update employee set salary="+salary+" where employeeid="+employeeid+";";
			statement.execute(sql);
		}
	}
}
