/**
 * 
 */
package org.hb.kotk.core.util;

/**
 * @author neil
 * 
 */
public class AppContext
{
	private AppConfig appConfig;

	private AppContext()
	{
	}

	private static class SingletonHolder
	{
		private static AppContext instance = new AppContext();
	}

	public static AppContext getAppContext()
	{
		return SingletonHolder.instance;
	}

	/**
	 * @return the appConfig
	 */
	public AppConfig getAppConfig()
	{
		return appConfig;
	}

	/**
	 * @param appConfig
	 *            the appConfig to set
	 */
	public void setAppConfig(AppConfig appConfig)
	{
		this.appConfig = appConfig;
	}

}
