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
	`petprofile` int NOT NULL,
	`petprofilefollowed_id` int NOT NULL,	
	`creation_date` datetime DEFAULT NULL,	
	PRIMARY KEY (`follow_id`),
	CONSTRAINT FK_pet_profile_id_fo FOREIGN KEY (`petprofile`) REFERENCES `pet_profiles`(`pet_profile_id`) ON UPDATE CASCADE ON DELETE CASCADE	
 ) ;
 
-- Creamos tabla photos
-- photos_id es clave principal y propia
-- profile_id es clave foranea y principal ,`profile_id`),
 CREATE TABLE IF NOT EXISTS `photos`(
	`photo_id` int NOT NULL AUTO_INCREMENT,
	`pet_profile_id` int NOT NULL,
	`url` varchar(190) NOT NULL,
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
	VALUES ('Jorge', '1111@gmail.com', '1111', '1989-01-20', '2019-12-04 00:00:00'),
		   ('Maria', '2222@gmail.com', '2222', '1995-11-02', '2019-11-04 00:00:00'),
		   ('Diego', '3333@gmail.com', '3333', '1999-03-03', '2019-10-04 00:00:00'),
		   ('Rocio', '4444@gmail.com', '4444', '2001-08-01', '2019-09-04 00:00:00'),
		   ('Rodri', '5555@gmail.com', '5555', '2000-07-07', '2019-08-04 00:00:00');
		   
	INSERT INTO `pet_profiles` (`user_id`, `nick`, `sexo`, `raza`, `img_profile`,`description`,`pet_borndate`) 
	VALUES (1, 'nick1','h','Raza1', 'C:\Users\Bazinga','description1','2009-12-04 00:00:00'),
		   (1, 'nick2','m','Raza2', 'C:\Users\Bazinga','description2','2019-11-04 00:00:00'),
		   (2, 'nick3','m','Raza3', 'C:\Users\Bazinga','description3','2005-10-04 00:00:00'),
		   (3, 'nick4','h','Raza4', 'C:\Users\Bazinga','description4','2008-09-04 00:00:00'),
		   (3, 'nick5','h','Raza5', 'C:\Users\Bazinga','description5','2009-08-04 00:00:00'),
		   (4, 'nick6','m','Raza6', 'C:\Users\Bazinga','description6','2010-10-04 00:00:00'),
		   (5, 'nick7','h','Raza7', 'C:\Users\Bazinga','description7','2017-09-04 00:00:00');	

	INSERT INTO `follows` (`petprofile_id`, `petprofilefollowed_id`, `creation_date`) 
	VALUES (1,2,'2019-12-04 00:00:00'),
		   (1,3,'2019-11-04 00:00:00'),
		   (1,4,'2019-10-04 00:00:00'),
		   (2,1,'2019-09-04 00:00:00'),
		   (2,3,'2019-08-04 00:00:00'),
		   (3,2,'2019-10-04 00:00:00'),
		   (4,5,'2019-09-04 00:00:00'),		
		   (5,2,'2019-09-04 00:00:00'),
		   (5,3,'2019-09-04 00:00:00'); 