package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Paths;

import com.constants.Env;
import com.google.gson.Gson;
import com.ui.pojo.Config;
import com.ui.pojo.Environement;

public class JSONUtility {

	public static Environement readJSON(Env env) {
		Gson gson = new Gson();
		// File jsonFile = new File(System.getProperty("user.dir") + "\\Config\\config.json"); 
		String filePath = Paths.get(System.getProperty("user.dir"), "Config", "config.json").toString();
		File jsonFile = new File(filePath);
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(jsonFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Config config = gson.fromJson(fileReader, Config.class);
		Environement envronement = config.getEnvironments().get("QA");
		System.out.println(envronement.getUrl());
		return envronement;
	}
}