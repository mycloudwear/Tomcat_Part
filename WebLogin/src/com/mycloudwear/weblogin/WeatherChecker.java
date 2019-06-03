package com.mycloudwear.weblogin;

import com.mycloudwear.library.DecodeTool;
import com.mycloudwear.library.MySQLHelper;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Group 4
 * @version 1.0.1
 * @since 14/5/2019
 * The class checks the whether the weather information is stored at the website.
 */
public class WeatherChecker extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String encryptedPhone = request.getParameter("phone");
        DecodeTool decode = new DecodeTool();
        String phoneNumber = decode.Base64Decoder(encryptedPhone);
        try {
            MySQLHelper helper = new MySQLHelper("Weather");
            helper.connectToMySQL();
            List<String> weatherInfo = helper.exeSelectQuery("SELECT WEATHER, TEMPERATURE, WIND, HUMIDITY FROM Weather WHERE PHONE = " + phoneNumber + ";",
                    "WEATHER", "TEMPERATURE", "WIND", "HUMIDITY");
            helper.closeMySQL();
            String info = String.join(",", weatherInfo);
            response.getOutputStream().write(info.getBytes());
        } catch (Exception e) {
            response.getOutputStream().write(e.getMessage().getBytes());
        }
    }
}
