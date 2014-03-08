/**
 * 
 */
package org.hb.kotk.core.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author neil
 * 
 */
public final class PropertyReader
{
	private PropertyReader()
	{
	}

	public static Properties getProperty(String propertyPath) throws FileNotFoundException, IOException
	{
		Properties props = new Properties();
		InputStream in = new BufferedInputStream(new FileInputStream(propertyPath));
		props.load(in);
		return props;
	}
}
