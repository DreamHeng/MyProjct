package com.kaishengit.hibernate;

import com.kaishengit.pojo.Account;
import com.kaishengit.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.*;
import org.junit.Test;

import java.util.List;

/**
 * Created by maoyirun on 2017/8/1.
 */
public class HQL {

    private Session session;

    @Before
    public void before(){
        session = HibernateUtil.getSession();
        session.getTransaction().begin();
    }

    @After
    public void after(){
        session.getTransaction().commit();
    }

    @org.junit.Test
    public void findAll(){
        String hql = "from Account";
        Query query = session.createQuery(hql);
        List<Account> accountList = query.list();

        query.setFirstResult(0);
        query.setMaxResults(3);

        for (Account account : accountList) {
            System.out.println(account.getId() + "->" + account.getUsername() + "->" + account.getAddress() + "->" +account.getAge());
        }
    }

    @Test
    public void findById() {
        String hql = "from Account as ac where ac.username = :name";
        Query query = session.createQuery(hql);
        query.setParameter("name","tom");

        Account account =(Account) query.uniqueResult();
        System.out.print(account);
    }

    @Test
    public void findByName(){
        String hql = "from Account where username = ? and address = ?";
        Query query = session.createQuery(hql);
        query.setParameter(0,"李梦");
        query.setParameter(1,"郑州");

        Account account =(Account) query.uniqueResult();
        System.out.println(account);
    }

    //查询年龄为23的信息条数
    @Test
    public void count(){
        String hql = "select count(*) from Account where age = :age";
        Query query = session.createQuery(hql);
        query.setParameter("age",22);

        Long count = (Long) query.uniqueResult();
        System.out.println("count:" + count);

//        List<Object[]> count = query.list();
//        System.out.println(count.get(0));
    }


}
