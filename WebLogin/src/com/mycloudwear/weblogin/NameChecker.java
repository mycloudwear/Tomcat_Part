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
 * This class checks the user name of the account.
 */
public class NameChecker extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String encryptedPhone = request.getParameter("phone");
        DecodeTool decode = new DecodeTool();
        String phoneNumber = decode.Base64Decoder(encryptedPhone);
        try {
            MySQLHelper helper = new MySQLHelper("userName");
            helper.connectToMySQL();
            String result = helper.checkName(phoneNumber);
            if (result == null) result = "";
            response.getOutputStream().write(result.getBytes());
        } catch (Exception e) {
            response.getOutputStream().write(e.getMessage().getBytes());
        }
    }
}
