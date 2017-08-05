package com.kaishengit.hibernate;

import com.kaishengit.pojo.Account;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.junit.*;

/**
 * Created by maoyirun on 2017/8/2.
 */
public class NativeSTest{

    private Session session;

    @Before
    public void before(){
        session = HibernateUtil.getSession();
        session.getTransaction().begin();//开启事务管理器
    }

    @After
    public void after(){
        session.getTransaction().commit();//关闭事务
    }

    @org.junit.Test
    public void nativeSQL(){
        String sql = "select id,username,address,age from account where age = :age ";
        SQLQuery sqlQuery = session.createSQLQuery(sql).addEntity(Account.class);

        //sqlQuery.setParameter("id",2);
        sqlQuery.setParameter("age",18);


        Account account = (Account) sqlQuery.uniqueResult();
        System.out.println(account);


    }



}
