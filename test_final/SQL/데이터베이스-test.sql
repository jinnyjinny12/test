-- users 테이블 생성
CREATE TABLE users (
    user_no INT PRIMARY KEY,
    user_name VARCHAR(100) NOT NULL,
    user_address VARCHAR(255),
    user_phone VARCHAR(20),
    user_status VARCHAR(20)
);

-- books 테이블 생성
CREATE TABLE books (
    book_code INT PRIMARY KEY,
    book_title VARCHAR(255) NOT NULL,
    book_quantity INT,
    book_status VARCHAR(20)
);

-- rentals 테이블 생성
CREATE TABLE rentals (
    rental_id INT PRIMARY KEY AUTO_INCREMENT,
    user_no INT,
    book_code INT,
    rental_date DATE,
    FOREIGN KEY (user_no) REFERENCES users(user_no),
    FOREIGN KEY (book_code) REFERENCES books(book_code)
);

-- users 데이터 삽입
INSERT INTO users (user_no, user_name, user_address, user_phone, user_status) VALUES
(1, '홍길동', '서울시 강남구', '010-1234-5678', '활성'),
(2, '김철수', '서울시 서초구', '010-8765-4321', '비활성');

-- books 데이터 삽입
INSERT INTO books (book_code, book_title, book_quantity, book_status) VALUES
(101, '데이터베이스 개론', 5, '대여 가능'),
(102, '운영체제', 3, '대여 가능');

-- rentals 데이터 삽입
INSERT INTO rentals (user_no, book_code, rental_date) VALUES
(1, 101, '2023-10-01'),
(2, 102, '2023-10-02');

SELECT u.user_no, u.user_name, b.book_title
FROM rentals r
JOIN users u ON r.user_no = u.user_no
JOIN books b ON r.book_code = b.book_code
WHERE u.user_no = 1;



--도서 테이블에 사용자의 외뢔키(user_no)가 있어 엔터티관계도가 비정상적입니다 책은 사용자와 직접적인 관계를 자지 않고 책은 여러 사용자에 의해 대여될 수 있기 때문에 별도의 테이블이 필요합니다 
--이를 수정하고, 테이블 생성 스크립트(DDL)와 사용자 번호를 기준으로 대여한 도서의 제목을 조회하는 SELECT 스크립트를 작성하겠습니다.

--문제점
--1. books 테이블에 user_no가 포함되어 있어, 도서와 사용자의 관계가 1:N 관계로 표현되어 있습니다. 이는 도서가 특정 사용자에게만 대여될 수 있다는 의미로 해석될 수 있습니다.
--2. Rental_data 필드가 books 테이블에 포함되어 있어, 대여 기록이 도서 테이블에 종속되어 있습니다. 이는 대여 기록을 독립적으로 관리하기 어렵게 만듭니다.
--수정된 ERD
--1. rentals 테이블을 추가하여 대여 기록을 독립적으로 관리합니다.
--2. users 테이블과 books 테이블은 각각 독립적으로 존재하며, rentals 테이블이 두 테이블을 연결합니다.

