package nuc.test.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import nuc.test.Service.userService;
import nuc.test.vo.registerModel;

public class registerAction extends ActionSupport implements ModelDriven<registerModel> {
	private userService uService=new userService();
	private registerModel register=new registerModel();
	public String registerMethod() {
		System.out.println("pppppppp");
		if(uService.registerUser(register)) {
		  return "registerOk";
		}
		else {
			ActionContext.getContext().put("error","抱歉，注册失败");
			return ERROR;
		}
	}
	@Override
	public registerModel getModel() {
		// TODO Auto-generated method stub
		return register;
	}
}
