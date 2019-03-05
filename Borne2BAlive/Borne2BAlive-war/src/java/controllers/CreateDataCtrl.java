package controllers;

import dataCreation.DataTestLocal;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateDataCtrl implements Serializable, SubControllerInterface {
    DataTestLocal dataTest = lookupDataTestLocal();

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        dataTest.createData();
        return "/index.jsp";
    }

    private DataTestLocal lookupDataTestLocal() {
        try {
            Context c = new InitialContext();
            return (DataTestLocal) c.lookup("java:global/Borne2BAlive/Borne2BAlive-ejb/DataTest!dataCreation.DataTestLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }



}
