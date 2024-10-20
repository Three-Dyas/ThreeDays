package codinggirls.threedays;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MAILBOX")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mailbox {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authorId", updatable = false)
    private int authorId;

    @Column(name="author" ,nullable = false)
    private String author;

    @Column(name = "authorEmail", nullable = false)
    private String authorEmail;

    @Column(name="receivedEmail",nullable = false)
    private String receivedEmail;

    @Column(name="sendingDate",nullable = false)
    private String sendingDate;

    @Column(name ="title" , nullable = false)
    private String title;

    @Column(name = "content",nullable = false)
    private String content;

    @Column(name = "writtenDate",nullable = false)
    private String writtenDate;

    @Column(name = "tag")
    private String tag;

    @Builder
    public Mailbox(String author, String authorEmail, String receivedEmail, String sendingDate,
                   String title, String content, String writtenDate, String tag) {
        this.author = author;
        this.authorEmail = authorEmail;
        this.receivedEmail = receivedEmail;
        this.sendingDate = sendingDate;
        this.title = title;
        this.content = content;
        this.writtenDate = writtenDate;
        this.tag = tag;
    }
}