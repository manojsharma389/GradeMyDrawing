package application.com.dao;

import application.com.genericHibernateClient.GenericHibernateClient;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import application.com.entities.Pricing;
import application.com.model.PricingModel;
import application.com.property.GradeMyDesignProperties;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PricingDaoImpl extends GenericHibernateClient<Pricing, String>
        implements IPricingDao {

    @Transactional
    public void add(PricingModel pricingModel){
        Pricing pricing = new Pricing();
        create(modelToPricing(pricingModel, pricing));
    }

    @Transactional
    public void update(PricingModel pricingModel){
        Pricing pricing = findBypricingKey(pricingModel.getPricingKey());
        update(modelToPricing(pricingModel, pricing));
    }

    @Transactional
    public void delete(String pricingKey){
        Pricing pricing = findBypricingKey(pricingKey);
        delete(pricing);
    }

    public List<PricingModel> listPricing(){
        List<Pricing> pricingList = (List<Pricing>)getSession().
                createQuery(GradeMyDesignProperties.LIST_PRICING.toString()).list();

        List<PricingModel> pricingModelList = new ArrayList<PricingModel>();
        PricingModel pricingModel = null;
        for (Pricing pricing : pricingList) {
            pricingModel = new PricingModel();
            pricingModelList.add(pricingToModel(pricingModel, pricing));
        }
        return pricingModelList;
    }

    public Pricing findBypricingKey(String pricingKey){

        Criterion criterion =  Restrictions.eq("pricingKey", pricingKey);
        List<Pricing> pricings = findByCriteria(criterion);
        return pricings!=null ? pricings.get(0): null;
    }

    public PricingModel findBypricingKey(String pricingKey, PricingModel pricingModel){
        Pricing pricing = findBypricingKey(pricingKey);
        return pricingToModel(pricingModel, pricing);

    }

    public Pricing modelToPricing(PricingModel pricingModel, Pricing pricing){
        if(null != pricingModel && null!= pricing) {
            pricing = (Pricing) CopyProperties.copyNotNullProperties(pricingModel, pricing);
            //BeanUtils.copyProperties(pricingModel, pricing);
        }
        return pricing;
    }

    public PricingModel pricingToModel(PricingModel pricingModel, Pricing pricing){
        if(null != pricingModel && null!= pricing) {
            pricingModel = (PricingModel) CopyProperties.copyNotNullProperties(pricing, pricingModel);
            //BeanUtils.copyProperties(pricing, pricingModel);
        }
        return pricingModel;
    }

}
