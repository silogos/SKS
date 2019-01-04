-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 16, 2018 at 02:48 PM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `artificial_intelegen`
--
CREATE DATABASE IF NOT EXISTS `artificial_intelegen` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `artificial_intelegen`;

-- --------------------------------------------------------

--
-- Table structure for table `hasil`
--

CREATE TABLE `hasil` (
  `hasil_id` int(10) NOT NULL,
  `user_id` int(10) NOT NULL,
  `question_id` int(10) NOT NULL,
  `answer_kode` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `kepribadian`
--

CREATE TABLE `kepribadian` (
  `id_kepribadian` int(10) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `keterangan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `profesi`
--

CREATE TABLE `profesi` (
  `id` int(11) NOT NULL,
  `kode` varchar(3) NOT NULL,
  `nama` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `profesi`
--

INSERT INTO `profesi` (`id`, `kode`, `nama`) VALUES
(1, 'D01', 'Pemimpin'),
(2, 'D02', 'Manager'),
(4, 'I01', 'Marketing'),
(5, 'I02', 'Motivator'),
(6, 'I03', 'Presenter'),
(7, 'I04', 'Negosiator'),
(8, 'S01', 'Staf'),
(9, 'S02', 'Administrasi'),
(10, 'C01', 'Bagian Keuangan'),
(11, 'C02', 'Pengawas'),
(12, 'C03', 'Audit');

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE `question` (
  `question_id` int(11) NOT NULL,
  `dominan` varchar(50) NOT NULL,
  `influens` varchar(50) NOT NULL,
  `complaien` varchar(50) NOT NULL,
  `stediness` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`question_id`, `dominan`, `influens`, `complaien`, `stediness`) VALUES
(1, 'Petualang', 'Memberi,semangat', 'teliti', 'mudah,menyesuaikan,diri'),
(2, 'senang,membujuk', 'suka,bercerita', 'berpendirian,teguh', 'suka,kedamaian'),
(3, 'berkemauan,kuat', 'pandai,bergaul', 'suka,berkorban', 'mau,mengalah'),
(4, 'suka,bersaing', 'suka,meyakinkan', 'penuh,pertimbangan', 'senang,dibimbing'),
(5, 'senang,menangani,masalah', 'periang', 'dihormati,orang,lain', 'cenderung,menahan,diri'),
(6, 'percaya,diri', 'bersemangat', 'Peka/perasa', 'cepat,puas'),
(7, 'berpikir,positif', 'suka,memuji/menyanjung', 'perencana', 'sabar'),
(8, 'praktis', 'spontan', 'ketat,pada,waktu', 'pemalu'),
(9, 'suka,berbicara,terus,terang', 'optimis', 'rapi', 'sopan/hormat'),
(10, 'tegar/kuat,hati', 'suka,senda,gurau', 'jujur', 'ramah,tamah'),
(11, 'berani/tidak,penakut', 'menyukai,orang,lain', 'rinci/terperinci', 'diplomatis/berhari-hati'),
(12, 'berani,mengambil,resiko', 'riang/gembira', 'berbudaya/terpelajar', 'konsisten/tidak,mudah,berubah'),
(13, 'mandiri', 'idealis', 'percaya,pada,ide,teman', 'suka,memberi,inspirasi'),
(14, 'mampu,memutuskan', 'lincah/suka,membuka,diri', 'tekun/ulet', 'cinta,keluarga'),
(15, 'cepat,bertindak', 'mudah,berbaur/bergaul', 'ge,mar,musik,lembut', 'perantara/penengah'),
(16, 'suka,ngotot,kuat,bertahan', 'senang,bicara', 'senang,berpikir', 'bersikap,tolol'),
(17, 'senang,membimbing', 'lincah,bersemangat', 'setia/tak,gampang,berubah', 'pendengar,yg,baik'),
(18, 'suka,memimpin', 'lucu/humoris', 'berpikir,matematis', 'mudah,menerima,saran'),
(19, 'produktif/menghasilkan', 'terkenal,luas/populer', 'perfeksionis', 'suka,mengijinkan'),
(20, 'berani/tidak,gampang,takut', 'bersemangat/gembira', 'berkelakuan,tenang/,kalem', 'berpendirian,tetap'),
(21, 'bersikap,seperti,boss,(Bossy)', 'bicara,ramai/meriah', 'malu-malu/sungkan', 'tanpa,ekspresi/datar'),
(22, 'tidak,simpatik', 'kurang,disiplin', 'kurang,antusias/tidak,bergairah,(cuek)', 'tidak,mudah,memaafkan'),
(23, 'suka,melawan/membantah', 'sering,mengulang,janji', 'gampang,tersinggung', 'pendiam'),
(24, 'cenderung,blak-blakan', 'pelupa', 'rewel/ngomel,melulu', 'suka,takut/kuatir'),
(25, 'tidak,sabaran', 'suka,menyela/memotong,bicara,orang,lain', 'tidak,merasa,aman/mantap', 'sering,bimbang,memutuskan'),
(26, 'sulit,mempercayai,orang,lain', 'sulit,diramalkan/sulit,diduga', 'kurang,terkenal/tidak,populer', 'tidak,suka,melibatkan,diri'),
(27, 'keras,kepala', 'serampangan/ceroboh', 'sulit,mengiklaskan/merelakan', 'bimbang/ragu2'),
(28, 'tinggi,hati/gengsi', 'suka,membiarkan', 'pesimis', 'kurang,modis'),
(29, 'gampang,marah', 'tanpa,arah,tujuan', 'suka,berdebat/berbantahan', 'senang,sendirian/,memisahkan,diri'),
(30, 'kasar/suka,menyerang', 'kurang,tenang', 'selalu,berpikir,jelek/sukar,percaya', 'masa,bodoh/tak,pedulian'),
(31, 'bekerja,giat,terlalu,keras', 'ingin,pujian/penghargaan', 'menarik,diri', 'kuatir/cemas'),
(32, 'tidak,bijaksana/tidak,pikir,panjang', 'banyak,bicara/monopoli,percakapan', 'terlalu,pekaa', 'malu/segan'),
(33, 'ambisius', 'tidak,teratur/berantakan', 'murung/mudah,patah,semangat', 'banyak,ragu-ragu/sanksi'),
(34, 'sukar,bertoleransi', 'gampang,berubah,pendirian', 'tertutup/sulit,membuka,diri', 'lalai/acuh,tak,acuh,(cuek,bgt)'),
(35, 'manipulatif/suka,memanfaatkan', 'kurang,rapi/morat-marit', 'murung/masgul,hati', 'suka,menggerutu/ngomel'),
(36, 'bandel', 'berlagak/suka,pamer', 'ragu2/selalu,curiga', 'lamban'),
(37, 'suka,memerintah/menggurui', 'suka,membual/bohong', 'penyendiri', 'malas/,berat,langkah'),
(38, 'cepat,marah/emosional', 'bingung/sulit,berkonsentrasi', 'sering,berprasangka', 'enggan/sering,ogah'),
(39, 'gegabah/terburu-buru/kurang,pikir,panjang', 'sering,resah/,gelisah', 'suka,membalas,dendam', 'perlu,dorongan/bimbingan'),
(40, 'senang,bertipu,daya/,ngakalin,org', 'angin-anginan/suka,berubah,pikiran', 'sering,mencela/mengkritik', 'mudah,berkompromi/suka,mengalah');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `nama`) VALUES
(1, 'rizal'),
(2, 'amin'),
(3, 'amin'),
(4, 'amin'),
(5, 'amin'),
(6, 'aslina');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `hasil`
--
ALTER TABLE `hasil`
  ADD PRIMARY KEY (`hasil_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `question_id` (`question_id`);

--
-- Indexes for table `kepribadian`
--
ALTER TABLE `kepribadian`
  ADD PRIMARY KEY (`id_kepribadian`);

--
-- Indexes for table `profesi`
--
ALTER TABLE `profesi`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `kode` (`kode`);

--
-- Indexes for table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`question_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `profesi`
--
ALTER TABLE `profesi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `question`
--
ALTER TABLE `question`
  MODIFY `question_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
