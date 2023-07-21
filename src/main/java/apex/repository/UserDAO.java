package apex.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import apex.pojo.User;

@Repository
public class UserDAO {
	
	@Autowired
	 private JdbcTemplate template;
	
	public List<User> getUsers()
	{
		List<User> finalList = new ArrayList<User>();
		List<Map<String ,Object>> userData = template.queryForList("SELECT * FROM apex.user");
		
		ListIterator<Map<String ,Object>> itr = userData.listIterator();
		
		while(itr.hasNext())
		{
			Map<String ,Object> mapobj =(Map<String ,Object>) itr.next();
			finalList.add(convertMapToUserObject(mapobj));
		}
		return finalList;
	}
	
	

	private User convertMapToUserObject(Map<String, Object> mapobj) {
		User u=new User();
		u.setId((Integer)mapobj.get("id"));
		u.setUserid((String)mapobj.get("userid"));
        u.setUsername((String)mapobj.get("username"));
        u.setPassward((String)mapobj.get("passward"));
		// TODO Auto-generated method stub
		return u;
	}



	public User getUser(String userId) {
		// TODO Auto-generated method stub
		Map<String ,Object> myuser = (Map<String, Object>) template.queryForMap("SELECT * FROM apex.user where userid = ?",userId);
		return convertMapToUserObject(myuser);
	}



	public User addUsers(String userid, String username, String passward) {
		int numberofrows = template.update("insert into apex.user(userid , username ,passward ) values ( ? , ? , ? )",userid , username , passward );
		if(numberofrows >0)
		{
			return getUser(userid);
		}
		return null;
	}



	public Boolean deleateUser(Integer id) {
		int numberofrows = template.update("delete from apex.user where id = ? ", id);
         System.out.println("no of row deleted" + numberofrows);
		return numberofrows >0;
		
	}



	public User updateUsers(User userObject, Integer id) {
		int numberofrow = template.update("update apex.user set userid = ? , username = ? ,passward = ? where id = ?" ,userObject.getUserid(),userObject.getUsername(),userObject.getPassward(), id );
		if(numberofrow >0)
		{
			return getUser(userObject.getUserid());
		}
		
		return null;
	}
	
	


	

}
