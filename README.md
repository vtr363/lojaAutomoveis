# lojaAutomoveis

> Tabelas SQL
```sql

-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Tempo de geração: 07-Dez-2022 às 16:22
-- Versão do servidor: 10.4.25-MariaDB
-- versão do PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `AutoVendas`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `automovel`
--

CREATE TABLE `automovel` (
  `Codigo` int(11) NOT NULL,
  `Fabricante` varchar(50) NOT NULL,
  `modelo` varchar(50) NOT NULL,
  `preco` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `automovel`
--

INSERT INTO `automovel` (`Codigo`, `Fabricante`, `modelo`, `preco`) VALUES
(10, 'Chevrolet', 'Zafira', 36000),
(12, 'Chevrolet', 'Zafira', 38000),
(13, 'Chevrolet', 'Zafira', 75000),
(14, 'Chevrolet', 'Vectra', 45000),
(15, 'Chevrolet', 'Vectra', 50000),
(16, 'Chevrolet', 'Astra ', 35000),
(17, 'Chevrolet', 'Astra ', 47000),
(18, 'Chevrolet', 'Astra ', 52010),
(20, 'Fiat', 'Uno', 20100);

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `CPF` char(11) NOT NULL,
  `Nome` varchar(20) NOT NULL,
  `Cidade` varchar(30) NOT NULL,
  `Estado` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`CPF`, `Nome`, `Cidade`, `Estado`) VALUES
('01', 'john Oats', 'São Paulo', 'SP'),
('02', 'Daryl Hall', 'Rio de Janeiro', 'RJ'),
('03', 'DC Sunshine Band', 'Brasilia', 'DF'),
('04', 'Donna Summer', 'Brasilia', 'DF'),
('05', 'Air Supply', 'Brasilia', 'DF'),
('06', 'Mackenzie', 'São Paulo', 'SP');

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `Nome` varchar(20) NOT NULL,
  `CPF` char(11) NOT NULL,
  `Matricula` char(8) NOT NULL,
  `cargo` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`Nome`, `CPF`, `Matricula`, `cargo`) VALUES
('David', '10', '0001', 'Gerente'),
('joão', '11', '0002', 'supervisor'),
('maria', '12', '0003', 'vendedor'),
('Matheus', '13', '0004', 'vendedor');

-- --------------------------------------------------------

--
-- Estrutura da tabela `negocio`
--

CREATE TABLE `negocio` (
  `CPF` char(11) DEFAULT NULL,
  `Matricula` char(8) DEFAULT NULL,
  `Codigo` int(11) DEFAULT NULL,
  `DataCompra` varchar(11) DEFAULT NULL,
  `PrecoPago` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `automovel`
--
ALTER TABLE `automovel`
  ADD PRIMARY KEY (`Codigo`);

--
-- Índices para tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`CPF`);

--
-- Índices para tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`Matricula`),
  ADD UNIQUE KEY `CPF` (`CPF`),
  ADD UNIQUE KEY `Matricula` (`Matricula`);

--
-- Índices para tabela `negocio`
--
ALTER TABLE `negocio`
  ADD KEY `FK01` (`Matricula`),
  ADD KEY `FK02` (`CPF`),
  ADD KEY `FK03` (`Codigo`);

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `negocio`
--
ALTER TABLE `negocio`
  ADD CONSTRAINT `FK01` FOREIGN KEY (`Matricula`) REFERENCES `funcionario` (`Matricula`),
  ADD CONSTRAINT `FK02` FOREIGN KEY (`CPF`) REFERENCES `cliente` (`CPF`),
  ADD CONSTRAINT `FK03` FOREIGN KEY (`Codigo`) REFERENCES `automovel` (`Codigo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;


```