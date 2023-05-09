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
	
/*	public User getUsers(String userId)
	{
	return dao.getUsers(userId);
	}
	 
	public User addUsers(User userObject)
	{
		if(!validateDate(userObject))
		{
			return null;
		}
	return dao.addUsers(userObject.getUserid(),userObject.getUsername(),userObject.getPassward());
	
	}
	*/

}
