package com.mycloudwear.weblogin;

import com.mycloudwear.library.DecodeTool;
import com.mycloudwear.library.MySQLHelper;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * @author Group 4
 * @version 1.0.1
 * @since 14/5/2019
 * This class sets the password of the account at the website.
 */
public class SetPasswordServlet extends HttpServlet {
    private MySQLHelper helper;
    private static final String PASS = "pass";
    private static final String FAIL = "fail";
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        String encryptedPhone = request.getParameter("username");
        String encryptedPwd = request.getParameter("password");
        String password = null;
        DecodeTool decode = new DecodeTool();
        String phoneNumber = decode.Base64Decoder(encryptedPhone);
        phoneNumber = phoneNumber == null? encryptedPhone : phoneNumber;

        //If the password has been existed, decode it from the website.
        if (encryptedPwd != null) password = decode.Base64Decoder(encryptedPwd);
        password = password == null? encryptedPwd : password;

        try{
            helper = new MySQLHelper("Account");
            helper.connectToMySQL();
            if (helper.checkExist(phoneNumber)){
                //If the account is existed and the password is not null, update the new password to the website.
                if (password != null) helper.executeUpdate("UPDATE Account SET PASSWORD = " + password +
                        " WHERE PHONE = " + phoneNumber);
            } else{
                //If the account is not existed, add a new account to the website.
                if (password != null) helper.executeInsert("Account", phoneNumber, password);
                else helper.addNewAccount(phoneNumber);
            }
            helper.closeMySQL();
            response.getOutputStream().write(PASS.getBytes());
        } catch(Exception e){
            e.printStackTrace();
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        doGet(request, response);
    }
}
