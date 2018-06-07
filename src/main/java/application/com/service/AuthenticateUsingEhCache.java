package application.com.service;


import application.com.model.AuthenticationModel;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.UUID;

public class AuthenticateUsingEhCache {

    private static CacheManager manager;
    private static Cache authenticationTokenCache;

    static {
        try {
            manager = CacheManager.create(new FileInputStream(ResourceUtils.getFile("classpath:/ehcache.xml")));
            authenticationTokenCache = manager.getCache("authTokenCache");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void storeAuthToken(String authenticationToken, AuthenticationModel authenticationModel) {
        authenticationTokenCache.put(new Element(authenticationToken, authenticationModel));
    }

    public static boolean containsAuthToken(String authenticationToken) {
        return authenticationTokenCache.isElementInMemory(authenticationToken);
    }

    public static boolean removeAuthenticationToken(String authenticationToken) {
        return authenticationTokenCache.remove(authenticationToken);
    }

    public static String generateAuthenticationToken(AuthenticationModel authenticationModel) {
//        String authenticationToken = Integer.valueOf(new Random().nextInt(Integer.MAX_VALUE)).
//                toString() + authenticationModel.getUserId();
        final String authenticationToken = UUID.randomUUID().toString();
        storeAuthToken(authenticationToken, authenticationModel);
        return authenticationToken;
    }

    //Get the UserId saved against each authentication token
    public static String getUserId(String authenticationToken) {
        Element cachedResult = authenticationTokenCache.get(authenticationToken);
        return ((AuthenticationModel) cachedResult.getObjectValue()).getUserId();
    }

}
