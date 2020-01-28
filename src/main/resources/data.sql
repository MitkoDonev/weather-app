DROP TABLE USERS IF EXISTS;
DROP TABLE city IF EXISTS;
DROP TABLE weather IF EXISTS;

CREATE TABLE users (
id INTEGER AUTO_INCREMENT PRIMARY KEY,
username VARCHAR(45) UNIQUE NOT NULL,
password VARCHAR(45) NOT NULL,
)

CREATE TABLE city (
id INT AUTO_INCREMENT NOT NULL,
city_name VARCHAR(45) NOT NULL,
country VARCHAR(45) NOT NULL,
)

CREATE TABLE weather(
id INT AUTO_INCREMENT PRIMARY KEY,
city_id INT NOT NULL,
date_time DATE NOT NULL,
highest_temp INT NOT NULL,
highest_lowest INT NOT NULL,
precip INT NOT NULL,
wind VARCHAR(45) NOT NULL,
humidity INT NOT NULL,
description VARCHAR(80) NOT NULL,
)

INSERT INTO USERS VALUES
(1, 'mitko', 'mitko123'),
(2, 'racho', 'racho123'),
(3, 'radi', '123');

INSERT INTO CITY VALUES
(1, 'Sofia', 'Bulgaria'),
(2, 'Burgas', 'Bulgaria'),
(3, 'Plovdiv', 'Bulgaria');


INSERT INTO weather VALUES
(1,1, '2004-12-31', '40', '-20', '33', 'WNW 120 km/h', '54', 'test text for test number 1'),
(2, 2, '2004-12-31', '46', '-5', '50', 'WSW 193 km/h', '85', 'test text for test number 2'),
(3, 3, '2004-12-31', '55', '-19', '12', 'W 148 km/h', '23', 'test text for test number 3');