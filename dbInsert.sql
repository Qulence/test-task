INSERT INTO AUTHOR (FIRSTNAME, LASTNAME, PATRONYMIC) VALUES ('Роберт', 'Мартин', 'Сесил');
INSERT INTO AUTHOR (FIRSTNAME, LASTNAME, PATRONYMIC) VALUES ('Виктор', 'Олифер', 'Григорьевич');
INSERT INTO AUTHOR (FIRSTNAME, LASTNAME, PATRONYMIC) VALUES ('Кэтти', 'Сьерра', '');
INSERT INTO AUTHOR (FIRSTNAME, LASTNAME, PATRONYMIC) VALUES ('Кайл', 'Симпсон', '');

INSERT INTO GENRE(NAME) VALUES ('Зарубежная компьютерная литература');
INSERT INTO GENRE(NAME) VALUES ('Учебник для вузов');

INSERT INTO BOOK(NAME, AUTHOR_ID, GENRE_ID, PUBLISHER, YEAR, CITY) VALUES ('Чистый код',0, 0,'Питер',  2019, 'Санкт-Петербург');
INSERT INTO BOOK(NAME, AUTHOR_ID, GENRE_ID, PUBLISHER, YEAR, CITY) VALUES ('Компьютерные сети',1, 1,'Питер',  2016, 'Санкт-Петербург');
INSERT INTO BOOK(NAME, AUTHOR_ID, GENRE_ID, PUBLISHER, YEAR, CITY) VALUES ('Head First. Паттерны проектирования. Обновленное юбилейное издание', 2, 0,'Питер',  2018, 'Санкт-Петербург');
INSERT INTO BOOK(NAME, AUTHOR_ID, GENRE_ID, PUBLISHER, YEAR, CITY) VALUES ('ES6 & не только', 3, 0, 'O’Reilly', 2017, 'Санкт-Петербург');