package app;

import model.card.Card;

public class CardFactory implements Factory {
	static CardFactory cardFactory = new CardFactory();

	public static CardFactory getInstance() {
		return cardFactory;
	}

	@Override
	public Card createCard(char colour, String label) {
		Card card = new Card();
		card.setColour(colour);
		card.setLabel(label);
		// card.setValue(Value.getValue());
		return card;
	}
}
