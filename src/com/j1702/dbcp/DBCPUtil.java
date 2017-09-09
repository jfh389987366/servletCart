package com.j1702.dbcp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSourceFactory;

/**
 * DBCP配置类
 * @author SUN
 */
public class DBCPUtil {
    
    private static Properties properties = new Properties();
    private static DataSource dataSource;
    //加载DBCP配置文件
    static{
        try{
            properties.load(DBCPUtil.class.getClassLoader().getResourceAsStream("dbcp.properties"));
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //从连接池中获取一个连接
    public static Connection getConnection(){
        Connection connection = null;
        try{
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }    
}