create table cliente (
codigo serial primary key,
nome varchar(50),
login varchar(50) unique,
senha varchar(20) );

create table departamento(
codigo serial primary key,
nome varchar(50));

insert into departamento(nome) values ('Camisetas'), ('Casacos'), ('Sneakers');

select * from departamento;

create table produto (
codigo serial primary key,
descricao varchar(50),
preco float,
qtde int check(qtde >=0),
imagem varchar(100),
coddep int not null references departamento(codigo) on update cascade);

insert into produto (descricao, preco, qtde, imagem, coddep) values('Camisa Oakley', 100, 4, 'Oakley.jpg', 1)
insert into produto (descricao, preco, qtde, imagem, coddep) values('Camisa Nike', 60, 4, 'Camisanike.jpg', 1)
insert into produto (descricao, preco, qtde, imagem, coddep) values('Camisa Adidas', 80, 4, 'Camisaadidas.jpg', 1)
insert into produto (descricao, preco, qtde, imagem, coddep) values('Camisa Gucci', 300, 4, 'Gucci.jpg', 1)
insert into produto (descricao, preco, qtde, imagem, coddep) values('Camisa Puma', 150, 4, 'Puma.jpg', 1)

insert into produto (descricao, preco, qtde, imagem, coddep) values('Moletom Love', 150, 4, 'MoletomLove.jpg', 2)
insert into produto (descricao, preco, qtde, imagem, coddep) values('Moletom Lakers', 300, 4, 'MoletomLakers.jpg', 2)
insert into produto (descricao, preco, qtde, imagem, coddep) values('Moletom DC', 200, 4, 'MoletomDC.jpg', 2)
insert into produto (descricao, preco, qtde, imagem, coddep) values('Sobretudo Masculino', 500, 4, 'Sobretudo.jpg', 2)
insert into produto (descricao, preco, qtde, imagem, coddep) values('Moletom Adidas Skateboarding', 150, 4, 'MoletomAdidas.jpg', 2)

insert into produto (descricao, preco, qtde, imagem, coddep) values('Balenciaga Speed', 5200, 4, 'Balenciaga.png', 3);
insert into produto (descricao, preco, qtde, imagem, coddep) values('Nike AirJordan1', 1200, 4, 'Jordan.jpg', 3);
insert into produto (descricao, preco, qtde, imagem, coddep) values('Adidas Yeezy Boost 350', 1500, 4, 'AdidasYeezy.jpg', 3);
insert into produto (descricao, preco, qtde, imagem, coddep) values('Puma Suede', 300, 4, 'PumaSuede.jpg', 3);
insert into produto (descricao, preco, qtde, imagem, coddep) values('Gucci Ace', 3000, 4, 'GucciAce.jpg', 3);

select * from produto;

create table venda(
codigo serial primary key,
total float default 0,
datav timestamp default current_timestamp,
codcli int not null references cliente(codigo) on update cascade);

create table item (
qtde int check(qtde>0),
precounit float,
codproduto int not null references produto(codigo) on update cascade,
codvenda int not null references venda(codigo) on update cascade);

select * from item;
select * from venda;
select * from cliente;

select max(codigo) from venda;