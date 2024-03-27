-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 27, 2024 at 03:13 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mancing_mania`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `id_barang` varchar(100) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `harga` int(11) NOT NULL,
  `stok` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`id_barang`, `nama`, `harga`, `stok`) VALUES
('BRG_57654709', 'Indomie Goreng', 6000, 0);

-- --------------------------------------------------------

--
-- Table structure for table `barang_masuk`
--

CREATE TABLE `barang_masuk` (
  `id_stok` varchar(100) NOT NULL,
  `id_barang` varchar(100) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `total` int(11) NOT NULL,
  `tanggal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `detail_transaksi`
--

CREATE TABLE `detail_transaksi` (
  `id_detail_transaksi` varchar(100) NOT NULL,
  `id_transaksi` varchar(100) NOT NULL,
  `id_pegawai` varchar(100) DEFAULT NULL,
  `tanggal` datetime NOT NULL,
  `total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `detail_transaksi`
--

INSERT INTO `detail_transaksi` (`id_detail_transaksi`, `id_transaksi`, `id_pegawai`, `tanggal`, `total`) VALUES
('DTRX_61179075', 'TRX_31603246', 'y', '2024-03-27 09:04:49', 12000);

-- --------------------------------------------------------

--
-- Table structure for table `event`
--

CREATE TABLE `event` (
  `id_event` varchar(100) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `deskripsi` varchar(255) NOT NULL,
  `tanggal` date NOT NULL,
  `biaya` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `event`
--

INSERT INTO `event` (`id_event`, `nama`, `deskripsi`, `tanggal`, `biaya`) VALUES
('EVENT_36099655', 'Lomba Mancing', 'Lomba mancing aniversary abah', '2024-03-26', 50000);

-- --------------------------------------------------------

--
-- Table structure for table `pegawai`
--

CREATE TABLE `pegawai` (
  `id_pegawai` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `jabatan` varchar(100) NOT NULL,
  `gaji` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pegawai`
--

INSERT INTO `pegawai` (`id_pegawai`, `password`, `nama`, `jabatan`, `gaji`) VALUES
('y', 'y', 'y', 'y', 0);

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` varchar(100) NOT NULL,
  `id_barang_0` varchar(100) DEFAULT NULL,
  `id_barang_1` varchar(100) DEFAULT NULL,
  `id_barang_2` varchar(100) DEFAULT NULL,
  `id_barang_3` varchar(100) DEFAULT NULL,
  `id_barang_4` varchar(100) DEFAULT NULL,
  `id_barang_5` varchar(100) DEFAULT NULL,
  `id_barang_6` varchar(100) DEFAULT NULL,
  `id_barang_7` varchar(100) DEFAULT NULL,
  `id_barang_8` varchar(100) DEFAULT NULL,
  `id_barang_9` varchar(100) DEFAULT NULL,
  `keterangan` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `id_barang_0`, `id_barang_1`, `id_barang_2`, `id_barang_3`, `id_barang_4`, `id_barang_5`, `id_barang_6`, `id_barang_7`, `id_barang_8`, `id_barang_9`, `keterangan`) VALUES
('TRX_31603246', 'BRG_57654709', 'BRG_57654709', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'Indomie Goreng x2\n');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`id_barang`);

--
-- Indexes for table `barang_masuk`
--
ALTER TABLE `barang_masuk`
  ADD PRIMARY KEY (`id_stok`),
  ADD KEY `id_barang` (`id_barang`);

--
-- Indexes for table `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  ADD PRIMARY KEY (`id_detail_transaksi`),
  ADD KEY `id_transaksi` (`id_transaksi`),
  ADD KEY `id_pegawai` (`id_pegawai`);

--
-- Indexes for table `event`
--
ALTER TABLE `event`
  ADD PRIMARY KEY (`id_event`);

--
-- Indexes for table `pegawai`
--
ALTER TABLE `pegawai`
  ADD PRIMARY KEY (`id_pegawai`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `id_barang_0` (`id_barang_0`),
  ADD KEY `id_barang_1` (`id_barang_1`),
  ADD KEY `id_barang_2` (`id_barang_2`),
  ADD KEY `id_barang_3` (`id_barang_3`),
  ADD KEY `id_barang_4` (`id_barang_4`),
  ADD KEY `id_barang_5` (`id_barang_5`),
  ADD KEY `id_barang_6` (`id_barang_6`),
  ADD KEY `id_barang_7` (`id_barang_7`),
  ADD KEY `id_barang_8` (`id_barang_8`),
  ADD KEY `id_barang_9` (`id_barang_9`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `barang_masuk`
--
ALTER TABLE `barang_masuk`
  ADD CONSTRAINT `barang_masuk_ibfk_1` FOREIGN KEY (`id_barang`) REFERENCES `barang` (`id_barang`);

--
-- Constraints for table `detail_transaksi`
--
ALTER TABLE `detail_transaksi`
  ADD CONSTRAINT `detail_transaksi_ibfk_1` FOREIGN KEY (`id_transaksi`) REFERENCES `transaksi` (`id_transaksi`),
  ADD CONSTRAINT `detail_transaksi_ibfk_2` FOREIGN KEY (`id_pegawai`) REFERENCES `pegawai` (`id_pegawai`);

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`id_barang_0`) REFERENCES `barang` (`id_barang`),
  ADD CONSTRAINT `transaksi_ibfk_10` FOREIGN KEY (`id_barang_9`) REFERENCES `barang` (`id_barang`),
  ADD CONSTRAINT `transaksi_ibfk_2` FOREIGN KEY (`id_barang_1`) REFERENCES `barang` (`id_barang`),
  ADD CONSTRAINT `transaksi_ibfk_3` FOREIGN KEY (`id_barang_2`) REFERENCES `barang` (`id_barang`),
  ADD CONSTRAINT `transaksi_ibfk_4` FOREIGN KEY (`id_barang_3`) REFERENCES `barang` (`id_barang`),
  ADD CONSTRAINT `transaksi_ibfk_5` FOREIGN KEY (`id_barang_4`) REFERENCES `barang` (`id_barang`),
  ADD CONSTRAINT `transaksi_ibfk_6` FOREIGN KEY (`id_barang_5`) REFERENCES `barang` (`id_barang`),
  ADD CONSTRAINT `transaksi_ibfk_7` FOREIGN KEY (`id_barang_6`) REFERENCES `barang` (`id_barang`),
  ADD CONSTRAINT `transaksi_ibfk_8` FOREIGN KEY (`id_barang_7`) REFERENCES `barang` (`id_barang`),
  ADD CONSTRAINT `transaksi_ibfk_9` FOREIGN KEY (`id_barang_8`) REFERENCES `barang` (`id_barang`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
