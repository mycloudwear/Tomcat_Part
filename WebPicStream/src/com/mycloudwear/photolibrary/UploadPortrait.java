package com.mycloudwear.photolibrary;

import com.mycloudwear.webtools.DecodeTool;
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
 * This class uploads the portrait image which is stores at the server
 */
public class UploadPortrait extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        String encryptedPhone = request.getParameter("phone");
        DecodeTool decode = new DecodeTool();
        String phoneNumber = decode.Base64Decoder(encryptedPhone);
        String encryptedImg = request.getParameter("img");
        String path = "/Users/hephaest/UserPhotoLibrary/" + phoneNumber + "/UserPortrait/";
        try {
            byte[] imageByteArray = Base64.decode(encryptedImg);
            FileOutputStream imageOutFile = new FileOutputStream(path + "head.jpg");
            imageOutFile.write(imageByteArray);
            imageOutFile.close();
        } catch (Base64DecodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
