/**
 * 
 */
package org.hb.kotk.core.player;

import java.util.List;

import org.hb.kotk.core.card.Card;

/**
 * @author neil
 * 
 */
public abstract class Player
{
	public abstract void useCard(Card card);

	public abstract void dropCards(List<Card> cards);
}
