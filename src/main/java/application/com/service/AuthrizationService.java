package application.com.service;

import application.com.dao.IAuthrizationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;

@Service
@Transactional
public class AuthrizationService implements IAuthrizationService {

    @Autowired
    IAuthrizationDao authrizationDao;

    public boolean hasPermission(ConcurrentHashMap<String, String> c) {
        List<String> actionIdList = authrizationDao.fechActionIdList(c.get("userId"));
        return actionIdList.contains(c.get("actionId"));
    }

    public boolean containsAuthToken(Predicate<String> p, String authToken){
        return p.test(authToken);
    }

    @Override
    public boolean hasPermission(Predicate<ConcurrentHashMap> p, String userId, int actionId) {
        ConcurrentHashMap<String, String> c = new ConcurrentHashMap<>();
        c.put("userId", userId);
        c.put("actionId", Integer.toString(actionId));
        return p.test(c);
    }
}
