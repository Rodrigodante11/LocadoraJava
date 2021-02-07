CREATE TABLE `categoria` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `tipo` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `email` varchar(255) NOT NULL,
  `telefone` char(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `filme` (
  `id` int(11) NOT NULL,
  `titulo` varchar(45) NOT NULL,
  `descricao` text,
  `preco` decimal(15,2) NOT NULL,
  `numeroDias` int(11) NOT NULL,
  `categoria` varchar(45) DEFAULT NULL,
  `categoria_id` int(11) NOT NULL,
  `diretor` varchar(45) NOT NULL,
  `duracao` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `itemlocacao` (
  `id` int(11) NOT NULL,
  `valor` decimal(10,2) DEFAULT NULL,
  `Jogo_id` int(11) DEFAULT NULL,
  `Filme_id` int(11) DEFAULT NULL,
  `Locacao_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `jogo` (
  `id` int(11) NOT NULL,
  `titulo` varchar(45) NOT NULL,
  `descricao` text,
  `preco` decimal(15,2) NOT NULL,
  `numeroDias` int(11) NOT NULL,
  `categoria` varchar(45) DEFAULT NULL,
  `memoria` int(11) DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `locacao` (
  `id` int(11) NOT NULL,
  `data` date DEFAULT NULL,
  `valor` decimal(10,2) DEFAULT NULL,
  `Cliente_id` int(11) NOT NULL,
  `usuario_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `login` varchar(100) NOT NULL,
  `senha` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `filme`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_filme_categoria` (`categoria_id`);

ALTER TABLE `itemlocacao`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_ItemLocacao_Jogo1_idx` (`Jogo_id`),
  ADD KEY `fk_ItemLocacao_Filme1_idx` (`Filme_id`),
  ADD KEY `fk_ItemLocacao_Locacao1_idx` (`Locacao_id`);

ALTER TABLE `jogo`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `locacao`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_Locacao_Cliente1_idx` (`Cliente_id`),
  ADD KEY `fk_Locacao_Usuario` (`usuario_id`);

ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `categoria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `filme`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `itemlocacao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `jogo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `locacao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `filme`
  ADD CONSTRAINT `fk_filme_categoria` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`id`);

ALTER TABLE `itemlocacao`
  ADD CONSTRAINT `fk_ItemLocacao_Filme1` FOREIGN KEY (`Filme_id`) REFERENCES `filme` (`id`),
  ADD CONSTRAINT `fk_ItemLocacao_Jogo1` FOREIGN KEY (`Jogo_id`) REFERENCES `jogo` (`id`),
  ADD CONSTRAINT `fk_ItemLocacao_Locacao1` FOREIGN KEY (`Locacao_id`) REFERENCES `locacao` (`id`);

ALTER TABLE `locacao`
  ADD CONSTRAINT `fk_Locacao_Cliente` FOREIGN KEY (`Cliente_id`) REFERENCES `cliente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Locacao_Usuario` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`);