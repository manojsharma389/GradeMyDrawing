package application.com.dao;

import application.com.model.SubscriptionModel;

import java.util.List;

public interface ISubscriptionDao {
    public void add(SubscriptionModel subscriptionModel);
    public void update(SubscriptionModel subscriptionModel);
    public SubscriptionModel findByPlanId(String planId, SubscriptionModel subscriptionModel);
    public void delete(String planId);
    public List<SubscriptionModel> fetchSubscriptions();
}
