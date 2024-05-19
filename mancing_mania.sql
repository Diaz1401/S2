-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 19, 2024 at 04:41 AM
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
('BRG_11543584', 'Nutrisari', 2800, 0),
('BRG_12236349', 'Top White Coffee', 2000, 13),
('BRG_16879568', 'Aqua', 4000, 5),
('BRG_25715283', 'Torabika Mocca', 3200, 3),
('BRG_42090751', 'Indomie', 4000, 0),
('BRG_42277430', 'Luwak White Coffee', 2500, 0),
('BRG_52694509', 'Torabika Cappucino', 3200, 0),
('BRG_57229399', 'Kopi Kapal Api', 2300, 0),
('BRG_80943990', 'Pop Mie', 5000, 0);

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

--
-- Dumping data for table `barang_masuk`
--

INSERT INTO `barang_masuk` (`id_stok`, `id_barang`, `jumlah`, `total`, `tanggal`) VALUES
('STOK_12249265', 'BRG_16879568', 15, 60000, '2024-02-01'),
('STOK_26994337', 'BRG_42090751', 11, 44000, '2024-05-03'),
('STOK_28905188', 'BRG_57229399', 15, 34500, '2024-02-03'),
('STOK_35310167', 'BRG_80943990', 11, 55000, '2024-01-02'),
('STOK_44663622', 'BRG_42277430', 9, 22500, '2024-04-03'),
('STOK_66820074', 'BRG_11543584', 12, 33600, '2024-04-01'),
('STOK_73979686', 'BRG_25715283', 13, 41600, '2024-05-02'),
('STOK_94220190', 'BRG_12236349', 13, 26000, '2024-03-01'),
('STOK_96742260', 'BRG_52694509', 8, 25600, '2024-04-03');

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
('DTRX_15451878', 'TRX_69233450', 'admin', '2024-05-19 09:36:35', 48000),
('DTRX_26642052', 'TRX_47148167', 'admin', '2024-05-19 09:37:48', 43000),
('DTRX_37689512', 'TRX_65542224', 'admin', '2024-05-19 09:36:56', 51200),
('DTRX_71466133', 'TRX_44083158', 'y', '2024-05-19 09:41:04', 52000),
('DTRX_77575989', 'TRX_31565285', 'admin', '2024-05-19 09:37:32', 46500),
('DTRX_92312684', 'TRX_56993442', 'y', '2024-05-19 09:39:52', 28500),
('DTRX_94148962', 'TRX_58184768', 'y', '2024-05-19 09:40:06', 60000),
('DTRX_98278222', 'TRX_49144703', 'y', '2024-05-19 09:40:47', 60000);

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
('admin', 'admin', 'admin', 'admin', 0),
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
('TRX_31565285', 'BRG_42277430', 'BRG_42277430', 'BRG_42277430', 'BRG_42277430', 'BRG_42277430', 'BRG_42277430', 'BRG_42277430', 'BRG_42277430', 'BRG_42277430', 'BRG_42090751', 'Luwak White Coffee x9\nIndomie\n'),
('TRX_44083158', 'BRG_25715283', 'BRG_25715283', 'BRG_25715283', 'BRG_25715283', 'BRG_25715283', 'BRG_25715283', 'BRG_25715283', 'BRG_25715283', 'BRG_25715283', 'BRG_25715283', 'Torabika Mocca x10\n'),
('TRX_47148167', 'BRG_57229399', 'BRG_57229399', 'BRG_57229399', 'BRG_57229399', 'BRG_57229399', 'BRG_57229399', 'BRG_57229399', 'BRG_57229399', 'BRG_57229399', 'BRG_57229399', 'Kopi Kapal Api x10\n'),
('TRX_49144703', 'BRG_16879568', 'BRG_16879568', 'BRG_16879568', 'BRG_16879568', 'BRG_16879568', 'BRG_16879568', 'BRG_16879568', 'BRG_16879568', 'BRG_16879568', 'BRG_16879568', 'Aqua x10\n'),
('TRX_56993442', 'BRG_57229399', 'BRG_57229399', 'BRG_57229399', 'BRG_57229399', 'BRG_57229399', 'BRG_80943990', NULL, NULL, NULL, NULL, 'Kopi Kapal Api x5\nPop Mie\n'),
('TRX_58184768', 'BRG_42090751', 'BRG_42090751', 'BRG_42090751', 'BRG_42090751', 'BRG_42090751', 'BRG_42090751', 'BRG_42090751', 'BRG_42090751', 'BRG_42090751', 'BRG_42090751', 'Indomie x10\n'),
('TRX_65542224', 'BRG_11543584', 'BRG_11543584', 'BRG_52694509', 'BRG_52694509', 'BRG_52694509', 'BRG_52694509', 'BRG_52694509', 'BRG_52694509', 'BRG_52694509', 'BRG_52694509', 'Nutrisari x2\nTorabika Cappucino x8\n'),
('TRX_69233450', 'BRG_11543584', 'BRG_11543584', 'BRG_11543584', 'BRG_11543584', 'BRG_11543584', 'BRG_11543584', 'BRG_11543584', 'BRG_11543584', 'BRG_11543584', 'BRG_11543584', 'Nutrisari x10\n');

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
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
