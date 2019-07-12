create table orders
(
    id         bigint unsigned auto_increment,
    cartNumber varchar(50)          not null comment 'generated cart order number for reference',
    productId  int                  not null,
    userId     int                  not null,
    pending    tinyint(1) default 1 not null comment 'item not bought yet and is still in cart',
    constraint orders_id_uindex
        unique (id)
)
    comment 'all orders, pending and closed';

alter table orders
    add primary key (id);

create table products
(
    id          bigint unsigned auto_increment,
    name        varchar(1000)        null,
    description text                 null,
    price       double               null comment 'BAM default',
    featured    tinyint(1) default 0 not null comment 'is featured at welcome page',
    constraint products_id_uindex
        unique (id)
)
    comment 'webshop products';

alter table products
    add primary key (id);

INSERT INTO webshop.products (id, name, description, price, featured) VALUES (1, 'Lenovo Laptip', 'Idea Pad Novi laptop za vise namjenske potrebe', 1500, 0);
INSERT INTO webshop.products (id, name, description, price, featured) VALUES (2, 'Slusalice', 'Esp slusalice', 60, 0);
INSERT INTO webshop.products (id, name, description, price, featured) VALUES (3, 'Razer Mis', 'Razer Naga', 550, 0);
INSERT INTO webshop.products (id, name, description, price, featured) VALUES (4, 'Clutch Seats', 'Computer chair', 399, 0);
create table users
(
    id               bigint unsigned auto_increment,
    email            varchar(100)                   not null,
    password         varchar(1000)                  null comment 'SHA512 encoded password',
    shipping_address varchar(1000)                  null,
    phone            varchar(100)                   null,
    items_bought     int         default 0          null comment 'number of items bought by user',
    role             varchar(10) default 'customer' not null,
    constraint id
        unique (id)
)
    comment 'webshop users';

alter table users
    add primary key (id);

INSERT INTO webshop.users (id, email, password, shipping_address, phone, items_bought, role) VALUES (2, 'krlicmuhamed@gmail.com', '5b19de423adf4a563de418be480cc302bd9c7f79b151778f78d627e8320b3786bc345afd55e9536cfe6d18776d862fa6ac92ea31977523ac3c0b10a7989fce17', 'Bare kod stupa 59', '+387 61 981 500', 0, 'customer');