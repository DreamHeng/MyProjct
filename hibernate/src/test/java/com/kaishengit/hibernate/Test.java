package com.kaishengit.hibernate;

import com.kaishengit.pojo.Account;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

/**
 * Created by maoyirun on 2017/7/31.
 */
public class Test {

    //增加
    @org.junit.Test
    public void first(){
        //读取配置文件(从classpath中读取名称为hibernate.cfg.xml)
        Configuration configuration = new Configuration().configure();
        //创建SessionFactory
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        //创建Session
        Session session = sessionFactory.getCurrentSession();
        //开启事务
        Transaction transaction = session.getTransaction();
        transaction.begin();

        //执行语句
        Account account = new Account();
        account.setUsername("王美丽");
        account.setAddress("上海");
        account.setAge(18);

        session.save(account);
        //关闭事务（提交|回滚）
        transaction.commit();
    }

    //删除
    @org.junit.Test
    public void delete(){
        //读取配置文件（从classpath中读取名为hibernate.cfg.xml）
        Configuration configuration = new Configuration().configure();
        //创建SessionFacrory
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        //创建session
        Session session = sessionFactory.getCurrentSession();
        //开启事务
        Transaction transaction = session.getTransaction();
        transaction.begin();
        //执行语句
        Account account = (Account)session.get(Account.class,2);
        session.delete(account);
        //关闭事物（提交|回滚）
        transaction.commit();
    }

    //根据Id查找
    @org.junit.Test
    public void findById(){
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();

        Account account = (Account) session.get(Account.class,1);//get立即进行查询
        System.out.print(account);
        //事物回滚
        session.getTransaction().commit();
    }

    //load
    @org.junit.Test
    public void findByID(){
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();//开启事务

        Account account = (Account) session.load(Account.class,1);
        System.out.println(account);
        session.getTransaction().commit();

    }

    //查询所有
    @org.junit.Test
    public void findAll(){
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();

        String hql = "from Account where username = ?";
        Query query = session.createQuery(hql);
        query.setParameter(0,"tom");

        List<Account> accountList = query.list();

        for(Account account : accountList ){
            System.out.print(account.getUsername()+ "->" + account.getAddress());
        }

        session.getTransaction().commit();
    }



}
