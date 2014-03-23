SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `hurtownia` DEFAULT CHARACTER SET utf8 COLLATE utf8_polish_ci ;
USE `hurtownia` ;

-- -----------------------------------------------------
-- Table `hurtownia`.`rabat`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hurtownia`.`rabat` (
  `rabat_id` INT NOT NULL AUTO_INCREMENT,
  `wysokosc` DOUBLE NOT NULL,
  PRIMARY KEY (`rabat_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hurtownia`.`kod_poczt`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hurtownia`.`kod_poczt` (
  `kod_poczt_id` INT NOT NULL AUTO_INCREMENT,
  `kod_poczt` VARCHAR(6) NOT NULL,
  `nazwa_miejscowosci` TEXT NOT NULL,
  PRIMARY KEY (`kod_poczt_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hurtownia`.`ulica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hurtownia`.`ulica` (
  `ulica_id` INT NOT NULL AUTO_INCREMENT,
  `nazwa_ulicy` TEXT NOT NULL,
  `kod_poczt_id` INT NOT NULL,
  PRIMARY KEY (`ulica_id`),
  INDEX `fk_ulica_kod_poczt1_idx` (`kod_poczt_id` ASC),
  CONSTRAINT `fk_ulica_kod_poczt1`
    FOREIGN KEY (`kod_poczt_id`)
    REFERENCES `hurtownia`.`kod_poczt` (`kod_poczt_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hurtownia`.`klient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hurtownia`.`klient` (
  `klient_id` INT NOT NULL AUTO_INCREMENT,
  `nazwa_firmy` VARCHAR(256) NULL,
  `imie` VARCHAR(30) NULL,
  `nazwisko` VARCHAR(30) NULL,
  `nip` VARCHAR(10) NOT NULL,
  `regon` VARCHAR(9) NULL,
  `telefon` INT NULL,
  `rabat_id` INT NOT NULL,
  `ulica_id` INT NOT NULL,
  PRIMARY KEY (`klient_id`),
  UNIQUE INDEX `nip_UNIQUE` (`nip` ASC),
  UNIQUE INDEX `regon_UNIQUE` (`regon` ASC),
  INDEX `fk_klient_rabat_idx` (`rabat_id` ASC),
  INDEX `fk_klient_ulica1_idx` (`ulica_id` ASC),
  CONSTRAINT `fk_klient_rabat`
    FOREIGN KEY (`rabat_id`)
    REFERENCES `hurtownia`.`rabat` (`rabat_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_klient_ulica1`
    FOREIGN KEY (`ulica_id`)
    REFERENCES `hurtownia`.`ulica` (`ulica_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hurtownia`.`faktura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hurtownia`.`faktura` (
  `faktura_id` INT NOT NULL AUTO_INCREMENT,
  `nr_faktury` VARCHAR(30) NOT NULL,
  `sciezka` TEXT NOT NULL,
  `data_wystawienia` DATETIME NOT NULL,
  `klient_id` INT NOT NULL,
  PRIMARY KEY (`faktura_id`),
  INDEX `fk_faktura_klient1_idx` (`klient_id` ASC),
  CONSTRAINT `fk_faktura_klient1`
    FOREIGN KEY (`klient_id`)
    REFERENCES `hurtownia`.`klient` (`klient_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hurtownia`.`zamowienie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hurtownia`.`zamowienie` (
  `zamowienie_id` INT NOT NULL AUTO_INCREMENT,
  `nr_zamowienia` VARCHAR(30) NOT NULL,
  `klient_id` INT NOT NULL,
  PRIMARY KEY (`zamowienie_id`),
  INDEX `fk_zamowienie_klient1_idx` (`klient_id` ASC),
  CONSTRAINT `fk_zamowienie_klient1`
    FOREIGN KEY (`klient_id`)
    REFERENCES `hurtownia`.`klient` (`klient_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hurtownia`.`zamowienie_has_faktura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hurtownia`.`zamowienie_has_faktura` (
  `zamowienie_id` INT NOT NULL,
  `faktura_id` INT NOT NULL,
  PRIMARY KEY (`zamowienie_id`, `faktura_id`),
  INDEX `fk_zamowienie_has_faktura_faktura1_idx` (`faktura_id` ASC),
  INDEX `fk_zamowienie_has_faktura_zamowienie1_idx` (`zamowienie_id` ASC),
  CONSTRAINT `fk_zamowienie_has_faktura_zamowienie1`
    FOREIGN KEY (`zamowienie_id`)
    REFERENCES `hurtownia`.`zamowienie` (`zamowienie_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_zamowienie_has_faktura_faktura1`
    FOREIGN KEY (`faktura_id`)
    REFERENCES `hurtownia`.`faktura` (`faktura_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hurtownia`.`produkt`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hurtownia`.`produkt` (
  `produkt_id` INT NOT NULL AUTO_INCREMENT,
  `nazwa_produktu` TEXT NOT NULL,
  `data_dodania` DATETIME NOT NULL,
  `miara` VARCHAR(45) NOT NULL,
  `cena` DOUBLE NOT NULL,
  `data_modyfikacji` DATETIME NULL,
  PRIMARY KEY (`produkt_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hurtownia`.`magazyn`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hurtownia`.`magazyn` (
  `magazyn_id` INT NOT NULL AUTO_INCREMENT,
  `nazwa_magazynu` TEXT NOT NULL,
  `ulica_id` INT NOT NULL,
  PRIMARY KEY (`magazyn_id`),
  INDEX `fk_magazyn_ulica1_idx` (`ulica_id` ASC),
  CONSTRAINT `fk_magazyn_ulica1`
    FOREIGN KEY (`ulica_id`)
    REFERENCES `hurtownia`.`ulica` (`ulica_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hurtownia`.`stan_magazynowy`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hurtownia`.`stan_magazynowy` (
  `stan_magazynowy_id` INT NOT NULL AUTO_INCREMENT,
  `produkt_id` INT NOT NULL,
  `magazyn_id` INT NOT NULL,
  PRIMARY KEY (`stan_magazynowy_id`),
  INDEX `fk_stan_magazynowy_produkt1_idx` (`produkt_id` ASC),
  INDEX `fk_stan_magazynowy_magazyn1_idx` (`magazyn_id` ASC),
  CONSTRAINT `fk_stan_magazynowy_produkt1`
    FOREIGN KEY (`produkt_id`)
    REFERENCES `hurtownia`.`produkt` (`produkt_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_stan_magazynowy_magazyn1`
    FOREIGN KEY (`magazyn_id`)
    REFERENCES `hurtownia`.`magazyn` (`magazyn_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hurtownia`.`rozchody`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hurtownia`.`rozchody` (
  `rozchody_id` INT NOT NULL AUTO_INCREMENT,
  `ilosc` DOUBLE NULL,
  `zamowienie_id` INT NOT NULL,
  `stan_magazynowy_id` INT NOT NULL,
  PRIMARY KEY (`rozchody_id`),
  INDEX `fk_rozchody_zamowienie1_idx` (`zamowienie_id` ASC),
  INDEX `fk_rozchody_stan_magazynowy1_idx` (`stan_magazynowy_id` ASC),
  CONSTRAINT `fk_rozchody_zamowienie1`
    FOREIGN KEY (`zamowienie_id`)
    REFERENCES `hurtownia`.`zamowienie` (`zamowienie_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_rozchody_stan_magazynowy1`
    FOREIGN KEY (`stan_magazynowy_id`)
    REFERENCES `hurtownia`.`stan_magazynowy` (`stan_magazynowy_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hurtownia`.`przychody`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hurtownia`.`przychody` (
  `przychody_id` INT NOT NULL AUTO_INCREMENT,
  `ilosc` DOUBLE NOT NULL,
  `stan_magazynowy_id` INT NOT NULL,
  PRIMARY KEY (`przychody_id`),
  INDEX `fk_przychody_stan_magazynowy1_idx` (`stan_magazynowy_id` ASC),
  CONSTRAINT `fk_przychody_stan_magazynowy1`
    FOREIGN KEY (`stan_magazynowy_id`)
    REFERENCES `hurtownia`.`stan_magazynowy` (`stan_magazynowy_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
