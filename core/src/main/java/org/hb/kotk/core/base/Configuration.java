/**
 * 
 */
package org.hb.kotk.core.base;

/**
 * @author neil
 * 
 */
public class Configuration
{
	private String cardConfigFilePath;
	private String ruleConfigFilePath;
	private String driverComponent;
	private String controllerComponent;
	private String processorComponent;
	private String gatherComponent;
	private String deciderComponent;
	private String facadeClient;
	private String adapterClient;

	/**
	 * @return the cardConfigFilePath
	 */
	public String getCardConfigFilePath()
	{
		return cardConfigFilePath;
	}

	/**
	 * @param cardConfigFilePath
	 *        the cardConfigFilePath to set
	 */
	public void setCardConfigFilePath(String cardConfigFilePath)
	{
		this.cardConfigFilePath = cardConfigFilePath;
	}

	/**
	 * @return the ruleConfigFilePath
	 */
	public String getRuleConfigFilePath()
	{
		return ruleConfigFilePath;
	}

	/**
	 * @param ruleConfigFilePath
	 *        the ruleConfigFilePath to set
	 */
	public void setRuleConfigFilePath(String ruleConfigFilePath)
	{
		this.ruleConfigFilePath = ruleConfigFilePath;
	}

	/**
	 * @return the driverComponent
	 */
	public String getDriverComponent()
	{
		return driverComponent;
	}

	/**
	 * @param driverComponent
	 *        the driverComponent to set
	 */
	public void setDriverComponent(String driverComponent)
	{
		this.driverComponent = driverComponent;
	}

	/**
	 * @return the controllerComponent
	 */
	public String getControllerComponent()
	{
		return controllerComponent;
	}

	/**
	 * @param controllerComponent
	 *        the controllerComponent to set
	 */
	public void setControllerComponent(String controllerComponent)
	{
		this.controllerComponent = controllerComponent;
	}

	/**
	 * @return the processorComponent
	 */
	public String getProcessorComponent()
	{
		return processorComponent;
	}

	/**
	 * @param processorComponent
	 *        the processorComponent to set
	 */
	public void setProcessorComponent(String processorComponent)
	{
		this.processorComponent = processorComponent;
	}

	/**
	 * @return the gatherComponent
	 */
	public String getGatherComponent()
	{
		return gatherComponent;
	}

	/**
	 * @param gatherComponent
	 *        the gatherComponent to set
	 */
	public void setGatherComponent(String gatherComponent)
	{
		this.gatherComponent = gatherComponent;
	}

	/**
	 * @return the deciderComponent
	 */
	public String getDeciderComponent()
	{
		return deciderComponent;
	}

	/**
	 * @param deciderComponent
	 *        the deciderComponent to set
	 */
	public void setDeciderComponent(String deciderComponent)
	{
		this.deciderComponent = deciderComponent;
	}

	/**
	 * @return the facadeClient
	 */
	public String getFacadeClient()
	{
		return facadeClient;
	}

	/**
	 * @param facadeClient
	 *        the facadeClient to set
	 */
	public void setFacadeClient(String facadeClient)
	{
		this.facadeClient = facadeClient;
	}

	/**
	 * @return the adapterClient
	 */
	public String getAdapterClient()
	{
		return adapterClient;
	}

	/**
	 * @param adapterClient
	 *        the adapterClient to set
	 */
	public void setAdapterClient(String adapterClient)
	{
		this.adapterClient = adapterClient;
	}

}
