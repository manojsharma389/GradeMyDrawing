package application.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import application.com.model.FaqModel;
import application.com.model.PricingModel;
import application.com.model.SubscriptionModel;
import application.com.service.IDashboardService;
import application.com.service.IFaqService;
import application.com.service.IPricingService;
import application.com.service.ISubscriptionService;

import java.util.List;

@RestController
@RequestMapping(value = "/dashboard")
public class DashboardController extends BaseController {

    @Autowired
    IDashboardService dashboardService;

    @Autowired
    IFaqService faqService;

    @Autowired
    IPricingService pricingService;

    @Autowired
    ISubscriptionService subscriptionService;

    @RequestMapping(value = "/faqs/get", method = RequestMethod.GET)
    public List<FaqModel> getFaq(){
        return faqService.listFAQs();
    }

    @RequestMapping(value = "/subscription/get", method = RequestMethod.GET)
    public List<SubscriptionModel> getSubscription(){
        return subscriptionService.listSubscriptions();
    }

    @RequestMapping(value = "/pricing/get", method = RequestMethod.GET)
    public List<PricingModel> getPricing(){
        return pricingService.listPricing();
    }


}
