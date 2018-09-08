CREATE DATABASE IF NOT EXISTS xyzBank;

CREATE TABLE IF NOT EXISTS `Users` (
  `userId` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) NOT NULL DEFAULT '',
  `email` varchar(20) NOT NULL DEFAULT '',
  `contactNumber` varchar(20) NOT NULL DEFAULT '',
  `createdDate` timestamp DEFAULT current_timestamp,
  `updatedDate` timestamp,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `User_Wallets` (
  `walletId` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `userId` int(11) unsigned NOT NULL,
  `balance` decimal(18,4),
  `createdDate` timestamp DEFAULT current_timestamp,
  `updatedDate` timestamp,
  PRIMARY KEY (`walletId`),
  KEY `userId` (`userId`),
  CONSTRAINT `UserWallet_fk_1` FOREIGN KEY (`userId`)
  REFERENCES `Users` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

