package com.training.krishna.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.training.krishna.models.User;

public class UserDao {
	
	
	public Set<User> retriveUsers() {
		Set<User> users= new HashSet<User>();
			
			  EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
			  EntityManager entityManager = factory.createEntityManager();
			  
			  User user= new User();
			  user.setUserID(3);
			  user.setFirstName("Hello");
			  user.setLastName("IMCS");
			  
			  EntityTransaction transaction = entityManager.getTransaction();
			  transaction.begin();
			  entityManager.persist(user);
			  transaction.commit();
			  
			  Query createQuery = entityManager.createQuery("select t from User t");
			  List<User> users1=(List<User>)createQuery.getResultList();
			  
			
			  
			  users.addAll(users1);
			  
			 
			/*Class.forName("com.mysql.cj.jdbc.Driver");
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/2019jan","root","root");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("Select * from User");
			
						
			while(resultSet.next()) {
				User user = new User();
				
				user.setUserID(Integer.toString(resultSet.getInt("user_id")));
				user.setFirstName(resultSet.getString("first_name")+resultSet.getString("last_name"));
				users.add(user);
			}
			
			connection.close();*/
		
		
		return users;
		
		
		
	}

}
