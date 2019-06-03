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
 * This class updates the personal information of the account to the website.
 */
public class UpdateProfile extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String encryptedPhone = request.getParameter("phone");
        String height = request.getParameter("height");
        String weight = request.getParameter("weight");
        String gender = request.getParameter("gender");
        String bmi = request.getParameter("bmi");

        DecodeTool decode = new DecodeTool();
        String phoneNumber = decode.Base64Decoder(encryptedPhone);
        System.out.println("phone: " + phoneNumber);
        try {
            MySQLHelper helper = new MySQLHelper("profile");
            helper.connectToMySQL();
            /*
             * If this account is existed, updates the new personal information to the website;
             * if it is not existed, add the new personal information to the website.
             */
            if (helper.checkExist(phoneNumber)) {
                helper.executeUpdate("UPDATE profile SET HEIGHT = " + height + ", WEIGHT = " + weight + ", GENDER = "+
                        gender + ", BMI = " + bmi + " WHERE PHONE = " + phoneNumber);
            } else {
                helper.executeInsert("profile", phoneNumber, height, weight, gender, bmi);
            }

            helper.closeMySQL();
        } catch (Exception e) {
            response.getOutputStream().write(e.getMessage().getBytes());
        }
    }

}
