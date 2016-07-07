package service;
import dao.dao;
import dao.station;



public class service {
	
	public static void write(String name,String longtitude,String latitude){
		dao dbDao = new dao();
		System.out.println(name);
		dbDao.setUser(new station(name,longtitude, latitude));
		//dbDao.close();
	}
	public static void main(String[] args) {
		write("天安门东(公交站)","116.401299","39.907696");
	}
}
