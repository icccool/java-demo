package com.code.jdbc;

import java.sql.*;

/**
 * @Author WANG JI BO
 * @Date 2019/1/9 下午5:41
 * @Description  oracle版本 11g
 **/
public class OracleJdbcDemo {

    public void oracleJdbcDemo(){
        String driver = "oracle.jdbc.driver.OracleDriver";    //驱动标识符
        String url = "jdbc:oracle:thin:@192.168.10.181:1521:hydee"; //链接字符串
        // url ="jdbc:oracle:thin:@10.0.30.64:1521:orcl";  // 连接远程的数据库可以这么写
        String user = "H2";         //数据库的用户名
        String password = "hydeesoft";     //数据库的密码
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            String sql = "select count(1) from t_ware";
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }
    }
}
