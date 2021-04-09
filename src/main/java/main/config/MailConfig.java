package main.config;

import java.util.Properties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {
  @Value("${blog.email}")
  private String myEmail;

  @Value("${blog.emailPass}")
  private String myEmailPass;

  @Bean
  public JavaMailSender getJavaMailSender() {


    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    mailSender.setHost("smtp.mail.ru");
    mailSender.setPort(465);

    mailSender.setUsername(myEmail);
    mailSender.setPassword(myEmailPass);

    Properties props = mailSender.getJavaMailProperties();
    props.put("mail.transport.protocol", "smtp");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.debug", "true");

    props.put("mail.smtps.ssl.checkserveridentity", true);
    props.put("mail.smtps.ssl.trust", "*");
    props.put("mail.smtp.ssl.enable", "true");

    return mailSender;
  }

}
