package nuc.test.action;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import nuc.test.Service.userService;
import nuc.test.vo.loginModel;
import nuc.test.vo.registerModel;

public class loginAction extends ActionSupport implements ModelDriven<registerModel> {
     private loginModel login = new loginModel();
     private userService uService=new userService();
 	 private registerModel register=new registerModel();
     public String loginMethod() {
    	 ActionContext.getContext().getSession().put("login", login);
    	 ActionContext.getContext().getSession().put("loginname", register.getUsername());
    	 
    	 if(uService.testLogination(register)) {
    		ResultSet rs= uService.selectId(register.getUsername());
    		try {
				if(rs.next()) {
					 ActionContext.getContext().getSession().put("loginid", rs.getString("id"));
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	 return "loginOk";
    	 }
    	 else {
    	 ActionContext.getContext().put("error","登录失败，用户名或密码错误");
    	 return ERROR; 
    	 }
     }
	@Override
	public registerModel getModel() {
		// TODO Auto-generated method stub
		return register;
	}
	
	public void validateLoginMethod() {
		if(register.getUsername()==null||register.getUsername().trim().equalsIgnoreCase("")) {
			this.addFieldError("username","用户名不能为空");
		}
		if(register.getPassword()==null||register.getPassword().trim().equals("")) {
			this.addFieldError("password","密码不能为空");
		}
		if(register.getChecking()==null||register.getChecking().trim().equals("")) {
			this.addFieldError("checking","验证码不能为空");
		}
	}

}
