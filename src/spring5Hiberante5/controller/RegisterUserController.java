package spring5Hiberante5.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring5Hiberante5.bean.UserAccountDTO;
import spring5Hiberante5.editor.AgeEditor;
import spring5Hiberante5.editor.DateEditor;
import spring5Hiberante5.editor.SalaryEditor;


@Controller
@RequestMapping("/register_user_account")
public class RegisterUserController {

    /* Autowire validator.*/
    @Autowired
    private LocalValidatorFactoryBean validator;

    /* Autowire custom user account validator.*/
//    @Autowired
//    private Validator customUserAccountValidator;

    // Model attribute key.
    public static final String ATTR_USER_ACCOUNT_DATA = "userAccountData";

    /* @InitBinder annotated method will register custom editor and set Validator to the model attribute by the attribute name. */
    @InitBinder(ATTR_USER_ACCOUNT_DATA)
    public void initBinder(WebDataBinder binder){
      
      /* The default validator do not need to set. It can take effect automatically by default. 
       * If set the default validator here, the web page will show two same error messages.
       * */
        binder.setValidator(validator);

        // The custom validator need to be set or add here to take effect.
      //  binder.setValidator(customUserAccountValidator);

        //binder.addValidators(customUserAccountValidator);

        /* Register form object java.util.Date, Integer and Float type property editor. 
           The first parameter is property data type class, the second parameter is related property editor instance object.
        */
        binder.registerCustomEditor(Date.class, new DateEditor());
        binder.registerCustomEditor(Integer.class, new AgeEditor());
        binder.registerCustomEditor(Float.class, new SalaryEditor());
    }

    /* When request the url in GET method. */
    @RequestMapping(method=RequestMethod.GET, value = "/getForm")
    public String showUserAccountRegistrPage(Model model) {

        UserAccountDTO userAccountDto = new UserAccountDTO();
        model.addAttribute(ATTR_USER_ACCOUNT_DATA, userAccountDto);
        return "register_user_account_form";
    }

    @RequestMapping(method=RequestMethod.POST, value = "/showResult")
    public String registerUserAccount(Model model, @ModelAttribute(ATTR_USER_ACCOUNT_DATA) @Validated UserAccountDTO userAccountDto, BindingResult result) {

        String ret = "register_user_account_success";

        // Do not need validate here, because have add the validator in the @InitBinder method. Otherwise the error messages will be shown twice in jsp page.
        // validator.validate(userAccountDto, result);
        // customUserAccountValidator.validate(userAccountDto, result);
        
        if(result.hasErrors()){
            ret = "register_user_account_form";
        }
        return ret;
    }
}