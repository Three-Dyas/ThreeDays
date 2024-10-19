package codinggirls.threedays;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MailboxDto {

    private int authorId;
    private String author;
    private String authorEmail;
    private String receivedEmail;
    private String sendingDate;
    private String title;
    private String content;
    private String writtenDate;
    private String tag;
}
