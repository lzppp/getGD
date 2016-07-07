package dao;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;
import java.sql.SQLException;
  
public class dao { 
    Connection conn = null;

    public  Connection getConnection() {
        try {
        	Class.forName("com.mysql.jdbc.Driver");// ��ȡ���ݿ�����
            String url = "jdbc:mysql://localhost:3306/getgd?characterEncoding=utf-8";   //�������������ݿ��url
            String user = "root";           //�����������ݿ���û���   
            String passWord = "";        //�����������ݿ������
            conn = DriverManager.getConnection(url, user, passWord);    //��������
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
