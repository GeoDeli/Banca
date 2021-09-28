-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Gazdă: 127.0.0.1
-- Timp de generare: sept. 28, 2021 la 11:26 AM
-- Versiune server: 10.4.18-MariaDB
-- Versiune PHP: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Bază de date: `banca`
--

-- --------------------------------------------------------

--
-- Structură tabel pentru tabel `client`
--

CREATE TABLE `client` (
  `ID_C` int(11) NOT NULL,
  `CNP` varchar(13) NOT NULL,
  `Sold_Cont_EURO` float NOT NULL,
  `Sold_Cont_LEI` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Eliminarea datelor din tabel `client`
--

INSERT INTO `client` (`ID_C`, `CNP`, `Sold_Cont_EURO`, `Sold_Cont_LEI`) VALUES
(2, '2890522090097', 1090, 3520),
(3, '1701102090097', 50, 7520),
(4, '2781002090097', 502, 720),
(5, '4021002090097', 502, 720),
(6, '3021014090097', 502, 720),
(7, '3020914090097', 12, 1234),
(8, '2990423020097', 264, 45),
(9, '2990507020097', 487, 788),
(10, '1780715020097', 413, 450),
(11, '2990423020097', 1000, 2700),
(12, '5990423020097', 14000, 884),
(13, '7990423020097', 1200, 1245),
(14, '5970423020097', 1310, 976);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
