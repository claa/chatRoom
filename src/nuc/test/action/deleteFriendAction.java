package nuc.test.action;

import com.opensymphony.xwork2.ActionSupport;

import nuc.test.Service.userService;

public class deleteFriendAction extends ActionSupport {
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


		public String deleteMethod() {
			 uService.deleteFriends(id, ids);
			 return "deleteOk";
		 }
		
}
