create database Explore_Agencia;

/* Modelo Lógico_1: */

CREATE TABLE cidades (
    Nome VARCHAR(30),
    Estado CHAR(2),
    Pais VARCHAR(20),
    Continente VARCHAR(30),
    ID INT PRIMARY KEY auto_increment
    
);
select * from cidades;
insert into cidades(nome,estado,pais,continente) values("Salvador","BA","Brasil","America do sul");
insert into cidades(nome,estado,pais,continente) values("Duque de Caxias","RJ","Brasil","America do sul");
insert into cidades(nome,estado,pais,continente) values("São Paulo","SP","Brasil","America do sul");
 insert into cidades(nome,estado,pais,continente) values("Rio de Janeiro","RJ","Brasil","America do sul");
insert into cidades(nome,estado,pais,continente) values("Brasília","DF","Brasil","America do sul");
 insert into cidades(nome,estado,pais,continente) values("Recife","PE","Brasil","America do sul");
insert into cidades(nome,estado,pais,continente) values("Fortaleza","CE","Brasil","America do sul");
insert into cidades(nome,estado,pais,continente) values("California","CA","EUA","America do Norte");
insert into cidades(nome,estado,pais,continente) values("Orlando","FL","EUA","America do Norte");
insert into cidades(nome,estado,pais,continente) values("Lisboa","LB","Portugal","Europa");
insert into cidades(nome,estado,pais,continente) values("Madri","MA","Espanha","Europa");
insert into cidades(nome,estado,pais,continente) values("Londres","LO","Inglaterra","Europa");
CREATE TABLE Pacote (
    Diaria INT,
    Preco DOUBLE,
    Cafe_manha BOOLEAN,
    ID INT PRIMARY KEY auto_increment,
    ID_cidade INT,
    foreign key (ID_cidade) references cidades(id)
);
insert into pacote(id_cidade,diaria,preco,cafe_manha)
values(1,4,300.99,false);
insert into pacote(id_cidade,diaria,preco,cafe_manha)
values(3,5,800.99,false);
insert into pacote(id_cidade,diaria,preco,cafe_manha)
values(4,3,550.99,false);
insert into pacote(id_cidade,diaria,preco,cafe_manha)
values(5,3,580.99,false);
insert into pacote(id_cidade,diaria,preco,cafe_manha)
values(6,4,850.99,false);
insert into pacote(id_cidade,diaria,preco,cafe_manha)
values(7,9,950.99,false);
insert into pacote(id_cidade,diaria,preco,cafe_manha)
values(2,4,600.99,true);
insert into pacote(id_cidade,diaria,preco,cafe_manha)
values(6,6,900.99,true);
insert into pacote(id_cidade,diaria,preco,cafe_manha)
values(10,4,300.99,false);
insert into pacote(id_cidade,diaria,preco,cafe_manha)
values(11,4,300.99,false);
insert into pacote(id_cidade,diaria,preco,cafe_manha)
values(10,4,300.99,true);
insert into pacote(id_cidade,diaria,preco,cafe_manha)
values(9,4,500.99,false);
insert into pacote(id_cidade,diaria,preco,cafe_manha)
values(8,4,400.99,false);
insert into pacote(id_cidade,diaria,preco,cafe_manha)
values(12,4,900.99,false);
select * from pacote;









 


