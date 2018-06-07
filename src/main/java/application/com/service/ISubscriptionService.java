package application.com.service;

import application.com.model.SubscriptionModel;

import java.util.List;

public interface ISubscriptionService {
    public void add(SubscriptionModel subscriptionModel);
    public void update(SubscriptionModel subscriptionModel);
    public SubscriptionModel findByPlanId(String planId, SubscriptionModel subscriptionModel);
    public void delete(String planId);
    public List<SubscriptionModel> listSubscriptions();
}
