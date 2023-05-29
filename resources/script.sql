CREATE DATABASE `pao`;

CREATE TABLE `beverage` (
                            `id` int NOT NULL AUTO_INCREMENT,
                            `name` varchar(30) DEFAULT NULL,
                            `description` varchar(60) DEFAULT NULL,
                            `price` float(5,2) DEFAULT NULL,
  `isAlcoholic` varchar(5) DEFAULT NULL,
  `volume` int DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `deliveryman` (
                          `id` int NOT NULL AUTO_INCREMENT,
                          `name` varchar(30) DEFAULT NULL,
                          `age` int DEFAULT NULL,
                          `email` varchar(30) DEFAULT NULL,
                          `phone` varchar(15) DEFAULT NULL,
                          `rating` float(4,2) DEFAULT NULL,
                          `salary` float(5,3) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `food` (
                        `id` int NOT NULL AUTO_INCREMENT,
                        `name` varchar(30) DEFAULT NULL,
                        `description` varchar(60) DEFAULT NULL,
                        `price` float(5,2) DEFAULT NULL,
  `isVegetarian` varchar(5) DEFAULT NULL,
  `preparationTime` int DEFAULT NULL,
  `weight` int DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `restaurant` (
                              `id` int NOT NULL AUTO_INCREMENT,
                              `name` varchar(30) DEFAULT NULL,
                              `rating` float(5,2) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `user` (
                        `id` int NOT NULL AUTO_INCREMENT,
                        `name` varchar(30) DEFAULT NULL,
                        `age` int DEFAULT NULL,
                        `email` varchar(30) DEFAULT NULL,
                        `phone` varchar(15) DEFAULT NULL,
                        `address` varchar(50) DEFAULT NULL,
                        PRIMARY KEY (`id`)
);

CREATE TABLE `order` (
                         `id` int NOT NULL AUTO_INCREMENT,
                         `userId` int DEFAULT NULL,
                         `restaurantId` int DEFAULT NULL,
                         `deliverymanId` int DEFAULT NULL,
                         `foodId` int DEFAULT NULL,
                         `beverageId` int DEFAULT NULL,
                         PRIMARY KEY (`id`),
                         KEY `userId` (`userId`),
                         KEY `restaurantId` (`restaurantId`),
                         KEY `deliverymanId` (`deliverymanId`),
                         KEY `foodId` (`foodId`),
                         KEY `beverageId` (`beverageId`),
                         CONSTRAINT `order_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE CASCADE,
                         CONSTRAINT `order_ibfk_2` FOREIGN KEY (`restaurantId`) REFERENCES `restaurant` (`id`) ON DELETE CASCADE,
                         CONSTRAINT `order_ibfk_3` FOREIGN KEY (`deliverymanId`) REFERENCES `deliveryman` (`id`) ON DELETE CASCADE,
                         CONSTRAINT `order_ibfk_4` FOREIGN KEY (`foodId`) REFERENCES `food` (`id`) ON DELETE CASCADE,
                         CONSTRAINT `order_ibfk_5` FOREIGN KEY (`beverageId`) REFERENCES `beverage` (`id`) ON DELETE CASCADE
);