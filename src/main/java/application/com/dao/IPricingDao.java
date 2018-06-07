package application.com.dao;

import application.com.model.PricingModel;

import java.util.List;

public interface IPricingDao {
    public void add(PricingModel pricingModel);
    public void update(PricingModel pricingModel);
    public void delete(String pricingKey);
    public List<PricingModel> listPricing();
    public PricingModel findBypricingKey(String lookUpKey, PricingModel pricingModel);
}
