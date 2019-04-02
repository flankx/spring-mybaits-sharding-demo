package com.denachina.springmybaitsshardingdemo.dao;

import com.denachina.springmybaitsshardingdemo.po.PurchaseOrderPo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PurchaseOrderDao {

    PurchaseOrderPo selectByPrimaryKey(Integer hid);

    Integer deleteByPrimaryKey(Integer hid);

    Integer insert(PurchaseOrderPo purchaseOrder);

    Integer insertSelective(PurchaseOrderPo purchaseOrder);

    Integer insertSelectiveIgnore(PurchaseOrderPo purchaseOrder);

    Integer updateByPrimaryKeySelective(PurchaseOrderPo purchaseOrder);

    Integer updateByPrimaryKey(PurchaseOrderPo purchaseOrder);

    Integer batchInsert(List<PurchaseOrderPo> list);

    Integer batchUpdate(List<PurchaseOrderPo> list);

    /**
     * 存在即更新
     */
    Integer upsert(PurchaseOrderPo purchaseOrder);

    /**
     * 存在即更新，可选择具体属性
     */
    Integer upsertSelective(PurchaseOrderPo purchaseOrder);

    List<PurchaseOrderPo> query(PurchaseOrderPo purchaseOrder);

    Long queryTotal();

    Integer deleteBatch(List<Integer> list);

}