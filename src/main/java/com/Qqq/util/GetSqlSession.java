package com.Qqq.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by Administrator on 2019/1/30.
 */
public class GetSqlSession {
    @Autowired
    @Qualifier(value="SqlSessionFactory")
    private static  SqlSessionFactory sqlSessionFactory;

    public static SqlSession sqlSession(){



    return sqlSessionFactory.openSession();
    }
}
