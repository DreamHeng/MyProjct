package com.kaishengit.hibernate;


import com.kaishengit.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;

/**
 * Created by maoyirun on 2017/8/1.
 */
public class BaseTestCase {

    protected Session session;

    @Before
    public void before(){
        session = HibernateUtil.getSession();
        session.getTransaction().begin();
    }

    @After
    public void after(){
        session.getTransaction().commit();
    }


}
