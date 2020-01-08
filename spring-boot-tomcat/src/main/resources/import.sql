insert into clientes(nombre,apellido,email,create_at, foto) values ('Andres','Guzman','andres@guzman.com','2017-08-28','');
insert into clientes(nombre,apellido,email,create_at, foto) values ('Jhon','Doe','jhon@doe.com','2017-08-29','');


insert into productos(nombre,precio,create_at) values ('Panasonic Pantalla LCD', 259990, NOW());
insert into productos(nombre,precio,create_at) values ('Sony Camara digital DSC-W320B', 123490, NOW());
insert into productos(nombre,precio,create_at) values ('Apple iPod shuffle', 1499990, NOW());
insert into productos(nombre,precio,create_at) values ('Sony Notebook Z110', 37990, NOW());
insert into productos(nombre,precio,create_at) values ('Hewlett Packard Multifuncional F2280', 69990, NOW());
insert into productos(nombre,precio,create_at) values ('Bianchi Bicicleta Aro 26', 69990, NOW());
insert into productos(nombre,precio,create_at) values ('Mica Comoda 5 Cajones', 299990, NOW());

insert into facturas(descripcion, observacion, cliente_id, create_at) values ('Factura equipos de oficina', null, 1, now());
insert into facturas_items(cantidad, factura_id, producto_id) values (1,1,1);
insert into facturas_items(cantidad, factura_id, producto_id) values (2,1,4);
insert into facturas_items(cantidad, factura_id, producto_id) values (1,1,5);
insert into facturas_items(cantidad, factura_id, producto_id) values (1,1,7);

insert into facturas(descripcion, observacion, cliente_id, create_at) values ('Factura Bicicleta', 'Alguna nota importante', 1, now());
insert into facturas_items(cantidad, factura_id, producto_id) values (3,2,6);

INSERT INTO users (username, password, enabled) VALUES('andres', '$2a$10$C33v390RRes2c9Jpu6GD9.lgr3PMQr.UKD.4UJpQZKUoQkhSjWvHe', 1);
INSERT INTO users (username, password, enabled) VALUES('admin', '$2a$10$bBTKl2wMnXDomTV1aYvDYOCLHrua.jnXvsaaZRVmzf5iMUOR5eVAK', 1);

INSERT INTO authorities (user_id, authority) VALUES (1, 'ROLE_USER');
INSERT INTO authorities (user_id, authority) VALUES (2, 'ROLE_ADMIN');
INSERT INTO authorities (user_id, authority) VALUES (2, 'ROLE_USER');



