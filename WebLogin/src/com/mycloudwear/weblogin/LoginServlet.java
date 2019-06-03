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
 * This class checks the existence and validity of the account which is login.
 */
public class LoginServlet extends HttpServlet {
    private static final String PASS = "pass";
    private static final String FAIL = "fail";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String encryptedPhone = request.getParameter("username");
        String encryptedPwd = request.getParameter("password");

        DecodeTool decode = new DecodeTool();
        String phoneNumber = decode.Base64Decoder(encryptedPhone);
        String password = decode.Base64Decoder(encryptedPwd);

        //Try to check the existence and the validity of the account.
        try{
            MySQLHelper helper = new MySQLHelper("Account");
            helper.connectToMySQL();
            if (helper.checkExist(phoneNumber) && helper.checkValid(phoneNumber,password)){
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
