package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.training.ers.model.Reimbursements;
import com.training.ers.model.User;
import com.training.ers.model.manager;

import utility.DBConnection;

public class LoginDAOImpl implements LoginDAO {

	private static Logger logger = Logger.getLogger(LoginDAOImpl.class);
	Connection connection = DBConnection.getConnection();
	
	@Override
	public boolean register(User user) {
		System.out.println("##Adding user :" + user);
		PreparedStatement statement = null;
		int rows = 0;
		try {
			statement = connection.prepareStatement("insert into users values(default,?,?,?,?,?)");
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getGender());
			statement.setString(4, user.getNotifications());
			statement.setString(5, user.getQualification());

			rows = statement.executeUpdate();
			System.out.println(rows + " user registered successfully");
			logger.info(user.getUsername()+" has Signed up at :" + new java.util.Date());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rows == 0)
			return false;
		else
			return true;
	}
	
	@Override
	public boolean validate(String username, String password) {
		
		boolean userValid = false;
		PreparedStatement stat;
		try {
			stat = connection.prepareStatement("select * from users where username = ? and password = ? ");
			stat.setString(1, username);
			stat.setString(2, password);

			ResultSet res = stat.executeQuery();
			userValid = res.next();
			logger.info(username+" has logged on at :" + new java.util.Date());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userValid;
	}

	@Override
	public List<User> getUsers() {
		System.out.println("Printing all Users ");
		List<User> users = new ArrayList<User>();
		Statement stat;
		try {
			stat = connection.createStatement();
			ResultSet res = stat.executeQuery("select * from Users");
			while (res.next()) {
				User user = new User();
				user.setUserId(res.getInt(1));
				user.setUsername(res.getString(2));
				user.setPassword(res.getString(3));
				user.setGender(res.getString(4));
				user.setNotifications(res.getString(5));
				user.setQualification(res.getString(6));
				users.add(user);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;

	}

	@Override
	public List<User> getUsersByUserName(String username) {
		System.out.println("##Printing search users  ");
		List<User> users = new ArrayList<User>();

		Statement stat;
		try {
			stat = connection.createStatement();
			ResultSet res = stat.executeQuery("select * from users where username = '" + username + "'");
			while (res.next()) {
				User user = new User();
				user.setUserId(res.getInt(1));
				user.setUsername(res.getString(2));
				user.setPassword(res.getString(3));
				user.setGender(res.getString(4));
				user.setNotifications(res.getString(5));
				user.setQualification(res.getString(6));
				users.add(user);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	public ArrayList<Reimbursements> viewMyReiumbersements(String username, boolean isPending) {
		PreparedStatement stat = null;
		String SQL = "";
		if (isPending) {
			SQL = "select title, purpose, amount, status "
					+ " from reimbursements where username = ? and status = ?";
		} else {
			SQL = "select title, purpose, amount, status "
					+ " from reimbursements where username = ? and status != ?";
		}
		Connection conn = DBConnection.getConnection();
		ArrayList<Reimbursements> list = new ArrayList<Reimbursements>();
		try {
			if (conn != null) {
				stat = conn.prepareStatement(SQL);
				stat.setString(1, username);
				stat.setString(2, "Pending");
				ResultSet res = stat.executeQuery();
				while (res != null && res.next()) {
					String status = res.getString(1);
					String purpose = res.getString(2);
					Float amount = res.getFloat(3);
					Reimbursements reimb = new Reimbursements(username, status, purpose, amount);
					list.add(reimb);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if (stat != null)
					stat.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public void ApproveorDenyRequests(String managerId, String username, String approveOrDeny) {
		System.out.println("ApproveorDenyRequests : managerId: " + managerId + ", username:" + username 
				+  ",approveOrDeny:" + approveOrDeny);

		
		Connection conn = DBConnection.getConnection();
		try {
			PreparedStatement stat = null;
			ResultSet res = stat.executeQuery("update reimbursements " + "set status = ? " + "where username = ? "
					+ "and status = 'Pending' " + "and username in (" + "	select username "
					+ "	from users "  + ")");
		while(res.next()) {
			stat.setString(1, approveOrDeny);
		}
		
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void newRequest(String username, String purpose, float amount) {
		System.out.println("user request");
		PreparedStatement stat = null; 
		final String SQL =("insert into reimbursement values(default,?,?,?,?)" );
		Connection conn = DBConnection.getConnection();
		try {
			
			stat = conn.prepareStatement(SQL);
			
				stat.setString(1,username);
				stat.setString(2, purpose);
				stat.setFloat(3, amount);
				
				
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<Reimbursements> viewAllResolvedRequests(){
		System.out.println("Printing all Users ");
		ArrayList<Reimbursements> list = new ArrayList<Reimbursements>();
		Statement stat;
		try {
			stat = connection.createStatement();
			ResultSet res = stat.executeQuery("select * from reimbursements where status = ''");
			while (res.next()) {
				Reimbursements reimbursements = new Reimbursements(null, null, null, 0);
				String username = res.getString(1);
				String status = res.getString(2);
				String purpose = res.getString(3);
				Float amount = res.getFloat(4);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}