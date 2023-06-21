-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema securecapita
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema securecapita
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `securecapita` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `securecapita` ;

-- -----------------------------------------------------
-- Table `securecapita`.`Users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `securecapita`.`Users` (
  `id` BIGINT NOT NULL,
  `first_name` VARCHAR(50) NOT NULL,
  `last_name` VARCHAR(50) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `phone` VARCHAR(20) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `securecapita`.`Roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `securecapita`.`Roles` (
  `id` BIGINT NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `permissions` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `securecapita`.`UserRoles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `securecapita`.`UserRoles` (
  `id` BIGINT NOT NULL,
  `users_id` BIGINT NOT NULL,
  `roles_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_UserRoles_Users_idx` (`users_id` ASC) VISIBLE,
  INDEX `fk_UserRoles_Roles1_idx` (`roles_id` ASC) VISIBLE,
  CONSTRAINT `fk_UserRoles_Users`
    FOREIGN KEY (`users_id`)
    REFERENCES `securecapita`.`Users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_UserRoles_Roles1`
    FOREIGN KEY (`roles_id`)
    REFERENCES `securecapita`.`Roles` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
