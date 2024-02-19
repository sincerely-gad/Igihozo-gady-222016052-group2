-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 19, 2024 at 10:08 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `igihozogady_222016052`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteincustomer` (IN `customer_ID` INT(3))   BEGIN DELETE FROM customer where customer_ID=customer_ID; END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getcustomerinfo` ()   BEGIN SELECT* FROM customer; END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getdeliveryinfo` ()   BEGIN SELECT* FROM delivery; END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getemployeeinfo` ()   BEGIN SELECT* FROM employee; END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getordersinfo` ()   BEGIN SELECT* FROM orders; END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getpaymentinfo` ()   BEGIN SELECT* FROM payment; END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getproductinfo` ()   BEGIN SELECT* FROM product; END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updatecustomer` (IN `customer_id` INT(4))   BEGIN UPDATE customer SET firstname='SHEMA' WHERE customer_id=customer_id; END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `Id` int(50) NOT NULL,
  `Firstname` varchar(20) NOT NULL,
  `Lastname` varchar(20) NOT NULL,
  `Gender` varchar(1) NOT NULL,
  `Telephone` int(50) NOT NULL,
  `Address` varchar(30) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `Password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`Id`, `Firstname`, `Lastname`, `Gender`, `Telephone`, `Address`, `Email`, `Password`) VALUES
(1, 'MUKAMAN', 'Clarisse', 'F', 78695857, 'Huye', 'mukamana@gmail.com', '1234'),
(2, 'UWERA', 'Jean', 'F', 789484746, 'Huye', 'uwera@gmail.com', '12345'),
(3, 'HABAKUBAHO', 'Fidelle', 'M', 784152637, 'HUYE MUKONI', 'habakubaho@gmail.com', '1234567890'),
(4, 'HIRWA', 'Test', 'M', 789872663, 'HUYE, MUKONI', 'hirwa@gmail.com', '1234567890'),
(5, 'For ', 'now', 'M', 80989798, 'JJJJ', 'murugo@gmail.com', '12345'),
(6, 'SINDIKUBWABO', 'Emile', 'M', 90348938, 'Rwanda', 'emile@gmail.com', '123456'),
(7, 'UWAMAHORO', 'Clarisse', 'F', 78937388, 'Huye', 'uwamahoro@gmail.com', '12345'),
(8, 'Testing', 'testy', 'M', 9897867, 'Huye', 'testing@gmail.com', '2001abcdA1!'),
(9, 'ITU', 'Gilz', 'M', 785958348, 'HUYE,TUMBA', 'gilz@gmail.com', '2001abcdA1!'),
(10, 'UWIDUHAYE', 'Test', 'F', 789287367, 'HUYE', 'uwiduhaye@gmail.com', '12345abcd');

-- --------------------------------------------------------

--
-- Table structure for table `delivery`
--

CREATE TABLE `delivery` (
  `Delivery_id` int(3) NOT NULL,
  `Address` varchar(20) NOT NULL,
  `Details` varchar(20) NOT NULL,
  `Product_id` int(40) NOT NULL,
  `Amount` int(40) NOT NULL,
  `Payment_id` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `delivery`
--

INSERT INTO `delivery` (`Delivery_id`, `Address`, `Details`, `Product_id`, `Amount`, `Payment_id`) VALUES
(1, 'HUYE', 'Products', 1, 9000, 7),
(2, 'MUKONI', 'Products on discount', 2, 200, 11);

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `Id` int(50) NOT NULL,
  `Firstname` varchar(20) NOT NULL,
  `Lastname` varchar(20) NOT NULL,
  `Telephone` int(20) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`Id`, `Firstname`, `Lastname`, `Telephone`, `Email`, `Address`, `Password`) VALUES
(6, 'Kill', 'Bill', 78987655, 'killy@gmail.com', 'Huye Tumba', '123456'),
(7, 'UWIMANA', 'Lydia', 80977675, 'uwimana@gmail.com', 'Huye', '2001abcdA1!'),
(9, 'UWAMARIYA', 'Clarisse', 8097979, 'uwamariya@gmail.com', 'HUYE', '12345'),
(10, 'HUMURA', 'test', 78776757, 'humura@gmail.com', 'Kigali', '1234abcd!');

-- --------------------------------------------------------

--
-- Table structure for table `insert_data_into_delivery`
--

CREATE TABLE `insert_data_into_delivery` (
  `Delivery_id` int(3) DEFAULT NULL,
  `Delivery_Address` varchar(20) DEFAULT NULL,
  `Delivery_details` varchar(20) DEFAULT NULL,
  `Product_id` int(4) DEFAULT NULL,
  `Delivery_amount` int(4) DEFAULT NULL,
  `Customer_id` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `insert_data_into_employees`
--

CREATE TABLE `insert_data_into_employees` (
  `Employee_id` int(3) DEFAULT NULL,
  `Employee_Firstname` varchar(20) DEFAULT NULL,
  `Employee_Lastname` varchar(20) DEFAULT NULL,
  `Empoyee_Tel` bigint(10) DEFAULT NULL,
  `Employee_Address` varchar(20) DEFAULT NULL,
  `Employee_Emailaddress` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `insert_data_into_orders`
--

CREATE TABLE `insert_data_into_orders` (
  `Order_id` int(4) DEFAULT NULL,
  `Order_details` varchar(30) DEFAULT NULL,
  `product_id` int(4) DEFAULT NULL,
  `Customer_id` int(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `insert_data_into_products`
--

CREATE TABLE `insert_data_into_products` (
  `Product_id` int(4) DEFAULT NULL,
  `Product_price` int(4) DEFAULT NULL,
  `Quantity` int(3) DEFAULT NULL,
  `Customer_id` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `Order_id` int(4) NOT NULL,
  `product_id` int(40) NOT NULL,
  `Customer_id` int(40) NOT NULL,
  `Quantity` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`Order_id`, `product_id`, `Customer_id`, `Quantity`) VALUES
(1, 17, 4, 12);

--
-- Triggers `orders`
--
DELIMITER $$
CREATE TRIGGER `Afterinsertorder` AFTER INSERT ON `orders` FOR EACH ROW BEGIN 
UPDATE products SET products.Quantity=products.Quantity-NEW.Quantity WHERE products.Id=NEW.product_id;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `Id` int(50) NOT NULL,
  `product_id` int(50) NOT NULL,
  `Tel` varchar(255) NOT NULL,
  `Amount_paid` int(255) NOT NULL,
  `Payment_method` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`Id`, `product_id`, `Tel`, `Amount_paid`, `Payment_method`) VALUES
(7, 9, '99', 9, ''),
(8, 2, '8778798', 99000, 'MTN'),
(9, 222, '7898876', 2003, 'MTN'),
(10, 999, '78948594', 9000, 'MTN'),
(11, 7321, '78766789', 48200, 'MTN'),
(12, 3198, '789978765', 48200, 'MTN'),
(13, 5266, '7899987', 24200, 'TIGO'),
(14, 7335, '788898', 24200, 'Crypto'),
(15, 5851, '78696875', 96200, 'MTN'),
(16, 6132, '789484838', 24200, 'MTN'),
(17, 6586, '878676788', 24200, 'MTN'),
(18, 6902, '7898685667', 8200, 'MTN'),
(19, 6799, '78876', 90000, 'MTN');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `Id` int(50) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Quantity` int(255) NOT NULL,
  `Price` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`Id`, `Name`, `Quantity`, `Price`) VALUES
(1, 'Impuzu', 1, '12000'),
(2, 'Inkwetoh', 12, '2000'),
(4, 'tubireke', 4, '120000'),
(6, 'Shoes', 12, '12000'),
(7, 'Inshabure', 11, '11000'),
(8, 'T-Shirts', 10, '1000'),
(9, 'T-Shirts', 12, '2000'),
(10, 'Kill', 14, '8000'),
(11, 'Ipantaro', 18, '4000'),
(12, 'jj', 1, '1000'),
(13, 'GG', 12, '3000'),
(14, 'kk', 123, '1000'),
(15, '19kk', 14, '4500'),
(16, 'JUMONGO', 6, '3200'),
(17, '', -3, '9800');

-- --------------------------------------------------------

--
-- Table structure for table `products_view`
--

CREATE TABLE `products_view` (
  `Product_id` int(4) DEFAULT NULL,
  `Product_price` int(4) DEFAULT NULL,
  `Quantity` int(3) DEFAULT NULL,
  `Customer_id` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `rented`
--

CREATE TABLE `rented` (
  `House_Id` int(50) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `Rooms` int(50) NOT NULL,
  `Amount` int(50) NOT NULL,
  `Periodrentedfor` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `rented`
--

INSERT INTO `rented` (`House_Id`, `Address`, `Rooms`, `Amount`, `Periodrentedfor`) VALUES
(1, 'Huye', 3, 20000, 7),
(2, 'HUYE', 3, 800000, 6),
(3, 'MUKONI', 4, 80000, 8),
(4, 'HUYE', 9, 13000, 12),
(5, 'mukoni', 7, 120000, 13),
(6, 'TUMBA', 8, 14000, 8),
(7, 'MWIRANGO', 10, 10000, 12),
(8, 'MUKONI ll', 3, 12000, 9),
(10, 'huye', 7, 70000, 4);

-- --------------------------------------------------------

--
-- Table structure for table `rent_houses`
--

CREATE TABLE `rent_houses` (
  `House_id` int(255) NOT NULL,
  `Address` varchar(30) NOT NULL,
  `Rooms` int(255) NOT NULL,
  `Amount` int(50) NOT NULL,
  `Periodavailable` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `rent_houses`
--

INSERT INTO `rent_houses` (`House_id`, `Address`, `Rooms`, `Amount`, `Periodavailable`) VALUES
(1, 'HUYE', 3, 20000, 7),
(2, 'HUYE', 3, 30000, 7),
(3, 'MUKONI', 4, 80000, 8);

-- --------------------------------------------------------

--
-- Table structure for table `sells`
--

CREATE TABLE `sells` (
  `Id` int(50) NOT NULL,
  `Name` varchar(250) NOT NULL,
  `Quantity` int(50) NOT NULL,
  `Price` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `sells`
--

INSERT INTO `sells` (`Id`, `Name`, `Quantity`, `Price`) VALUES
(1, 'Inshabure', 19, 19000);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
