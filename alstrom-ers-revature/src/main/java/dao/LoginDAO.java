package dao;



import java.util.ArrayList;
import java.util.List;

import com.training.ers.model.User;
import com.training.ers.model.manager;
import com.training.ers.model.Reimbursements;


public interface LoginDAO {
	public boolean register(User user);
	public boolean validate(String username,String password);
	public List<User> getUsers();
	public List<User> getUsersByUserName(String username);
	public ArrayList<Reimbursements> viewMyReiumbersements(String username, boolean isPending);
	public void ApproveorDenyRequests(String managerId, String username, String approveOrDeny);
	public void newRequest(String username, String purpose, float amount);
	public ArrayList<Reimbursements> viewAllResolvedRequests();
}
