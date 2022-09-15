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

//      String host = "smtp.gmail.com"; // ����� ����Ʈ
//      final String user = "���̵�@gmail.com"; // ID
//      final String password = "���� 2�� ��й�ȣ or ��й�ȣ"; // PW
//
//      String to = "���� �̸��� �ּ�"; // ���� �̸��� �ּ�
      
      String host = "smtp.naver.com"; // ����� ����Ʈ
      final String user = "j38317_study@naver.com"; // ID
      final String password = "��й�ȣ"; // PW
      
      String to = "���� ���� �ּ�"; // ���� �̸��� �ּ�


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
         message.setSubject("�׽�Ʈ �޼��� �Դϴ�.");

         // Text
         message.setText("�׽�Ʈ");

         // send the message
         Transport.send(message);
         System.out.println("�̸��� ���� ����!");

      } catch (MessagingException e) {
         e.printStackTrace();
      }
   }
}