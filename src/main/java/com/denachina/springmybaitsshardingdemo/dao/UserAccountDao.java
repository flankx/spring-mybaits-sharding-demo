package com.denachina.springmybaitsshardingdemo.dao;

import com.denachina.springmybaitsshardingdemo.po.UserAccountPo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserAccountDao {

    UserAccountPo selectByPrimaryKey(Integer userId);

    Integer deleteByPrimaryKey(Integer userId);

    Integer insert(UserAccountPo userAccount);

    Integer insertSelective(UserAccountPo userAccount);

    Integer insertSelectiveIgnore(UserAccountPo userAccount);

    Integer updateByPrimaryKeySelective(UserAccountPo userAccount);

    Integer updateByPrimaryKey(UserAccountPo userAccount);

    Integer batchInsert(List<UserAccountPo> list);

    Integer batchUpdate(List<UserAccountPo> list);

    /**
     * 存在即更新
     */
    Integer upsert(UserAccountPo userAccount);

    /**
     * 存在即更新，可选择具体属性
     */
    Integer upsertSelective(UserAccountPo userAccount);

    List<UserAccountPo> query(UserAccountPo userAccount);

    Long queryTotal();

    Integer deleteBatch(List<Integer> list);

}