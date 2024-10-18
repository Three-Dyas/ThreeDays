CREATE USER 'codingGirls'@'%' IDENTIFIED BY  'codingGirls';

SHOW databases;

USE MAILBOX;

SELECT * FROM MAILBOX;

-- 2) 데이터베이스 생성 후 계정에 권한 부여
-- 데이터베이스(스키마) 생성
CREATE DATABASE MAILBOX;

SHOW GRANTS FOR 'codingGirls'@'%';

GRANT ALL PRIVILEGES ON MAILBOX.* TO 'codingGirls'@'%';

USE MAILBOX;


CREATE TABLE IF NOT EXISTS MAILBOX (
                                       authorId INT NOT NULL AUTO_INCREMENT COMMENT '작성자 아이디',
                                       author VARCHAR(255) NOT NULL COMMENT '작성자',
    authorEmail VARCHAR(255) NOT NULL COMMENT '작성자 이메일',
    receivedEmail VARCHAR(255) NOT NULL COMMENT '받는 사람 이메일',
    sendingDate DATETIME NOT NULL COMMENT '보낸 날짜',
    title VARCHAR(255) NOT NULL COMMENT '메일 제목',
    content TEXT NOT NULL COMMENT '메일 내용',
    writtenDate DATETIME NOT NULL COMMENT '작성 날짜',
    tag VARCHAR(255) COMMENT '해시태그',
    CONSTRAINT pk_authorId PRIMARY KEY (authorId)
    ) ENGINE=INNODB COMMENT '메일함';
