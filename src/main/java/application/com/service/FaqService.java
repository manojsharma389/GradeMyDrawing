package application.com.service;

import application.com.dao.IFaqDao;
import application.com.model.FaqModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FaqService implements IFaqService {

    @Autowired
    IFaqDao faqDao;

    public void add(FaqModel faqModel){
        faqDao.add(faqModel);
    }

    public void update(FaqModel faqModel){
        faqDao.update(faqModel);
    }

    public void delete(int faqId){
        faqDao.delete(faqId);
    }

    public FaqModel findFAQ(int id, FaqModel faqModel){
        return faqDao.findByFaqId(id, faqModel);
    }

    public List<FaqModel> listFAQs(){
        return faqDao.listFAQs();
    }

}
