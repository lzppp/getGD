package dao;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;
import java.sql.SQLException;
  
public class dao { 
    Connection conn = null;

    public  Connection getConnection() {
        try {
        	Class.forName("com.mysql.jdbc.Driver");// 获取数据库连接
            String url = "jdbc:mysql://localhost:3306/getgd?characterEncoding=utf-8";   //定义与连接数据库的url
            String user = "root";           //定义连接数据库的用户名   
            String passWord = "";        //定义连接数据库的密码
            conn = DriverManager.getConnection(url, user, passWord);    //连接连接
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    public boolean setUser(station aStation) {
        try {
        	conn = getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO get_copy (name,longitude,latitude) VALUES(?,?,?)");
            preparedStatement.setString(1, aStation.name);
            preparedStatement.setString(2, aStation.longitude);
            preparedStatement.setString(3, aStation.latitude);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            conn.close();
        }

        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public void close(){
    	try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	public boolean setLine(Line aline) {
		// TODO Auto-generated method stub
		 try {
	        	conn = getConnection();
	            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO get_line (name,path) VALUES(?,?)");
	            preparedStatement.setString(1, aline.name);
	            preparedStatement.setString(2, aline.path);
	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	            conn.close();
	        }

	        catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	        return true;
	   }
	
}
