package com.kaishengit.hibernate;

import com.kaishengit.pojo.Account;
import org.hibernate.Criteria;
import org.hibernate.criterion.*;
import org.hibernate.dialect.SybaseAnywhereDialect;
import org.junit.*;
import org.junit.Test;

import javax.xml.ws.Response;
import java.util.List;

/**
 * Created by maoyirun on 2017/8/1.
 */
public class CriteriaTest extends BaseTestCase{

    @org.junit.Test
    public void findAll(){

        Criteria criteria = session.createCriteria(Account.class);
        List<Account> accountList = criteria.list();//查询结果集为多条记录时用list

        for (Account account : accountList) {
            System.out.println(account);
        }
    }

    @org.junit.Test
    public void findById(){

        Criteria criteria = session.createCriteria(Account.class);
        //criteria.add(Restrictions.eq("username","李梦"));
        //criteria.add(Restrictions.lt("age",25));
        //criteria.add(Restrictions.gt("age",40));
        //criteria.add(Restrictions.le("age",22));
        //criteria.add(Restrictions.like("username","张%"));
        //criteria.add(Restrictions.like("username", "王", MatchMode.ANYWHERE));
        //criteria.add(Restrictions.like("address","郑",MatchMode.START));
        criteria.add(Restrictions.or(Restrictions.eq("username","李梦")
                ,(Restrictions.eq("username","王美丽"))));
        //or方法可以传入多个查询条件，这些条件使用or来连接，还可以使用Disjunction来封装
        Disjunction disjunction = Restrictions.disjunction();
        disjunction.add(Restrictions.eq("username","李梦"));
        disjunction.add(Restrictions.eq("username","张三丰"));

        List<Account> accountList = criteria.list();

        for (Account account : accountList) {
            System.out.println(account);
        }
    }


    //分页
    @Test
    public void page(){
        Criteria criteria = session.createCriteria(Account.class);
        //分页
        criteria.setFirstResult(0);//设置起始行
        criteria.setMaxResults(3);//设置每页数据数量

        //排序
        criteria.addOrder(Order.desc("id"));
        List<Account> accountList = criteria.list();

        for (Account account : accountList) {
            System.out.println(account);
        }
    }
    //聚合函数
    @Test
    public void count(){
        Criteria criteria = session.createCriteria(Account.class);
        //criteria.setProjection(Projections.count("age"));
        //criteria.setProjection(Projections.rowCount());//count(*)
        //criteria.setProjection(Projections.countDistinct("address"));

        //criteria.setProjection(Projections.max("age"));
        criteria.setProjection(Projections.avg("age"));

        Double avg = (Double) criteria.uniqueResult();
        System.out.println(avg);

        /*Long count = (Long) criteria.uniqueResult();
        System.out.println(count);*/
    }

}
