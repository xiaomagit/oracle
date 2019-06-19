package com.itheima.oracle;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OracleDemo {

    @Test
    public void test() throws Exception {
        /*
        * 测试oracle数据库的连接
        * */
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.184.10:1521:orcl", "scott", "tiger");
        PreparedStatement ps = connection.prepareStatement("select * from emp where empno =?");
        ps.setObject(1,7788);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            System.out.println(rs.getString("ename"));
        }

        /*
         关闭资源
         */
        rs.close();
        ps.close();
        connection.close();
    }

}
