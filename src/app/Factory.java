package app;

import model.card.Card;

public interface Factory {
	public Card createCard(char colour, String label);
}
