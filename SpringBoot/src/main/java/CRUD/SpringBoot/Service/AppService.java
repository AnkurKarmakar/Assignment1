package CRUD.SpringBoot.Service;

import java.sql.SQLException;
import java.util.ArrayList;

import CRUD.SpringBoot.DAO.DAO;

public class AppService {

	public boolean authenticate(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		DAO ob = new DAO();
		if (ob.check(username,password) == true)
			return true;
		else
			return false;
	}
	public ArrayList<ArrayList<String>> getDataService() throws SQLException{
		return (new DAO()).getData();
	}
	public void add(int employeeid, String employeename, String designation, double salary) throws SQLException {
		// TODO Auto-generated method stub
		(new DAO()).add(employeeid,employeename,designation,salary);
	}
	public void delete(int employeeid) throws SQLException {
		// TODO Auto-generated method stub
		(new DAO()).delete(employeeid);
	}
	public void update(int employeeid, String employeename, String designation, double salary) throws SQLException {
		// TODO Auto-generated method stub
		(new DAO()).update(employeeid,employeename,designation,salary);
	}
	public ArrayList<ArrayList<String>> getDBADataService() throws SQLException {
		// TODO Auto-generated method stub
		return (new DAO()).getDBAData();
	}
	public void addDBA(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		(new DAO()).addDBA(username,password);
		
	}
	public void deleteDBA(String username) throws SQLException {
		// TODO Auto-generated method stub
		(new DAO()).deleteDBA(username);
	}

}
