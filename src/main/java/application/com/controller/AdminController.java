package application.com.controller;

import application.com.dao.CopyProperties;
import application.com.model.*;
import application.com.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.nio.file.AccessDeniedException;
import java.util.List;

@RestController
@RequestMapping(value = "/admin")
public class AdminController extends BaseController {

    @Autowired
    IAdminService adminService;

    @Autowired
    IUserRolesService userRolesService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    IFaqService FAQService;

    @Autowired
    ISubscriptionService subscriptionService;

    @Autowired
    IPricingService pricingService;

    @Autowired
    ICadClassService cadClassService;

    @Autowired
    IRoleService roleService;

    @Autowired
    IAuthrizationService authrizationService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<AdminRegistrationModel> registerAdmin(@Validated @RequestBody AdminRegistrationModel adminRegistrationModel,
                                                                @RequestHeader String authToken) throws AccessDeniedException, AuthenticationException{
        if(authrizationService.containsAuthToken(AuthenticateUsingEhCache ::containsAuthToken, authToken)) {
            if (authrizationService.hasPermission( authrizationService ::hasPermission, AuthenticateUsingEhCache.getUserId(authToken), 7)) {
                adminRegistrationModel.setRoleId("1");
                adminService.add(adminRegistrationModel);
                UserRolesModel userRolesModel = new UserRolesModel();
                userRolesService.add(mapAdminModelToUserRolesModel(adminRegistrationModel, userRolesModel));

                return new ResponseEntity<AdminRegistrationModel>(adminRegistrationModel, HttpStatus.OK) ;
            } else
                throw new AccessDeniedException("Access Denied for user");
        } else
            throw new AuthenticationException("User is not authorized");
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<AdminProfileUpdateModel> updateAdmin(@Validated @RequestBody AdminProfileUpdateModel adminProfileUpdateModel,
                                                               @RequestHeader String authToken) throws AccessDeniedException, AuthenticationException{
        if(authrizationService.containsAuthToken(AuthenticateUsingEhCache ::containsAuthToken, authToken)) {
            if (authrizationService.hasPermission( authrizationService ::hasPermission, AuthenticateUsingEhCache.getUserId(authToken), 8)) {
                adminService.update(adminProfileUpdateModel);
                return new ResponseEntity<AdminProfileUpdateModel>(adminProfileUpdateModel, HttpStatus.OK);
            } else
                throw new AccessDeniedException("Access Denied for user");
        } else
            throw new AuthenticationException("User is not authorized");
    }

    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> updateAdmin(@PathVariable String userId,
                                               @RequestHeader String authToken) throws AccessDeniedException, AuthenticationException{
        if(authrizationService.containsAuthToken(AuthenticateUsingEhCache ::containsAuthToken, authToken)) {
            if (authrizationService.hasPermission( authrizationService ::hasPermission, AuthenticateUsingEhCache.getUserId(authToken), 9)) {
                adminService.delete(userId);
                userRolesService.delete(userId);
                return new ResponseEntity<Boolean>(true, HttpStatus.OK);
            } else
                throw new AccessDeniedException("Access Denied for user");
        } else
            throw new AuthenticationException("User is not authorized");
    }

    @RequestMapping(value = "/addFAQ", method = RequestMethod.POST)
    public ResponseEntity<FaqModel> add(@Validated @RequestBody FaqModel faqModel,
                                        @RequestHeader String authToken) throws AccessDeniedException, AuthenticationException{

        if(authrizationService.containsAuthToken(AuthenticateUsingEhCache ::containsAuthToken, authToken)) {
            if (authrizationService.hasPermission( authrizationService ::hasPermission, AuthenticateUsingEhCache.getUserId(authToken), 10)) {
                FAQService.add(faqModel);
                return new ResponseEntity<FaqModel>(faqModel, HttpStatus.OK) ;
            } else
                throw new AccessDeniedException("Access Denied for user");
        } else
            throw new AuthenticationException("User is not authorized");
    }

    @RequestMapping(value = "/updateFAQ", method = RequestMethod.PUT)
    public ResponseEntity<FaqModel> update(@Validated @RequestBody FaqModel faqModel,
                                           @RequestHeader String authToken) throws AccessDeniedException, AuthenticationException{

        if(authrizationService.containsAuthToken(AuthenticateUsingEhCache ::containsAuthToken, authToken)) {
            if (authrizationService.hasPermission( authrizationService ::hasPermission, AuthenticateUsingEhCache.getUserId(authToken), 11)) {
                FAQService.update(faqModel);
                return new ResponseEntity<FaqModel>(faqModel, HttpStatus.OK) ;
            } else
                throw new AccessDeniedException("Access Denied for user");
        } else
            throw new AuthenticationException("User is not authorized");
    }

    @RequestMapping(value = "/deleteFAQ/{faqId}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable int faqId,
                                 @RequestHeader String authToken) throws AccessDeniedException, AuthenticationException{

        if(authrizationService.containsAuthToken(AuthenticateUsingEhCache ::containsAuthToken, authToken)) {
            if (authrizationService.hasPermission( authrizationService ::hasPermission, AuthenticateUsingEhCache.getUserId(authToken), 12)) {
                FAQService.delete(faqId);
                return new ResponseEntity(HttpStatus.OK) ;
            } else
                throw new AccessDeniedException("Access Denied for user");
        } else
            throw new AuthenticationException("User is not authorized");
    }

    @RequestMapping(value = "/subscription/add", method = RequestMethod.POST)
    public ResponseEntity<SubscriptionModel> addSubscription(@Validated @RequestBody SubscriptionModel subscriptionModel,
                                                             @RequestHeader String authToken) throws AccessDeniedException, AuthenticationException{

        if(authrizationService.containsAuthToken(AuthenticateUsingEhCache ::containsAuthToken, authToken)) {
            if (authrizationService.hasPermission( authrizationService ::hasPermission, AuthenticateUsingEhCache.getUserId(authToken), 13)) {
                subscriptionService.add(subscriptionModel);
                return new ResponseEntity<SubscriptionModel>(subscriptionModel, HttpStatus.OK) ;
            } else
                throw new AccessDeniedException("Access Denied for user");
        } else
            throw new AuthenticationException("User is not authorized");
    }

    @RequestMapping(value = "/subscription/update", method = RequestMethod.PUT)
    public ResponseEntity<SubscriptionModel> updateSubscription(@Validated @RequestBody SubscriptionModel subscriptionModel,
                                                                @RequestHeader String authToken) throws AccessDeniedException, AuthenticationException{
        if(authrizationService.containsAuthToken(AuthenticateUsingEhCache ::containsAuthToken, authToken)) {
            if (authrizationService.hasPermission( authrizationService ::hasPermission, AuthenticateUsingEhCache.getUserId(authToken), 14)) {

                subscriptionService.update(subscriptionModel);
                return new ResponseEntity<SubscriptionModel>(subscriptionModel, HttpStatus.OK) ;
            } else
                throw new AccessDeniedException("Access Denied for user");
        } else
            throw new AuthenticationException("User is not authorized");

    }

    @RequestMapping(value = "/subscription/delete/{planId}", method = RequestMethod.GET)
    public ResponseEntity deleteSubscription(@PathVariable String planId,
                                             @RequestHeader String authToken) throws AccessDeniedException, AuthenticationException{
        if(authrizationService.containsAuthToken(AuthenticateUsingEhCache ::containsAuthToken, authToken)) {
            if (authrizationService.hasPermission( authrizationService ::hasPermission, AuthenticateUsingEhCache.getUserId(authToken), 15)) {
                subscriptionService.delete(planId);
                return new ResponseEntity(HttpStatus.OK);
            } else
                throw new AccessDeniedException("Access Denied for user");
        } else
            throw new AuthenticationException("User is not authorized");
    }

    @RequestMapping(value = "/pricing/add", method = RequestMethod.POST)
    public ResponseEntity<PricingModel> addPricing(@Validated @RequestBody PricingModel pricingModel,
                                                   @RequestHeader String authToken) throws AccessDeniedException, AuthenticationException{
        if(authrizationService.containsAuthToken(AuthenticateUsingEhCache ::containsAuthToken, authToken)) {
            if (authrizationService.hasPermission( authrizationService ::hasPermission, AuthenticateUsingEhCache.getUserId(authToken), 16)) {
                pricingService.add(pricingModel);
                return new ResponseEntity<PricingModel>(pricingModel, HttpStatus.OK);
            } else
                throw new AccessDeniedException("Access Denied for user");
        } else
            throw new AuthenticationException("User is not authorized");
    }

    @RequestMapping(value = "/pricing/update", method = RequestMethod.POST)
    public ResponseEntity<PricingModel> updatePricing(@Validated @RequestBody PricingModel pricingModel,
                                                      @RequestHeader String authToken) throws AccessDeniedException, AuthenticationException{

        if(authrizationService.containsAuthToken(AuthenticateUsingEhCache ::containsAuthToken, authToken)) {
            if (authrizationService.hasPermission( authrizationService ::hasPermission, AuthenticateUsingEhCache.getUserId(authToken), 17)) {
                pricingService.update(pricingModel);
                return new ResponseEntity<PricingModel>(pricingModel, HttpStatus.OK);
            } else
                throw new AccessDeniedException("Access Denied for user");
        } else
            throw new AuthenticationException("User is not authorized");
    }

    @RequestMapping(value = "/pricing/delete/{pricingKey}", method = RequestMethod.GET)
    public ResponseEntity deletePricing(@PathVariable String pricingKey,
                                        @RequestHeader String authToken) throws AccessDeniedException, AuthenticationException{
        if(authrizationService.containsAuthToken(AuthenticateUsingEhCache ::containsAuthToken, authToken)) {
            if (authrizationService.hasPermission( authrizationService ::hasPermission, AuthenticateUsingEhCache.getUserId(authToken), 18)) {
                pricingService.delete(pricingKey);
                return new ResponseEntity(HttpStatus.OK);
            } else
                throw new AccessDeniedException("Access Denied for user");
        } else
            throw new AuthenticationException("User is not authorized");
    }

    @RequestMapping(value = "/change/password/{oldPassword}/{newPassword}/{userId}")
    public ResponseEntity<Boolean> changePassword(@RequestHeader String authToken,
                                                  @PathVariable String oldPassword,
                                                  @PathVariable String newPassword,
                                                  @PathVariable String userId) throws AccessDeniedException, AuthenticationException{
        if(authrizationService.containsAuthToken(AuthenticateUsingEhCache ::containsAuthToken, authToken)) {
            if (authrizationService.hasPermission( authrizationService ::hasPermission, AuthenticateUsingEhCache.getUserId(authToken), 19)) {
                Boolean response = adminService.updatePassword(newPassword, oldPassword, userId);
                return new ResponseEntity<Boolean>(response, HttpStatus.OK);
            } else
                throw new AccessDeniedException("Access Denied for user");
        } else
            throw new AuthenticationException("User is not authorized");
    }

    @RequestMapping(value = "/class/fetchAll", method = RequestMethod.GET)
    public ResponseEntity<List<ClassModel>> fetchAllClasses(@RequestHeader String authToken) throws AccessDeniedException, AuthenticationException{

        if(authrizationService.containsAuthToken(AuthenticateUsingEhCache ::containsAuthToken, authToken)) {
            if (authrizationService.hasPermission( authrizationService ::hasPermission, AuthenticateUsingEhCache.getUserId(authToken), 20)) {
                List<ClassModel> classModelList = cadClassService.fetchAllClasses();
                return new ResponseEntity<List<ClassModel>>(classModelList, HttpStatus.OK);
            } else
                throw new AccessDeniedException("Access Denied for user");
        } else
            throw new AuthenticationException("User is not authorized");
    }

    @RequestMapping(value = "/role/add", method = RequestMethod.POST)
    public ResponseEntity<RoleCreateModel> createRole(@RequestHeader String authToken,
                                                      @Validated @RequestBody RoleCreateModel roleCreateModel) throws AccessDeniedException, AuthenticationException{
        if(authrizationService.containsAuthToken(AuthenticateUsingEhCache ::containsAuthToken, authToken)) {
            if (authrizationService.hasPermission( authrizationService ::hasPermission, AuthenticateUsingEhCache.getUserId(authToken), 21)) {
                roleService.add(roleCreateModel);
                return new ResponseEntity<RoleCreateModel>(roleCreateModel, HttpStatus.OK);
            } else
                throw new AccessDeniedException("Access Denied for user");
        } else
            throw new AuthenticationException("User is not authorized");
    }

    @RequestMapping(value = "/role/update", method = RequestMethod.PUT)
    public ResponseEntity<RoleCreateModel> updateRole(@RequestHeader String authToken,
                                                      @Validated @RequestBody RoleCreateModel roleCreateModel) throws AccessDeniedException, AuthenticationException{
        if(authrizationService.containsAuthToken(AuthenticateUsingEhCache ::containsAuthToken, authToken)) {
            if (authrizationService.hasPermission( authrizationService ::hasPermission, AuthenticateUsingEhCache.getUserId(authToken), 22)) {
                roleService.update(roleCreateModel);
                return new ResponseEntity<RoleCreateModel>(roleCreateModel, HttpStatus.OK);
            } else
                throw new AccessDeniedException("Access Denied for user");
        } else
            throw new AuthenticationException("User is not authorized");
    }

    @RequestMapping(value = "/role/delete/{roleId}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteRole(@RequestHeader String authToken,
                                              @NotNull @PathVariable String roleId) throws AccessDeniedException, AuthenticationException{
        if(authrizationService.containsAuthToken(AuthenticateUsingEhCache ::containsAuthToken, authToken)) {
            if (authrizationService.hasPermission( authrizationService ::hasPermission, AuthenticateUsingEhCache.getUserId(authToken), 23)) {
                roleService.delete(roleId);
                return new ResponseEntity<Boolean>(true, HttpStatus.OK);
            } else
                throw new AccessDeniedException("Access Denied for user");
        } else
            throw new AuthenticationException("User is not authorized");
    }

    public UserRolesModel mapAdminModelToUserRolesModel(AdminRegistrationModel adminRegistrationModel, UserRolesModel userRolesModel){
        CopyProperties.copyNotNullProperties(adminRegistrationModel, userRolesModel);
        //BeanUtils.copyProperties(adminRegistrationModel, userRolesModel);

        return userRolesModel;
    }

}
