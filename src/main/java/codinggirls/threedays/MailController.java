package codinggirls.threedays;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

    @Autowired
    MailService mailService;

    @PostMapping("/mail/send")
    public void sendMail(@ModelAttribute MailboxDto mailDto) {
        try {
            mailService.sendMail(mailDto);
            System.out.println("*** 메일 발송 및 저장 성공 ***");
        } catch (MessagingException e) {
            System.out.println("*** 메일 발송 실패 ***");
        }
    }
}
