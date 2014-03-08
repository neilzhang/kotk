/**
 * 
 */
package org.hb.kotk.core.util;

/**
 * @author neil
 * 
 */
public abstract class FileMonitor implements Monitor
{
	private String filePath;
	private boolean active;
	private long lastModifiedTime;

	public FileMonitor(String filePath)
	{
		this.filePath = filePath;
	}

	/*
	 * (non-Javadoc)
	 * @see org.hb.kotk.core.util.Monitor#start()
	 */
	public void start()
	{
		setActive(true);
	}

	/*
	 * (non-Javadoc)
	 * @see org.hb.kotk.core.util.Monitor#stop()
	 */
	public void stop()
	{
		setActive(false);
	}

	/*
	 * (non-Javadoc)
	 * @see org.hb.kotk.core.util.Monitor#on()
	 */
	public abstract void on();

	/**
	 * @return the active
	 */
	public boolean isActive()
	{
		return active;
	}

	/**
	 * @param active
	 *        the active to set
	 */
	public void setActive(boolean active)
	{
		this.active = active;
	}

	/**
	 * @return the lastModifiedTime
	 */
	public long getLastModifiedTime()
	{
		return lastModifiedTime;
	}

	/**
	 * @param lastModifiedTime
	 *        the lastModifiedTime to set
	 */
	public void setLastModifiedTime(long lastModifiedTime)
	{
		this.lastModifiedTime = lastModifiedTime;
	}

	/**
	 * @return the filePath
	 */
	public String getFilePath()
	{
		return filePath;
	}
}
