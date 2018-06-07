package application.com.genericHibernateClient;


import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

import java.io.Serializable;
import java.util.List;

public interface IGenericHibernateClient<T, PK extends Serializable> {

    void create(T t);

    T find(PK id);

    void update(T t);

    void delete(T t);

    List<T> findAll();

    List<T> findByCriteria(Criterion... criterion);

    T findSingleByCriteria(Criterion... criterion);

    List<T> findByCriteria();

    T findById(int id);

    boolean isDataExist(Criterion... criterion);

    void saveOrUpdate(T t);

    List<T> findByCriteria(Order order, Criterion[] criterion);

    List<T> findByCriteria(Order order, int firstResult, int maxResults, Criterion[] criterion);

    T load(int id);

    List<T> findByCriteria(Order order);
    public void deleteById(int id);

    public void flush();

    void commit();

}
