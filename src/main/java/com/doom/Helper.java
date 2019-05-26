package com.doom;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.doom.exception.DoomException;

public class Helper {
	
	static Properties properties = null;
	
	public static Properties getProperties() {
		if(properties == null) {
			properties = new Properties();
			try (final InputStream stream = Helper.class.getClassLoader().getResourceAsStream("bootsrap.properties")) {
				properties.load(stream);
			    return properties;
			} catch (IOException e) {
				throw new DoomException(e);
			}
		}
		return properties;
		
	}
}
