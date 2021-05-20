CREATE TABLE Member(
    member_num      NUMBER          PRIMARY KEY,
    id              VARCHAR2(20)    NOT NULL,
    pw              VARCHAR2(20)    NOT NULL,
    name            VARCHAR2(20),
    email           VARCHAR2(50),
    address         VARCHAR2(300),
    tel             VARCHAR2(14),
    p_image         VARCHAR2(100)
);

CREATE TABLE Board(
    board_num       NUMBER          PRIMARY KEY,
    title           VARCHAR2(50)    NOT NULL,
    cate            NUMBER          DEFAULT 2,
    author          NUMBER,
    pub_date        DATE            DEFAULT SYSDATE,
    mod_date        DATE            DEFAULT SYSDATE,
    view_cnt        NUMBER          DEFAULT 0,
    like_cnt        NUMBER          DEFAULT 0,
    content         VARCHAR2(2000),
    FOREIGN KEY (author) REFERENCES Member(member_num)
);

CREATE TABLE Reply(
    reply_num       NUMBER          PRIMARY KEY,
    board_num       NUMBER,
    author          NUMBER,
    pub_date        DATE            DEFAULT SYSDATE,
    mod_date        DATE            DEFAULT SYSDATE,
    rpy_parent_num  NUMBER,
    content         VARCHAR2(1000),
    FOREIGN KEY (board_num) REFERENCES Board(board_num),
    FOREIGN KEY (author) REFERENCES Member(member_num),
    FOREIGN KEY (rpy_parent_num) REFERENCES Reply(reply_num)
);