DROP TABLE IF EXISTS BOOK;
DROP TABLE IF EXISTS GENRE;
DROP TABLE IF EXISTS AUTHOR;

CREATE TABLE IF NOT EXISTS AUTHOR
(
    ID         BIGINT IDENTITY PRIMARY KEY,
    FIRSTNAME  VARCHAR(64) NOT NULL,
    LASTNAME   VARCHAR(64) NOT NULL,
    PATRONYMIC VARCHAR(64)
);

CREATE TABLE IF NOT EXISTS GENRE
(
    ID   BIGINT IDENTITY PRIMARY KEY,
    NAME VARCHAR(64) NOT NULL
);

CREATE TABLE IF NOT EXISTS BOOK
(
    ID        BIGINT IDENTITY PRIMARY KEY,
    NAME      VARCHAR(128)                  NOT NULL,
    AUTHOR_ID BIGINT REFERENCES AUTHOR (ID) NOT NULL,
    GENRE_ID  BIGINT REFERENCES GENRE (ID)  NOT NULL,
    PUBLISHER VARCHAR(32)                   NOT NULL,
    YEAR      SMALLINT                      NOT NULL,
    CITY      VARCHAR(64)                   NOT NULL,
    CHECK (PUBLISHER IN ('Москва', 'Питер', 'O’Reilly'))
);
--todo many-to-many book-genre, book-author?