/**
 * 
 */
package org.hb.kotk.core.util;

import org.apache.log4j.Logger;
import org.dom4j.DocumentException;

/**
 * @author neil
 * 
 */
public class DefaultFileMonitor extends FileMonitor
{
	private static Logger logger = Logger.getLogger(DefaultFileMonitor.class);
	private FileCache fileCache;

	public DefaultFileMonitor(String filePath, FileCache fileCache)
	{
		super(filePath);
		this.fileCache = fileCache;
	}

	/*
	 * (non-Javadoc)
	 * @see org.hb.kotk.core.util.FileMonitor#on()
	 */
	@Override
	public void on()
	{
		if (super.isActive())
		{
			try
			{
				this.fileCache.load();
			}
			catch (DocumentException e)
			{
				String analysisError = ErrorMessage.getMessage(AppConstant.LAUNCHER_ANALYASIS_ERROR);
				logger.error(analysisError);
				System.exit(1);
			}
		}
	}
}
