DROP TABLE USERS IF EXISTS;
DROP TABLE WEATHER IF EXISTS;
DROP TABLE CITIES IF EXISTS;

CREATE TABLE users
(
    id       INTEGER AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(45) UNIQUE NOT NULL,
    password VARCHAR(45)        NOT NULL
);

CREATE TABLE cities
(
    id        INT AUTO_INCREMENT NOT NULL,
    city_name VARCHAR(45)        NOT NULL,
    country   VARCHAR(45)        NOT NULL
);

CREATE TABLE WEATHER
(
    id             INT AUTO_INCREMENT PRIMARY KEY,
    city_id        INT         NOT NULL,
    date_time      DATE                ,
    highest_temp   INT         NOT NULL,
    lowest_temp    INT         NOT NULL,
    precipitation  INT         NOT NULL,
    wind           VARCHAR(45) NOT NULL,
    humidity       INT         NOT NULL,
    description    VARCHAR(80) NOT NULL
);

INSERT INTO USERS VALUES (1000, 'mitko', 'mitko123');
INSERT INTO USERS VALUES (2000, 'racho', 'racho123');
INSERT INTO USERS VALUES (3000, 'radi', '123');

INSERT INTO CITIES VALUES (1000, 'Sofia', 'Bulgaria');
INSERT INTO CITIES VALUES  (2000, 'Burgas', 'Bulgaria');
INSERT INTO CITIES VALUES  (3000, 'Plovdiv', 'Bulgaria');


INSERT INTO WEATHER VALUES (1000, 1000, '2004-12-31', '40', '-20', '33', 'WNW 120 km/h', '54', 'test text for test number 1');
INSERT INTO WEATHER VALUES (2000, 2000, '2004-12-31', '46', '-5', '50', 'WSW 193 km/h', '85', 'test text for test number 2');
INSERT INTO WEATHER VALUES (3000, 3000, '2004-12-31', '55', '-19', '12', 'W 148 km/h', '23', 'test text for test number 3');