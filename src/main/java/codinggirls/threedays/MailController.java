package codinggirls.threedays;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class MailController {

    @Autowired
    MailService mailService;

    @GetMapping("redirect")
    public ResponseEntity<?> redirect() {
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("/"));
        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
    }

    @PostMapping("/mail/send")
    public ResponseEntity<?> sendMail(@ModelAttribute MailboxDto mailDto) {
        try {
            mailService.sendMail(mailDto);

            System.out.println("*** 메일 발송 및 저장 성공 ***");
            return redirect();

        } catch (MessagingException e) {
            System.out.println("*** 메일 발송 실패 ***");
            return redirect();
        }

    }
}
