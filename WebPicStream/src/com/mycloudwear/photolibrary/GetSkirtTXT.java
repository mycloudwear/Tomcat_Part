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
 * This class gets the txt file which is stored the all paths of the skirts at the website.
 */
public class GetSkirtTXT extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        String encryptedPhone = request.getParameter("phone");
        try {
            response.getOutputStream().write(FileHelper.getTxt(encryptedPhone, "/UserAlbum/Skirts/skirtList.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
