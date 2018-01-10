package controller;

import java.util.ArrayList;
import java.util.Iterator;

import exception.DuplicateUserException;
import exception.UserNotFoundException;
import model.User;

public class AdminController extends UserController {
	
	private static ArrayList<User> usersList = new ArrayList<>();
	
	
	public AdminController() {
		// TODO Auto-generated constructor stub
	}
	
	public void registerAdmin() {
		// TODO RegisterUser
	}
	
	public void updateUser() {
		// TODO UpdateUser
	}
	
	public User deleteUser() {
		// TODO
		return null;
	}
	
	/**
	 * Valida as credenciais de um usu�rio.
	 * 
	 * @param String email, String password
	 * @return true, ou lanca a exce��o {@link UserNotFoundException}
	 * */
	@Override
	public boolean validateCredentials(String email, String password) throws UserNotFoundException {
		User user = this.getUserByEmail(email);
		if (user != null) {
			if (user.getPassword().equals(password)) {
				return true;
			}
		}			
		throw new UserNotFoundException();
	}
	
	/**
	 * Retorna o usu�rio que tem o email passado por par�metro, se existir.
	 * 
	 * @param String email
	 * @return boolean
	 * */
	private User getUserByEmail(String email) {
		Iterator<User> userIterator = usersList.iterator();
		while (userIterator.hasNext()) {
			User user = userIterator.next();
			if (user.getEmail().equals(email)) {
				return user;
			}
		}
		return null;
	}
	
	
	@Override
	public boolean registerUser(String name, String nickname, String email, String password) throws DuplicateUserException {
		if (this.getUserByEmail(email) == null) {
			AdminController.usersList.add(new User(name, nickname, email, password));
			return true;
		}
		throw new DuplicateUserException();
	}
}
