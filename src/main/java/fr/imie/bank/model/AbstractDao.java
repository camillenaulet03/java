package fr.imie.bank.model;

import java.util.Properties;

public abstract class AbstractDao {
	private static Properties properties;
	
	static {
		try {
			properties = new Properties();
			properties.load(AbstractDao.class.getResourceAsStream("settings.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String key){
		String parametre = properties.getProperty(key,null);
		return parametre;
	}

}