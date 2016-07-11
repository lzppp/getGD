package service;
import dao.dao;
import dao.station;



public class service {
	
	public static void write(String id,String name,String longtitude,String latitude){
		dao dbDao = new dao();
		System.out.println(name);
		dbDao.setPOI(new station(id,name,longtitude, latitude));
		
		//dbDao.close();
	}
	public static void main(String[] args) {
		write("BV110","天安门东(公交站)","116.401299","39.907696");
	}
}
