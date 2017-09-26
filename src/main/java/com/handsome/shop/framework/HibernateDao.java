package com.handsome.shop.framework;

import com.wangrg.db2.Dao;
import com.wangrg.db2.Query;
import com.wangrg.db2.Where;
import com.wangrg.java_util.ReflectUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Entity;
import java.util.List;

/**
 * by wangrongjun on 2017/6/13.
 */
public class HibernateDao<T> implements Dao<T> {

    protected static SessionFactory sessionFactory;
    private Class<T> entityClass;

    public HibernateDao() {
        if (sessionFactory == null) {
            System.out.println("start config");
            Configuration config = new Configuration().configure("hibernate.cfg.xml");
            System.out.println("end config");
            System.out.println("start sessionFactory");
            sessionFactory = config.buildSessionFactory();
            System.out.println("end sessionFactory");
        }
    }

    public static void closeSessionFactory() {
        if (sessionFactory != null) {
            sessionFactory.close();
            sessionFactory = null;
        }
    }

    @SuppressWarnings("unchecked")
    protected Class<T> getEntityClass() {
        if (entityClass == null) {
            entityClass = ReflectUtil.getGenericClass(getClass());
        }
        return entityClass;
    }

    private String getTableName() {
        Entity tableAnno = getEntityClass().getAnnotation(Entity.class);
        if (tableAnno != null) {
            String name = tableAnno.name();
            if (name.length() > 0) {
                return name;
            }
        }
        return getEntityClass().getSimpleName();
    }

    @Override
    public boolean insert(T entity) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Where where) {
//        Session session = sessionFactory.openSession();
//        String hql = "delete from " + getTableName() + " where " + where;
//        session.createQuery(hql, getEntityClass());
//        session.close();
        return true;
    }

    @Override
    public boolean deleteById(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(queryById(id));
        session.getTransaction().commit();
        return true;
    }

    @Override
    public boolean update(T entity) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public T queryById(long id) {
        Session session = sessionFactory.openSession();
        T entity = session.get(getEntityClass(), (int) id);
        session.close();
        return entity;
    }

    @Override
    public List<T> queryAll() {
        Session session = sessionFactory.openSession();
        String hql = "from " + getTableName();
        List<T> entityList = session.createQuery(hql, getEntityClass()).list();
        session.close();
        return entityList;
    }

    @Override
    public List<T> query(Where where) {
        Session session = sessionFactory.openSession();
        String hql = "from " + getTableName() + " where " + where;
        System.out.println(hql);
        List<T> entityList = session.createQuery(hql, getEntityClass()).list();
        session.close();
        return entityList;
    }

    @Override
    public List<T> query(Query query) {
        return null;
    }

    @Override
    public int queryCount(Where where) {
        return 0;
    }

}
