/**
 * 
 */
package org.hb.kotk.core.util;

import java.util.List;

import org.hb.kotk.core.card.Card;
import org.hb.kotk.core.player.Player;

/**
 * @author neil
 * 
 */
public class Controller
{
	private CardMachine cardMachine;
	private List<Player> players;

	private Controller()
	{
		init();
	}

	private static class SingletonHolder
	{
		private static Controller instance = new Controller();
	}

	private void init()
	{
		cardMachine = CardMachine.getInstance();
	}

	public static Controller getInstance()
	{
		return SingletonHolder.instance;
	}

	public List<Card> dealCards(int number)
	{
		return cardMachine.dealCards(number);
	}

	public void collectCards(List<Card> cards)
	{
		cardMachine.collectCards(cards);
	}

	public void shuffle()
	{
		cardMachine.shuffle();
	}
}
