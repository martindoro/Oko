package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import handler.CardHandler;
import model.card.Card;
import model.card.Colour;
import model.card.Value;

public class Start {
	public static boolean doesAnyoneWantCard(List<Player> listOfPlayers) {
		boolean someoneWantsCard = false;
		for (Player p : listOfPlayers) {
			if (p.isWantAnotherCard()) {
				someoneWantsCard = true;
			}
		}
		return someoneWantsCard;
	}

	public static void main(String[] args) throws BadUserInputException {
		System.out.println("1st Deal");
		List<Player> listOfPlayers = new ArrayList<>();
		listOfPlayers.add(new Player("Player"));
		listOfPlayers.add(new Player("Dumb"));
		listOfPlayers.add(new Player("Smart"));
		listOfPlayers.add(new Player("Cheater"));
		listOfPlayers.add(new Player("Genius"));

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

		while (doesAnyoneWantCard(listOfPlayers)) {
			for (Player p : listOfPlayers) {
				if (Player.getDecision(p)) {
					Card card = allCards.get(new Random().nextInt(allCards.size()));
					p.setCards(card);
					allCards.remove(card);
				}
			}
			if (listOfPlayers.get(0).isWantAnotherCard()) {
				CardHandler.drawCards(listOfPlayers);
			}
		}
		CardHandler.drawCards(listOfPlayers);
		System.out.println("And the Winner is " + Screen.andTheWinnerIs(listOfPlayers).toUpperCase() + " !");
	}
}
