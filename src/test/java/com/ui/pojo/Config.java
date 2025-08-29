package com.ui.pojo;

import java.util.Map;

public class Config {
	Map<String, Environement> environments;

	public Map<String, Environement> getEnvironments() {
		return environments;
	}

	public void setEnvironments(Map<String, Environement> environments) {
		this.environments = environments;
	}
}