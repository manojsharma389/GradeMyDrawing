package application.com.dao;

import application.com.model.FaqModel;

import java.util.List;

public interface IFaqDao {
    public void add(FaqModel faqModel);
    public void update(FaqModel faqModel);
    public void delete(int faqId);
    public FaqModel findByFaqId(int id, FaqModel faqModel);
    public List<FaqModel> listFAQs();
}
