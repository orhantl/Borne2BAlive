

package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface SubControllerInterface {
    
    public String process(HttpServletRequest request, HttpServletResponse response);
    
}
