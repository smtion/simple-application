create database if not exists test;
use test;

create table if not exists employee (
    emp_no  int(11)     not null    auto_increment  primary key,
    emp_nm  varchar(20) not null
);

create table if not exists prod (
    prod_no     int(11)     not null    auto_increment  primary key,
    prod_nm     varchar(20) not null,
    partner_id  varchar(20) not null,
    md_emp_no   int(11)     not null,
    sale_status varchar(1)  not null
);

create table if not exists deal (
    deal_no     int(11)     not null    auto_increment  primary key,
    deal_nm     varchar(20) not null
);

create table if not exists deal_prod (
    deal_no   int(11)     not null,
    prod_no   int(11)     not null
);
alter table deal_prod add primary key(deal_no, prod_no);

create table if not exists test (
    id          int(11)     not null    auto_increment  primary key,
    name        varchar(20) not null,
    description varchar(99) not null
);