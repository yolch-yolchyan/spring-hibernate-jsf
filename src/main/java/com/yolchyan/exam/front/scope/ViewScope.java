/**
 * 
 */
package com.yolchyan.exam.front.scope;

import java.util.Map;

import javax.faces.context.FacesContext;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

/**
 * <p>
 * This class for jsf view scope implements of {@link Scope}
 * 
 * <p>
 * Classes declared ViewScope the class scope keep in page visit time
 * 
 * @author Artur Yolchyan
 * @version 1.0
 */
public class ViewScope implements Scope {
	
	/*
	 * (non-Javadoc)
	 * @see org.springframework.beans.factory.config.Scope#get(java.lang.String, org.springframework.beans.factory.ObjectFactory)
	 */
	public Object get(String name, ObjectFactory<?> objectFactory) {
		final Map<String, Object> viewMap = FacesContext.getCurrentInstance().getViewRoot().getViewMap();

		if (viewMap.containsKey(name)) {
			Object bean = viewMap.get(name);

			// restore a transient autowired beans after re-serialization bean
			WebApplicationContext webAppContext = ContextLoader.getCurrentWebApplicationContext();
			AutowireCapableBeanFactory autowireFactory = webAppContext.getAutowireCapableBeanFactory();
			
			if (webAppContext.containsBean(name)) {
				
				// Reconfigure resored bean instance.
				bean = autowireFactory.configureBean(bean, name);
			}
			// end restore
			
			return bean;
		} else {
			final Object object = objectFactory.getObject();
			viewMap.put(name, object);
			return object;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see org.springframework.beans.factory.config.Scope#getConversationId()
	 */
	public String getConversationId() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see org.springframework.beans.factory.config.Scope#registerDestructionCallback(java.lang.String, java.lang.Runnable)
	 */
	public void registerDestructionCallback(String arg0, Runnable arg1) {		
	}

	/*
	 * (non-Javadoc)
	 * @see org.springframework.beans.factory.config.Scope#remove(java.lang.String)
	 */
	public Object remove(String name) {
		if (FacesContext.getCurrentInstance().getViewRoot() != null) {
			return FacesContext.getCurrentInstance().getViewRoot().getViewMap().remove(name);
		} else {
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see org.springframework.beans.factory.config.Scope#resolveContextualObject(java.lang.String)
	 */
	public Object resolveContextualObject(String arg0) {
		return null;
	}

}
