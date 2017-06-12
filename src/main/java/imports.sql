/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Mouna
 * Created: 9 juin 2017
 */

DROP TABLE `account`;
DROP TABLE `assurance`;
DROP TABLE `client_bank`;
DROP TABLE `credit`;
DROP TABLE `simulation_ids`;

CREATE TABLE `account` (
  `id_account` int(11) NOT NULL,
  `ndc` varchar(20) NOT NULL,
  `psw` varchar(20) NOT NULL,
  `questionSecrete` varchar(20) NOT NULL,
  `reponseSecrete` varchar(20) NOT NULL,
  `role` enum('User','Cons','DirAge','DirBnk') NOT NULL,
  `dateCreation` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `account` (`id_account`, `ndc`, `psw`, `questionSecrete`, `reponseSecrete`, `role`, `dateCreation`) VALUES
(1, 'mouna', '123456', 'pourquoi', 'parceque', 'User', '2017-06-09 14:07:49');

--
-- Structure de la table `assurance`
--

CREATE TABLE `assurance` (
  `idassurance` int(11) NOT NULL,
  `libelle` varchar(20) NOT NULL,
  `type` varchar(20) NOT NULL,
  `montant` double NOT NULL,
  `datecreation` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `assurance`
--

INSERT INTO `assurance` (`idassurance`, `libelle`, `type`, `montant`, `datecreation`) VALUES
(1, 'Assurance de vie1', 'ASSURANCE VIE', 200, '2017-06-09 14:17:36'),
(2, 'Assurance de vie2', 'ASU_VIE', 400, '2017-06-09 14:17:51');

-- --------------------------------------------------------

--
-- Structure de la table `client_bank`
--

CREATE TABLE `client_bank` (
  `idClient` int(11) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `dateNaissance` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `adresse` varchar(20) NOT NULL,
  `sexe` varchar(1) DEFAULT NULL,
  `codePostale` varchar(6) NOT NULL,
  `salaire` int(11) NOT NULL,
  `id_assurance` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `client_bank`
--

INSERT INTO `client_bank` (`idClient`, `nom`, `prenom`, `dateNaissance`, `adresse`, `sexe`, `codePostale`, `salaire`, `id_assurance`) VALUES
(1, 'Izouggarhan', 'Mouna', '2017-06-09 14:21:44', '17 rue des halles', 'F', '75001', 2500, 1),
(2, 'Marc', 'Blancher', '2017-06-09 14:21:48', '12 rue campagne ', 'H', '75014', 8000, 2);

-- --------------------------------------------------------

--
-- Structure de la table `credit`
--

CREATE TABLE `credit` (
  `idcredit` int(11) NOT NULL,
  `mensualite` double NOT NULL,
  `mtrestant` double NOT NULL,
  `mttotal` double NOT NULL,
  `idclient` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `credit`
--

INSERT INTO `credit` (`idcredit`, `mensualite`, `mtrestant`, `mttotal`, `idclient`) VALUES
(1, 200, 100, 600, 1);

-- --------------------------------------------------------

--
-- Structure de la table `simulation_ids`
--

CREATE TABLE `simulation_ids` (
  `idSimulation` int(11) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `valeur_rp` int(11) NOT NULL,
  `valeur_apb` int(11) NOT NULL,
  `valeur_dettes` int(11) NOT NULL,
  `valeur_pme` int(11) NOT NULL,
  `valeur_don` int(11) NOT NULL,
  `valeur_assurance` int(11) NOT NULL,
  `valeur_credit` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `simulation_ids`
--

INSERT INTO `simulation_ids` (`idSimulation`, `date`, `valeur_rp`, `valeur_apb`, `valeur_dettes`, `valeur_pme`, `valeur_don`, `valeur_assurance`, `valeur_credit`) VALUES
(1, '2017-05-30 15:34:14', 1300000, 0, 0, 0, 0, 0, 0),
(2, '2017-05-30 15:37:00', 1400000, 0, 0, 0, 0, 0, 0),
(3, '2017-05-30 15:37:11', 1500000, 0, 0, 0, 0, 0, 0),
(4, '2017-05-30 15:37:25', 1700000, 0, 0, 0, 0, 0, 0),
(5, '2017-05-30 15:37:36', 2000000, 0, 0, 0, 0, 0, 0),
(6, '2017-05-30 15:37:54', 5000000, 0, 0, 0, 0, 0, 0),
(7, '2017-05-30 18:28:41', 1400000, 0, 0, 0, 0, 0, 0),
(8, '2017-05-30 18:28:56', 1400000, 0, 0, 0, 0, 0, 0),
(9, '2017-05-30 18:29:09', 2000000, 0, 0, 0, 0, 0, 0),
(10, '2017-06-01 12:36:45', 0, 0, 0, 0, 0, 0, 0),
(12, '2017-06-03 11:52:25', 1400000, 0, 0, 0, 0, 0, 0),
(13, '2017-06-04 16:48:40', 0, 0, 0, 0, 0, 0, 0),
(14, '2017-06-04 17:05:54', 0, 0, 0, 0, 0, 0, 0),
(15, '2017-06-09 13:55:17', 0, 0, 0, 0, 0, 0, 0),
(16, '2017-06-09 15:17:20', 0, 0, 0, 0, 0, 200, 0),
(17, '2017-06-09 15:17:26', 20000000, 0, 0, 0, 0, 200, 0),
(18, '2017-06-09 15:18:41', 20000000, 0, 0, 0, 0, 200, 0),
(19, '2017-06-09 15:27:02', 0, 0, 0, 0, 0, 200, 0),
(20, '2017-06-09 15:32:01', 12, 0, 0, 0, 0, 200, 0);

--
-- Index pour les tables exportÃ©es
--

--
-- Index pour la table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id_account`),
  ADD UNIQUE KEY `ndc` (`ndc`);

--
-- Index pour la table `assurance`
--
ALTER TABLE `assurance`
  ADD PRIMARY KEY (`idassurance`);

--
-- Index pour la table `client_bank`
--
ALTER TABLE `client_bank`
  ADD PRIMARY KEY (`idClient`);

--
-- Index pour la table `credit`
--
ALTER TABLE `credit`
  ADD PRIMARY KEY (`idcredit`);

--
-- Index pour la table `simulation_ids`
--
ALTER TABLE `simulation_ids`
  ADD PRIMARY KEY (`idSimulation`);

--
-- AUTO_INCREMENT pour les tables exportÃ©es
--

--
-- AUTO_INCREMENT pour la table `account`
--
ALTER TABLE `account`
  MODIFY `id_account` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `assurance`
--
ALTER TABLE `assurance`
  MODIFY `idassurance` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `client_bank`
--
ALTER TABLE `client_bank`
  MODIFY `idClient` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `credit`
--
ALTER TABLE `credit`
  MODIFY `idcredit` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `simulation_ids`
--
ALTER TABLE `simulation_ids`
  MODIFY `idSimulation` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;