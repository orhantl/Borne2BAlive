
package controllers;

import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ConsumChoiceCtrl implements Serializable, SubControllerInterface {
    
    public String process(HttpServletRequest request, HttpServletResponse response){
        
        HttpSession session = request.getSession();
        
        
        
        
        return "/WEB-INF/consumerChoice/consumChoice.jsp";
    }
    
}
