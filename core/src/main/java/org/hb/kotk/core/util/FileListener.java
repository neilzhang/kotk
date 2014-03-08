/**
 * 
 */
package org.hb.kotk.core.util;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author neil
 * 
 */
public final class FileListener implements Runnable
{
	private Map<String, FileMonitor> listeners = new HashMap<String, FileMonitor>();

	private FileListener()
	{
	}

	private static class SingletonHolder
	{
		private static FileListener instance = new FileListener();
	}

	public static FileListener getInstance()
	{
		return SingletonHolder.instance;
	}

	private boolean fileAmended(String filePath, FileMonitor monitor)
	{
		File file = new File(filePath);
		if (file.isFile())
		{
			if (monitor.getLastModifiedTime() == 0)
			{
				monitor.setLastModifiedTime(file.lastModified());
			}
			else if (file.lastModified() != monitor.getLastModifiedTime())
			{
				return true;
			}
		}
		return false;
	}

	public void start()
	{
		Thread thread = new Thread(this);
		thread.start();
	}

	public void addListener(String filePath, FileMonitor fileMonitor)
	{
		listeners.put(filePath, fileMonitor);
		fileMonitor.start();
	}

	public void removeListener(String filePath)
	{
		listeners.get(filePath).stop();
		listeners.remove(filePath);
	}

	public void run()
	{
		while (true)
		{
			for (Entry<String, FileMonitor> entry : listeners.entrySet())
			{
				if (fileAmended(entry.getKey(), entry.getValue()))
				{
					entry.getValue().on();
				}
			}
			Thread.currentThread();
			try
			{
				Thread.sleep(1000 * 5);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
