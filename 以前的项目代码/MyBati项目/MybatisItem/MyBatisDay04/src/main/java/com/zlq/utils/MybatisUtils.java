package com.zlq.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/*

//sqlSessionFactory -->SqlSession
public class MybatisUtils {

//            使用mybatis的第一步：获取SqlSessionFactory 对象
    private  static SqlSession sqlSession;
    private static SqlSessionFactory sqlSessionFactory;
    static{
        String resource="mybatis-config.xml";
        InputStream inputStream=null;
        try {
            inputStream= Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
    }
    public static synchronized SqlSession getSqlSession(){
        if (sqlSession==null){
            sqlSession=sqlSessionFactory.openSession();
        }
        return sqlSession;
    }

//    既然有了 SqlSessionFactory，顾名思义，我们可以从中获得 SqlSession 的实例。
//    SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。
//    你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。
*/
//sqlSessionFactory -->SqlSession
public class MybatisUtils {
    public static SqlSessionFactory sqlSessionFactory;
    static {
        try {
//            使用mybatis的第一步：获取SqlSessionFactory 对象
            String resource="mybatis-config.xml";
            InputStream inputStream =  Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //    既然有了 SqlSessionFactory，顾名思义，我们可以从中获得 SqlSession 的实例。
//    SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。
//    你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession(true);
    }

}
