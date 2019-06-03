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
 * This class updates the tops list txt file in the server.
 */
public class UpdateTopList extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String encryptedPhone = request.getParameter("phone");
        String list = request.getParameter("list");
        FileHelper.updateList(encryptedPhone, "/UserAlbum/Tops/topList.txt", list);
        response.getOutputStream().write("pass".getBytes());
    }
}
