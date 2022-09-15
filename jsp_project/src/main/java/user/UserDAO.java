package user;

import java.sql.*;

public class UserDAO {

    private Connection conn;  //자바와 데이터베이스 연결
    private PreparedStatement pstmt;  //쿼리문 대기 및 설정
    private ResultSet rs;  //결과값 받아오기

    //기본 생성자
    //UserDAO 가 실행되면 자동으로 생성되는 부분
    //메소드마다 반복되는 코드를 이곳에 넣으면 코드가 간소화된다.
    public UserDAO(){
        try {
            String dbURL = "jdbc:mysql://localhost:3306/bbs?characterEncoding=utf8";
            String dbID = "root";
            String dbPassword = "1234";
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //로그인 영역
    public int login(String userID, String userPassword){

        String sql = "select userPassword from USER where userID = ?";
        try {
            pstmt = conn.prepareStatement(sql); //sql 쿼리문을 대기 시킨다.
            pstmt.setString(1, userID); //첫번째 '?'에 매개변수로 받아온 'userID' 를 대입
            rs = pstmt.executeQuery(); //쿼리를 실행한 결과를 rs 에 저장

            if (rs.next()){
                if(rs.getString(1).equals(userPassword)){
                    return 1; //로그인 성공
                }else
                    return 0; //비밀번호 틀림
            }
            return -1; //아이디 없음
        } catch (SQLException e) {
            e.printStackTrace();
            //throw new RuntimeException(e);
        }
        return -2; //오류
    }
}
