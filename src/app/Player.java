package app;

import java.util.ArrayList;
import java.util.List;

import model.card.Card;

public class Player {
	private List<Card> cards = new ArrayList<Card>();
	private int cardsValue;
	private String name;

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCardsValue() {
		for (Card card : cards) {
			cardsValue = cardsValue + card.getValue(card).value;
		}
		return cardsValue;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(Card card) {
		cards.add(card);
	}
}
