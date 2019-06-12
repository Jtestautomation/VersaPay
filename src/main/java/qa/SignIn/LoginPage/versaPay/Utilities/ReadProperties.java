package qa.SignIn.LoginPage.versaPay.Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadProperties {
	Properties properties;

	public ReadProperties(String filePath)
	{
		try
		{
			properties = new Properties();
			FileInputStream fileStream = new FileInputStream(filePath);
			properties.load(fileStream);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public String getPropertyValue(String key)
	{
		String property = properties.getProperty(key);
		return property;
	}
}
