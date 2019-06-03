package com.mycloudwear.photolibrary;

import com.mycloudwear.webtools.FileHelper;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @author Group 4
 * @version 1.0.1
 * @since 14/5/2019
 * This class gets the portrait image of the user which is stored in the website.
 */
public class GetPortrait extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        String encryptedPhone = request.getParameter("phone");
        byte[] data = FileHelper.getPhoto(encryptedPhone, "/UserPortrait/head.jpg", "");
        try {
            response.getOutputStream().write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
