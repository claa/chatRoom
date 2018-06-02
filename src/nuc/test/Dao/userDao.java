package nuc.test.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import nuc.test.DB.TaoConnection;
import nuc.test.vo.registerModel;

public class userDao {
        public int Insert(registerModel register) {
        	PreparedStatement pst=null;
        	int rs=0;
        	TaoConnection coon=new TaoConnection();
        	Connection coona=coon.getCoon();
        	String sql_insert="insert into user(username,password,trueusername,truepassword,email,phone,date) values (?,?,?,?,?,?,?)";
        	try {
				pst=coona.prepareStatement(sql_insert);
				pst.setString(1, register.getUsername());
				pst.setString(2, register.getPassword());
				pst.setString(3, register.getTrueusername());
				pst.setString(4, register.getTruepassword());
				pst.setString(5, register.getEmail());
				pst.setString(6, register.getPhone());
				String datetime1 = DateFormat.getDateInstance().format(register.getDate());//得到日期的DateFormat对象 ，作用为把date类型转化为String类型
				SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");//设置日期格式
			    String datetime2=df.format(new Date());// new Date()为获取当前系统时间
			    String datetime=datetime1+" "+datetime2;
				pst.setString(7, datetime);
				rs=pst.executeUpdate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	return rs;
        }
        
        public ResultSet testLogin(registerModel register) {
        	PreparedStatement pst=null;
        	ResultSet rs=null;
        	TaoConnection coon=new TaoConnection();
        	Connection coona=coon.getCoon();
        	String sql_test="select * from user where username=? and password=?";
        	try {
				pst=coona.prepareStatement(sql_test);
				pst.setString(1, register.getUsername());
				pst.setString(2, register.getPassword());
				rs=pst.executeQuery();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	return rs;
        }
        //根据用户名从用户表中查出id,再到朋友表中查找好友
       public ResultSet selectUserId(String name) {
    	   PreparedStatement pst=null;
    	   ResultSet rs=null;
    	   TaoConnection coon=new TaoConnection();
    	   Connection coona=coon.getCoon();
    	   String sql_id="select id from user where username=?";
    	   try {
			pst=coona.prepareStatement(sql_id);
			pst.setString(1, name);
			rs=pst.executeQuery();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	   return rs;
       }
       
       public ResultSet selectFriend(int id) {
    	   PreparedStatement pst=null;
    	   ResultSet rs=null;
    	   TaoConnection coon=new TaoConnection();
    	   Connection coona=coon.getCoon();
    	   String sql="select * from user where id in(select friend.fid from user,friend where user.id=friend.uid and id=?)";
    	   try {
			pst=coona.prepareStatement(sql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	   return rs;
       }
       
       //查出所有用户的名单
       public ResultSet selectUser() {
    	   PreparedStatement pst=null;
    	   ResultSet rs=null;
    	   TaoConnection coon=new TaoConnection();
    	   Connection coona=coon.getCoon();
    	   String sql="select * from user";
    	   try {
			pst=coona.prepareStatement(sql);
			rs=pst.executeQuery();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	   return rs;
       }
       //删除好友列表中的好友
       public int deleteFriend(int id ,int ids) {
    	   PreparedStatement pst=null;
    	   int rs=0;
    	   TaoConnection coon=new TaoConnection();
    	   Connection coona=coon.getCoon();
    	   String sql="delete from friend where uid=? and fid=?";
    	   try {
			pst=coona.prepareStatement(sql);
			pst.setInt(1, id);
			pst.setInt(2, ids);
			rs=pst.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	   return rs;
       }
       
       //增加好友列表中的好友
       public int addFriend(int id,int ids) {
    	   PreparedStatement pst=null;
    	   int rs=0;
     	   TaoConnection coon=new TaoConnection();
    	   Connection coona=coon.getCoon();
    	   String sql="insert into friend(uid,fid) values (?,?)";
    	   try {
			pst=coona.prepareStatement(sql);
			pst.setInt(1, id);
			pst.setInt(2, ids);
			rs=pst.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	   return rs;
    	   
       }
}
