package nuc.test.Dao;

import java.util.Set;

import javax.websocket.Endpoint;
import javax.websocket.server.ServerApplicationConfig;
import javax.websocket.server.ServerEndpointConfig;

public class DemeConfig implements ServerApplicationConfig {

	//注解的方式启动
	@Override
	public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> scan) {
		// TODO Auto-generated method stub
		 System.out.println("-------------websoket start-----------------");  
	     System.out.println("scan.size() = " + scan.size());  
	          
	     return scan; //必须要返回scan,否则会造成连接失败  
	}

	
	//接口的方式启动
	@Override
	public Set<ServerEndpointConfig> getEndpointConfigs(Set<Class<? extends Endpoint>> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
