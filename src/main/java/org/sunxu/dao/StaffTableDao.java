package org.sunxu.dao;

import org.sunxu.model.StaffTable;

import java.util.List;

public interface StaffTableDao {
    //这条路是一条从数据库去前端的路
    List<StaffTable> list(int offset, int limit, String account);
    Integer listCount(String account);
}
