# lojaAutomoveis

> Tabelas SQL
```sql

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

CREATE TABLE `automovel` (
  `Codigo` int(11) NOT NULL,
  `Fabricante` varchar(50) NOT NULL,
  `modelo` varchar(50) NOT NULL,
  `preco` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `automovel` (`Codigo`, `Fabricante`, `modelo`, `preco`) VALUES
(10, 'Chevrolet', 'Zafira', 35000),
(12, 'Chevrolet', 'Zafira', 38000),
(13, 'Chevrolet', 'Zafira', 75000),
(14, 'Chevrolet', 'Vectra', 45000),
(15, 'Chevrolet', 'Vectra', 50000),
(16, 'Chevrolet', 'Astra ', 35000),
(17, 'Chevrolet', 'Astra ', 47000),
(18, 'Chevrolet', 'Astra ', 52010),
(20, 'Fiat', 'Uno', 20100);

CREATE TABLE `cliente` (
  `CPF` char(11) NOT NULL,
  `Nome` varchar(20) NOT NULL,
  `Cidade` varchar(30) NOT NULL,
  `Estado` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `cliente` (`CPF`, `Nome`, `Cidade`, `Estado`) VALUES
('01', 'john Oats', 'Rio de Janeiro', 'RJ'),
('02', 'Daryl Hall', 'Rio de Janeiro', 'RJ'),
('03', 'DC Sunshine Band', 'Brasilia', 'DF'),
('04', 'Donna Summer', 'Brasilia', 'DF'),
('05', 'Air Supply', 'Brasilia', 'DF');


CREATE TABLE `funcionario` (
  `Nome` varchar(20) NOT NULL,
  `CPF` char(11) NOT NULL,
  `Matricula` char(8) NOT NULL,
  `cargo` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `funcionario` (`Nome`, `CPF`, `Matricula`, `cargo`) VALUES
('David', '10', '0001', 'Gerente'),
('joão', '11', '0002', 'vendedor'),
('maria', '12', '0003', 'vendedor');

CREATE TABLE `negocio` (
  `CPF` char(11) DEFAULT NULL,
  `Matricula` char(8) DEFAULT NULL,
  `Codigo` int(11) DEFAULT NULL,
  `DataCompra` date DEFAULT NULL,
  `PrecoPago` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

ALTER TABLE `automovel`
  ADD PRIMARY KEY (`Codigo`);

ALTER TABLE `cliente`
  ADD PRIMARY KEY (`CPF`);

ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`Matricula`),
  ADD UNIQUE KEY `CPF` (`CPF`),
  ADD UNIQUE KEY `Matricula` (`Matricula`);

ALTER TABLE `negocio`
  ADD KEY `FK01` (`Matricula`),
  ADD KEY `FK02` (`CPF`),
  ADD KEY `FK03` (`Codigo`);

ALTER TABLE `negocio`
  ADD CONSTRAINT `FK01` FOREIGN KEY (`Matricula`) REFERENCES `funcionario` (`Matricula`),
  ADD CONSTRAINT `FK02` FOREIGN KEY (`CPF`) REFERENCES `cliente` (`CPF`),
  ADD CONSTRAINT `FK03` FOREIGN KEY (`Codigo`) REFERENCES `automovel` (`Codigo`);
COMMIT;

```