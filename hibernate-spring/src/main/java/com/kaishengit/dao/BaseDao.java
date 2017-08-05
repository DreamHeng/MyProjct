package com.kaishengit.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by maoyirun on 2017/8/3.
 */
@Repository
public abstract class BaseDao<T,PK extends Serializable> {

    private Class<?> clazz;

    public BaseDao() {
        ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
        Type[] types =parameterizedType.getActualTypeArguments();
        clazz = (Class<?>) types[0];
    }

    @Autowired
    private SessionFactory sessionFactory;

    //获取session
    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    //保存(根据对象)
    public void save(T entity){
        getSession().saveOrUpdate(entity);
    }

    //根据ID查找
    public T findById(PK id) {
        return (T) getSession().get(clazz,id);
    }

    //删除
    public void delete(T entity){
        getSession().delete(entity);
    }

    //根据Id删除
    public void deleteById(PK id){
        getSession().delete(findById(id));
    }

    //查询所有
    public List<T> findAll(){
        Criteria criteria = getSession().createCriteria(clazz);
        return criteria.list();
    }

    //根据Id查找
    public List<T> findByProperty(String propertyName,Object value){
        Criteria criteria = getSession().createCriteria(clazz);
        criteria.add(Restrictions.eq(propertyName,value));
        return criteria.list();
    }
}
