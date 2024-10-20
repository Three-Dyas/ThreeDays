package codinggirls.threedays;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class MailController {

    @Autowired
    MailService mailService;
    @Autowired
    private MailRepository mailRepository;

    @GetMapping("redirect")
    public ResponseEntity<?> redirect() {
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("/"));
        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
    }

    @PostMapping("/mail/send")
    public ResponseEntity<?> sendMail(@ModelAttribute MailboxDto mailDto) throws MessagingException {

        int yn = mailService.sendMail(mailDto);

        return mail(yn);
    }

    public ResponseEntity<?> mail(int yn) {
        if(yn == 1) {

            System.out.println("*** 메일 발송 및 저장 성공 ***");
            return redirect();

        } else {
            System.out.println("*** 메일 발송 실패 ***");
            return redirect();
        }


    }

    @GetMapping("/list")
    public List<Mailbox> getMailList() {
        return mailService.findAllMail();
    }
}
