
package controllers;
import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeScreenCtrl implements Serializable, SubControllerInterface {

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
    String url= "/WEB-INF/welcomeScreen/welcomeScreen.jsp"   ;
    return url;
  
    
    }
    }
    
    

