package app;

import java.util.ArrayList;
import java.util.List;

import model.card.Card;
import model.card.Colour;
import model.card.Value;

public class Start {
	public static void main(String[] args) {
		System.out.println("Štart hry...");
		Player player = new Player();
		Player computer = new Player();
		CardFactory cf = CardFactory.getInstance();
		List<Card> allCards = new ArrayList<>();

		for (Colour colour : Colour.values()) {
			for (Value value : Value.values()) {
				allCards.add(cf.createCard(colour, value));
			}
		}
		System.out.println();
		// player.setCards(cf.createCard(Colour.DIAMONDS, Value.EIGHT));
		// computer.setCards(cf.createCard(Colour.HEARTS, Value.KING));

		// CardHandler.drawCards(player, computer);
	}
}
