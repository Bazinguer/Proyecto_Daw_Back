-- Creamos tabla users
-- mail es única
-- Nota: Md5 genera 32 caracteres
-- git remote add origin https://github.com/Bazinguer/Proyecto_Daw_Back.git
-- git push -u origin master
 CREATE TABLE IF NOT EXISTS `users`(	
	`user_id` int NOT NULL AUTO_INCREMENT,
	`username` varchar(150) NOT NULL,	
	`email` varchar(150) NOT NULL UNIQUE,
	`password` varchar(32) NOT NULL,	
	`born_date` datetime NOT NULL,	
	`registration_date` datetime NOT NULL,
	 PRIMARY KEY (`user_id`)	
 ) ;

-- Creamos tabla pet_profiles
 CREATE TABLE IF NOT EXISTS `pet_profiles`(
	`pet_profile_id` int NOT NULL AUTO_INCREMENT,
	`user_id` int NOT NULL,
	`nick` varchar(30) NOT NULL UNIQUE,
	`sexo` varchar(1) DEFAULT NULL,
	`raza` varchar(100) DEFAULT NULL,
	`img_profile` varchar(150) NULL,	
	`description` varchar(191) DEFAULT NULL,	
	`pet_borndate` datetime DEFAULT NULL,	
	 PRIMARY KEY (`pet_profile_id`),
	 CONSTRAINT FK_user_id FOREIGN KEY (`user_id`) REFERENCES `users`(`user_id`) ON UPDATE CASCADE ON DELETE CASCADE
 ) ;
 
-- Creamos tabla follows (seguir/seguidos)
-- follows_id es clave principal
-- profile_follow_id es clave foranea y principal ,`profile_follow_id`),
 CREATE TABLE IF NOT EXISTS `follows`(
	`follow_id` int NOT NULL AUTO_INCREMENT,	
	`pet_profile_follow_id` int NOT NULL,
	`pet_profile_followed_id` int NOT NULL,	
	`creation_date` datetime DEFAULT NULL,	
	PRIMARY KEY (`follow_id`),
	CONSTRAINT FK_pet_profile_id_fo FOREIGN KEY (`pet_profile_follow_id`) REFERENCES `pet_profiles`(`pet_profile_id`) ON UPDATE CASCADE ON DELETE CASCADE	
 ) ;
 
-- Creamos tabla photos
-- photos_id es clave principal y propia
-- profile_id es clave foranea y principal ,`profile_id`),
 CREATE TABLE IF NOT EXISTS `photos`(
	`photo_id` int NOT NULL AUTO_INCREMENT,
	`pet_profile_id` int NOT NULL,
 	`title` varchar(50) NOT NULL,
	`shortDesciprion` varchar(191) NOT NULL,
	`creation_date` datetime DEFAULT NULL,	
	PRIMARY KEY (`photo_id`),
	CONSTRAINT FK_pet_profile_id_pho FOREIGN KEY (`pet_profile_id`) REFERENCES `pet_profiles`(`pet_profile_id`) ON UPDATE CASCADE ON DELETE CASCADE	
 ) ;

-- Creamos tabla photo_comments `photo_id`,`profile_id`),
 CREATE TABLE IF NOT EXISTS `photo_comments`(
	`comment_id` int NOT NULL AUTO_INCREMENT,
	`photo_id` int NOT NULL,
	`pet_profile_id` int NOT NULL, 	
	`text_comment` varchar(191) NOT NULL,
	`creation_date` datetime DEFAULT NULL,	
	 PRIMARY KEY (`comment_id`),
	 CONSTRAINT FK_photo_id FOREIGN KEY (`photo_id`) REFERENCES `photos`(`photo_id`) ON UPDATE CASCADE ON DELETE CASCADE,	
	 CONSTRAINT FK_pet_profile_id_com FOREIGN KEY (`pet_profile_id`) REFERENCES `pet_profiles`(`pet_profile_id`) ON UPDATE CASCADE ON DELETE CASCADE	 
 ) ;
 
	INSERT INTO `users` (`username`, `email`, `password`, `born_date`, `registration_date`) 
	VALUES ('Jorge', 'aaaa@gmail.com', '123456', '1989-01-20', '2019-12-04 00:00:00'),
		   ('Maria', 'bbbb@gmail.com', 'abc', '1995-11-02', '2019-11-04 00:00:00'),
		   ('Diego', 'cccc@gmail.com', 'abc123', '1999-03-03', '2019-10-04 00:00:00'),
		   ('Nacho', 'dddd@gmail.com', '987654', '1987-10-10', '2019-09-04 00:00:00'),
		   ('Rodrigo', 'eeee@gmail.com', '1111', '2000-07-07', '2019-08-04 00:00:00');