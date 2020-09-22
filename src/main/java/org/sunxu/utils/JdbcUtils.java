package org.sunxu.utils;

import java.sql.*;

public class JdbcUtils {
    /**
     * 获取连接
     * @return 数据库连接
     */
    public static Connection getConnection(){
        //加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //连接数据库
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/guanjiapo?characterEncoding=utf8",
                    "root",
                    ""
            );
            return con;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 关闭连接
     * @param con
     * @param ps
     * @param rs
     */
    public static void close(Connection con, PreparedStatement ps, ResultSet rs){
        //关闭
        try {
            if(rs !=null){
                rs.close();
            }
            if(ps !=null){
                ps.close();
            }
            if(con !=null){
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
