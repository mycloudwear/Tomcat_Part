package com.mycloudwear.weblogin;

import com.mycloudwear.library.DecodeTool;
import com.mycloudwear.library.MySQLHelper;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Group 4
 * @version 1.0.1
 * @since 14/5/2019
 * This class checks the profile of the account.
 */
public class ProfileChecker extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String encryptedPhone = request.getParameter("phone");
        DecodeTool decode = new DecodeTool();
        String phoneNumber = decode.Base64Decoder(encryptedPhone);
        try {
            MySQLHelper helper = new MySQLHelper("profile");
            helper.connectToMySQL();
            List<String> result = helper.exeSelectQuery("SELECT BMI FROM profile WHERE PHONE = " + phoneNumber + ";",
                    "BMI");
            helper.closeMySQL();
            String info = String.join("", result);
            response.getOutputStream().write(info.getBytes());
        } catch (Exception e) {
            response.getOutputStream().write(e.getMessage().getBytes());
        }
    }
}
