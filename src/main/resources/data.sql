INSERT INTO article(title, content) VALUES ('가가','11');
INSERT INTO article(title, content) VALUES ('나나','22');
INSERT INTO article(title, content) VALUES ('다다','33');
INSERT INTO article(title, content) VALUES ('당신의 인생 영화는?','댓글 고');
INSERT INTO article(title, content) VALUES ('당신의 소울 푸드는?','댓글 고고');
INSERT INTO article(title, content) VALUES ('당신의 취미는?','댓글 고고고');

INSERT INTO comment(article_id, nickname, body) VALUES (4, 'Park', '굿 윌 헌팅' );
INSERT INTO comment(article_id, nickname, body) VALUES (4, 'Kim', '아이 엠 샘' );
INSERT INTO comment(article_id, nickname, body) VALUES (5, 'Park', '치킨' );
INSERT INTO comment(article_id, nickname, body) VALUES (5, 'Kim', '샤브샤브' );
INSERT INTO comment(article_id, nickname, body) VALUES (6, 'Park', '조깅' );
INSERT INTO comment(article_id, nickname, body) VALUES (6, 'Kim', '유튜브' );

INSERT INTO member(id, email, password) VALUES (1,'hihi@naver.com','1111');

INSERT INTO coffee(name, price) VALUES ('아메리카노', '4500');
INSERT INTO coffee(name, price) VALUES ('라떼', '5000');
INSERT INTO coffee(name, price) VALUES ('카페 모카', '5500');
