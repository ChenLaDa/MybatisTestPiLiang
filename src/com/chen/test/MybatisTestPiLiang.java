package com.chen.test;

import com.chen.po.Customer;
import com.chen.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MybatisTestPiLiang {

    @Test
    public void insertListTest(){
        SqlSession session = MybatisUtils.getSqlSession(true);
        List<Customer> ls = new ArrayList<>();
        for(int i = 10;i <= 15;i++){
            Customer customer = new Customer();
            customer.setId(i);
            customer.setUsername("陈冰清" + i);
            customer.setJobs("学生" + i);
            customer.setPhone("150744*****" + i);
            ls.add(customer);
        }
        int rows = session.insert("insertList", ls);
        if (rows>0){
            System.out.println("成功增加"+rows+"条数据！");
        }else {
            System.out.println("增加失败！");
        }
        session.commit();
        MybatisUtils.closeSqlSession(session);
    }

    @Test
    public void updateBatchTest(){
        SqlSession session = MybatisUtils.getSqlSession(true);
        List<Integer> ls = new ArrayList<>();
        for(int i = 10;i <=15 ;i++){
            ls.add(i);
        }
        int rows = session.update("updateBatch",ls);
        if (rows>0){
            System.out.println("成功修改"+rows+"条数据！");
        }else {
            System.out.println("修改失败！");
        }
        session.commit();
        MybatisUtils.closeSqlSession(session);
    }

    @Test
    public void deleteByBatchTest(){
        SqlSession session = MybatisUtils.getSqlSession(true);
        int[] array = new int[]{10,11,12,13,14,15};
        int rows = session.delete("deleteByBatch",array);
        if (rows>0){
            System.out.println("成功删除"+rows+"条数据！");
        }else {
            System.out.println("删除失败！");
        }
        MybatisUtils.closeSqlSession(session);
    }
}

