package app;

import java.util.ArrayList;
import java.util.List;

import model.card.Card;

public class Player {
	private List<Card> cards = new ArrayList<Card>();

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(Card card) {
		cards.add(card);
	}
}
