# lojaAutomoveis

> Tabelas SQL
```sql
Create table automovel
( 
    Codigo int  NOT NULL,
    Fabricante varchar(50)  NOT NULL,
    modelo varchar(50)  NOT NULL,
    preco float  NOT NULL

);


Create table cliente  
(
    CPF char(11)  UNIQUE NOT NULL,
    Nome varchar(20) NOT NULL,
    Cidade varchar(30) NOT NULL,
    Estado varchar(30) NOT NULL
    
);


Create table funcionario  
(
    Nome varchar(20) NOT NULL,
    CPF char(11)  UNIQUE NOT NULL,
    Matricula char(8) UNIQUE NOT NULL,
    cargo varchar(30) NOT NULL
);



CREATE TABLE negocio
(
    CPF char(11),
    Matricula char(8),
    Codigo int,
    DataCompra date,
    PrecoPago float

);


ALTER  table automovel   add CONSTRAINT PK01 PRIMARY KEY(Codigo);
ALTER  table cliente   add CONSTRAINT PK02 PRIMARY KEY(CPF);
ALTER  table funcionario add CONSTRAINT PK03 PRIMARY KEY(Matricula);

ALTER  table negocio add CONSTRAINT FK01 FOREIGN KEY (Matricula)  REFERENCES Funcionario(Matricula);
ALTER  table negocio add CONSTRAINT FK02 FOREIGN KEY (CPF)        REFERENCES cliente(CPF);
ALTER  table NEGOCIO add CONSTRAINT FK03 FOREIGN KEY (Codigo)     REFERENCES automovel(Codigo);


insert into automovel values
(10,'Chevrolet'    ,'Zafira'    ,35000),
(12,'Chevrolet'    ,'Zafira'    ,38000),
(13,'Chevrolet'    ,'Zafira'    ,75000),
(14,'Chevrolet'    ,'Vectra'    ,45000),
(15,'Chevrolet'    ,'Vectra'    ,50000),
(16,'Chevrolet'    ,'Astra '    ,35000),
(17,'Chevrolet'    ,'Astra '    ,47000),
(18,'Chevrolet'    ,'Astra '    ,52010),
(20,'Fiat'    ,'Uno'        ,20100);

insert into cliente values
 ('01','john Oats', 'Rio de Janeiro', 'RJ' ),
 ('02','Daryl Hall', 'Rio de Janeiro', 'RJ' ),
 ('03','DC Sunshine Band', 'Brasilia', 'DF' ),
 ('04','Donna Summer', 'Brasilia', 'DF' ),
 ('05','Air Supply', 'Brasilia', 'DF' );

 insert into Funcionario values
('David','10','0001','Gerente'),
('joão','11','0002','vendedor'),
('maria','12','0003','vendedor');



```