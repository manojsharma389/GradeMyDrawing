package application.com.service;

import application.com.dao.IPricingDao;
import application.com.model.PricingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PricingService implements IPricingService {

    @Autowired
    IPricingDao pricingDao;

    public void add(PricingModel pricingModel){
        pricingDao.add(pricingModel);
    }
    public void update(PricingModel pricingModel){
        pricingDao.update(pricingModel);
    }
    public PricingModel findByPricingKey(String pricingKey, PricingModel pricingModel){
        return pricingDao.findBypricingKey(pricingKey, pricingModel);
    }
    public List<PricingModel> listPricing(){
        return pricingDao.listPricing();
    }
    public void delete(String pricingKey){
        pricingDao.delete(pricingKey);
    }

}
