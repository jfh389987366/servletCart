package com.j1702.dbcp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSourceFactory;

/**
 * DBCP������
 * @author SUN
 */
public class DBCPUtil {
    
    private static Properties properties = new Properties();
    private static DataSource dataSource;
    //����DBCP�����ļ�
    static{
        try{
            properties.load(DBCPUtil.class.getClassLoader().getResourceAsStream("dbcp.properties"));
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //�����ӳ��л�ȡһ������
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