package dao;
public class Line{
	String name = null;
	String path = null;
	public Line(String aname,String apath) {
		// TODO Auto-generated constructor stub
		this.name = aname;
		this.path = apath;
	}
	public String toString(){
		return name+path;
	}
}