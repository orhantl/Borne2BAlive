
package controllers;

import java.io.Serializable;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class Kill extends HttpServlet implements Serializable, SubControllerInterface {

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response){
        
        HttpSession session = request.getSession();
        session.invalidate();
        
        return "/index.jsp";
        
    }

}
