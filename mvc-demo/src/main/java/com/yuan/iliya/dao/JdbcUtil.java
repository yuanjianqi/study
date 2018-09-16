package com.yuan.iliya.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import lombok.SneakyThrows;
import lombok.extern.java.Log;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * All Rights Reserved, Designed By Iliya Kaslana
 * Copyright ©2018
 *
 * @author Iliya Kaslana
 * @version 1.0
 * @date 2018/9/16 20:40
 * @since 1.8
 */
@Log
public class JdbcUtil {

    private static ComboPooledDataSource dataSource;

    static {
        dataSource = new ComboPooledDataSource();
        try {
            ResourceBundle bundle = ResourceBundle.getBundle("db");
            dataSource.setJdbcUrl(bundle.getString("jdbcUrl"));
//        dataSource.setDriverClass(bundle.getString("driverClass"));
            dataSource.setDriverClass(bundle.getString("driverClass"));
            dataSource.setUser(bundle.getString("user"));
            dataSource.setPassword(bundle.getString("password"));
        } catch (PropertyVetoException e) {
            log.warning("无法找到配置文件");
        }
    }

    /**
     * 获取数据库连接
     * @return
     */
    @SneakyThrows
    public static Connection getConnection(){
        return dataSource.getConnection();
    }

    /**
     * 关闭数据库连接
     * @param connection
     */
    @SneakyThrows
    public static void close(Connection connection){
        if (connection != null){
            connection.close();
        }
    }

    @SneakyThrows
    public static void close(Connection connection, Statement statement){
        close(connection);
        if (statement != null){
            statement.close();
        }
    }

    @SneakyThrows
    public static void close(Connection connection, Statement statement, ResultSet resultSet){
        close(connection,statement);
        if (resultSet != null){
            resultSet.close();
        }
    }

}
