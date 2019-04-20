package com.chen.mapper;

import com.chen.po.Customer;

import java.util.List;
import java.util.Map;

public interface MybatisMapper {
    int insertList(Map<String,Object> map);

    int updateBatch(List<Customer> list);

    int deleteByBatch(int[] ids);
}
