-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 25, 2019 at 08:31 AM
-- Server version: 5.5.39
-- PHP Version: 5.4.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `db_skp_saw`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_bobot`
--

CREATE TABLE IF NOT EXISTS `tbl_bobot` (
  `no` int(1) NOT NULL,
  `b1` double(5,3) DEFAULT NULL,
  `b2` double(5,3) DEFAULT NULL,
  `b3` double(5,3) DEFAULT NULL,
  `b4` double(5,3) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbl_bobot`
--

INSERT INTO `tbl_bobot` (`no`, `b1`, `b2`, `b3`, `b4`) VALUES
(0, 0.200, 0.350, 0.250, 0.200);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_kriteria`
--

CREATE TABLE IF NOT EXISTS `tbl_kriteria` (
  `R` varchar(100) NOT NULL,
  `C1` double(5,3) DEFAULT NULL,
  `C2` double(5,3) DEFAULT NULL,
  `C3` double(5,3) DEFAULT NULL,
  `C4` double(5,3) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbl_kriteria`
--

INSERT INTO `tbl_kriteria` (`R`, `C1`, `C2`, `C3`, `C4`) VALUES
('M.irfan Maulana', 0.800, 1.000, 0.450, 0.600),
('Moh.Irwansyah S.', 0.700, 0.200, 0.300, 0.700),
('Jaelani', 1.000, 0.500, 1.000, 0.900),
('Siti Nuraeni', 0.800, 0.700, 0.850, 0.950),
('Jihan Nur Ali', 1.000, 0.800, 1.000, 0.500),
('Haerul Adha', 1.000, 0.400, 0.300, 0.900),
('Muflihun', 0.800, 0.650, 0.750, 0.850),
('Ahmad Juniar Gemilang', 0.780, 0.580, 0.880, 0.900);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_nm_kriteria`
--

CREATE TABLE IF NOT EXISTS `tbl_nm_kriteria` (
  `no` varchar(1) NOT NULL,
  `kriteria1` varchar(30) NOT NULL,
  `kriteria2` varchar(30) NOT NULL,
  `kriteria3` varchar(30) NOT NULL,
  `kriteria4` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbl_nm_kriteria`
--

INSERT INTO `tbl_nm_kriteria` (`no`, `kriteria1`, `kriteria2`, `kriteria3`, `kriteria4`) VALUES
('1', 'Kehadiran', 'Kesopanan', 'Kerja Sama', 'Ketelitian');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_peringkat`
--

CREATE TABLE IF NOT EXISTS `tbl_peringkat` (
  `Nama` varchar(50) NOT NULL,
  `nilai` double(3,2) DEFAULT NULL,
  `rank` int(3) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbl_peringkat`
--

INSERT INTO `tbl_peringkat` (`Nama`, `nilai`, `rank`) VALUES
('Ahmad Juniar Gemilang', 0.56, 5),
('Muflihun', 0.54, 6),
('Haerul Adha', 0.32, 7),
('Jihan Nur Ali', 0.76, 1),
('Siti Nuraeni', 0.57, 3),
('Jaelani', 0.59, 2),
('Moh.Irwansyah S.', 0.32, 8),
('M.irfan Maulana', 0.57, 4);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_periode`
--

CREATE TABLE IF NOT EXISTS `tbl_periode` (
  `Nama` varchar(50) NOT NULL,
  `Nilai` double(3,2) NOT NULL,
  `rank` int(3) NOT NULL,
  `bulan` varchar(15) NOT NULL,
  `tahun` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbl_periode`
--

INSERT INTO `tbl_periode` (`Nama`, `Nilai`, `rank`, `bulan`, `tahun`) VALUES
('Jihan Nur Ali', 0.76, 1, 'May', '2019'),
('Jaelani', 0.59, 2, 'May', '2019'),
('Siti Nuraeni', 0.57, 3, 'May', '2019'),
('M.irfan Maulana', 0.57, 4, 'May', '2019'),
('Ahmad Juniar Gemilang', 0.56, 5, 'May', '2019'),
('Muflihun', 0.54, 6, 'May', '2019'),
('Haerul Adha', 0.32, 7, 'May', '2019'),
('Moh.Irwansyah S.', 0.32, 8, 'May', '2019');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
`id_user` int(3) NOT NULL,
  `user` varchar(50) NOT NULL,
  `pass` varchar(50) NOT NULL,
  `akses` enum('Admin','User') NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `user`, `pass`, `akses`) VALUES
(1, 'Admin', 'admin', 'Admin'),
(2, 'user', 'user', 'User');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_kriteria`
--
ALTER TABLE `tbl_kriteria`
 ADD PRIMARY KEY (`R`);

--
-- Indexes for table `tbl_peringkat`
--
ALTER TABLE `tbl_peringkat`
 ADD PRIMARY KEY (`Nama`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
 ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
MODIFY `id_user` int(3) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
