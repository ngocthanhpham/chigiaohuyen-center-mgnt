/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : sql_quanlihocvien

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 14/07/2020 13:50:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for information_class
-- ----------------------------
DROP TABLE IF EXISTS `information_class`;
CREATE TABLE `information_class`  (
  `id_class` int(0) NOT NULL AUTO_INCREMENT,
  `name_class` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `id_lecturer` int(0) NOT NULL,
  `class_start` date NOT NULL,
  `class_finish` date NOT NULL,
  `id_course` int(0) NOT NULL,
  `name_room` int(0) NOT NULL,
  `daylearn1` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `shiftlearn1` int(0) NOT NULL,
  `daylearn2` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `shiftlearn2` int(0) NOT NULL,
  `SL_student` int(0) NULL DEFAULT 0,
  `status_class` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT 'X',
  PRIMARY KEY (`id_class`) USING BTREE,
  INDEX `fk_id_course`(`id_course`) USING BTREE,
  INDEX `fk_id_shift1`(`shiftlearn1`) USING BTREE,
  INDEX `fk_id_shift2`(`shiftlearn2`) USING BTREE,
  INDEX `fk_id_room`(`name_room`) USING BTREE,
  INDEX `fk_id_lecturer`(`id_lecturer`) USING BTREE,
  CONSTRAINT `fk_id_course` FOREIGN KEY (`id_course`) REFERENCES `information_course` (`id_course`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_id_lecturer` FOREIGN KEY (`id_lecturer`) REFERENCES `information_lecturer` (`id_lecturer`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_id_room` FOREIGN KEY (`name_room`) REFERENCES `room` (`name_room`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_id_shift1` FOREIGN KEY (`shiftlearn1`) REFERENCES `shift` (`name_shift`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_id_shift2` FOREIGN KEY (`shiftlearn2`) REFERENCES `shift` (`name_shift`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2020000 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of information_class
-- ----------------------------
INSERT INTO `information_class` VALUES (2020000, 'SUPER001', 20205000, '2020-05-29', '2020-07-29', 202000, 201, 'Monday', 1, 'Sunday', 2, 2, 'X');

-- ----------------------------
-- Table structure for information_course
-- ----------------------------
DROP TABLE IF EXISTS `information_course`;
CREATE TABLE `information_course`  (
  `id_course` int(0) NOT NULL AUTO_INCREMENT,
  `name_course` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `price_course` int(0) NOT NULL DEFAULT 0,
  `describe_course` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `status_course` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id_course`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 202000 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of information_course
-- ----------------------------
INSERT INTO `information_course` VALUES (202000, 'Sử dụng excel nâng cao', 999000, 'Giúp bạn làm chủ excell trong 3 tháng', 'Sắp diễn ra');

-- ----------------------------
-- Table structure for information_lecturer
-- ----------------------------
DROP TABLE IF EXISTS `information_lecturer`;
CREATE TABLE `information_lecturer`  (
  `id_lecturer` int(0) NOT NULL AUTO_INCREMENT,
  `name_lecturer` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `sex_lecturer` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `birthday_lecturer` date NOT NULL,
  `phone_lecturer` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `gmail_lecturer` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `describe_lecturer` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `basesalary_lecturer` int(0) NOT NULL DEFAULT 0,
  `status_lecturer` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id_lecturer`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20205000 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of information_lecturer
-- ----------------------------
INSERT INTO `information_lecturer` VALUES (20205000, 'Thầy giáo Hai', 'Nam', '1990-02-02', '123123123', 'teacher@gmail.com', 'TOIEC 900+', 500000, 'HĐ');

-- ----------------------------
-- Table structure for information_staff
-- ----------------------------
DROP TABLE IF EXISTS `information_staff`;
CREATE TABLE `information_staff`  (
  `id_staff` int(0) NOT NULL AUTO_INCREMENT,
  `name_staff` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `sex_staff` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `birth_staff` date NOT NULL,
  `phone_staff` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `gmail_staff` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `position` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `basesalary_staff` int(0) NOT NULL,
  `status` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id_staff`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20200003 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of information_staff
-- ----------------------------
INSERT INTO `information_staff` VALUES (20200000, 'Admin', 'khác', '1975-02-02', '123123123', 'nhanvien@gmail.com', 'Tiếp tân', 500000, 'Chuyên cần');
INSERT INTO `information_staff` VALUES (20200001, 'Staff', 'khác', '1975-01-01', '123467890', 'staff@gmail.com', 'Staff', 0, ' ');

-- ----------------------------
-- Table structure for information_student
-- ----------------------------
DROP TABLE IF EXISTS `information_student`;
CREATE TABLE `information_student`  (
  `id_student` int(0) NOT NULL AUTO_INCREMENT,
  `name_student` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `id_class` int(0) NOT NULL,
  `phone_student` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `gmail_student` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `status_student` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT 'X',
  PRIMARY KEY (`id_student`) USING BTREE,
  INDEX `fk_id_class`(`id_class`) USING BTREE,
  CONSTRAINT `fk_id_class` FOREIGN KEY (`id_class`) REFERENCES `information_class` (`id_class`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 20207501 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of information_student
-- ----------------------------
INSERT INTO `information_student` VALUES (20207500, 'Nguyễn Văn Học', 2020000, '1234567890', 'student@gmail.com', 'O');
INSERT INTO `information_student` VALUES (20207501, 'Nguyễn An Ninh', 2020000, '0964345678', 'anninh@gmail.com', 'X');

-- ----------------------------
-- Table structure for login
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login`  (
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `id_staff` int(0) NOT NULL,
  `type` int(0) NOT NULL DEFAULT 3,
  INDEX `fk_id_staff`(`id_staff`) USING BTREE,
  CONSTRAINT `fk_id_staff` FOREIGN KEY (`id_staff`) REFERENCES `information_staff` (`id_staff`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES ('admin', '123456', 20200000, 1);
INSERT INTO `login` VALUES ('staff', 'staff', 20200001, 2);

-- ----------------------------
-- Table structure for note
-- ----------------------------
DROP TABLE IF EXISTS `note`;
CREATE TABLE `note`  (
  `id_note` int(0) NOT NULL AUTO_INCREMENT,
  `id_staff` int(0) NOT NULL,
  `date` date NOT NULL,
  `content` varchar(5000) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id_note`) USING BTREE,
  INDEX `fk_id_note`(`id_staff`) USING BTREE,
  CONSTRAINT `fk_id_note` FOREIGN KEY (`id_staff`) REFERENCES `information_staff` (`id_staff`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of note
-- ----------------------------
INSERT INTO `note` VALUES (1, 20200000, '2020-06-30', 'Vẫn Trống');
INSERT INTO `note` VALUES (4, 20200001, '2020-06-05', 'Vẫn Trống\n- Một con bò\n- Một con vịt\n- Một con tàu');
INSERT INTO `note` VALUES (10, 20200001, '2020-06-30', '\n 	 Đi làm sớm có buổi họp quan trọng\n 12h30:	 Đi gặp đối tác \n15h50:	 Mua thêm 2 hộp bủt');

-- ----------------------------
-- Table structure for payother
-- ----------------------------
DROP TABLE IF EXISTS `payother`;
CREATE TABLE `payother`  (
  `stt` int(0) NOT NULL AUTO_INCREMENT,
  `date` date NULL DEFAULT NULL,
  `pay` int(0) NOT NULL,
  `reciver` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `status` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`stt`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of payother
-- ----------------------------
INSERT INTO `payother` VALUES (1, '2020-06-15', 700000, 'Nuyen van B', 'Mua thiet bi');

-- ----------------------------
-- Table structure for payroll
-- ----------------------------
DROP TABLE IF EXISTS `payroll`;
CREATE TABLE `payroll`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `date` date NULL DEFAULT NULL,
  `salary_staff` int(0) NOT NULL,
  `salary_lecturer` int(0) NOT NULL,
  `pay_other` int(0) NOT NULL,
  `tuition` int(0) NOT NULL,
  `profit` int(0) NOT NULL,
  `describe_tuition` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT ' ',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of payroll
-- ----------------------------
INSERT INTO `payroll` VALUES (1, '2020-06-15', -1500000, 8800000, 700000, 499000, -7501000, ' ');

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room`  (
  `name_room` int(0) NOT NULL,
  `status_room` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT 'X',
  PRIMARY KEY (`name_room`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES (201, 'O');
INSERT INTO `room` VALUES (202, 'X');

-- ----------------------------
-- Table structure for salary_lecturer
-- ----------------------------
DROP TABLE IF EXISTS `salary_lecturer`;
CREATE TABLE `salary_lecturer`  (
  `stt` int(0) NOT NULL AUTO_INCREMENT,
  `date` date NULL DEFAULT NULL,
  `id_lecturer` int(0) NOT NULL,
  `salary_lecturer` int(0) NOT NULL,
  `numteach` int(0) NULL DEFAULT 0,
  `payother` int(0) NULL DEFAULT 0,
  `pay_lecturer` int(0) NOT NULL,
  `status` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`stt`) USING BTREE,
  INDEX `fk_salary_lecturer`(`id_lecturer`) USING BTREE,
  CONSTRAINT `fk_salary_lecturer` FOREIGN KEY (`id_lecturer`) REFERENCES `information_lecturer` (`id_lecturer`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of salary_lecturer
-- ----------------------------
INSERT INTO `salary_lecturer` VALUES (1, '2020-06-15', 20205000, 500000, 18, -200000, 8800000, 'đi muộn');

-- ----------------------------
-- Table structure for salary_staff
-- ----------------------------
DROP TABLE IF EXISTS `salary_staff`;
CREATE TABLE `salary_staff`  (
  `stt` int(0) NOT NULL AUTO_INCREMENT,
  `date` date NULL DEFAULT NULL,
  `id_staff` int(0) NOT NULL,
  `salary_staff` int(0) NOT NULL,
  `payother` int(0) NULL DEFAULT 0,
  `pay_staff` int(0) NOT NULL,
  `status` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`stt`) USING BTREE,
  INDEX `fk_salary_staff`(`id_staff`) USING BTREE,
  CONSTRAINT `fk_salary_staff` FOREIGN KEY (`id_staff`) REFERENCES `information_staff` (`id_staff`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of salary_staff
-- ----------------------------
INSERT INTO `salary_staff` VALUES (1, '2020-06-15', 20200000, 500000, -2000000, -1500000, 'đi muộn');

-- ----------------------------
-- Table structure for schedule_class
-- ----------------------------
DROP TABLE IF EXISTS `schedule_class`;
CREATE TABLE `schedule_class`  (
  `lession` int(0) NOT NULL AUTO_INCREMENT,
  `id_class` int(0) NOT NULL,
  `nameshift` int(0) NOT NULL,
  `dayweek` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `daylearn` date NULL DEFAULT NULL,
  PRIMARY KEY (`lession`) USING BTREE,
  INDEX `fk_schedule_class`(`id_class`) USING BTREE,
  INDEX `fk_schedule_nameshift`(`nameshift`) USING BTREE,
  CONSTRAINT `fk_schedule_class` FOREIGN KEY (`id_class`) REFERENCES `information_class` (`id_class`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_schedule_nameshift` FOREIGN KEY (`nameshift`) REFERENCES `shift` (`name_shift`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of schedule_class
-- ----------------------------
INSERT INTO `schedule_class` VALUES (1, 2020000, 2, 'Sunday', '2020-05-31');
INSERT INTO `schedule_class` VALUES (2, 2020000, 1, 'Monday', '2020-06-01');
INSERT INTO `schedule_class` VALUES (3, 2020000, 2, 'Sunday', '2020-06-07');
INSERT INTO `schedule_class` VALUES (4, 2020000, 1, 'Monday', '2020-06-08');
INSERT INTO `schedule_class` VALUES (5, 2020000, 2, 'Sunday', '2020-06-14');
INSERT INTO `schedule_class` VALUES (6, 2020000, 1, 'Monday', '2020-06-15');
INSERT INTO `schedule_class` VALUES (7, 2020000, 2, 'Sunday', '2020-06-21');
INSERT INTO `schedule_class` VALUES (8, 2020000, 1, 'Monday', '2020-06-22');
INSERT INTO `schedule_class` VALUES (9, 2020000, 2, 'Sunday', '2020-06-28');
INSERT INTO `schedule_class` VALUES (10, 2020000, 1, 'Monday', '2020-06-29');
INSERT INTO `schedule_class` VALUES (11, 2020000, 2, 'Sunday', '2020-07-05');
INSERT INTO `schedule_class` VALUES (12, 2020000, 1, 'Monday', '2020-07-06');
INSERT INTO `schedule_class` VALUES (13, 2020000, 2, 'Sunday', '2020-07-12');
INSERT INTO `schedule_class` VALUES (14, 2020000, 1, 'Monday', '2020-07-13');
INSERT INTO `schedule_class` VALUES (15, 2020000, 2, 'Sunday', '2020-07-19');
INSERT INTO `schedule_class` VALUES (16, 2020000, 1, 'Monday', '2020-07-20');
INSERT INTO `schedule_class` VALUES (17, 2020000, 2, 'Sunday', '2020-07-26');
INSERT INTO `schedule_class` VALUES (18, 2020000, 1, 'Monday', '2020-07-27');
INSERT INTO `schedule_class` VALUES (19, 2020000, 2, 'Sunday', '2020-05-31');
INSERT INTO `schedule_class` VALUES (20, 2020000, 1, 'Monday', '2020-06-01');
INSERT INTO `schedule_class` VALUES (21, 2020000, 2, 'Sunday', '2020-06-07');
INSERT INTO `schedule_class` VALUES (22, 2020000, 1, 'Monday', '2020-06-08');
INSERT INTO `schedule_class` VALUES (23, 2020000, 2, 'Sunday', '2020-06-14');
INSERT INTO `schedule_class` VALUES (24, 2020000, 1, 'Monday', '2020-06-15');
INSERT INTO `schedule_class` VALUES (25, 2020000, 2, 'Sunday', '2020-06-21');
INSERT INTO `schedule_class` VALUES (26, 2020000, 1, 'Monday', '2020-06-22');
INSERT INTO `schedule_class` VALUES (27, 2020000, 2, 'Sunday', '2020-06-28');
INSERT INTO `schedule_class` VALUES (28, 2020000, 1, 'Monday', '2020-06-29');
INSERT INTO `schedule_class` VALUES (29, 2020000, 2, 'Sunday', '2020-07-05');
INSERT INTO `schedule_class` VALUES (30, 2020000, 1, 'Monday', '2020-07-06');
INSERT INTO `schedule_class` VALUES (31, 2020000, 2, 'Sunday', '2020-07-12');
INSERT INTO `schedule_class` VALUES (32, 2020000, 1, 'Monday', '2020-07-13');
INSERT INTO `schedule_class` VALUES (33, 2020000, 2, 'Sunday', '2020-07-19');
INSERT INTO `schedule_class` VALUES (34, 2020000, 1, 'Monday', '2020-07-20');
INSERT INTO `schedule_class` VALUES (35, 2020000, 2, 'Sunday', '2020-07-26');
INSERT INTO `schedule_class` VALUES (36, 2020000, 1, 'Monday', '2020-07-27');

-- ----------------------------
-- Table structure for shift
-- ----------------------------
DROP TABLE IF EXISTS `shift`;
CREATE TABLE `shift`  (
  `name_shift` int(0) NOT NULL,
  `time_start` time(0) NOT NULL,
  `time_finish` time(0) NOT NULL,
  PRIMARY KEY (`name_shift`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shift
-- ----------------------------
INSERT INTO `shift` VALUES (1, '09:30:00', '11:30:00');
INSERT INTO `shift` VALUES (2, '12:30:00', '15:30:00');

-- ----------------------------
-- Table structure for tuition_student
-- ----------------------------
DROP TABLE IF EXISTS `tuition_student`;
CREATE TABLE `tuition_student`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `id_student` int(0) NOT NULL,
  `date` date NULL DEFAULT NULL,
  `price_course` int(0) NOT NULL,
  `other` int(0) NOT NULL,
  `paytuition` int(0) NOT NULL,
  `describe_tuition` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT ' ',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_tuition_student`(`id_student`) USING BTREE,
  CONSTRAINT `fk_tuition_student` FOREIGN KEY (`id_student`) REFERENCES `information_student` (`id_student`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tuition_student
-- ----------------------------
INSERT INTO `tuition_student` VALUES (1, 20207500, '2020-06-15', 999000, -500000, 499000, 'Kuyen mai');

-- ----------------------------
-- Procedure structure for checkId_class
-- ----------------------------
DROP PROCEDURE IF EXISTS `checkId_class`;
delimiter ;;
CREATE PROCEDURE `checkId_class`(IN id INT(10),
															  OUT checkvl   INT(4))
BEGIN  
       SELECT id_class INTO @t FROM information_class WHERE id_class = id;
			  IF (@t = id)  
				THEN
			     SET checkvl = 1;
				ELSE
			     SET checkvl = 0;
			  END IF;
    END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for checkId_lecturer
-- ----------------------------
DROP PROCEDURE IF EXISTS `checkId_lecturer`;
delimiter ;;
CREATE PROCEDURE `checkId_lecturer`(IN id INT(10),
															  OUT checkvl   INT(4))
BEGIN  
       SELECT id_lecturer  INTO @t FROM information_lecturer WHERE id_lecturer = id;
			  IF (@t = id)  
				THEN
			     SET checkvl = 1;
				ELSE
			     SET checkvl = 0;
			  END IF;
    END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for checkId_staff
-- ----------------------------
DROP PROCEDURE IF EXISTS `checkId_staff`;
delimiter ;;
CREATE PROCEDURE `checkId_staff`(IN id INT(10),
															  OUT checkvl   INT(4))
BEGIN   
       SELECT id_staff  INTO @t FROM login WHERE id_staff = id;
			  IF (@t = id)  
				THEN
			     SET checkvl = 1;
				ELSE
			     SET checkvl = 0;
			  END IF;
    END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for checkId_student
-- ----------------------------
DROP PROCEDURE IF EXISTS `checkId_student`;
delimiter ;;
CREATE PROCEDURE `checkId_student`(IN id INT(10),
 															  OUT checkvl   INT(4))
BEGIN  
        SELECT id_student  INTO @t FROM information_student WHERE id_student = id;
 			  IF (@t = id)  
 				THEN
 			     SET checkvl = 1;
 				ELSE
			     SET checkvl = 0;
			  END IF;
    END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for checkUsername
-- ----------------------------
DROP PROCEDURE IF EXISTS `checkUsername`;
delimiter ;;
CREATE PROCEDURE `checkUsername`(IN usernamevl VARCHAR(50),
															  OUT checkvl   INT(4))
BEGIN  
		  DECLARE t  VARCHAR(50); 
       SELECT username  INTO t FROM login WHERE username = usernamevl;
			  IF (t = usernamevl)  
				THEN
			     SET checkvl = 1;
				ELSE
			     SET checkvl = 0;
			  END IF;
    END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for creat_tuition_invoice
-- ----------------------------
DROP PROCEDURE IF EXISTS `creat_tuition_invoice`;
delimiter ;;
CREATE PROCEDURE `creat_tuition_invoice`(IN idstudent INT(10),
	                                         OUT id_hd INT(10),
	                                         OUT namestudent VARCHAR(50),
																					 OUT sdtstudent VARCHAR(50),
																					 OUT gmailstudent VARCHAR(50),
																				   OUT nameclass VARCHAR(50),
																					 OUT namecourse VARCHAR(50),
																					 OUT room VARCHAR(10),
																					 OUT vdaylearn1 VARCHAR(50),
																					 OUT vshiftlearn1 INT(10),
																					 OUT vdaylearn2 VARCHAR(50),
																					 OUT vshiftlearn2 INT(10),
																					 OUT pay_tuition INT(10))
BEGIN
		     SELECT id,paytuition
			   INTO id_hd,pay_tuition
  			 FROM tuition_student
				 WHERE id_student = idstudent;
		 
 		  	SELECT name_student,phone_student, gmail_student, id_class 
				INTO namestudent,sdtstudent,gmailstudent,@idclass
  			 FROM information_student
				 WHERE id_student = idstudent;
				 
				 SELECT name_class, id_course,name_room, daylearn1,shiftlearn1,daylearn2,shiftlearn2
			  	INTO nameclass,@idcourse,room,vdaylearn1,vshiftlearn1,vdaylearn2,vshiftlearn2
  			 FROM information_class
				 WHERE id_class = @idclass;
				 
				 SELECT name_course
				 INTO namecourse
  			 FROM information_course
				 WHERE id_course = @idcourse;
				 
     END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for deleteClass
-- ----------------------------
DROP PROCEDURE IF EXISTS `deleteClass`;
delimiter ;;
CREATE PROCEDURE `deleteClass`(IN idclass INT(10))
BEGIN
       DELETE FROM information_class
			 WHERE id_class = idclass;
    END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for deleteCourse
-- ----------------------------
DROP PROCEDURE IF EXISTS `deleteCourse`;
delimiter ;;
CREATE PROCEDURE `deleteCourse`(IN idcourse INT(20))
BEGIN
       DELETE FROM information_course
			 WHERE id_course = idcourse;
    END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for deleteLecturer
-- ----------------------------
DROP PROCEDURE IF EXISTS `deleteLecturer`;
delimiter ;;
CREATE PROCEDURE `deleteLecturer`(IN idlecturer INT(10))
BEGIN
       DELETE FROM information_lecturer
			 WHERE id_lecturer = idlecturer;
    END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for deleteNote
-- ----------------------------
DROP PROCEDURE IF EXISTS `deleteNote`;
delimiter ;;
CREATE PROCEDURE `deleteNote`(IN tid INT(20))
BEGIN
       DELETE FROM Note
			 WHERE id = tid;
    END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for deleteRoom
-- ----------------------------
DROP PROCEDURE IF EXISTS `deleteRoom`;
delimiter ;;
CREATE PROCEDURE `deleteRoom`(IN nameroom INT(20))
BEGIN
       DELETE FROM room
			 WHERE name_room = nameroom;
    END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for deleteShift
-- ----------------------------
DROP PROCEDURE IF EXISTS `deleteShift`;
delimiter ;;
CREATE PROCEDURE `deleteShift`(IN nameshift INT(10))
BEGIN
       DELETE FROM shift
			 WHERE name_shift = nameshift;
    END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for deleteStaff
-- ----------------------------
DROP PROCEDURE IF EXISTS `deleteStaff`;
delimiter ;;
CREATE PROCEDURE `deleteStaff`(IN idstaff INT(10))
BEGIN
       DELETE FROM information_staff
			 WHERE id_staff = idstaff;
    END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for deleteStudent
-- ----------------------------
DROP PROCEDURE IF EXISTS `deleteStudent`;
delimiter ;;
CREATE PROCEDURE `deleteStudent`(IN idstudent INT(10))
BEGIN  
       SELECT id_class INTO @id
			 FROM information_student
		   WHERE id_student = idstudent;
			
			 
		 SELECT SL_student INTO @sl
			FROM information_class
		  WHERE id_class = @id;
			
			 UPDATE information_class
       SET SL_student = @sl-1
       WHERE id_class = @id;
			 
			 DELETE FROM information_student
			 WHERE id_student = idstudent;
			 
    END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for getContent
-- ----------------------------
DROP PROCEDURE IF EXISTS `getContent`;
delimiter ;;
CREATE PROCEDURE `getContent`(IN idstaff INT(10),
                             IN tdate DATE,
														 OUT tcontent VARCHAR(5000))
BEGIN
       SELECT content INTO tcontent FROM Note
			 WHERE id_staff = idstaff AND date = tdate;
    END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for getcount
-- ----------------------------
DROP PROCEDURE IF EXISTS `getcount`;
delimiter ;;
CREATE PROCEDURE `getcount`(OUT countobj INT(10))
BEGIN
       SELECT COUNT(*) INTO countobj
 			 FROM information_staff;
    END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for getId
-- ----------------------------
DROP PROCEDURE IF EXISTS `getId`;
delimiter ;;
CREATE PROCEDURE `getId`(IN nameobj varchar (250),
												 OUT idobj INT(10))
BEGIN
       SELECT id_staff INTO idobj
			 FROM information_staff
			 WHERE name_staff = nameobj;
    END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for getMaxId
-- ----------------------------
DROP PROCEDURE IF EXISTS `getMaxId`;
delimiter ;;
CREATE PROCEDURE `getMaxId`(OUT countobj INT(10))
BEGIN
		  	SELECT MAX(id_staff) INTO countobj
 			 FROM information_staff;
    END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for getMaxId_lecturer
-- ----------------------------
DROP PROCEDURE IF EXISTS `getMaxId_lecturer`;
delimiter ;;
CREATE PROCEDURE `getMaxId_lecturer`(OUT countobj INT(10))
BEGIN
 		  	SELECT MAX(id_lecturer) INTO countobj
  			 FROM information_lecturer;
     END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for getMaxId_student
-- ----------------------------
DROP PROCEDURE IF EXISTS `getMaxId_student`;
delimiter ;;
CREATE PROCEDURE `getMaxId_student`(OUT countobj INT(10))
BEGIN
 		  	SELECT MAX(id_student) INTO countobj
  			 FROM information_student;
     END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for getName
-- ----------------------------
DROP PROCEDURE IF EXISTS `getName`;
delimiter ;;
CREATE PROCEDURE `getName`(IN idobj INT(10),
                          OUT nameobj varchar (250))
BEGIN
       SELECT name_staff INTO nameobj
			 FROM information_staff
			 WHERE id_staff = idobj;
    END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for insertClass
-- ----------------------------
DROP PROCEDURE IF EXISTS `insertClass`;
delimiter ;;
CREATE PROCEDURE `insertClass`(IN name_class VARCHAR(100),
																	IN id_lecturer INT(10),
														      IN id_course INT(10),
																	IN class_start DATE,
																	IN class_finish DATE,
																	IN name_room INT(10),
																	IN daylearn1 VARCHAR(10),
																	IN shiftlearn1 INT(10),
																	IN daylearn2 VARCHAR(10),
																	IN shiftlearn2 INT(10))
BEGIN
		   INSERT INTO information_class(name_class,id_lecturer,id_course, class_start, class_finish, name_room,daylearn1,shiftlearn1,daylearn2,shiftlearn2 ) 
			 VALUES (name_class,id_lecturer,id_course, class_start, class_finish, name_room,daylearn1,shiftlearn1,daylearn2,shiftlearn2 );
			 SELECT MAX(id_class) INTO @max_id_class
				FROM information_class;
			  CALL insertSchedule_class(@max_id_class);
    END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for insertCourse
-- ----------------------------
DROP PROCEDURE IF EXISTS `insertCourse`;
delimiter ;;
CREATE PROCEDURE `insertCourse`(IN name_course VARCHAR(100),
															 IN price_course INT(10),
															 IN describe_course VARCHAR(5000),
                               IN status_course VARCHAR(500))
BEGIN
		   INSERT INTO information_course(name_course,price_course,describe_course,status_course) 
			 VALUES (name_course, price_course, describe_course, status_course);
    END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for insertLecturer
-- ----------------------------
DROP PROCEDURE IF EXISTS `insertLecturer`;
delimiter ;;
CREATE PROCEDURE `insertLecturer`(IN namelecturer VARCHAR(50),
                                 IN sex_lecturer  VARCHAR(10),
																 IN birthday_lecturer DATE,
                                 IN phone_lecturer VARCHAR(50),
														     IN gmail_lecturer VARCHAR(50),
														     IN describe_lecturer VARCHAR(5000),
																 IN basesalary_lecturer INT(10),
															   IN status_lecturer VARCHAR(500))
BEGIN
		   INSERT INTO information_lecturer(name_lecturer,sex_lecturer,birthday_lecturer, phone_lecturer, gmail_lecturer, describe_lecturer,basesalary_lecturer, status_lecturer) 
			 VALUES (namelecturer,sex_lecturer,birthday_lecturer, phone_lecturer, gmail_lecturer, describe_lecturer, basesalary_lecturer, status_lecturer);
    END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for insertNote
-- ----------------------------
DROP PROCEDURE IF EXISTS `insertNote`;
delimiter ;;
CREATE PROCEDURE `insertNote`(IN idstaff INT(10),
                       IN tdate DATE,
                       IN tcontent varchar (5000))
BEGIN
		   INSERT INTO Note(id_staff,date,content) VALUES (idstaff,tdate,tcontent);
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for insertRoom
-- ----------------------------
DROP PROCEDURE IF EXISTS `insertRoom`;
delimiter ;;
CREATE PROCEDURE `insertRoom`(IN name_room INT(10))
BEGIN
		   INSERT INTO room(name_room) 
			 VALUES (name_room);
    END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for insertSchedule_class
-- ----------------------------
DROP PROCEDURE IF EXISTS `insertSchedule_class`;
delimiter ;;
CREATE PROCEDURE `insertSchedule_class`(IN idclass INT(10))
BEGIN
	  	SELECT class_start,class_finish,daylearn1,shiftlearn1, daylearn2,shiftlearn2 
				INTO @date_start ,@date_finish, @daylearn1, @shiftlearn1, @daylearn2, @shiftlearn2
			FROM information_class
		  WHERE id_class = idclass;
			SET @date = @date_start;
			
			 WHILE  @date_start <= @date AND @date <= @date_finish DO
			 
					  IF DAYNAME(@date) =  @daylearn1 THEN
						  	INSERT schedule_class(id_class,nameshift,dayweek, daylearn)
								VALUES(idclass,@shiftlearn1,DAYNAME(@date), @date);
					  END IF;
						
						  IF DAYNAME(@date) =  @daylearn2 THEN
						  	INSERT schedule_class(id_class,nameshift,dayweek, daylearn)
								VALUES(idclass,@shiftlearn2,DAYNAME(@date), @date);
					  END IF;
						
					 SET @date = ADDDATE( @date,1);		 
			 END WHILE;
    END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for insertShift
-- ----------------------------
DROP PROCEDURE IF EXISTS `insertShift`;
delimiter ;;
CREATE PROCEDURE `insertShift`(IN nameshift INT(10),
                                IN time_start TIME,
                                IN time_finish TIME)
BEGIN
		   INSERT INTO shift(name_shift,time_start,time_finish) 
			 VALUES (nameshift,time_start, time_finish);
    END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for insertStaff
-- ----------------------------
DROP PROCEDURE IF EXISTS `insertStaff`;
delimiter ;;
CREATE PROCEDURE `insertStaff`(IN username varchar (50),
														  IN password varchar (50),
														  IN type INT(3),
                              IN name_staff varchar (250),
                              IN sex_staff varchar (10),
															IN birth_staff DATE, 
															IN phone_staff varchar (20),
															IN gmail_staff varchar (50),
														  IN position varchar (50),
														  IN basesalary_staff INT(20),
															IN status varchar (500))
BEGIN
		   INSERT INTO information_staff(name_staff,sex_staff,birth_staff, phone_staff, gmail_staff, position, basesalary_staff,       status) VALUES (name_staff,sex_staff,birth_staff, phone_staff, gmail_staff, position,
			 basesalary_staff, status);
			 CALL getid(name_staff,@id_staff);
			 INSERT INTO login (username, password, id_staff,type) VALUES(username, password, @id_staff, type);
    END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for insertStudent
-- ----------------------------
DROP PROCEDURE IF EXISTS `insertStudent`;
delimiter ;;
CREATE PROCEDURE `insertStudent`(IN name_student VARCHAR(100),
															  IN idclass INT(10),
														  	IN phone_student VARCHAR(50),
                                IN gmail_student VARCHAR(50),
														  	IN status_student VARCHAR(50))
BEGIN
		   INSERT INTO information_student(name_student,id_class,phone_student,gmail_student,status_student) 
			 VALUES (name_student, idclass, phone_student, gmail_student, status_student);
 
			 
			SELECT SL_student INTO @sl
			FROM information_class
		  WHERE id_class = idclass;
			
			 UPDATE information_class
       SET SL_student = @sl+1
       WHERE id_class = idclass;

    END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for insert_payother
-- ----------------------------
DROP PROCEDURE IF EXISTS `insert_payother`;
delimiter ;;
CREATE PROCEDURE `insert_payother`(IN pay INT(10),
													          IN reciver VARCHAR(500),
																		IN tstatus VARCHAR(500))
BEGIN
				INSERT INTO payother(date,pay,reciver,status) 
			  VALUES (CURRENT_DATE(),pay,reciver,tstatus);
    END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for insert_payroll
-- ----------------------------
DROP PROCEDURE IF EXISTS `insert_payroll`;
delimiter ;;
CREATE PROCEDURE `insert_payroll`()
BEGIN
		    SELECT SUM(pay_staff) INTO @salary_staff
			  FROM salary_staff
			  WHERE MONTH(date) = MONTH(CURRENT_DATE) AND YEAR(@date) = YEAR(CURRENT_DATE);
				
				SELECT SUM(pay_lecturer) INTO @salary_lecturer
			  FROM salary_lecturer
			  WHERE MONTH(date) = MONTH(CURRENT_DATE) AND YEAR(@date) = YEAR(CURRENT_DATE);
				
				SELECT SUM(pay) INTO @pay_other
			  FROM payother
			  WHERE MONTH(date) = MONTH(CURRENT_DATE) AND YEAR(@date) = YEAR(CURRENT_DATE);
				
				SELECT SUM(paytuition) INTO @pay_tuition
			  FROM tuition_student
			  WHERE MONTH(date) = MONTH(CURRENT_DATE) AND YEAR(@date) = YEAR(CURRENT_DATE);
				
				SET @profit = @pay_tuition -  @salary_staff -  @salary_lecturer - @pay_other;
				
			 SELECT date INTO @date FROM payroll
				WHERE MONTH(date) = MONTH(CURRENT_DATE) AND YEAR(date) = YEAR(CURRENT_DATE);
				IF MONTH(@date) != MONTH(CURRENT_DATE) OR YEAR(@date) != YEAR(CURRENT_DATE) THEN
						INSERT INTO payroll(date,salary_staff,salary_lecturer,pay_other,tuition,profit) 
						VALUES (CURRENT_DATE(),@salary_staff,@salary_lecturer, @pay_other,@pay_tuition, @profit);
				
				ELSE
				    UPDATE payroll
			      SET date = CURRENT_DATE(),salary_staff = @salary_staff,salary_lecturer= @salary_lecturer,pay_other = @pay_other,						tuition = @pay_tuition,profit = @profit
						WHERE MONTH(date) = MONTH(CURRENT_DATE) AND YEAR(@date) = YEAR(CURRENT_DATE);
				END IF;
    END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for insert_salary_lecturer
-- ----------------------------
DROP PROCEDURE IF EXISTS `insert_salary_lecturer`;
delimiter ;;
CREATE PROCEDURE `insert_salary_lecturer`(IN idlecturer INT(10),
													                  IN payother INT(10),
																			    	IN tstatus VARCHAR(5000),
													                	OUT salary INT(10))
BEGIN
				
			  SELECT basesalary_lecturer INTO @basesalary
			  FROM information_lecturer
			  WHERE id_lecturer = idlecturer;
				
		  	SELECT MAX(id_class) INTO @max_id_class
        FROM information_class;
				SET @tsum =0;
				SET @id_class = 2020000;
				WHILE(@id_class <= @max_id_class) DO
					  CALL checkId_class(@id_class,@tcheck);
						IF @tcheck = 1 THEN
								SELECT id_lecturer INTO @id_lecturer
								FROM information_class
								WHERE id_class = @id_class;
							 	IF @id_lecturer = idlecturer THEN 
									   CALL Numteach(@id_class,MONTH(CURRENT_DATE),@num);
										 SET @tsum = @tsum + @num;
								END IF;
						END IF;
				    SET @id_class= @id_class+1;
				END WHILE;
				
        SET salary =  @basesalary* @tsum + payother;
				INSERT INTO salary_lecturer(date,id_lecturer,salary_lecturer,numteach,payother,pay_lecturer,status) 
			  VALUES (CURRENT_DATE(),idlecturer,@basesalary,@tsum,payother,salary,tstatus);
    END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for insert_salary_staff
-- ----------------------------
DROP PROCEDURE IF EXISTS `insert_salary_staff`;
delimiter ;;
CREATE PROCEDURE `insert_salary_staff`(IN idstaff INT(10),
													              IN payother INT(10),
																				IN tstatus VARCHAR(5000),
													            	OUT salary INT(10))
BEGIN
				
			  SELECT basesalary_staff INTO @basesalary
			  FROM information_staff
			  WHERE id_staff = idstaff;
        SET @pay =  @basesalary+ payother;
				SET salary =  @pay;
				INSERT INTO salary_staff(date,id_staff,salary_staff,payother,pay_staff,status) 
			  VALUES (CURRENT_DATE(),idstaff,@basesalary,payother,@pay,tstatus);
    END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for insert_tuition_student
-- ----------------------------
DROP PROCEDURE IF EXISTS `insert_tuition_student`;
delimiter ;;
CREATE PROCEDURE `insert_tuition_student`(IN idstudent INT(10),
													               IN other VARCHAR(500),
																		     IN describe_tuition VARCHAR(500))
BEGIN
		
				SELECT id_class INTO @idclass
			  FROM information_student
			  WHERE id_student = idstudent;
			
				SELECT id_course INTO @idcourse
			  FROM information_class
			  WHERE id_class = @idclass;
				
				SELECT price_course INTO @price_course
			  FROM information_course
			  WHERE id_course = @idcourse;
				 
		    SET @paytuition = @price_course+ other;
				INSERT INTO tuition_student(id_student,date,price_course,other,paytuition,describe_tuition) 
			  VALUES (idstudent, CURRENT_DATE(), @price_course,other,@paytuition,describe_tuition);
    END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for lastdatenote
-- ----------------------------
DROP PROCEDURE IF EXISTS `lastdatenote`;
delimiter ;;
CREATE PROCEDURE `lastdatenote`(IN idstaff INT(10),
                                 OUT tdate DATE)
BEGIN
       SELECT MAX(date) INTO tdate 
			 FROM Note
			 WHERE id_staff = idstaff;
    END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for Numteach
-- ----------------------------
DROP PROCEDURE IF EXISTS `Numteach`;
delimiter ;;
CREATE PROCEDURE `Numteach`(IN idclass INT(10) ,
                            IN tmonth INT(10),
														OUT num INT(10))
BEGIN
		           SELECT COUNT(*) INTO num 
							 FROM schedule_class
							 WHERE id_class = id_class AND MONTH(daylearn) = tmonth;
		END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for updateClass
-- ----------------------------
DROP PROCEDURE IF EXISTS `updateClass`;
delimiter ;;
CREATE PROCEDURE `updateClass`(IN idclass INT (10),
                                  IN name_class VARCHAR(100),
																	IN id_lecturer INT(10),
														      IN id_course INT(10),
																	IN class_start DATE,
																	IN class_finish DATE,
																	IN name_room INT(10),
																	IN daylearn1 VARCHAR(10),
																	IN shiftlearn1 INT(10),
																	IN daylearn2 VARCHAR(10),
																	IN shiftlearn2 INT(10))
BEGIN
		   UPDATE information_class
       SET name_class = name_class,id_lecturer = id_lecturer, id_course = id_course, class_start=class_start,class_finish=class_finish, name_room = name_room ,daylearn1 = daylearn1, shiftlearn1= shiftlearn1, daylearn2 = daylearn2, shiftlearn2= shiftlearn2
       WHERE id_class = idclass;
			 
    END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for updateCourse
-- ----------------------------
DROP PROCEDURE IF EXISTS `updateCourse`;
delimiter ;;
CREATE PROCEDURE `updateCourse`(IN idcourse INT (10),
                                 IN name_course VARCHAR(100),
														     IN price_course INT(10),
														     IN describe_course VARCHAR(5000),
								                 IN status_course VARCHAR(500))
BEGIN
		   UPDATE information_course
       SET name_course = name_course, price_course = price_course, describe_course = describe_course ,
			 status_course = status_course
       WHERE id_course = idcourse;
    END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for updateLecturer
-- ----------------------------
DROP PROCEDURE IF EXISTS `updateLecturer`;
delimiter ;;
CREATE PROCEDURE `updateLecturer`(IN idlecturer INT (10),
                                 IN phone_lecturer varchar (50),
														     IN gmail_lecturer varchar (50),
														     IN describe_lecturer varchar (5000),
																 IN basesalary_lecturer INT(10),
															   IN status_lecturer varchar(500))
BEGIN
		   UPDATE information_lecturer
       SET phone_lecturer = phone_lecturer, gmail_lecturer = gmail_lecturer, describe_lecturer = describe_lecturer, basesalary_lecturer = basesalary_lecturer,status_lecturer = status_lecturer
       WHERE id_lecturer = idlecturer;
    END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for updateNote
-- ----------------------------
DROP PROCEDURE IF EXISTS `updateNote`;
delimiter ;;
CREATE PROCEDURE `updateNote`(IN idstaff INT(10),
                       IN tdate DATE,
                       IN tcontent varchar (5000))
BEGIN
		   UPDATE Note
			 SET content = tcontent 
			 WHERE id_staff = idstaff AND date = tdate;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for updateRoom
-- ----------------------------
DROP PROCEDURE IF EXISTS `updateRoom`;
delimiter ;;
CREATE PROCEDURE `updateRoom`(IN nameroom INT (10),
                                IN status_room VARCHAR(50))
BEGIN
		   UPDATE room
       SET status_room = status_room
       WHERE name_room = nameroom;
    END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for updateShift
-- ----------------------------
DROP PROCEDURE IF EXISTS `updateShift`;
delimiter ;;
CREATE PROCEDURE `updateShift`(IN nameshift INT (10),
                                IN time_start TIME,
                                IN time_finish TIME)
BEGIN
		   UPDATE shift
       SET time_start = time_start, time_finish = time_finish
       WHERE name_shift = nameshift;
    END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for updateStaff
-- ----------------------------
DROP PROCEDURE IF EXISTS `updateStaff`;
delimiter ;;
CREATE PROCEDURE `updateStaff`(IN idstaff INT (10),
                              IN tdate DATE,
															IN tcontent varchar (5000))
BEGIN
		   UPDATE Note
       SET id_staff = idstaff, content = tcontent
       WHERE id_staff = idstaff AND date = tdate;
    END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for update_salary_staff
-- ----------------------------
DROP PROCEDURE IF EXISTS `update_salary_staff`;
delimiter ;;
CREATE PROCEDURE `update_salary_staff`(IN idstaff INT(10),
													              IN payother INT(10),
																				IN tstatus VARCHAR(5000),
													            	OUT salary INT(10))
BEGIN
				
    END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
