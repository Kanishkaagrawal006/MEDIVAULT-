import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Email {
    private static Session news ;
    private static MimeMessage mimi;

public static void main(String[] args)  {
Email e = new Email();
e.setupserverProperties();
try{
    e.draftemail();

}
catch(MessagingException ep){
ep.printStackTrace();
}
try{
e.sendmail();
}catch(MessagingException eqe){
    eqe.printStackTrace();
}
}


private void sendmail() throws MessagingException {
    String fromuser = "kanishka.23bsa10095@vitbhopal.ac.in";
    String password ="hong fxnl tgcw wxhr";

    String emailHost = "smtp.gmail.com";
    Transport transport = news.getTransport("smtp");
    transport.connect(emailHost,fromuser,password);
    transport.sendMessage(mimi,mimi.getAllRecipients() );
    transport.close();
    System.out.println("Email sent successfully");
    

    


}

private MimeMessage  draftemail() throws AddressException, MessagingException  {
    String emailRecipent = "kanishkaa182@gmail.com";
    String emailSubject = "Test Mail";
    String emailBody = "Test Body of my email";
       mimi = new MimeMessage(news);
      mimi.addRecipient(Message.RecipientType.TO,new InternetAddress(emailRecipent));
      mimi.setSubject(emailSubject);
      MimeBodyPart bodypart = new MimeBodyPart();
      bodypart.setContent(emailBody,"text/html");
      MimeMultipart multi = new MimeMultipart();
      multi.addBodyPart(bodypart);
      mimi.setContent(multi);
      return mimi;


}

void setupserverProperties() {
    Properties prop = System.getProperties();
    prop.put("mail.smtp.port", "587");
    prop.put("mail.smtp.auth", "true");
    prop.put("mail.smtp.starttls.enable", "true");
     news = Session.getDefaultInstance(prop,null);
   
}
}
