package com.mycloudwear.photolibrary;

import com.mycloudwear.webtools.FileHelper;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Group 4
 * @version 1.0.1
 * @since 14/5/2019
 * This class deletes the image of the pants at the website of a specified account.
 */
public class DeletePantBitmap extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        String encryptedPhone = request.getParameter("phone");
        String targetPath = request.getParameter("target");
        FileHelper.deleteFile(encryptedPhone, "/UserAlbum/Pants/", targetPath);
    }
}
