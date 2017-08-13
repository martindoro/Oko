package app;

import model.card.Card;
import model.card.Colour;
import model.card.Value;

public class CardFactory implements Factory {
	private CardFactory() {
	}

	private static final CardFactory INSTANCE = new CardFactory();

	public static CardFactory getInstance() {
		return INSTANCE;
	}

	@Override
	public Card createCard(Colour colour, Value value) {
		Card card = new Card();
		card.setColour(colour);
		card.setValue(value);
		return card;
	}
}
