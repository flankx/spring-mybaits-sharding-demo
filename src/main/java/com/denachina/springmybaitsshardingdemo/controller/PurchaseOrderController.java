package com.denachina.springmybaitsshardingdemo.controller;

import com.denachina.springmybaitsshardingdemo.po.PurchaseOrderPo;
import com.denachina.springmybaitsshardingdemo.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/purchaseorder")
public class PurchaseOrderController {

    @Autowired
    private PurchaseOrderService purchaseOrderService;

    /**
     * 通过id查询
     *
     * @return
     */
    @RequestMapping("/select_by_id")
    public PurchaseOrderPo selectByPrimaryKey(Integer hid) {
        PurchaseOrderPo po = purchaseOrderService.selectByPrimaryKey(hid);
        return po;
    }

    /**
     * 通过ID删除
     *
     * @return
     */
    @RequestMapping("/delete_by_id")
    public Integer deleteByPrimaryKey(Integer hid) {
        Integer num = purchaseOrderService.deleteByPrimaryKey(hid);
        return num;
    }

    /**
     * 新增数据
     *
     * @return
     */
    @RequestMapping("/save_purchaseOrder")
    public Integer insert(PurchaseOrderPo purchaseOrder) {
        Integer num = purchaseOrderService.insertSelective(purchaseOrder);
        return num;
    }

    /**
     * 修改数据
     *
     * @return
     */
    @RequestMapping("/update_purchaseOrder")
    public Integer updateByPrimaryKeySelective(PurchaseOrderPo purchaseOrder) {
        Integer num = purchaseOrderService.updateByPrimaryKeySelective(purchaseOrder);
        return num;
    }


    /**
     * 查询列表
     *
     * @return
     */
    @RequestMapping("/query_list")
    public List<PurchaseOrderPo> queryByCondition(PurchaseOrderPo purchaseOrder) {
        List<PurchaseOrderPo> list = purchaseOrderService.query(purchaseOrder);
        return list;
    }

}
