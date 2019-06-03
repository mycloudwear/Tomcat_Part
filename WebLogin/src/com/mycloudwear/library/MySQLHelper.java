package com.mycloudwear.library;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is the builder of the database which is manages the accounts and the images and stored in the server.
 * @author Group 4
 * @version 1.0.1
 * @since 14/5/2019
 */
public class MySQLHelper {
    // The name of the database
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private String dbUrl;
    private String tableName;
    private String sql;
    private PreparedStatement ps;
    private Connection conn;
    private ResultSet rs;
    private StringBuilder builder;

    //The user name and the keyword of the database, it can be modified by administrator.
    static final String USER = "root";
    static final String PWD = "iH>fg+GqQ()4%>/9";
    static final String DB = "test";

    /**
     * This constructor creates an instance of the database by the given name.
     * @param table  The table name which wants to be created in the database.
     * @throws ClassNotFoundException   This exception is thrown when an application tries to load a class
     * through its string name, but no definition for the specified class name could be found.
     */
    public MySQLHelper(String table) throws ClassNotFoundException{
        // Register JDBC driver.
        Class.forName(JDBC_DRIVER);
        dbUrl = "jdbc:mysql://localhost:3306/" + DB + "?characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true";
        tableName = table;
    }

    public  void connectToMySQL() throws SQLException{
        conn = DriverManager.getConnection(dbUrl,USER,PWD);
    }

    public  void closeMySQL() throws SQLException{
        conn.close();
    }

    /**
     * This method updates the preference of the user to the database.
     * @param imgPath  This string is the path of the component image which is stored in the database.
     * @param preference  This string is the preference of the user and updates to the database.
     */
    public void updateUserPreference(String imgPath, String preference) {
        sql = "UPDATE " + tableName + " SET PREFERENCE = ? WHERE IMAGE_NAME = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, preference);
            ps.setString(2, imgPath);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method checks the validity of the account in the database.
     * @param phoneNumber  This parameter is the phone number which is user name of the account.
     * @param password  This parameter is the password of the account.
     * @return This return value is the result of whether this account is valid.
     * @throws SQLException  An exception that provides information on a database access error or other errors.
     */
    public boolean checkValid(String phoneNumber, String password) throws SQLException {
        String databasePwd = null;
        if (checkExist(phoneNumber)){
            sql = "SELECT PASSWORD FROM " + tableName + " where PHONE = " + phoneNumber +";";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                databasePwd  = rs.getString("PASSWORD");
            }
            ps.close();
            rs.close();
            if (databasePwd.equals(password)) return true;
            else return false;
        }
        else{
            return false;
        }
    }

    /**
     * This method deletes the account from the database.
     * @param phoneNumber  This parameter is the key of account by the phone number of the user.
     */
    public void deleteAccount(String phoneNumber) {
        sql = "DELETE FROM " + tableName + " WHERE PHONE=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, phoneNumber);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * This method adds the new account to the database.
     * @param phoneNumber  This parameter is the key of account by the phone number of the user.
     */
    public void addNewAccount(String phoneNumber) {
        sql = "INSERT INTO " + tableName + " (phone) VALUES (?);";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, phoneNumber);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * This method checks the validity of the account in the database.
     * @param phoneNumber  This parameter is the phone number which is user name of the account.
     * @return This return value is the result of whether this account is valid.
     * @throws SQLException An exception that provides information on a database access error or other errors.
     */
    public String checkName(String phoneNumber) {
        String result = null;
        try{
            sql = "SELECT NAME FROM " + tableName + " WHERE PHONE = " + phoneNumber + ";";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                result = rs.getString("NAME");
            }
            ps.close();
            rs.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Check whether the record exists or not.
     * @param sql the query.
     * @return the checking result.
     */
    public boolean checkExist(String sql){
        int exist = 0;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                // Search the account in the database.
                exist = rs.getInt("COUNT(*)");
            }
            // Close the connection with the database after finished the search.
            ps.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exist > 0;
    }
    /**
     * This method is used to generate question marks (?)
     * @param len the total number of parameters.
     * @return the string of question marks.
     */
    private String getParaNum (int len){
        builder = new StringBuilder();

        for(int i = 1; i < len; i++)
            builder.append("?").append(",");

        return builder.toString().substring(0, builder.length()-1);
    }

    /**
     * This method is used to execute the "select" statement.
     * @param sql the query.
     * @param args the columns which will be queried.
     */
    public List<String>  exeSelectQuery (String sql, String ... args){
        List<String> info = new ArrayList<>();
        try{
            /*
             * If we put Statement cs = con.createStatement(); here
             * We need write cs.executeUpdate(sql); here
             */
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                for (String s:args)
                {
                    info.add(rs.getString(s));
                }
            }
            ps.close();
            rs.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return info;
    }

    /**
     * This method is used to execute the "update" statement.
     * @param sql the query.
     */
    public void executeUpdate(String sql){
        try {
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            ps.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * This method is used to execute the "insert" statement.
     * @param args the values that will be added.
     */
    public void executeInsert(String ... args){
        sql = "INSERT INTO " + args[0] + " VALUES (" + getParaNum(args.length) + ");";
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 1; i< args.length; i++)
            {
                ps.setString(i, args[i]);
            }
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
