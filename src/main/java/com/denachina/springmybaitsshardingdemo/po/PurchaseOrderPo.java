package com.denachina.springmybaitsshardingdemo.po;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PurchaseOrderPo {

    private Integer hid;

    private String orderId;

    private String storeType;

    private Long lid;

    private String deviceUniqueId;

    private String sessionId;

    private Integer status;

    private Integer sdkStatus;

    private Integer serverStatus;

    private BigDecimal priceShow;

    private String unitShow;

    private Integer lnum;

    private Integer priceTier;

    private String sku;

    private String affcode;

    private String region;

    private BigDecimal payAmount;

    private String memo;

    private String notifyInfo;

    private Integer type;

    private Integer subtype;

    private String orderInfo;

    private Integer createdOn;

    private Integer updatedOn;

    private Integer sdkUpdatedOn;

    private Integer serverUpdatedOn;

}

/*
CREATE TABLE `purchase_order` (
  `hid` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(255) NOT NULL,
  `store_type` varchar(20) NOT NULL,
  `lid` bigint(20) NOT NULL,
  `device_unique_id` varchar(100) DEFAULT NULL,
  `session_id` varchar(255) DEFAULT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '0',
  `sdk_status` tinyint(4) DEFAULT '0',
  `server_status` tinyint(4) DEFAULT '0',
  `price_show` decimal(11,2) NOT NULL,
  `unit_show` varchar(255) NOT NULL,
  `lnum` int(11) NOT NULL,
  `price_tier` int(11) NOT NULL,
  `sku` varchar(128) NOT NULL,
  `affcode` varchar(50) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  `pay_amount` decimal(11,2) DEFAULT NULL,
  `memo` text,
  `notify_info` text,
  `type` smallint(4) DEFAULT '0',
  `subtype` smallint(4) DEFAULT '0',
  `order_info` text,
  `created_on` int(11) unsigned NOT NULL,
  `updated_on` int(11) unsigned NOT NULL,
  `sdk_updated_on` int(11) unsigned DEFAULT '0',
  `server_updated_on` int(11) unsigned DEFAULT '0',
  PRIMARY KEY (`hid`),
  UNIQUE KEY `order_id` (`order_id`),
  KEY `i1` (`order_id`,`store_type`),
  KEY `lid` (`lid`),
  KEY `i2` (`created_on`)
) ENGINE=InnoDB AUTO_INCREMENT=10327 DEFAULT CHARSET=utf8
 */
