package com.mycloudwear.photolibrary;

import com.mycloudwear.webtools.DecodeTool;
import com.mycloudwear.webtools.FileHelper;
import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * @author Group 4
 * @version 1.0.1
 * @since 14/5/2019
 * This class updates the top image in the tops list txt file in the website which is from the user's phone.
 */
public class UpdateTop extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) {

        String encryptedPhone = request.getParameter("phone");
        String fileName = request.getParameter("filename");
        String encryptedImg = request.getParameter("img");
        FileHelper.updatePhoto(encryptedPhone, "/UserAlbum/Tops/", fileName, encryptedImg);
    }
}