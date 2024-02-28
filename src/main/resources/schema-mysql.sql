DROP TABLE IF EXISTS users;
create table users (
                       id INT,
                       userid VARCHAR(50),
                       firstname VARCHAR(50),
                       lastname VARCHAR(50),
                       dob DATE,
                       email VARCHAR(50),
                       phone VARCHAR(50)
);

DROP TABLE IF EXISTS performers;
create table performers (
                       id INT,
                       performerid VARCHAR(50),
                       firstname VARCHAR(50),
                       lastname VARCHAR(50),
                       stagename VARCHAR(50),
                       dob DATE,
                       email VARCHAR(50),
                       phone VARCHAR(50)
);