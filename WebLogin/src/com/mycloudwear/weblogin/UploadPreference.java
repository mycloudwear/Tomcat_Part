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
 * This class updates the user's preference of the matching result to the website.
 */
public class UploadPreference extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String encryptedPhone = request.getParameter("username");
        String encryptedPath = request.getParameter("imgpath");
        String userPreference = request.getParameter("preference");

        DecodeTool decode = new DecodeTool();
        String phoneNumber = decode.Base64Decoder(encryptedPhone);
        String imgPath = decode.Base64Decoder(encryptedPath);

        /*
         * Try to updates the preference (if the image is existed) or
         * add a new preference (if the image if not existed) to the website.
         */
        try {

            MySQLHelper helper = new MySQLHelper("userPreference");
            helper.connectToMySQL();
            if (helper.checkExist("SELECT COUNT(*) FROM userPreference WHERE IMAGE_NAME = \"" + imgPath + "\";")) {
                helper.updateUserPreference(imgPath,userPreference);
            } else {
                helper.executeInsert("userPreference", imgPath,phoneNumber,userPreference);
            }
            helper.closeMySQL();

        } catch (Exception e) {
            response.getOutputStream().write(e.getMessage().getBytes());
        }
    }


}
