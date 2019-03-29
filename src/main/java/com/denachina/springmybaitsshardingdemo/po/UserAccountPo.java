package com.denachina.springmybaitsshardingdemo.po;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserAccountPo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer userId;

    private String email;

    private String encryptEmail;

    private String phoneNo;

    private String encryptPhone;

    private Integer area;

    private String pwd;

    private String seed;

    private Integer createdOn;

    private Integer updatedOn;

}
/*
CREATE TABLE `user_account` (
  `user_id` int(11) unsigned NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `encrypt_email` varchar(100) DEFAULT NULL,
  `phone_no` varchar(13) DEFAULT NULL,
  `encrypt_phone` varchar(100) DEFAULT NULL,
  `area` int(4) DEFAULT NULL,
  `pwd` varchar(150) DEFAULT NULL,
  `seed` varchar(50) DEFAULT NULL,
  `created_on` int(11) NOT NULL DEFAULT '0',
  `updated_on` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `phone_no` (`phone_no`,`area`),
  UNIQUE KEY `encrypt_phone` (`encrypt_phone`,`area`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
 */