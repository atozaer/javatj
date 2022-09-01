package kr.co.tj.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCUtil {
    static final String driverName="com.mysql.cj.jdbc.Driver";
    static final String url="jdbc:mysql://127.0.0.1:3306/tj?characterEncoding=utf8";
    static final String user="root";
    static final String pw="1234";

    public static Connection connect(){
        Connection conn=null;
        try {
            Class.forName(driverName);
            conn= DriverManager.getConnection(url,user,pw);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return conn;
    }

    public static void disconnect(PreparedStatement pstmt, Connection conn){
        try {
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
