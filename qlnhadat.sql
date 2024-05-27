-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 05, 2023 lúc 02:35 PM
-- Phiên bản máy phục vụ: 10.1.38-MariaDB
-- Phiên bản PHP: 5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `qlnhadat`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chusohuu`
--

CREATE TABLE `chusohuu` (
  `MaChuSoHuu` int(11) NOT NULL,
  `TenChuSoHuu` varchar(255) DEFAULT NULL,
  `SoThua` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `chusohuu`
--

INSERT INTO `chusohuu` (`MaChuSoHuu`, `TenChuSoHuu`, `SoThua`) VALUES
(1, 'dsafasf', 2),
(2, 'dsfsdfd', 3),
(4, 'Hoang', 4);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loaidat`
--

CREATE TABLE `loaidat` (
  `MaLoai` int(11) NOT NULL,
  `TenLoai` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `loaidat`
--

INSERT INTO `loaidat` (`MaLoai`, `TenLoai`) VALUES
(1, 'dat tho cu'),
(2, 'dat ruong'),
(3, 'dat thanh thi');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nguoidung`
--

CREATE TABLE `nguoidung` (
  `id` int(11) NOT NULL,
  `TenND` varchar(50) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `role` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `nguoidung`
--

INSERT INTO `nguoidung` (`id`, `TenND`, `Password`, `role`) VALUES
(1, 'minh hoang', 'a', 1),
(2, 'quoc22', 'b', 2),
(3, 'anh quoc', 'anhvip pro', 2),
(4, 'anh quoc anh', 'aaaaaa', 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thongtindat`
--

CREATE TABLE `thongtindat` (
  `SoThua` int(11) NOT NULL,
  `DienTich` float DEFAULT NULL,
  `MaLoai` int(11) DEFAULT NULL,
  `GiapRanh` varchar(255) DEFAULT NULL,
  `SoDo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `thongtindat`
--

INSERT INTO `thongtindat` (`SoThua`, `DienTich`, `MaLoai`, `GiapRanh`, `SoDo`) VALUES
(1, 100, 1, 'hung yen', 'da co'),
(2, 100, 1, 'hung yen', 'da co'),
(3, 100, 1, 'hung yen', 'da co'),
(4, 111, 1, 'dfsasdfadsfds', 'chua co');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chusohuu`
--
ALTER TABLE `chusohuu`
  ADD PRIMARY KEY (`MaChuSoHuu`),
  ADD KEY `SoThua` (`SoThua`);

--
-- Chỉ mục cho bảng `loaidat`
--
ALTER TABLE `loaidat`
  ADD PRIMARY KEY (`MaLoai`);

--
-- Chỉ mục cho bảng `nguoidung`
--
ALTER TABLE `nguoidung`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `thongtindat`
--
ALTER TABLE `thongtindat`
  ADD PRIMARY KEY (`SoThua`),
  ADD KEY `MaLoai` (`MaLoai`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `chusohuu`
--
ALTER TABLE `chusohuu`
  ADD CONSTRAINT `chusohuu_ibfk_1` FOREIGN KEY (`SoThua`) REFERENCES `thongtindat` (`SoThua`);

--
-- Các ràng buộc cho bảng `thongtindat`
--
ALTER TABLE `thongtindat`
  ADD CONSTRAINT `thongtindat_ibfk_1` FOREIGN KEY (`MaLoai`) REFERENCES `loaidat` (`MaLoai`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
