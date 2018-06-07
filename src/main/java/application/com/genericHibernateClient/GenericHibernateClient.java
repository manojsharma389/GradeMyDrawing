package application.com.genericHibernateClient;


import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class GenericHibernateClient <T, PK extends Serializable> implements IGenericHibernateClient<T, PK> {


    private Class<T> type;

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public GenericHibernateClient() {
        super();
    }

    public GenericHibernateClient(Class clazz) {
        super();
        this.type = clazz;
    }

    public void setType(Class<T> type) {
        this.type = type;
    }

    public void create(T t) {
        getSession().save(t);
    }

    public T find(PK id) {
        return (T) this.getSession().get(this.type, id);
    }

    public void update(T t) {
        getSession().update(t);
    }

    public void merge(T t) {
        getSession().merge(t);
    }

    public void delete(T t) {
        getSession().delete(t);
        getSession().flush();
    }

    final Class<T> getPersistentClass() {
        return cast(((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }

    public static <T> T cast(Object object) {
        return (T) object;
    }

    public List<T> findByCriteria(Criterion... criterion) {
        return findByCriteria(getPersistentClass(), null, 0, 0, criterion, null);
    }

    public List<T> findByCriteria() {
        return findByCriteria(getPersistentClass(), null, 0, 0, null, null);
    }

    public T findSingleByCriteria(Criterion... criterion) {
        List<T> resultList = findByCriteria(getPersistentClass(), null, 0, 1, criterion, null);
        if (resultList != null && resultList.size() > 0) {
            return resultList.get(0);
        } else {
            return null;
        }
    }

    public List<T> findByCriteria(Order order, Criterion... criterion) {
        return findByCriteria(getPersistentClass(), order, 0, 0, criterion, null);
    }

    public List<T> findByCriteria(Order order) {
        return findByCriteria(getPersistentClass(), order, 0, 0, null, null);
    }

    public List<T> findByCriteria(Order order, int firstResult, int maxResults, Criterion... criterion) {
        return findByCriteria(getPersistentClass(), order, firstResult, maxResults, criterion, null);
    }



    private List<T> findByCriteria(Class actualClass, Order order, int firstResult, int maxResults, Criterion[] criterion, String...eagerFechColumn) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        if (order != null) {
            criteria.addOrder(order);
        }

        if(criterion != null){
            for (Criterion c : criterion) {
                criteria.add(c);
            }
        }
        if(eagerFechColumn != null){
            for (String string : eagerFechColumn) {
                criteria.setFetchMode(string, FetchMode.JOIN);
            }
        }
        if (firstResult > 0) {
            criteria.setFirstResult(firstResult);
        }
        if (maxResults > 0) {
            criteria.setMaxResults(maxResults);
        }
        return cast(criteria.list());
    }

    public T findById(int id) {
        Criterion criteria = Restrictions.idEq(id);
        List<T> result = findByCriteria(criteria);
        if (result.size() == 1) {
            return result.iterator().next();
        }
        if (result.size() == 0) {
            return null;
        }
        throw new RuntimeException("Found more than one object with the given ID, verify integrity of you data");
    }

    public List<T> findAll() {
        return findByCriteria(getPersistentClass(), null, 0, 0, null, null);
    }

    public void saveOrUpdate(T t) {
        getSession().saveOrUpdate(t);
    }

    public boolean isDataExist(Criterion... criterion) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());
        if(criterion != null){
            for (Criterion c : criterion) {
                criteria.add(c);
            }
        }
        criteria.setProjection(Projections.rowCount());
        long rowCount = ((Number)criteria.uniqueResult()).longValue();
        return (rowCount > 0) ? true : false;
    }

    public T load(int id) {
        // TODO Auto-generated method stub
        return (T) getSession().load(getPersistentClass(), id);
    }

    public void deleteById(int id) {
        T entity = findById(id);
        if(entity != null) {
            delete(entity);
        }
    }

    public void flush() {
        // TODO Auto-generated method stub
        getSession().flush();
    }

    public void commit() {
        // TODO Auto-generated method stub
        getSession().getTransaction().commit();
    }
}
