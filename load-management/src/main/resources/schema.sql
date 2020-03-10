drop table LOAD if exists;
drop table LOCATION if exists;
drop table `ORDER` if exists;

create table LOAD(
    id bigint not null auto_increment,
    equipment_type varchar(255),
    hazmat boolean not null,
    ltl boolean not null,
    miles float not null,
    stops integer not null,
    weight float not null,
    destination_id bigint,
    origin_id bigint,
    primary key (id));

create table LOCATION(
    id bigint not null auto_increment,
    city varchar(255),
    state varchar(255),
    zipcode varchar(255),
    primary key (id));

create table `ORDER`(
    id bigint not null auto_increment,
    delivery_date_time DATETIME,
    hazmat boolean not null,
    pick_up_date_time DATETIME,
    delivery_stop_id bigint,
    load_id bigint,
    pick_up_stop_id bigint,
    primary key (id));

alter table LOCATION add constraint UK_LOCATIONS_ZIP_CODE unique (zipcode);
alter table LOAD add constraint FK_LOCATIONS_LOADS_DEST_ID foreign key (destination_id) references LOCATION;
alter table LOAD add constraint FK_LOCATIONS_LOADS_ORIGIN_ID foreign key (origin_id) references LOCATION;
alter table `ORDER` add constraint FK_LOCATIONS_ORDERS_DEL_STOP_ID foreign key (delivery_stop_id) references LOCATION;
alter table `ORDER` add constraint FK_LOADS_ORDERS_LOAD_ID foreign key (load_id) references LOAD;
alter table `ORDER` add constraint FK_LOCATIONS_ORDERS_PICK_STOP_ID foreign key (pick_up_stop_id) references LOCATION;
