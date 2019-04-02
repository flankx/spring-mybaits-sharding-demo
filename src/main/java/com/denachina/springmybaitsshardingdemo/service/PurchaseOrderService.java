package com.denachina.springmybaitsshardingdemo.service;

import com.denachina.springmybaitsshardingdemo.po.PurchaseOrderPo;

import java.util.List;

public interface PurchaseOrderService {

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
