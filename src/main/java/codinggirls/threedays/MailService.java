package codinggirls.threedays;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender mailSender;

    @Autowired
    MailRepository mailRepository;

    @Async
    public void sendMail(MailboxDto mailDto) throws MessagingException {
        System.out.println("Received Email: " + mailDto.getReceivedEmail());
        System.out.println("Title: " + mailDto.getTitle());
        System.out.println("Content: " + mailDto.getContent());

        MimeMessage message =mailSender.createMimeMessage();

        message.addRecipients(Message.RecipientType.TO, mailDto.getReceivedEmail());
        message.setSubject(mailDto.getTitle());
        message.setText(mailDto.getContent(), "UTF-8");
        message.setFrom(mailDto.getAuthor() + " <" + mailDto.getAuthorEmail() + ">");
        mailSender.send(message);
    }
}
