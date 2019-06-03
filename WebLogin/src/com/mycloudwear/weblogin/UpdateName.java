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
 * This class updates the user name of the account to the website.
 */
public class UpdateName extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String encryptedPhone = request.getParameter("phone");
        String encryptedName = request.getParameter("name");

        DecodeTool decode = new DecodeTool();
        String phoneNumber = decode.Base64Decoder(encryptedPhone);
        String name = decode.Base64Decoder(encryptedName);
        try {
            MySQLHelper helper = new MySQLHelper("userName");
            helper.connectToMySQL();

            if (helper.checkExist(phoneNumber)) {
                helper.executeUpdate("UPDATE userName SET NAME = " + name + " WHERE PHONE = " + phoneNumber);
            } else {
                helper.executeInsert("userName", phoneNumber, name);
            }

            helper.closeMySQL();
        } catch (Exception e) {
            response.getOutputStream().write(e.getMessage().getBytes());
        }
    }
}
