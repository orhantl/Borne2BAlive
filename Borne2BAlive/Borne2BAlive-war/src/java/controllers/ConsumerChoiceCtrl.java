
/**
 *Sous controller en servlet, et main controller en Hashmap.
 * 
 * @author cdi115@WebServlet(name = "ConsumerChoiceCtrl", urlPatterns = {"/ConsumerChoiceCtrl"})
public class ConsumerChoiceCtrl extends HttpServlet {
 */

package controllers;
import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConsumerChoiceCtrl implements Serializable, SubControllerInterface {

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
    String url= "/WEB-INF/consumerChoice/consumChoice.jsp" ;
    return url;
  
    
    }
    }