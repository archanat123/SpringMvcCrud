package apex.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apex.pojo.User;
import apex.repository.UserDAO;
@Service
public class UserServices {
	
	@Autowired
	 private UserDAO dao;
	
	public List<User> getUsers()
	{
	return dao.getUsers();
	}
	
	public User getUser(String userId)
	{
	return dao.getUser(userId);
	}

	 
	public User addUsers(User userObject)
	{
		if(!validateDate(userObject))
		{
			return null;
		}
	return dao.addUsers(userObject.getUserid(),userObject.getUsername(),userObject.getPassward());
	
	}

	private boolean validateDate(User userObject) {
		// TODO Auto-generated method stub
		return userObject != null;
	}

	public Boolean deleteUser(Integer id) {
		// TODO Auto-generated method stub
		return dao.deleateUser(id);
	}

	public User updateUsers(User userObject, Integer id) {
		// TODO Auto-generated method stub
		return dao.updateUsers(userObject,id);
	}

	



}
