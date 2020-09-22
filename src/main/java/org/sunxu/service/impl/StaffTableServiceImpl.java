package org.sunxu.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.sunxu.aop.Sunxu;
import org.sunxu.dao.StaffTableDao;
import org.sunxu.dao.impl.StaffTableDaoImpl;

import org.sunxu.model.StaffTable;
import org.sunxu.service.StaffTableService;

import java.util.List;

@Service("staffTableService")
//从数据库到前端
public class StaffTableServiceImpl implements StaffTableService {

    //一页几条数据(注解一定要写在这个属性头上才会注入到这个属性中，并且用注释的情况下注入则不需要用get和set方法)
    @Value("${pageSize}")
    private int pageSize;

    @Override
    @Sunxu
    public List<StaffTable> list(int index, String account) {
        //分页数据计算
        int offset=(index-1)*pageSize;
        int limit=pageSize;

        //调用dao
        StaffTableDaoImpl std = new StaffTableDaoImpl();
        List<StaffTable> list = std.list(offset, limit,account);
//        System.out.println(list);
        return list;
    }

    @Override
    public Integer listCount(String account) {
        //调用Dao
        StaffTableDao std = new StaffTableDaoImpl();
        Integer count = std.listCount(account);
//        System.out.println(count);

        // 计算最大页数
        int max = (count % pageSize== 0) ? (count / pageSize) : (count / pageSize + 1);
        return max;
    }
}
