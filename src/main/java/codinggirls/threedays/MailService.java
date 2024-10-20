package codinggirls.threedays;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender mailSender;

    @Autowired
    MailRepository mailRepository;

    @Async
    public int sendMail(MailboxDto mailDto) throws MessagingException {
        System.out.println("Received Email: " + mailDto.getReceivedEmail());
        System.out.println("Title: " + mailDto.getTitle());
        System.out.println("Content: " + mailDto.getContent());
        int yn = 0;
        MimeMessage message =mailSender.createMimeMessage();

        message.addRecipients(Message.RecipientType.TO, mailDto.getReceivedEmail());
        message.setSubject(mailDto.getTitle());

        String msg = mailDto.getContent();
        msg += "<hr>";
        msg += "본 메일은 <strong>\uD83E\uDD8A코딩걸즈\uD83E\uDD8A</strong>의 메일전송함에서 발송된 메일입니다.";
        message.setText(msg, "UTF-8", "html");

        message.setFrom(mailDto.getAuthor() + " <" + mailDto.getAuthorEmail() + ">");
        mailSender.send(message);

        Mailbox mail = convertDtoToEntity(mailDto);



        System.out.println("태그" + mail.getTag());
        mailRepository.save(mail);

        if(mailRepository.count()>0) {
            yn = 1;
            System.out.println(mail);
        };

        return yn;
    }

    private Mailbox convertDtoToEntity(MailboxDto mailDto) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String currentDate = now.format(formatter);

        return Mailbox.builder()
                .author(mailDto.getAuthor())
                .authorEmail(mailDto.getAuthorEmail())
                .receivedEmail(mailDto.getReceivedEmail())
                .sendingDate(currentDate)
                .title(mailDto.getTitle())
                .content(mailDto.getContent())
                .writtenDate(currentDate)
                .tag(mailDto.getTag())
                .build();
    }

    public List<Mailbox> findAllMail(){
        return mailRepository.findAll();
    }


}
