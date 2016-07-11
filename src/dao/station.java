package dao;
public class station{
	String id = null;
	String name = null;
	String longitude = null;
	String latitude = null;
	public station(String idString ,String aname,String alongitude,String alatitude) {
		// TODO Auto-generated constructor stub
		this.id = idString;
		this.name = aname;
		this.longitude =alongitude;
		this.latitude = alatitude;
	}
}