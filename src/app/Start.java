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
		Player player = new Player("Player");
		Player c1 = new Player("Stupid Computer");
		Player c2 = new Player("Smart Computer");
		Player c3 = new Player("Cheating Computer");
		Player c4 = new Player("Excellent Computer");
		List<Player> listOfPlayers = new ArrayList<>();
		listOfPlayers.add(player);
		listOfPlayers.add(c1);
		listOfPlayers.add(c2);
		listOfPlayers.add(c3);
		listOfPlayers.add(c4);

		CardFactory cf = CardFactory.getInstance();
		List<Card> allCards = new ArrayList<>();

		for (Colour colour : Colour.values()) {
			for (Value value : Value.values()) {
				allCards.add(cf.createCard(colour, value));
			}
		}
		for (int i = 0; i < 2; i++) {
			for (Player p : listOfPlayers) {
				Card playerCard = allCards.get(new Random().nextInt(allCards.size()));
				p.setCards(playerCard);
				allCards.remove(playerCard);
			}
		}

		CardHandler.drawCards(listOfPlayers);
	}
}
