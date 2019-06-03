package com.mycloudwear.weblogin;

import com.mycloudwear.library.DecodeTool;
import com.mycloudwear.library.MySQLHelper;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Group 4
 * @version 1.0.1
 * @since 14/5/2019
 * This class updates the weather to the website.
 */
public class UpdateWeather extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String encryptedPhone = request.getParameter("phone");
        String weather = request.getParameter("weather");
        String temperature = request.getParameter("temperature");
        String wind = request.getParameter("wind");
        String humidity = request.getParameter("humidity");
        DecodeTool decode = new DecodeTool();
        String phoneNumber = decode.Base64Decoder(encryptedPhone);
        /*
         * Try to update the weather (if the account is existed) or add anew weather
         * (if the account is not existed) to the website.
         */
        try {
            MySQLHelper helper = new MySQLHelper("Weather");
            helper.connectToMySQL();
            if (helper.checkExist(phoneNumber)) {
                helper.executeUpdate("UPDATE Weather SET WEATHER = " + weather + ", TEMPERATURE = " + temperature +
                        ", WIND = " + wind + ", HUMIDITY = " + humidity + " WHERE PHONE = " + phoneNumber);
            } else {
                helper.executeInsert("Weather", phoneNumber, weather, temperature, wind, humidity);
            }
            helper.closeMySQL();

        } catch (Exception e) {
            response.getOutputStream().write(e.getMessage().getBytes());
        }
    }
}
