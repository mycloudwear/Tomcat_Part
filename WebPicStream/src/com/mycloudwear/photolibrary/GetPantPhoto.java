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
 * This class gets the path of the chosen pants image which is stored at the txt file and in the website.
 */
public class GetPantPhoto extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        String encryptedPhone = request.getParameter("phone");
        String imgPath = request.getParameter("path");
        byte[] data = FileHelper.getPhoto(encryptedPhone, "/UserAlbum/Pants/", imgPath);
        try {
            response.getOutputStream().write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
