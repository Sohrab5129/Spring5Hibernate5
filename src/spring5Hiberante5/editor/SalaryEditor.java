package spring5Hiberante5.editor;

import java.beans.PropertyEditorSupport;

public class SalaryEditor extends PropertyEditorSupport {

	@Override
	public String getAsText() {
		String ret = "0";
		Object currValue = this.getValue();
		if (currValue != null) {
			ret = currValue.toString();
		}
		return ret;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		float salary = 0;
		try {
			salary = Float.parseFloat(text);
		} catch (NumberFormatException e) {
			salary = 0;
		} finally {
			this.setValue(salary);
		}
	}
}