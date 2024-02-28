DROP TABLE IF EXISTS tickets;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS events;
DROP TABLE IF EXISTS performers;
create table users (
                       id INT AUTO_INCREMENT,
                       userid VARCHAR(50),
                       firstname VARCHAR(50),
                       lastname VARCHAR(50),
                       dob DATE,
                       email VARCHAR(50),
                       phone VARCHAR(50),
                       PRIMARY KEY(id)
);

create table performers (
                       id INT NOT NULL AUTO_INCREMENT,
                       performerid VARCHAR(50) NOT NULL UNIQUE,
                       firstname VARCHAR(50),
                       lastname VARCHAR(50),
                       stagename VARCHAR(50),
                       dob DATE,
                       email VARCHAR(50),
                       phone VARCHAR(50),
                       PRIMARY KEY(id)
);

create table events (
                        id INT AUTO_INCREMENT,
                        eventid VARCHAR(40),
                        eventname VARCHAR(50),
                        startsat DATE,
                        endsat DATE,
                        eventtype VARCHAR(10),
                        performerid VARCHAR(40),
                        PRIMARY KEY(id),
                        FOREIGN KEY(performerid) REFERENCES performers(performerid)
);

create table tickets (
                         id INT,
                         ticketid VARCHAR(40),
                         purchasetime DATE
);

create table venues (
                         id INT,
                         venueid VARCHAR(40),
                         unit INT,
                         street VARCHAR(50),
                         city VARCHAR(50),
                         province VARCHAR(50),
                         country VARCHAR(50),
                         venuename VARCHAR(50)
);