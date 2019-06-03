package com.mycloudwear.photolibrary;

import com.mycloudwear.webtools.FileHelper;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Group 4
 * @version 1.0.1
 * @since 14/5/2019
 * This class updates the skirt image in the skirts list txt file in the website which is from the user's phone.
 */
public class UpdateSkirt extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        String encryptedPhone = request.getParameter("phone");
        String fileName = request.getParameter("filename");
        String encryptedImg = request.getParameter("img");
        FileHelper.updatePhoto(encryptedPhone, "/UserAlbum/Skirts/", fileName, encryptedImg);
    }
}
