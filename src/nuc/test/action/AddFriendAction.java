package nuc.test.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import nuc.test.Service.userService;
import nuc.test.vo.registerModel;

public class AddFriendAction extends ActionSupport {
     private userService uService=new userService();
     private int id;
     private int ids;
	 public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getIds() {
		return ids;
	}


	public void setIds(int ids) {
		this.ids = ids;
	}


	public String addMethod() {
		 uService.addFriends(id, ids);
		 return "addOk";
	 }
	
}
