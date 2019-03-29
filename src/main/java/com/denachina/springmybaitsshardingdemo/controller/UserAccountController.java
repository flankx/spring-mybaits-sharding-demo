package com.denachina.springmybaitsshardingdemo.controller;

import com.denachina.springmybaitsshardingdemo.po.UserAccountPo;
import com.denachina.springmybaitsshardingdemo.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/useraccount")
public class UserAccountController {
    @Autowired
    private UserAccountService userAccountService;

    /**
     * 通过id查询
     *
     * @return
     */
    @RequestMapping("/select_by_id")
    public UserAccountPo selectByPrimaryKey(Integer userId) {
        UserAccountPo po = userAccountService.selectByPrimaryKey(userId);
        return po;
    }

    /**
     * 通过ID删除
     *
     * @return
     */
    @RequestMapping("/delete_by_id")
    public int deleteByPrimaryKey(Integer userId) {
        Integer num = userAccountService.deleteByPrimaryKey(userId);
        return num;
    }

    /**
     * 新增数据
     *
     * @return
     */
    @RequestMapping("/save_userAccount")
    public Integer insert(UserAccountPo userAccount) {
        Integer num = userAccountService.insertSelective(userAccount);
        return num;
    }

    /**
     * 修改数据
     *
     * @return
     */
    @RequestMapping("/update_userAccount")
    public Integer updateByPrimaryKeySelective(UserAccountPo userAccount) {
        Integer num = userAccountService.updateByPrimaryKeySelective(userAccount);
        return num;
    }


    /**
     * 查询列表
     *
     * @return
     */
    @RequestMapping("/query_list")
    public List<UserAccountPo> queryByCondition(UserAccountPo userAccount) {
        List<UserAccountPo> list = userAccountService.query(userAccount);
        return list;
    }

}
