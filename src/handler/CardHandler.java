package handler;

import java.util.List;

import app.Player;
import app.Screen;
import model.Const;
import model.card.Card;

public class CardHandler {
	public static void drawCards(List<Player> listOfPlayers) {
		Player pl1 = listOfPlayers.get(0);
		Player pl2 = listOfPlayers.get(1);
		Player pl3 = listOfPlayers.get(2);
		Player pl4 = listOfPlayers.get(3);
		Player pl5 = listOfPlayers.get(4);
		int pl1CardCount = pl1.getCards().size();

		System.out.println(Screen.drawScreenLabel(pl1));
		System.out.println();
		System.out.println(drawTopLine(pl1CardCount));
		System.out.println(drawLabelLine(pl1, pl2));
		System.out.println(drawColourLine(pl1, pl3));
		for (int i = 0; i < Const.CARD_SIZE_Y - 6; i++) {
			System.out.println(drawEmptyLine(pl1CardCount));
		}
		System.out.println(drawColourLine(pl1, pl4));
		System.out.println(drawLabelLine(pl1, pl5));
		System.out.println(drawBottomLine(pl1CardCount));
	}

	public static String drawTopLine(int pl1CardCount) {
		StringBuilder line = new StringBuilder();

		for (int i = 0; i < pl1CardCount; i++) {
			line.append(Const.TLC);
			line.append(Const.HLINE);
			line.append(Const.HLINE);
			line.append(Const.HLINE);
		}

		for (int i = 0; i < Const.CARD_SIZE_X - 5; i++) {
			line.append(Const.HLINE);
		}
		line.append(Const.TRC);
		return line.toString();
	}

	public static String drawBottomLine(int pl1CardCount) {
		StringBuilder line = new StringBuilder();

		for (int i = 0; i < pl1CardCount; i++) {
			line.append(Const.BLC);
			line.append(Const.HLINE);
			line.append(Const.HLINE);
			line.append(Const.HLINE);
		}

		for (int i = 0; i < Const.CARD_SIZE_X - 5; i++) {
			line.append(Const.HLINE);
		}
		line.append(Const.BRC);
		return line.toString();
	}

	public static String drawLabelLine(Player pl1, Player pl2) {
		List<Card> pl1Cards = pl1.getCards();
		List<Card> pl2Cards = pl2.getCards();
		int pl1CardCount = pl1Cards.size();
		int pl2CardCount = pl2Cards.size();
		StringBuilder line = new StringBuilder();
		String pl1LastCard = pl1Cards.get(pl1CardCount - 1).getValue(pl1Cards.get(pl1CardCount - 1)).getLabel();

		for (int i = 0; i < pl1CardCount; i++) {
			String cardLabel = pl1Cards.get(i).getValue(pl1Cards.get(i)).getLabel();

			line.append(Const.VLINE);
			line.append(cardLabel);
			for (int j = cardLabel.length(); j < 3; j++) {
				line.append(Const.SPACE);
			}
		}
		for (int i = 0; i < Const.CARD_SIZE_X - 8; i++) {
			line.append(Const.SPACE);
		}
		for (int j = pl1LastCard.length(); j < 3; j++) {
			line.append(Const.SPACE);
		}
		line.append(pl1LastCard);
		line.append(Const.VLINE);

		for (int i = 0; i < 35 - ((pl1CardCount - 1) * 4 + Const.CARD_SIZE_X); i++) {
			line.append(Const.SPACE);
		}

		line.append(pl2.getName());
		line.append(" (" + Integer.toString(pl2.getCardsValue()) + " pts) ");

		for (int i = 0; i < pl2CardCount; i++) {
			line.append(pl2Cards.get(i).getValue(pl2Cards.get(i)).getLabel());
			line.append(pl2Cards.get(i).getColour().getColour());
			line.append(Const.SPACE);
		}

		return line.toString();
	}

	public static String drawColourLine(Player pl1, Player pl2) {
		List<Card> pl1Cards = pl1.getCards();
		List<Card> pl2Cards = pl2.getCards();
		int pl1CardCount = pl1Cards.size();
		int pl2CardCount = pl2Cards.size();
		StringBuilder line = new StringBuilder();
		char pl1LastCard = pl1Cards.get(pl1CardCount - 1).getColour().getColour();

		for (int i = 0; i < pl1CardCount; i++) {
			char cardColour = pl1Cards.get(i).getColour().getColour();

			line.append(Const.VLINE);
			line.append(Const.SPACE);
			line.append(cardColour);
			line.append(Const.SPACE);
		}
		for (int i = 0; i < Const.CARD_SIZE_X - 8; i++) {
			line.append(Const.SPACE);
		}
		line.append(Const.SPACE);
		line.append(pl1LastCard);
		line.append(Const.SPACE);
		line.append(Const.VLINE);

		for (int i = 0; i < 35 - ((pl1CardCount - 1) * 4 + Const.CARD_SIZE_X); i++) {
			line.append(Const.SPACE);
		}

		line.append(pl2.getName());
		line.append(" (" + Integer.toString(pl2.getCardsValue()) + " pts) ");

		for (int i = 0; i < pl2CardCount; i++) {
			line.append(pl2Cards.get(i).getValue(pl2Cards.get(i)).getLabel());
			line.append(pl2Cards.get(i).getColour().getColour());
			line.append(Const.SPACE);
		}

		return line.toString();
	}

	public static String drawEmptyLine(int cardCount) {
		StringBuilder line = new StringBuilder();

		for (int i = 0; i < cardCount; i++) {
			line.append(Const.VLINE);
			line.append(Const.SPACE);
			line.append(Const.SPACE);
			line.append(Const.SPACE);
		}

		for (int i = 0; i < Const.CARD_SIZE_X - 5; i++) {
			line.append(Const.SPACE);
		}
		line.append(Const.VLINE);
		return line.toString();
	}
}