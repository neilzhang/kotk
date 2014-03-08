/**
 * 
 */
package org.hb.kotk.core.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

/**
 * @author neil
 * 
 */
public final class ErrorMessage
{
	private static final String PROPERTY_PATH = "src/main/resources/errormessage.properties";
	private static final String VARIABLE_REGEX = "\\{\\d+\\}";
	private static Logger logger = Logger.getLogger(ErrorMessage.class);
	private static Properties properties;

	static
	{
		try
		{
			properties = PropertyReader.getProperty(PROPERTY_PATH);
		}
		catch (FileNotFoundException e)
		{
			logger.error("Can not find the errormessage.properties.");
			System.exit(1);
		}
		catch (IOException e)
		{
			logger.error("Can not load the errormessage.properties.");
			System.exit(1);
		}
	}

	private ErrorMessage()
	{
	}

	public static String getMessage(String key, String... args)
	{
		if (key.trim().isEmpty())
		{
			return "";
		}

		String property = properties.getProperty(key.trim());
		Pattern pattern = Pattern.compile(VARIABLE_REGEX);
		Matcher matcher = pattern.matcher(property);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; matcher.find() && i < args.length; i++)
		{
			matcher.appendReplacement(sb, args[i]);
		}
		matcher.appendTail(sb);

		return sb.toString();
	}

	public static void main(String[] args)
	{
		System.out.println(ErrorMessage.getMessage("test.error", "zhanghuanbin", "zhanghaiqiong"));
	}
}
