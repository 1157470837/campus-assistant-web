SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `campusAssistant_web` DEFAULT CHARACTER SET utf8 ;
USE `campusAssistant_web` ;

-- -----------------------------------------------------
-- Table `campusAssistant_web`.`geoinfo`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `campusAssistant_web`.`geoinfo` (
  `geoinfo_id` INT NOT NULL AUTO_INCREMENT ,
  `longtitude1` DOUBLE NOT NULL ,
  `longtitude2` DOUBLE NOT NULL ,
  `longtitude3` DOUBLE NOT NULL ,
  `longtitude4` DOUBLE NOT NULL ,
  `latitude1` DOUBLE NOT NULL ,
  `latitude2` DOUBLE NOT NULL ,
  `latitude3` DOUBLE NOT NULL ,
  `latitude4` DOUBLE NOT NULL ,
  `availabe` TINYINT(1) NOT NULL ,
  PRIMARY KEY (`geoinfo_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `campusAssistant_web`.`scenicspot`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `campusAssistant_web`.`scenicspot` (
  `scenicspot_id` INT NOT NULL AUTO_INCREMENT ,
  `spotname` VARCHAR(45) NOT NULL ,
  `description` TEXT NOT NULL ,
  `rate_mean` DOUBLE NULL DEFAULT 0 ,
  `rate_num` INT NULL DEFAULT 0 ,
  `image` BLOB NULL ,
  `geoinfo_id` INT NOT NULL ,
  PRIMARY KEY (`scenicspot_id`) ,
  INDEX `scenicspot_geoinfo_id` (`geoinfo_id` ASC) ,
  CONSTRAINT `scenicspot_geoinfo_id`
    FOREIGN KEY (`geoinfo_id` )
    REFERENCES `campusAssistant_web`.`geoinfo` (`geoinfo_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `campusAssistant_web`.`college`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `campusAssistant_web`.`college` (
  `college_id` INT NOT NULL AUTO_INCREMENT ,
  `college_name` VARCHAR(30) NOT NULL ,
  `description` TEXT NOT NULL ,
  `scenicspot_id` INT NOT NULL ,
  PRIMARY KEY (`college_id`) ,
  INDEX `college_scenicspot_id` (`scenicspot_id` ASC) ,
  CONSTRAINT `college_scenicspot_id`
    FOREIGN KEY (`scenicspot_id` )
    REFERENCES `campusAssistant_web`.`scenicspot` (`scenicspot_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `campusAssistant_web`.`major`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `campusAssistant_web`.`major` (
  `major_id` INT NOT NULL AUTO_INCREMENT ,
  `major_name` VARCHAR(30) NOT NULL ,
  `description` TEXT NOT NULL ,
  `image` BLOB NULL ,
  `college_id` INT NOT NULL ,
  PRIMARY KEY (`major_id`) ,
  INDEX `major_college_id` (`college_id` ASC) ,
  CONSTRAINT `major_college_id`
    FOREIGN KEY (`college_id` )
    REFERENCES `campusAssistant_web`.`college` (`college_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `campusAssistant_web`.`usertype`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `campusAssistant_web`.`usertype` (
  `usertype_id` INT NOT NULL AUTO_INCREMENT ,
  `usertype_name` INT NOT NULL ,
  PRIMARY KEY (`usertype_id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `campusAssistant_web`.`user`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `campusAssistant_web`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT ,
  `username` VARCHAR(20) NOT NULL ,
  `password` VARCHAR(20) NOT NULL ,
  `sex` VARCHAR(4) NOT NULL ,
  `email` VARCHAR(30) NOT NULL ,
  `phone` VARCHAR(20) NULL ,
  `college_id` INT NOT NULL ,
  `major_id` INT NOT NULL ,
  `usertype_id` INT NOT NULL ,
  `entrance_year` INT NULL ,
  `birthday` DATETIME NULL ,
  `description` TEXT NULL ,
  `image` BLOB NULL ,
  `geoinfo_id` INT NOT NULL ,
  PRIMARY KEY (`user_id`) ,
  INDEX `user_college_id` (`college_id` ASC) ,
  INDEX `user_major_id` (`major_id` ASC) ,
  INDEX `user_usertype_id` (`usertype_id` ASC) ,
  INDEX `user_geoinfo_id` (`geoinfo_id` ASC) ,
  CONSTRAINT `user_college_id`
    FOREIGN KEY (`college_id` )
    REFERENCES `campusAssistant_web`.`college` (`college_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `user_major_id`
    FOREIGN KEY (`major_id` )
    REFERENCES `campusAssistant_web`.`major` (`major_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `user_usertype_id`
    FOREIGN KEY (`usertype_id` )
    REFERENCES `campusAssistant_web`.`usertype` (`usertype_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `user_geoinfo_id`
    FOREIGN KEY (`geoinfo_id` )
    REFERENCES `campusAssistant_web`.`geoinfo` (`geoinfo_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `campusAssistant_web`.`relation`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `campusAssistant_web`.`relation` (
  `relation_id` INT NOT NULL AUTO_INCREMENT ,
  `user_id1` INT NOT NULL ,
  `user_id2` INT NOT NULL ,
  PRIMARY KEY (`relation_id`) ,
  INDEX `relation_user_id1` (`user_id1` ASC) ,
  INDEX `relation_user_id2` (`user_id2` ASC) ,
  CONSTRAINT `relation_user_id1`
    FOREIGN KEY (`user_id1` )
    REFERENCES `campusAssistant_web`.`user` (`user_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `relation_user_id2`
    FOREIGN KEY (`user_id2` )
    REFERENCES `campusAssistant_web`.`user` (`user_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `campusAssistant_web`.`grade`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `campusAssistant_web`.`grade` (
  `grade_id` INT NOT NULL AUTO_INCREMENT ,
  `grade_name` VARCHAR(30) NOT NULL ,
  `description` TEXT NOT NULL ,
  `image` BLOB NULL ,
  `college_id` INT NOT NULL ,
  `major_id` INT NOT NULL ,
  PRIMARY KEY (`grade_id`) ,
  INDEX `grade_college_id` (`college_id` ASC) ,
  INDEX `grade_major_id` (`major_id` ASC) ,
  CONSTRAINT `grade_college_id`
    FOREIGN KEY (`college_id` )
    REFERENCES `campusAssistant_web`.`college` (`college_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `grade_major_id`
    FOREIGN KEY (`major_id` )
    REFERENCES `campusAssistant_web`.`major` (`major_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `campusAssistant_web`.`chatroom`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `campusAssistant_web`.`chatroom` (
  `chatroom_id` INT NOT NULL AUTO_INCREMENT ,
  `chatroom_name` VARCHAR(30) NOT NULL ,
  `parentroom_id` INT NOT NULL ,
  `image` BLOB NULL ,
  `college_id` INT NOT NULL ,
  `major_id` INT NOT NULL ,
  `grade_id` INT NOT NULL ,
  `level` INT NOT NULL ,
  PRIMARY KEY (`chatroom_id`) ,
  INDEX `chatroom_college_id` (`college_id` ASC) ,
  INDEX `chatroom_major_id` (`major_id` ASC) ,
  INDEX `chatroom_grade_id` (`grade_id` ASC) ,
  CONSTRAINT `chatroom_college_id`
    FOREIGN KEY (`college_id` )
    REFERENCES `campusAssistant_web`.`college` (`college_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `chatroom_major_id`
    FOREIGN KEY (`major_id` )
    REFERENCES `campusAssistant_web`.`major` (`major_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `chatroom_grade_id`
    FOREIGN KEY (`grade_id` )
    REFERENCES `campusAssistant_web`.`grade` (`grade_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `campusAssistant_web`.`message`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `campusAssistant_web`.`message` (
  `message_id` INT NOT NULL AUTO_INCREMENT ,
  `content` TEXT NOT NULL ,
  `pubdate` DATETIME NOT NULL ,
  `user_id` INT NOT NULL ,
  `touser_id` INT NOT NULL ,
  `tochatroom_id` INT NOT NULL ,
  `totype` INT NOT NULL ,
  PRIMARY KEY (`message_id`) ,
  INDEX `message_user_id` (`user_id` ASC) ,
  INDEX `message_touser_id` (`touser_id` ASC) ,
  INDEX `message_chatroom_id` (`tochatroom_id` ASC) ,
  CONSTRAINT `message_user_id`
    FOREIGN KEY (`user_id` )
    REFERENCES `campusAssistant_web`.`user` (`user_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `message_touser_id`
    FOREIGN KEY (`touser_id` )
    REFERENCES `campusAssistant_web`.`user` (`user_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `message_chatroom_id`
    FOREIGN KEY (`tochatroom_id` )
    REFERENCES `campusAssistant_web`.`chatroom` (`chatroom_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `campusAssistant_web`.`campusnews`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `campusAssistant_web`.`campusnews` (
  `campusnew_id` INT NOT NULL AUTO_INCREMENT ,
  `newstype` INT NOT NULL ,
  `content` TEXT NOT NULL ,
  `pubdate` DATETIME NOT NULL ,
  `user_id` INT NOT NULL ,
  `college_id` INT NOT NULL ,
  `major_id` INT NOT NULL ,
  `level` INT NOT NULL ,
  PRIMARY KEY (`campusnew_id`) ,
  INDEX `campus_user_id` (`user_id` ASC) ,
  INDEX `campus_college_id` (`college_id` ASC) ,
  INDEX `campus_major_id` (`major_id` ASC) ,
  CONSTRAINT `campus_user_id`
    FOREIGN KEY (`user_id` )
    REFERENCES `campusAssistant_web`.`user` (`user_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `campus_college_id`
    FOREIGN KEY (`college_id` )
    REFERENCES `campusAssistant_web`.`college` (`college_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `campus_major_id`
    FOREIGN KEY (`major_id` )
    REFERENCES `campusAssistant_web`.`major` (`major_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `campusAssistant_web`.`spotcomment`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `campusAssistant_web`.`spotcomment` (
  `spotcomment_id` INT NOT NULL AUTO_INCREMENT ,
  `content` TEXT NOT NULL ,
  `pubdate` DATETIME NOT NULL ,
  `scenicspot_id` INT NOT NULL ,
  `user_id` INT NOT NULL ,
  `rating` INT NOT NULL DEFAULT 0 ,
  `impression` BLOB NULL ,
  PRIMARY KEY (`spotcomment_id`) ,
  INDEX `spotcomment_scenicspot_id` (`scenicspot_id` ASC) ,
  INDEX `spotcomment_user_id` (`user_id` ASC) ,
  CONSTRAINT `spotcomment_scenicspot_id`
    FOREIGN KEY (`scenicspot_id` )
    REFERENCES `campusAssistant_web`.`scenicspot` (`scenicspot_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `spotcomment_user_id`
    FOREIGN KEY (`user_id` )
    REFERENCES `campusAssistant_web`.`user` (`user_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `campusAssistant_web`.`question`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `campusAssistant_web`.`question` (
  `question_id` INT NOT NULL AUTO_INCREMENT ,
  `content` TEXT NOT NULL ,
  `answer` TEXT NOT NULL ,
  `user_id` INT NOT NULL ,
  `checked` TINYINT(1) NOT NULL ,
  PRIMARY KEY (`question_id`) ,
  INDEX `question_user_id` (`user_id` ASC) ,
  CONSTRAINT `question_user_id`
    FOREIGN KEY (`user_id` )
    REFERENCES `campusAssistant_web`.`user` (`user_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
