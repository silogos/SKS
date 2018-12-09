-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 09 Des 2018 pada 08.54
-- Versi Server: 10.1.19-MariaDB
-- PHP Version: 7.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
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
-- Struktur dari tabel `daftar`
--

CREATE TABLE `daftar` (
  `id_daftar` int(10) NOT NULL,
  `username` varchar(20) NOT NULL,
  `jenis_kelamin` varchar(20) NOT NULL,
  `e_mail` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL,
  `konfir_pass` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `hasil`
--

CREATE TABLE `hasil` (
  `hasil_id` int(10) NOT NULL,
  `user_id` int(10) NOT NULL,
  `question_id` int(10) NOT NULL,
  `answer_kode` varchar(20) NOT NULL,
  `id_ujian` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `kepribadian`
--

CREATE TABLE `kepribadian` (
  `id_kepribadian` int(10) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `keterangan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `question`
--

CREATE TABLE `question` (
  `question_id` int(11) NOT NULL,
  `dominan` varchar(50) NOT NULL,
  `influens` varchar(50) NOT NULL,
  `complaien` varchar(50) NOT NULL,
  `stediness` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `question`
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
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `user_id` int(10) NOT NULL,
  `nama` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`user_id`, `nama`) VALUES
(1, 'Rizal'),
(2, 'Amin'),
(3, 'Ari');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `daftar`
--
ALTER TABLE `daftar`
  ADD PRIMARY KEY (`id_daftar`);

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
-- AUTO_INCREMENT for table `daftar`
--
ALTER TABLE `daftar`
  MODIFY `id_daftar` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `question`
--
ALTER TABLE `question`
  MODIFY `question_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;
--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `hasil`
--
ALTER TABLE `hasil`
  ADD CONSTRAINT `hasil_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
