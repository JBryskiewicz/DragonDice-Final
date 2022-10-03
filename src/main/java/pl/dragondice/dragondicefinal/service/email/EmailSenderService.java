package pl.dragondice.dragondicefinal.service.email;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@AllArgsConstructor
public class EmailSenderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmailSenderService.class);

    private static final String FROM_EMAIL = "[email_placeholder]";
    private static final String ENCODING = "utf-8";
    private static final String SUBJECT_VERIFY = "'Dragon Dice' account verification.";
    private static final String SUBJECT_RECOVER = "'Dragon Dice' password reset.";
    private static final String ERROR_MESSAGE = "Failed to send email";
    private final JavaMailSender mailSender;

    @Async
    public void sendConfirmationEmail(String toEmail, String email){
        try{
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, ENCODING);
            helper.setText(email, true);
            helper.setTo(toEmail);
            helper.setSubject(SUBJECT_VERIFY);
            helper.setFrom(FROM_EMAIL);
            mailSender.send(mimeMessage);
        }catch (MessagingException e){
            LOGGER.error(ERROR_MESSAGE, e);
            throw new IllegalStateException(ERROR_MESSAGE);
        }
    }

    @Async
    public void sendRecoveryEmail(String toEmail, String email){
        try{
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, ENCODING);
            helper.setText(email, true);
            helper.setTo(toEmail);
            helper.setSubject(SUBJECT_RECOVER);
            helper.setFrom(FROM_EMAIL);
            mailSender.send(mimeMessage);
        }catch (MessagingException e){
            LOGGER.error(ERROR_MESSAGE, e);
            throw new IllegalStateException(ERROR_MESSAGE);
        }
    }
}
