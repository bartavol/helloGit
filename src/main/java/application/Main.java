package com.softserver.todolist.application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.softserver.todolist.entities.Specialization;
import com.softserver.todolist.entities.User;
import com.softserver.todolist.utill.DBUtill;

public class Main {

	public static void main(String[] args) {
		
		
		/*User u1 = new User();
		u1.setEmail("p@gmail.com");
		u1.setFirstName("Volodymyr");
		u1.setLastName("Barta");
		u1.setPassword("1123");
		List<Specialization> specializations = new ArrayList<Specialization>();
		specializations.add(Specialization.Developer);
		specializations.add(Specialization.Architect);
		u1.setSpecializations(specializations);
		
		addNewUser(u1);*/
		
		List<User> users = getAllUserBySpecialization(Specialization.ProjectManager);
		for(User user: users) {
			System.out.println(user.getId() + "\t" + user.getFirstName() + "\t" +
							user.getLastName());
		}
	}
	
	public static long addNewUser(User user) {
		Connection conn = DBUtill.getDBConnection();
		PreparedStatement stmt = null;
		String sql = "INSERT INTO users (email, first_name, last_name, password) VALUES(?, ?, ?, ?)";
		long id = -1;
		try {
			stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getFirstName());
			stmt.setString(3, user.getLastName());
			stmt.setString(4, user.getPassword());
			stmt.executeUpdate();
			
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next()) {
				id = rs.getLong(1);
			}
			user.setId(id);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		sql = "INSERT INTO users_has_specialization VALUES(?, ?)";
		try {
			stmt = conn.prepareStatement(sql);
			
			for(Specialization specialization: user.getSpecializations()) {
				long specializationId = getSpecializationIdByName(specialization);
				
				if(specializationId != -1) {
					stmt.setLong(1, user.getId());
					stmt.setLong(2, specializationId);
					stmt.executeUpdate();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
		
		return id;
	}
	
	public static long getSpecializationIdByName(Specialization specialization) {
		String sql = "SELECT specialization_id FROM specialization WHERE specialization_title = ?";
		Connection conn = DBUtill.getDBConnection();
		PreparedStatement stmt = null;
		long id = -1;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, specialization.toString());
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				id = rs.getLong("specialization_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return id;
	}
	
	public static List<User> getAllUserBySpecialization(Specialization specialization){
		List<User> users = new ArrayList<>();
		Connection conn = DBUtill.getDBConnection();
		PreparedStatement stmt = null;
		String sql = "SELECT * FROM users JOIN users_has_specialization USING(user_id) " +
						"JOIN specialization USING(specialization_id) " +
						"WHERE specialization.specialization_title = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, specialization.toString());
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getLong("user_id"));
				user.setEmail(rs.getString("email"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setPassword(rs.getString("password"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

}
