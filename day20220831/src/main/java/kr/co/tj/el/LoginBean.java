package kr.co.tj.el;

public class LoginBean {
    private String userid;
    private String passwd;

    public LoginBean() {
    }

    @Override
    public String toString() {
        return "LoginBean{" + "userid='" + userid + '\'' + ", passwd='" + passwd + '\'' + '}';
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
