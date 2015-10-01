SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `exam` ;
CREATE SCHEMA IF NOT EXISTS `exam` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `exam` ;

-- -----------------------------------------------------
-- Table `exam`.`role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `exam`.`role` ;

CREATE TABLE IF NOT EXISTS `exam`.`role` (
  `role_id` TINYINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE INDEX `role_id_UNIQUE` (`role_id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `exam`.`person`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `exam`.`person` ;

CREATE TABLE IF NOT EXISTS `exam`.`person` (
  `person_id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `role_id` TINYINT NOT NULL,
  PRIMARY KEY (`person_id`),
  UNIQUE INDEX `person_id_UNIQUE` (`person_id` ASC),
  INDEX `fk_person_role_idx` (`role_id` ASC),
  CONSTRAINT `fk_person_role`
    FOREIGN KEY (`role_id`)
    REFERENCES `exam`.`role` (`role_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `exam`.`role`
-- -----------------------------------------------------
START TRANSACTION;
USE `exam`;
INSERT INTO `exam`.`role` (`role_id`, `name`) VALUES (NULL, 'role1');
INSERT INTO `exam`.`role` (`role_id`, `name`) VALUES (NULL, 'role2');
INSERT INTO `exam`.`role` (`role_id`, `name`) VALUES (NULL, 'role3');
INSERT INTO `exam`.`role` (`role_id`, `name`) VALUES (NULL, 'role4');
INSERT INTO `exam`.`role` (`role_id`, `name`) VALUES (NULL, 'role5');
INSERT INTO `exam`.`role` (`role_id`, `name`) VALUES (NULL, 'role6');

COMMIT;