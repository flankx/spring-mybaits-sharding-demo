package com.denachina.springmybaitsshardingdemo.service.impl;

import com.denachina.springmybaitsshardingdemo.dao.UserAccountDao;
import com.denachina.springmybaitsshardingdemo.po.UserAccountPo;
import com.denachina.springmybaitsshardingdemo.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userAccountService")
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    public UserAccountDao userAccountDao;

    @Override
    public UserAccountPo selectByPrimaryKey(Integer userId) {
        return userAccountDao.selectByPrimaryKey(userId);
    }

    @Override
    public Integer deleteByPrimaryKey(Integer userId) {
        return userAccountDao.deleteByPrimaryKey(userId);
    }

    @Override
    public Integer insert(UserAccountPo userAccount) {
        return userAccountDao.insert(userAccount);
    }

    @Override
    public Integer insertSelective(UserAccountPo userAccount) {
        return userAccountDao.insertSelective(userAccount);
    }

    @Override
    public Integer insertSelectiveIgnore(UserAccountPo userAccount) {
        return userAccountDao.insertSelectiveIgnore(userAccount);
    }

    @Override
    public Integer updateByPrimaryKeySelective(UserAccountPo userAccount) {
        return userAccountDao.updateByPrimaryKeySelective(userAccount);
    }

    @Override
    public Integer updateByPrimaryKey(UserAccountPo userAccount) {
        return userAccountDao.updateByPrimaryKey(userAccount);
    }

    @Override
    public Integer batchInsert(List<UserAccountPo> list) {
        return userAccountDao.batchInsert(list);
    }

    @Override
    public Integer batchUpdate(List<UserAccountPo> list) {
        return userAccountDao.batchUpdate(list);
    }

    /**
     * 存在即更新
     */
    @Override
    public Integer upsert(UserAccountPo userAccount) {
        return userAccountDao.upsert(userAccount);
    }

    /**
     * 存在即更新，可选择具体属性
     */
    @Override
    public Integer upsertSelective(UserAccountPo userAccount) {
        return userAccountDao.upsertSelective(userAccount);
    }

    @Override
    public List<UserAccountPo> query(UserAccountPo userAccount) {
        return userAccountDao.query(userAccount);
    }

    @Override
    public Long queryTotal() {
        return userAccountDao.queryTotal();
    }

    @Override
    public Integer deleteBatch(List<Integer> list) {
        return userAccountDao.deleteBatch(list);
    }

}
