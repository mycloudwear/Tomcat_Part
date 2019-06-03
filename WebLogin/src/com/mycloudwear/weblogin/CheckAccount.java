package com.mycloudwear.weblogin;

import com.mycloudwear.library.DecodeTool;
import com.mycloudwear.library.MySQLHelper;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Group 4
 * @version 1.0.1
 * @since 14/5/2019
 * This class checks whether a specified account is existed in the website.
 */
public class CheckAccount extends HttpServlet {
    private MySQLHelper helper;
    private static final String PASS = "pass";
    private static final String FAIL = "fail";
    /**
     * This method achieve HTTP GET method.
     * @param request  This parameter extends the ServletRequest interface to provide request information for HTTP servlets.
     * @param response  This parameter extends the ServletResponse interface to provide HTTP-specific functionality in sending a response.
     * @throws IOException  This method throws the IOException whenever an input or output operation is failed or interpreted.
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String encryptedPhone = request.getParameter("username");
        DecodeTool decode = new DecodeTool();
        String phoneNumber = decode.Base64Decoder(encryptedPhone);
        try{
            helper = new MySQLHelper("Account");
            helper.connectToMySQL();
            if (helper.checkExist(phoneNumber)){
                response.getOutputStream().write(PASS.getBytes());
            }
            else response.getOutputStream().write(FAIL.getBytes());
            helper.closeMySQL();
        } catch(Exception e){
            response.getOutputStream().write(FAIL.getBytes());
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        doGet(request, response);
    }
}
