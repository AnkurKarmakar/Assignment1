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

}
