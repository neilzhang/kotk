/**
 * 
 */
package org.hb.kotk.core.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.hb.kotk.core.card.Card;

/**
 * @author huanbinzhang
 * 
 */
public class CardMachine
{

	private Map<Integer, Card> mappedCards;
	private List<Card> rawCards;
	private Queue<Integer> usedCardIndex;
	private Queue<Integer> unusedCardIndex;

	private CardMachine()
	{
		init();
	}

	private static class SingletonHolder
	{
		private static CardMachine instance = new CardMachine();
	}

	private void init()
	{
		createCards();
		numberCards();
	};

	public static CardMachine getInstance()
	{
		return SingletonHolder.instance;
	}

	private void createCards()
	{
		// read from xml
		rawCards = new ArrayList<Card>();
	}

	private void numberCards()
	{
		int index = 0;
		for (Iterator itor = rawCards.iterator(); itor.hasNext();)
		{
			mappedCards.put(index, (Card) itor.next());
			index++;
		}
	}

	private Integer getIndexOfCard(Card card)
	{
		return 0;

	}

	private List<Card> getCards()
	{
		return rawCards;
	}

	public List<Card> dealCards(int number)
	{
		if (unusedCardIndex.size() < number)
		{
			shuffle();
		}
		List<Card> result = new ArrayList<Card>();
		while (number > 0)
		{
			Integer index = unusedCardIndex.poll();
			result.add(mappedCards.get(index));
			number--;
		}
		return result;
	}

	public void collectCards(List<Card> cards)
	{

	}

	public void shuffle()
	{

	}
}
