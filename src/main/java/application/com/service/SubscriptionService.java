package application.com.service;

import application.com.dao.ISubscriptionDao;
import application.com.model.SubscriptionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SubscriptionService implements ISubscriptionService {

    @Autowired
    ISubscriptionDao subscriptionDao;

    public void add(SubscriptionModel subscriptionModel) {
        subscriptionDao.add(subscriptionModel);
    }

    public void update(SubscriptionModel subscriptionModel) {
        subscriptionDao.update(subscriptionModel);
    }

    public SubscriptionModel findByPlanId(String planId, SubscriptionModel subscriptionModel) {
        return subscriptionDao.findByPlanId(planId, subscriptionModel);
    }

    public void delete(String planId) {
        subscriptionDao.delete(planId);
    }

    public List<SubscriptionModel> listSubscriptions() {
        return subscriptionDao.fetchSubscriptions();
    }

}
