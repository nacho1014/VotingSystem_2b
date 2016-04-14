package es.uniovi.asw.presentation;

import java.util.Locale;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("settings")
@Scope("singleton")
public class BeanSettings {

	private Locale locale = new Locale("es");

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}
	
}
