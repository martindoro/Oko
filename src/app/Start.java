package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import handler.CardHandler;
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
		for (int i = 0; i < 2; i++) {
			Card playerCard = allCards.get(new Random().nextInt(allCards.size()));
			player.setCards(playerCard);
			allCards.remove(playerCard);
			Card computerCard = allCards.get(new Random().nextInt(allCards.size()));
			computer.setCards(computerCard);
			allCards.remove(computerCard);
		}

		CardHandler.drawCards(player, computer);
	}
}
