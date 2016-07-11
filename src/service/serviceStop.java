package service;

import dao.dao;
import dao.station;

public class serviceStop {

	/**
	 * @param args
	 */	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static void write(String stopid, String pathid, String name,
			String lng, String lat , String seq) {
		// TODO Auto-generated method stub
		dao db = new dao();
		if (!db.POIisExisted(stopid,lng,lat)){
			//create a station;
			station aStation = new station(stopid,name,lng,lat);
			db.setPOI(aStation);
		}
		if (!db.RelationisExisted(stopid,pathid))
			db.setRelation(stopid,pathid,seq);
	}

}
