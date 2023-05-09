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


	

}
