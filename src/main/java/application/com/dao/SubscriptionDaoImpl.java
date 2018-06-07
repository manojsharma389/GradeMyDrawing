package application.com.dao;

import application.com.genericHibernateClient.GenericHibernateClient;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import application.com.entities.Subscription;
import application.com.model.SubscriptionModel;
import application.com.property.GradeMyDesignProperties;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SubscriptionDaoImpl extends GenericHibernateClient<Subscription, String>
        implements ISubscriptionDao {

    @Transactional
    public void add(SubscriptionModel subscriptionModel){
        Subscription subscription = new Subscription();
        create(modelToSubscription(subscriptionModel, subscription));
    }

    @Transactional
    public void update(SubscriptionModel subscriptionModel){
        Subscription subscription =  findByPlanId(subscriptionModel.getPlanId());
        update(modelToSubscription(subscriptionModel, subscription));
    }

    public Subscription findByPlanId(String planId){
        Criterion criterion =  Restrictions.eq("planId", planId);
        List<Subscription> subscriptions = findByCriteria(criterion);
        return subscriptions!=null ? subscriptions.get(0): null;
    }

    public SubscriptionModel findByPlanId(String planId, SubscriptionModel subscriptionModel){
        Subscription subscription = findByPlanId(planId);
        return subscriptionToModel(subscriptionModel, subscription);

    }

    public void delete(String planId){
        Subscription subscription =  findByPlanId(planId);
        delete(subscription);
    }

    public List<SubscriptionModel> fetchSubscriptions(){
        List<Subscription> subscriptionList =
                (List<Subscription>)getSession().createQuery
                        (GradeMyDesignProperties.LIST_SUBSCRIPTION.toString()).list();

        List<SubscriptionModel> subscriptionModelList = new ArrayList<SubscriptionModel>();
        SubscriptionModel subscriptionModel = null;
        for (Subscription subscription : subscriptionList) {
            subscription = new Subscription();
            subscriptionModelList.add(subscriptionToModel(subscriptionModel, subscription));

        }
        return subscriptionModelList;
    }

    public Subscription modelToSubscription(SubscriptionModel subscriptionModel,
                                            Subscription subscription){
        if(null != subscriptionModel && null!= subscription) {
            subscription = (Subscription) CopyProperties.copyNotNullProperties
                    (subscriptionModel, subscription);
        }
        //BeanUtils.copyProperties(subscriptionModel, subscription);
        return subscription;
    }

    public SubscriptionModel subscriptionToModel(SubscriptionModel subscriptionModel,
                                            Subscription subscription){
        if(null != subscriptionModel && null!= subscription) {
            subscriptionModel = (SubscriptionModel) CopyProperties.
                    copyNotNullProperties(subscription, subscriptionModel);
            //BeanUtils.copyProperties(subscription, subscriptionModel);
        }
        return subscriptionModel;
    }

}
