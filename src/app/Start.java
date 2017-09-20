package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import handler.CardHandler;
import model.card.Card;
import model.card.Colour;
import model.card.Value;

public class Start {
	private static boolean nextGame = true;
	private static int gamesPlayed = 0;
	private static List<Player> listOfPlayers = new ArrayList<>();

	public static void main(String[] args) throws BadUserInputException {
		while (nextGame) {
			System.out.println("1st Deal");
			if (listOfPlayers.isEmpty()) {
				listOfPlayers.add(new Player("Player", 0));
				listOfPlayers.add(new Player("Ai1", 0));
				listOfPlayers.add(new Player("Ai2", 0));
				listOfPlayers.add(new Player("Ai3", 0));
				listOfPlayers.add(new Player("Ai4", 0));
			} else {
				for (Player player : listOfPlayers) {
					player.removeCards();
				}
			}
			CardFactory cf = CardFactory.getInstance();
			List<Card> allCards = new ArrayList<>();

			if (!allCards.isEmpty()) {
				allCards.clear();
			}

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
			gamesPlayed++;

			for (Player p : listOfPlayers) {
				p.setWantAnotherCard(true);
			}

			System.out.println();
			System.out.println();
			System.out.println("Do you want to play another game? (y = yes, n = no)");
			nextGame = Player.wantContinue();

		}

		Player.sc.close();
		System.out.println("Total games played " + gamesPlayed + ".");
		System.out.print("Number of wins: ");
		for (Player p : listOfPlayers) {
			System.out.print(p.getName().toString() + ":" + p.getGameWins() + "   ");
		}
	}

	public static boolean doesAnyoneWantCard(List<Player> listOfPlayers) {
		boolean someoneWantsCard = false;
		for (Player p : listOfPlayers) {
			if (p.isWantAnotherCard()) {
				someoneWantsCard = true;
			}
		}
		return someoneWantsCard;
	}
}
