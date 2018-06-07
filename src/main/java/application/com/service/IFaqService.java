package application.com.service;

import application.com.model.FaqModel;

import java.util.List;

public interface IFaqService {
    public void add(FaqModel faqModel);
    public void update(FaqModel faqModel);
    public void delete(int faqId);
    public FaqModel findFAQ(int id, FaqModel faqModel);
    public List<FaqModel> listFAQs();
}
