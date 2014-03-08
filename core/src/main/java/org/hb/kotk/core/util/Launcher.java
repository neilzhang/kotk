/**
 * 
 */
package org.hb.kotk.core.util;

import java.io.File;

import org.apache.log4j.Logger;
import org.dom4j.DocumentException;

/**
 * @author neil
 * 
 */
public final class Launcher
{

	private static Logger logger = Logger.getLogger(Launcher.class);

	private AppContext context = AppContext.getAppContext();

	public static void main(String[] args)
	{
		// 1.check configuration.xml √
		// 2.read configuration.xml √
		// 3.start listener for configuration file √
		// 4.load card
		// 5.load rule
		// 6.load component
		// 7.load client(facade and adapter)
		// 8.create player
		// 9.assign AI or man
		// 10.select role
		// 11.select hero
		// 12.load a player to be activated
		// 13.next
		// 14.good game

		Launcher launcher = new Launcher();
		launcher.configure();
		launcher.startFileListener();

	}

	private void checkFiles()
	{
		File file = new File(AppConstant.CONFIGURATION_XML);
		try
		{
			if (!file.exists())
			{
				String noFile = ErrorMessage.getMessage(AppConstant.LAUNCHER_NO_FILE);
				logger.error(noFile);
				System.exit(1);
			}
		}
		catch (SecurityException se)
		{
			String noAccesssToFile = ErrorMessage.getMessage(AppConstant.LAUNCHER_NO_ACCESSS_TO_FILE);
			logger.error(noAccesssToFile);
			System.exit(1);
		}
	}

	private void configure()
	{
		checkFiles();

		AppConfig appConfig = new AppConfig(AppConstant.CONFIGURATION_XML);
		context.setAppConfig(appConfig);

		try
		{
			appConfig.load();
		}
		catch (DocumentException e)
		{
			String analysisError = ErrorMessage.getMessage(AppConstant.LAUNCHER_ANALYASIS_ERROR);
			logger.error(analysisError);
			System.exit(1);
		}
	}

	private void startFileListener()
	{
		FileListener.getInstance().addListener(AppConstant.CONFIGURATION_XML,
				new DefaultFileMonitor(AppConstant.CONFIGURATION_XML, context.getAppConfig()));

	}

}
