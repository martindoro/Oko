package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.card.Card;

public class Player {
	static Scanner sc = new Scanner(System.in);
	private List<Card> cards = new ArrayList<Card>();
	private int cardsValue;
	private String name;
	private int gameWins;
	boolean wantAnotherCard = true;

	public int getGameWins() {
		return gameWins;
	}

	public void setGameWins(int gameWins) {
		this.gameWins = gameWins;
	}

	public boolean isWantAnotherCard() {
		return wantAnotherCard;
	}

	public void setWantAnotherCard(boolean wantAnotherCard) {
		this.wantAnotherCard = wantAnotherCard;
	}

	public Player(String name, int gameWins) {
		this.name = name;
		this.gameWins = gameWins;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCardsValue() {
		cardsValue = 0;

		for (Card card : cards) {
			cardsValue = cardsValue + card.getValue(card).value;
		}
		return cardsValue;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(Card card) {
		cards.add(card);
	}

	public void removeCards() {
		cards.clear();
	}

	public static boolean wantContinue() {
		String decision;
		boolean toContinue = true;
		boolean decisionMade = true;
		while (decisionMade) {
			try {
				decision = Player.userInput();
			} catch (BadUserInputException e) {
				continue;
			}
			switch (decision) {
			case "y":
				decisionMade = false;
				toContinue = true;
				break;
			case "n":
				decisionMade = false;
				toContinue = false;
				break;
			}
		}
		return toContinue;

	}

	private boolean decide(int cardsValue) {
		switch (cardsValue) {
		case 16:
		case 17:
		case 18:
			return true;
		default:
			return false;
		}
	}

	private static String userInput() throws BadUserInputException {
		String input = sc.nextLine();
		if (input.equals("y") || input.equals("n")) {
			return input;
		} else {
			throw new BadUserInputException();
		}
	}

	public static boolean getDecision(Player player) {
		boolean finalDecision = false;

		if (player.getName().equals("Player")) {
			if (player.wantAnotherCard) {
				Screen.drawPlayerInput();
				String myDecision;
				boolean decisionMade = true;
				while (decisionMade) {
					try {
						myDecision = Player.userInput();
					} catch (BadUserInputException e) {
						continue;
					}
					switch (myDecision) {
					case "y":
						decisionMade = false;
						finalDecision = true;
						break;
					case "n":
						player.setWantAnotherCard(false);
						decisionMade = false;
						finalDecision = false;
						break;
					}
				}
			}
		} else {
			if (player.wantAnotherCard) {
				if (player.getCardsValue() < 16) {
					finalDecision = true;
				} else {
					player.setWantAnotherCard(player.decide(player.getCardsValue()));
					finalDecision = player.wantAnotherCard;
				}
			}
		}
		return finalDecision;

	}
}
