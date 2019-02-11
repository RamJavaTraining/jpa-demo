package com.training.krishna.services;

import java.util.Optional;
import java.util.Set;

import com.training.krishna.dao.UserDao;
import com.training.krishna.models.User;

public class LoginService {
	
	
	
	public boolean validate(String userID,String password) {
		
		if(userID ==null || userID.trim().isEmpty()) {
			return false;
		}
		return true;
		
	}
	
	public User getUser(int userID) {
		
		UserDao dao= new UserDao();
		Set<User> retriveUsers = dao.retriveUsers();
		
		
		Optional<User> findFirst = retriveUsers.stream().filter(user1->user1.getUserID()==userID).findFirst();
		
		return findFirst.get();
		
	}
	
	
	public static void main(String[] args) {
		LoginService loginService= new LoginService();
		User user = loginService.getUser(3);
		 System.out.println(user.getFirstName()+user.getLastName());

	}
	

}
