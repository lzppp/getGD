package dao;
public class Line{
	String name = null;
	String path = null;
	String id = null;
	public Line(String aname,String apath,String aid) {
		// TODO Auto-generated constructor stub
		this.name = aname;
		this.path = apath;
		this.id = aid;
	}
	public String toString(){
		return id+name+path;
	}
}