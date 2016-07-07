package service;

import dao.Line;
import dao.dao;

public class serviceLine {

	public static void write(String name ,String path) {
		// TODO Auto-generated method stub
		
	
	dao dbDao = new dao();
	dbDao.setLine(new Line(name,path));
	//dbDao.close();
	}	
public static void main(String[] args) {
	write("1","116.401299,39.907696");
	}
}
