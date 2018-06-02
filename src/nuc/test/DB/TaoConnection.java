package nuc.test.DB;
import java.sql.*;
public class TaoConnection {
       public static final String DBDRIVER="org.gjt.mm.mysql.Driver";
       public static final String DBURL="jdbc:mysql://localhost:3306/tao";
       public static final String DBUSER="root";
       public static final String DBPASS="15735659458zxc";
       Connection coon=null;
       public Connection getCoon() {
    	   try {
			Class.forName(DBDRIVER);
		    coon=DriverManager.getConnection(DBURL,DBUSER,DBPASS);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	   return coon;
       }
}
