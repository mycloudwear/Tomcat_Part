package com.mycloudwear.photolibrary;

import com.mycloudwear.webtools.DecodeTool;
import com.mycloudwear.webtools.DeleteFile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
/**
 * @author Group 4
 * @version 1.0.1
 * @since 14/5/2019
 * This class deletes a specified account from the website through the phone number of the account.
 */
public class DeleteAccount extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        String encryptedPhone = request.getParameter("phone");
        DecodeTool decode = new DecodeTool();
        String phoneNumber = decode.Base64Decoder(encryptedPhone);
        String path = "/Users/hephaest/UserPhotoLibrary/" + phoneNumber;
        File personalFile = new File(path);
        DeleteFile.deleteDir(personalFile);
    }
}