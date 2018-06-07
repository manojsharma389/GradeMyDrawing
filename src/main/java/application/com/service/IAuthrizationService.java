package application.com.service;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;

public interface IAuthrizationService {
    public boolean hasPermission(Predicate<ConcurrentHashMap> p, String userId, int actionId);
    public boolean containsAuthToken(Predicate<String> p, String authToken);
    public boolean hasPermission(ConcurrentHashMap<String, String> c);
}
