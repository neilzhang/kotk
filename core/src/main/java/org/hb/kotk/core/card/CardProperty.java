/**
 * 
 */
package org.hb.kotk.core.card;

import org.hb.kotk.core.base.Color;
import org.hb.kotk.core.base.Property;

/**
 * @author neil
 * 
 */
public class CardProperty implements Property
{
	private Character character;
	private Color color;

	/**
	 * @return the number
	 */
	public Character getNumber()
	{
		return character;
	}

	/**
	 * @param number
	 *            the number to set
	 */
	public void setNumber(Character number)
	{
		this.character = number;
	}

	/**
	 * @return the color
	 */
	public Color getColor()
	{
		return color;
	}

	/**
	 * @param color
	 *            the color to set
	 */
	public void setColor(Color color)
	{
		this.color = color;
	}
}
