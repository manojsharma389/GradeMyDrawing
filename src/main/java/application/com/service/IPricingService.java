package application.com.service;

import application.com.model.PricingModel;

import java.util.List;

public interface IPricingService {
    public void add(PricingModel pricingModel);
    public void update(PricingModel pricingModel);
    public PricingModel findByPricingKey(String pricingKey, PricingModel pricingModel);
    public List<PricingModel> listPricing();
    public void delete(String pricingKey);
}
