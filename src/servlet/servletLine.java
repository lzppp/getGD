package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.serviceLine;

public class servletLine extends HttpServlet{
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //System.out.println(request.getParameter("count").toString());
        serviceLine.write(request.getParameter("name").toString(),request.getParameter("path").toString(),request.getParameter("id").toString());
/*        String name = request.getParameter("name");
        String langutide = request.getParameter("langutide");
        String latitude = request.getParameter("langutide");

       */

        //out.write(jsonStr);
        out.write("200");
        out.flush();
        out.close();

    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
