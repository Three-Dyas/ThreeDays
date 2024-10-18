package codinggirls.threedays;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
