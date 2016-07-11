package dao;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    public boolean LineisExisted(String LineID){
    	try {
        	conn = getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement("select * from get_line where pathid = ?");
            preparedStatement.setString(1, LineID);
            ResultSet rs = preparedStatement.executeQuery();
            if (!rs.next()){
            	conn.close();
            	return false;
            }
            conn.close();
    	}
    	catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    	
    	
        return true;
    }
    public boolean POIisExisted(String id,String lng,String lat){
    	try {
        	conn = getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement("select * from get_poi where stationid = ? and longitude = ? and latitude = ?");
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, lng);
            preparedStatement.setString(3, lat);
            ResultSet rs = preparedStatement.executeQuery();
            if (!rs.next()){
            	conn.close();
            	return false;
            }
            conn.close();
        }

        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    	
    	
        return true;
    }
    public boolean setPOI(station aStation) {
        try {
        	conn = getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO get_poi (name,longitude,latitude,stationid) VALUES(?,?,?,?)");
            preparedStatement.setString(1, aStation.name);
            preparedStatement.setString(2, aStation.longitude);
            preparedStatement.setString(3, aStation.latitude);
            preparedStatement.setString(4, aStation.id);
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
	            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO get_line (name,path,pathid) VALUES(?,?,?)");
	            preparedStatement.setString(1, aline.name);
	            preparedStatement.setString(2, aline.path);
	            preparedStatement.setString(3, aline.id);
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
	public boolean setRelation(String stopid, String pathid , String seq) {
		// TODO Auto-generated method stub
		try {
        	conn = getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO get_relation (stopid,pathid,seq) VALUES(?,?,?)");
            preparedStatement.setString(1,stopid);
            preparedStatement.setString(2,pathid);
            preparedStatement.setString(3,seq);
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
	public boolean RelationisExisted(String stopid, String pathid) {
		try {
        	conn = getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement("select * from get_relation where stopid = ? and pathid = ?");
            preparedStatement.setString(1, stopid);
            preparedStatement.setString(2, pathid);
            ResultSet rs = preparedStatement.executeQuery();
            if (!rs.next()){
            	conn.close();
            	return false;
            }
            conn.close();
        }

        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    	
    	
        return true;
	}
	
}
