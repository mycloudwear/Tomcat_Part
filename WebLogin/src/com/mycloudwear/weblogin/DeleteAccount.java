package com.mycloudwear.weblogin;

import com.mycloudwear.library.DecodeTool;
import com.mycloudwear.library.MySQLHelper;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * @author Group 4
 * @version 1.0.1
 * @since 14/5/2019
 * This class deletes the account in the website.
 */
public class DeleteAccount extends HttpServlet {
    private MySQLHelper helper;

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        String encryptedPhone = request.getParameter("phone");
        DecodeTool decode = new DecodeTool();
        String phoneNumber = decode.Base64Decoder(encryptedPhone);

        //Try to delete the user preference, account information, profile, and weather from the website.
        try{
            helper = new MySQLHelper("userPreference");
            helper.connectToMySQL();
            helper.deleteAccount(phoneNumber);
            helper.closeMySQL();

            helper = new MySQLHelper("Account");
            helper.connectToMySQL();
            helper.deleteAccount(phoneNumber);
            helper.closeMySQL();

            helper = new MySQLHelper("profile");
            helper.connectToMySQL();
            helper.deleteAccount(phoneNumber);
            helper.closeMySQL();

            helper = new MySQLHelper("Weather");
            helper.connectToMySQL();
            helper.deleteAccount(phoneNumber);
            helper.closeMySQL();

            helper = new MySQLHelper("userName");
            helper.connectToMySQL();
            helper.deleteAccount(phoneNumber);
            helper.closeMySQL();

            String path = "/Users/hephaest/UserPhotoLibrary/" + phoneNumber;
            File personalFile = new File(path);
            personalFile.delete();


        } catch(Exception e){
            e.printStackTrace();
        }

    }
}
