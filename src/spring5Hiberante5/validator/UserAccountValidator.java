package spring5Hiberante5.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import spring5Hiberante5.bean.UserAccountDTO;


public class UserAccountValidator implements Validator {

	/*
	 * Verify that the @ModelAttribute object is instance of UserAccountDTO class.
	 * Return true means can validate the class object.
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		boolean ret = clazz.equals(UserAccountDTO.class);
		return ret;
	}

	/* All the custom validation process are performed in this method. */
	@Override
	public void validate(Object target, Errors errors) {

		UserAccountDTO userAccount = (UserAccountDTO) target;

		// Validate userName property.
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "Size.userAccountData.userName");

		// Validate password property.
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Size.userAccountData.password");

		
		// Validate age property.
		if (userAccount.getAge() > 85) {
			errors.rejectValue("age", "age_too_old");
		}
		
		if (userAccount.getSalary() < 1000.0) {
			errors.rejectValue("salary", "Min.userAccountData.salary");
		}
	}
}