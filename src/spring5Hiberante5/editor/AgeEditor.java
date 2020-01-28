package spring5Hiberante5.editor;

import java.beans.PropertyEditorSupport;

public class AgeEditor extends PropertyEditorSupport {

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
		int age = 0;
		try {
			age = Integer.parseInt(text);
		} catch (NumberFormatException e) {
			age = 0;
		} finally {
			this.setValue(age);
		}
	}
}