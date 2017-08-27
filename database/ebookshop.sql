-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Aug 27, 2017 at 04:33 AM
-- Server version: 10.1.19-MariaDB
-- PHP Version: 7.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ebookshop`
--

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `id` int(11) NOT NULL,
  `title` varchar(50) DEFAULT NULL,
  `author` varchar(50) DEFAULT NULL,
  `picture` varchar(999) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `qty` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`id`, `title`, `author`, `picture`, `price`, `qty`) VALUES
(1001, 'Java for dummies', 'Tan Ah Teck', 'http://static1.squarespace.com/static/5349b24ce4b056257cdce647/58b9e46d579fb33e05a443ca/58df4bdff5e2318397e5c71b/1491030521420/C2BF0E36-C4C9-46F3-9CF1-205264083AF0.PNG?format=1000w', 11.11, 960),
(1002, 'More Java for dummies', 'Tan Ah Teck', 'http://www.startupremarkable.com/wp-content/uploads/2015/02/a-book-a-week-image.jpg', 22.22, 971),
(1003, 'More Java for more dummies', 'Mohammad Ali', '', 33.33, 983),
(1004, 'A Cup of Java', 'Kumar', '', 44.44, 982),
(1005, 'A Teaspoon of Java', 'Kevin Jones', '', 55.55, 999);

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `id` int(100) NOT NULL,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `lastname` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phonenumber` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`id`, `username`, `password`, `name`, `lastname`, `email`, `phonenumber`) VALUES
(1, 'Test', 'Test', 'Parshon', 'For', 'Patcher.wor57@cdtc.ac.th', '0819999999'),
(4, 'monlarmparm06', 'monlarmparm2538', 'Nammon', 'Orrachorn', 'monlarmparm@hotmail.com', '0907893581'),
(6, 'mm93', '6969', 'Rubberman', 'Hometoy', 'porkman@gmail.com', '696969696'),
(7, 'admin', '0990796663', 'dasd', 'sdasd', 'sadasd', 'sadasd'),
(11, 'Arm96', 'Arm69', 'Armnos', 'Wanitchayananda', 'armlike6996@hotmail.com', '0866969666'),
(13, 'arm1', 'arm1', 'arm1', 'arm1', 'arm1@hotmail.com', '0812345678'),
(14, 'Tip', 'Pakorn', 'orrachorn', 'soi2', 'thepsa555@hotmail.com', '0866966969'),
(15, 'tip', 'pa', 'korn', 'kee', 'tak@hotmail.com', '0866966969'),
(26, 'tipakorn', 'spam', 'noob', 'newbie', 'pinoy2007@hotmail.com', '0815555555'),
(27, 'a', 'a', 'a', 'a', 'a', 'a'),
(28, 'tara', 'tapa', 'tara', 'tara', 'a-astory@hotmail.com', '0866656665'),
(29, 'pk', 'pk', 'pk', 'pk', 'kk@hotmail.com', '0812345678'),
(31, 'ffff', '0000', 'dadad', 'dadad', 'jirachai_q07@safafa.com', ''),
(32, 'ffff', '0000', 'q', 'masterq', 'q@hotmail.com', '012345678');

-- --------------------------------------------------------

--
-- Table structure for table `message_header`
--

CREATE TABLE `message_header` (
  `MESSAGE_ID` int(11) NOT NULL,
  `NAME` varchar(50) DEFAULT NULL,
  `EMAIL` varchar(50) DEFAULT NULL,
  `website` varchar(50) DEFAULT NULL,
  `subject` varchar(50) DEFAULT NULL,
  `message` varchar(50) DEFAULT NULL,
  `record_status` varchar(1) DEFAULT NULL,
  `record_add_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `storyAct`
--

CREATE TABLE `storyAct` (
  `storyID` int(100) NOT NULL,
  `storyName` varchar(1000) CHARACTER SET utf8 COLLATE utf8_thai_520_w2 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `storyAct`
--

INSERT INTO `storyAct` (`storyID`, `storyName`) VALUES
(1, 'พี่คิวซ่าท้าโลกีย์'),
(2, 'พี่คิวซ่าท้าโลกีย์ภาค2');

-- --------------------------------------------------------

--
-- Table structure for table `storyContent`
--

CREATE TABLE `storyContent` (
  `contentID` int(11) NOT NULL,
  `storyID` int(11) NOT NULL,
  `storyName` varchar(1000) CHARACTER SET utf8 COLLATE utf8_thai_520_w2 NOT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_thai_520_w2 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `storyContent`
--

INSERT INTO `storyContent` (`contentID`, `storyID`, `storyName`, `content`) VALUES
(1, 1, 'พี่คิวซ่าท้าโลกีย์', 'just put some content here!'),
(2, 2, 'พี่คิวซ่าท้าโลกีย์ภาค2', 'just put some content here2!!');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `message_header`
--
ALTER TABLE `message_header`
  ADD PRIMARY KEY (`MESSAGE_ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `member`
--
ALTER TABLE `member`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;
--
-- AUTO_INCREMENT for table `message_header`
--
ALTER TABLE `message_header`
  MODIFY `MESSAGE_ID` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
