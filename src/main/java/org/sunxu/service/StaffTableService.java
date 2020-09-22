package org.sunxu.service;

import org.sunxu.model.StaffTable;

import java.util.List;

//从数据库到前端
public interface StaffTableService {
    List<StaffTable> list(int index, String account);
    Integer listCount(String account);
}
