# t10baas
Koostage Java rakendus, mille abil on võimalik andmebaasi andmeid vaadata ning neid sinna lisada,
paremal juhul ka kustutada ja muuta.

CREATE TABLE Players (
ID int AUTO_INCREMENT PRIMARY KEY,
Name varchar(35) NOT NULL,
Number int,
Team varchar(35), 
Points float NOT NULL,
Games int NOT NULL,
Minutes float NOT NULL,
Salary int
);
