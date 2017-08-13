package app;

import model.card.Card;
import model.card.Colour;
import model.card.Value;

public interface Factory {
	public Card createCard(Colour colour, Value value);
}
