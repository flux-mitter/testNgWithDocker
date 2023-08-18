package com.config;

import java.io.FileInputStream;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.constants.Contstants;
import com.enums.ConfigEnum;
import com.exceptions.PropertyFileException;


/**
 * Reading the property file and store it in a HashMap for faster processing
 * 
 * June 15, 2023
 * 
 * @author Preetam
 */
public final class PropertiesUtils {
	
	/**
	 * Private constructor to avoid external initialization
	 */
	private PropertiesUtils() {
	}
	
	private static Properties prop = new Properties();
	private static final Map<String, String> CONFIGMAP = new HashMap<>();
	// static block
	static {
		try (FileInputStream fis = new FileInputStream(Contstants.getCONFIGPROPPATH());) {

			prop.load(fis);

			for (Map.Entry<Object, Object> entry : prop.entrySet()) {
				CONFIGMAP.put(String.valueOf(entry.getKey()).trim(), String.valueOf(entry.getValue()).trim());
			}

		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}

	}
	@SuppressWarnings("null")
	public static String get(ConfigEnum enumkey) {
		
		if (Objects.isNull(enumkey) && Objects.isNull(CONFIGMAP.get(enumkey.name().toLowerCase()))) {
			throw new PropertyFileException(
					"Property with Key => " + enumkey + " is not found!!! Please check config.properties...");
		}

		return CONFIGMAP.get(enumkey.name().toLowerCase());

	}
}
