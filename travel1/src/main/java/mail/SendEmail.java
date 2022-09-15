package mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
   public static void main(String[] args) {

//      String host = "smtp.gmail.com"; // 사용할 사이트
//      final String user = "아이디@gmail.com"; // ID
//      final String password = "구글 2차 비밀번호 or 비밀번호"; // PW
//
//      String to = "보낼 이메일 주소"; // 보낼 이메일 주소
      
      String host = "smtp.naver.com"; // 사용할 사이트
      final String user = "j38317_study@naver.com"; // ID
      final String password = "비밀번호"; // PW
      
      String to = "보낼 메일 주소"; // 보낼 이메일 주소


      // Get the session object
      Properties props = new Properties();
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.port", "587");
      props.put("mail.smtp.ssl.protocols", "TLSv1.2");

      Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
         protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(user, password);
         }
      });

      // Compose the message
      try {
         MimeMessage message = new MimeMessage(session);
         message.setFrom(new InternetAddress(user));
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

         // Subject
         message.setSubject("테스트 메세지 입니다.");

         // Text
         message.setText("테스트");

         // send the message
         Transport.send(message);
         System.out.println("이메일 전송 성공!");

      } catch (MessagingException e) {
         e.printStackTrace();
      }
   }
}