package com.pet.di;
import java.util.*;

public class ModelAndView {
	private HashMap<String,Object> model = new HashMap<>();
	private String view;
	private boolean redirect = false;
	public HashMap<String, Object> getModel() {
		return model;
	}
	public void addObject(String name, Object value) {
		model.put(name, value);
	}
	public Object getObject(String name) {
		return model.get(name);
	}
	public String getView() {
		return view;
	}
	public void setView(String view) {
		this.view = view;
	}
	public void setRedirect() {
		this.redirect=true;
	}
	public boolean isRedirect() {
		return redirect;
	}
}
