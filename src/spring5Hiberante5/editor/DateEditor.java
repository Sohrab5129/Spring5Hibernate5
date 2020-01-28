package spring5Hiberante5.editor;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateEditor extends PropertyEditorSupport {

	@Override
	public String getAsText() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

		String ret = null;

		Object value = this.getValue();

		if (value != null) {
			if (value instanceof Date) {
				ret = sdf.format((Date) value);
			}
		}

		return ret;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date date = null;
		try {
			if (text!=null && text.trim()!="") {
				date = sdf.parse(text);
			}
			
		} catch (ParseException e) {
			date = new Date();
		} finally {
			this.setValue(date);
		}
	}
}
