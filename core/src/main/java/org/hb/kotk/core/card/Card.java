/**
 * 
 */
package org.hb.kotk.core.card;

import java.util.List;

import org.hb.kotk.core.player.Player;

/**
 * @author huanbinzhang
 * 
 */
public class Card extends CardProperty implements CardSkill
{
	private Player owner;
	private List<Player> targets;

	public void trigger()
	{

	}

	/**
	 * @return the owner
	 */
	public Player getOwner()
	{
		return owner;
	}

	/**
	 * @param owner
	 *            the owner to set
	 */
	public void setOwner(Player owner)
	{
		this.owner = owner;
	}

	/**
	 * @return the targets
	 */
	public List<Player> getTargets()
	{
		return targets;
	}

	/**
	 * @param targets
	 *            the targets to set
	 */
	public void setTargets(List<Player> targets)
	{
		this.targets = targets;
	}

}
