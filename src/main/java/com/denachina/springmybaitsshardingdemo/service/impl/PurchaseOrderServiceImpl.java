package com.denachina.springmybaitsshardingdemo.service.impl;

import com.denachina.springmybaitsshardingdemo.dao.PurchaseOrderDao;
import com.denachina.springmybaitsshardingdemo.po.PurchaseOrderPo;
import com.denachina.springmybaitsshardingdemo.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("purchaseOrderService")
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    @Autowired
    public PurchaseOrderDao purchaseOrderDao;

    @Override
    public PurchaseOrderPo selectByPrimaryKey(Integer hid) {
        return purchaseOrderDao.selectByPrimaryKey(hid);
    }

    @Override
    public Integer deleteByPrimaryKey(Integer hid) {
        return purchaseOrderDao.deleteByPrimaryKey(hid);
    }

    @Override
    public Integer insert(PurchaseOrderPo purchaseOrder) {
        return purchaseOrderDao.insert(purchaseOrder);
    }

    @Override
    public Integer insertSelective(PurchaseOrderPo purchaseOrder) {
        return purchaseOrderDao.insertSelective(purchaseOrder);
    }

    @Override
    public Integer insertSelectiveIgnore(PurchaseOrderPo purchaseOrder) {
        return purchaseOrderDao.insertSelectiveIgnore(purchaseOrder);
    }

    @Override
    public Integer updateByPrimaryKeySelective(PurchaseOrderPo purchaseOrder) {
        return purchaseOrderDao.updateByPrimaryKeySelective(purchaseOrder);
    }

    @Override
    public Integer updateByPrimaryKey(PurchaseOrderPo purchaseOrder) {
        return purchaseOrderDao.updateByPrimaryKey(purchaseOrder);
    }

    @Override
    public Integer batchInsert(List<PurchaseOrderPo> list) {
        return purchaseOrderDao.batchInsert(list);
    }

    @Override
    public Integer batchUpdate(List<PurchaseOrderPo> list) {
        return purchaseOrderDao.batchUpdate(list);
    }

    /**
     * 存在即更新
     */
    @Override
    public Integer upsert(PurchaseOrderPo purchaseOrder) {
        return purchaseOrderDao.upsert(purchaseOrder);
    }

    /**
     * 存在即更新，可选择具体属性
     */
    @Override
    public Integer upsertSelective(PurchaseOrderPo purchaseOrder) {
        return purchaseOrderDao.upsertSelective(purchaseOrder);
    }

    @Override
    public List<PurchaseOrderPo> query(PurchaseOrderPo purchaseOrder) {
        return purchaseOrderDao.query(purchaseOrder);
    }

    @Override
    public Long queryTotal() {
        return purchaseOrderDao.queryTotal();
    }

    @Override
    public Integer deleteBatch(List<Integer> list) {
        return purchaseOrderDao.deleteBatch(list);
    }

}
