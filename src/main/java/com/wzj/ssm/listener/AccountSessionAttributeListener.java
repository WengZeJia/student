package com.wzj.ssm.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class AccountSessionAttributeListener implements HttpSessionAttributeListener {

	public void attributeAdded(HttpSessionBindingEvent event) {
		if (event.getName().equals("SPRING_SECURITY_CONTEXT")) {

		}
	}

	public void attributeRemoved(HttpSessionBindingEvent event) {
		if (event.getName().equals("SPRING_SECURITY_CONTEXT")) {

		}
	}

	public void attributeReplaced(HttpSessionBindingEvent event) {
		if (event.getName().equals("SPRING_SECURITY_CONTEXT")) {

		}
	}

}
