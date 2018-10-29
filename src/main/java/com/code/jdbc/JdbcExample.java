package com.code.jdbc;

import java.sql.*;

public class JdbcExample {

    private static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://47.96.154.183:3306/employees";
            String user = "root";
            String password = "w5571393#";
            connection = DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            return null;
        }
        return connection;
    }


    public Object getUser(int id) {
        Connection connection = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement("select isAsia is_asia ID from t_user where id=?");
            ps.setInt(1, 10001);
            ps.execute();


            ResultSetMetaData metaData = ps.getMetaData();
            int cnt = metaData.getColumnCount();
            for(int i =1;i <= cnt;i++){
                System.out.println(metaData.getColumnName(i) +"-->" + metaData.getColumnClassName(i));
            }
            rs = ps.getResultSet();
            int i = 1;
            if (rs.next()){

                System.out.println(rs.getObject(1).getClass());
                System.out.println(rs.getObject(2).getClass());
                System.out.println(rs.getObject(3).getClass());
                System.out.println(rs.getObject(4).getClass());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close(rs, ps, connection);
        }
        return null;
    }

    private void close(ResultSet rs, Statement stmt, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
        }
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
        }
    }



    public static void main(String[] args) {
        Object user = new JdbcExample().getUser(1);//我们查询用户的id 为 1 用户
    }

}

