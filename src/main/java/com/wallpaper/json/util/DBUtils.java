package com.wallpaper.json.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class DBUtils {
    private final static String mybatisConfigPath = "mybatisConfig.xml";
    private  static  SqlSession SQL_SESSION;
    public static SqlSession getSqlSession(){
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(mybatisConfigPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SQL_SESSION = sqlSessionFactory.openSession();
        return  SQL_SESSION;
    }

    public static void closeSqlSession(){
        SQL_SESSION.commit();
        SQL_SESSION.close();
    }
}
