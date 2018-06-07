package application.com.dao;

import application.com.genericHibernateClient.GenericHibernateClient;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import application.com.entities.FrequentlyAskedQuestions;
import application.com.model.FaqModel;
import application.com.property.GradeMyDesignProperties;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FaqDaoImpl extends GenericHibernateClient<FrequentlyAskedQuestions, Integer> implements IFaqDao {

    @Transactional
    public void add(FaqModel faqModel){
        FrequentlyAskedQuestions frequentlyAskedQuestions = new FrequentlyAskedQuestions();
        create(modelToFrequentlyAskedQuestions(frequentlyAskedQuestions, faqModel));
    }

    @Transactional
    public void update(FaqModel faqModel){
        FrequentlyAskedQuestions frequentlyAskedQuestions =
                findByFaqId(faqModel.getFaqId());
        frequentlyAskedQuestions = modelToFrequentlyAskedQuestions
                (frequentlyAskedQuestions, faqModel);
        update(frequentlyAskedQuestions);
    }

    @Transactional
    public void delete(int faqId){
        FrequentlyAskedQuestions frequentlyAskedQuestions =
                findByFaqId(faqId);
        delete(frequentlyAskedQuestions);
    }

    public FrequentlyAskedQuestions findByFaqId(int id){
        Criterion criterion =  Restrictions.eq("faqId", id);
        List<FrequentlyAskedQuestions> frequentlyAskedQuestions = findByCriteria(criterion);
        return frequentlyAskedQuestions!=null ? frequentlyAskedQuestions.get(0): null;
    }

    public FaqModel findByFaqId(int id, FaqModel faqModel){
        FrequentlyAskedQuestions frequentlyAskedQuestions =
                findByFaqId(faqModel.getFaqId());
        return frequentlyAskedQuestionsToModel(frequentlyAskedQuestions, faqModel);

    }

    public List<FaqModel> listFAQs(){

        List<FrequentlyAskedQuestions> frequentlyAskedQuestionsList =
                (List<FrequentlyAskedQuestions>)getSession().
                        createQuery(GradeMyDesignProperties.LIST_FAQ.toString()).list();

        List<FaqModel> faqModelList = new ArrayList<FaqModel>();
        FaqModel faqModel = null;
        for (FrequentlyAskedQuestions frequentlyAskedQuestions : frequentlyAskedQuestionsList) {
            faqModel = new FaqModel();
            faqModelList.add(frequentlyAskedQuestionsToModel(frequentlyAskedQuestions, faqModel));
        }
        return faqModelList;
    }

    public FrequentlyAskedQuestions modelToFrequentlyAskedQuestions
            (FrequentlyAskedQuestions frequentlyAskedQuestions, FaqModel faqModel){
        if(null != faqModel && null != frequentlyAskedQuestions) {
            frequentlyAskedQuestions = (FrequentlyAskedQuestions) CopyProperties.copyNotNullProperties
                    (faqModel, frequentlyAskedQuestions);
            //BeanUtils.copyProperties(faqModel, frequentlyAskedQuestions);
        }
        return frequentlyAskedQuestions;
    }

    public FaqModel frequentlyAskedQuestionsToModel
            (FrequentlyAskedQuestions frequentlyAskedQuestions, FaqModel faqModel){
        if(null != faqModel && null != frequentlyAskedQuestions) {
            faqModel = (FaqModel) CopyProperties.copyNotNullProperties(frequentlyAskedQuestions, faqModel);
            //BeanUtils.copyProperties(frequentlyAskedQuestions, faqModel);
        }
        return faqModel;
    }
}
