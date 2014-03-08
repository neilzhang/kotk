/**
 * 
 */
package org.hb.kotk.core.util;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.hb.kotk.core.base.Configuration;

/**
 * @author neil
 * 
 */
public final class AppConfig implements FileCache
{
	private static Logger logger = Logger.getLogger(AppConfig.class);
	private Configuration configuration = new Configuration();
	private Document configDocument;
	private String filePath;

	public AppConfig(String filePath)
	{
		this.filePath = filePath;
	}

	public void load() throws DocumentException
	{
		configDocument = XmlReader.getXml(filePath);
		if (configDocument != null)
		{
			Element kotk = configDocument.getRootElement();
			phraseConfigFilePath(kotk);
			phraseComponent(kotk);
			phraseClient(kotk);
		}
	}

	/**
	 * @return the filePath
	 */
	public String getFilePath()
	{
		return filePath;
	}

	/**
	 * @param filePath
	 *        the filePath to set
	 */
	public void setFilePath(String filePath)
	{
		this.filePath = filePath;
	}

	public String getController()
	{
		return getConfiguration().getControllerComponent();
	}

	public String getProcessor()
	{
		return getConfiguration().getProcessorComponent();
	}

	public String getListener()
	{
		return getConfiguration().getGatherComponent();
	}

	public String getDecider()
	{
		return getConfiguration().getDeciderComponent();
	}

	public String getDriver()
	{
		return getConfiguration().getDeciderComponent();
	}

	public String getAdapter()
	{
		return getConfiguration().getAdapterClient();
	}

	public String getFacade()
	{
		return getConfiguration().getFacadeClient();
	}

	private Configuration getConfiguration()
	{
		return configuration;
	}

	private void phraseConfigFilePath(Element rootElt)
	{
		Iterator configFilePathItor = rootElt.elementIterator(AppConstant.CONFIG_FILE_PATH);
		while (configFilePathItor.hasNext())
		{
			Element recordEle = (Element) configFilePathItor.next();

			String card = recordEle.elementTextTrim(AppConstant.CARD);
			if (card != null)
			{
				configuration.setCardConfigFilePath(card);
			}
			else
			{
				configuration.setCardConfigFilePath(AppConstant.CARDS_XML);
			}

			String rule = recordEle.elementTextTrim(AppConstant.RULE);
			if (rule != null)
			{
				configuration.setRuleConfigFilePath(rule);
			}
			else
			{
				configuration.setRuleConfigFilePath(AppConstant.RULES_XML);
			}
		}
	}

	private void phraseComponent(Element rootElt)
	{
		Iterator componentItor = rootElt.elementIterator(AppConstant.COMPONENT);
		while (componentItor.hasNext())
		{
			Element recordEle = (Element) componentItor.next();

			String driver = recordEle.elementTextTrim(AppConstant.DRIVER);
			if (driver != null)
			{
				configuration.setDriverComponent(driver);
			}
			else
			{
				String error = ErrorMessage.getMessage(AppConstant.NO_DRIVER);
				logger.error(error);
				System.exit(1);
			}

			String controller = recordEle.elementTextTrim(AppConstant.CONTROLLER);
			if (controller != null)
			{
				configuration.setControllerComponent(controller);
			}
			else
			{
				String error = ErrorMessage.getMessage(AppConstant.NO_CONTROLLER);
				logger.error(error);
				System.exit(1);
			}

			String processor = recordEle.elementTextTrim(AppConstant.PROCESSOR);
			if (processor != null)
			{
				configuration.setProcessorComponent(processor);
			}
			else
			{
				String error = ErrorMessage.getMessage(AppConstant.NO_PROCESSOR);
				logger.error(error);
				System.exit(1);
			}

			String gather = recordEle.elementTextTrim(AppConstant.GATHER);
			if (gather != null)
			{
				configuration.setGatherComponent(gather);
			}
			else
			{
				String error = ErrorMessage.getMessage(AppConstant.NO_GATHER);
				logger.error(error);
				System.exit(1);
			}

			String decider = recordEle.elementTextTrim(AppConstant.DECIDER);
			if (decider != null)
			{
				configuration.setDeciderComponent(decider);
			}
			else
			{
				String error = ErrorMessage.getMessage(AppConstant.NO_DECIDER);
				logger.error(error);
				System.exit(1);
			}
		}
	}

	private void phraseClient(Element rootElt)
	{
		Iterator clientItor = rootElt.elementIterator(AppConstant.CLIENT);
		while (clientItor.hasNext())
		{
			Element recordEle = (Element) clientItor.next();

			String facade = recordEle.elementTextTrim(AppConstant.FACADE);
			if (facade != null)
			{
				configuration.setFacadeClient(facade);
			}
			else
			{
				String error = ErrorMessage.getMessage(AppConstant.NO_CLIENT);
				logger.error(error);
				System.exit(1);
			}

			String adapter = recordEle.elementTextTrim(AppConstant.ADAPTER);
			if (adapter != null)
			{
				configuration.setAdapterClient(adapter);
			}
			else
			{
				String error = ErrorMessage.getMessage(AppConstant.NO_ADAPTER);
				logger.error(error);
				System.exit(1);
			}
		}
	}
}
