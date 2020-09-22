package org.sunxu.dao.impl;

import org.sunxu.dao.StaffTableDao;

import org.sunxu.model.StaffTable;
import org.sunxu.utils.JdbcUtils;
import org.sunxu.utils.StringUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffTableDaoImpl implements StaffTableDao {

    @Override
    public List<StaffTable> list(int offset, int limit, String account) {
        List<StaffTable> al = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = JdbcUtils.getConnection();
            if (StringUtils.isEmpty(account)){
                ps = con.prepareStatement("SELECT * FROM stafftable limit ?,?");
                ps.setInt(1,offset);
                ps.setInt(2,limit);
            }else{
                ps = con.prepareStatement("SELECT * FROM stafftable WHERE account LIKE ? limit ?,?");
                ps.setString(1,"%"+account+"%");
                ps.setInt(2,offset);
                ps.setInt(3,limit);
            }

            rs = ps.executeQuery();
            while(rs.next()){
                //将每一个字段的值封装到这个对象中
                StaffTable st = new StaffTable();
                st.setId(rs.getInt(1));
                st.setRole(rs.getString(2));
                st.setUsername(rs.getString(3));
                st.setAccount(rs.getString(4));
                st.setPasswd(rs.getString(5));
                st.setStatus(rs.getString(6));
                st.setOtherthing(rs.getString(7));
                //把每一行数据都当做一个元素塞到数组里面
                al.add(st);
            }
//            System.out.println(al);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(con,ps,rs);
        }
        return al;
    }
    @Override
    public Integer listCount(String account) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = JdbcUtils.getConnection();
            if (StringUtils.isEmpty(account)) {
                ps = con.prepareStatement("SELECT count(*) FROM stafftable");
            } else {
                ps = con.prepareStatement("SELECT count(*) FROM stafftable WHERE account LIKE ?");
                ps.setString(1, "%" + account + "%");
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                int count = rs.getInt(1);
//                System.out.println(count);
                return count;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(con, ps, rs);
        }
        return 0;
    }
}
