create table airport(
    id bigint not null auto_increment,
    status integer,
    created_date timestamp,
    last_modified_date timestamp,
    row_version bigint,
    name varchar(255),
    code varchar(255),
    capacity INTEGER,
    city varchar(255),
    address varchar(255),
    primary key (id)
);

create table airway(
    id bigint not null auto_increment,
    status integer,
    created_date timestamp,
    last_modified_date timestamp,
    row_version bigint,
    name varchar(255),
    logo varchar(255),
    primary key (id)
);

create table customer(
    id bigint not null auto_increment,
    status integer,
    created_date timestamp,
    last_modified_date timestamp,
    row_version bigint,
    name varchar(255),
    family_name varchar(255),
    identity_number varchar(255),
    msisdn varchar(255),
    email varchar(255),
    birth_date date,
    gender varchar(255),
    primary key (id)
);

create table flight(
    id bigint not null auto_increment,
    status integer,
    created_date timestamp,
    last_modified_date timestamp,
    row_version bigint,
    flight_no varchar(255),
    flight_date date,
    flight_time time,
    total_seat_numbers INTEGER,
    available_seat_numbers INTEGER,
    price DECIMAL,
    sale_price DECIMAL,
    route_id bigint,
    airway_id bigint,
    primary key (id)
);

create table route(
    id bigint not null auto_increment,
    status integer,
    created_date timestamp,
    last_modified_date timestamp,
    row_version bigint,
    departure_id bigint,
    destination_id bigint,
    primary key (id)
);

create table ticket(
    id bigint not null auto_increment,
    status integer,
    created_date timestamp,
    last_modified_date timestamp,
    row_version bigint,
    pnr_no varchar(255),
    card_no varchar(255),
    sale_price DECIMAL,
    customer_id bigint,
    flight_id bigint,
    primary key (id)
);
