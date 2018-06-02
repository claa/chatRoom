package nuc.test.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

import nuc.test.Dao.userDao;
import nuc.test.vo.loginModel;
import nuc.test.vo.registerModel;

public class userService {
       userDao user = new userDao();
       public boolean registerUser(registerModel register) {
    	   if(user.Insert(register)!=0) {
    		   return true;
    	   }else {
    		   return false;
    	   }
       }
       
       public boolean testLogination(registerModel register) {
    	   try {
			if(user.testLogin(register).next()){
				  return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
		   return false;
       }
       
       //根据用户名查出用户id
       public ResultSet selectId(String login) {
    	     return user.selectUserId(login);
       }
       //根据用户id查出好友
       public ResultSet selectFriends(int id) {
    	   return user.selectFriend(id);
       }
       //查询所有用户名
       public ResultSet selectUsers() {
    	   return user.selectUser();
       }
       //删除好友列表中的好友
       public void deleteFriends(int id,int ids) {
    	    user.deleteFriend(id, ids);
       }
       //增加用户列表中的好友
       public void addFriends(int id,int ids) {
    	   user.addFriend(id, ids);
       }
}
