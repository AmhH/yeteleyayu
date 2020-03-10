CREATE TABLE users
(
    id       int auto_increment,
    name     varchar(128),
    username varchar(128),
    email    varchar(256),
    phone    varchar(128),
    website  varchar(256),
    PRIMARY KEY (id)
);

insert into users(name, username, email, phone, website)
values ('Phil Philips', 'phil123', 'phil@philips.com', '555-555-5555', 'philps.com');