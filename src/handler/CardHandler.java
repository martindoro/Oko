package handler;

import java.util.Collections;
import java.util.List;

import app.Player;
import app.Screen;
import model.Const;
import model.card.Card;

public class CardHandler {
	public static void drawCards(Player pl1, Player pl2) {
		List<Card> pl1Cards = pl1.getCards();
		List<Card> pl2Cards = pl2.getCards();
		Collections.reverse(pl2Cards);
		int pl1CardCount = pl1.getCards().size();
		int pl2CardCount = pl2.getCards().size();
		int[] cardCount = { pl1CardCount, pl2CardCount };

		System.out.println(Screen.drawScreenLabel(pl1, pl2));
		System.out.println();
		System.out.println(drawTopLine(cardCount));
		System.out.println(drawLabelLine(pl1Cards, pl2Cards, cardCount));
		System.out.println(drawColourLine(pl1Cards, pl2Cards, cardCount));
		for (int i = 0; i < Const.CARD_SIZE_Y - 6; i++) {
			System.out.println(drawEmptyLine(cardCount));
		}
		System.out.println(drawColourLine(pl1Cards, pl2Cards, cardCount));
		System.out.println(drawLabelLine(pl1Cards, pl2Cards, cardCount));
		System.out.println(drawBottomLine(cardCount));
	}

	public static String drawTopLine(int[] cardCount) {
		StringBuilder line = new StringBuilder();

		for (int i = 0; i < cardCount[0]; i++) {
			line.append(Const.TLC);
			line.append(Const.HLINE);
			line.append(Const.HLINE);
			line.append(Const.HLINE);
		}

		for (int i = 0; i < Const.CARD_SIZE_X - 5; i++) {
			line.append(Const.HLINE);
		}
		line.append(Const.TRC);

		for (int i = 0; i < 40 - ((cardCount[0] - 1) * 4 + Const.CARD_SIZE_X); i++) {
			line.append(Const.SPACE);
		}

		line.append(Const.TLC);

		for (int i = 0; i < Const.CARD_SIZE_X - 2; i++) {
			line.append(Const.HLINE);
		}

		line.append(Const.TRC);

		for (int i = 1; i < cardCount[1]; i++) {
			line.append(Const.HLINE);
			line.append(Const.HLINE);
			line.append(Const.HLINE);
			line.append(Const.TRC);
		}

		return line.toString();
	}

	public static String drawBottomLine(int[] cardCount) {
		StringBuilder line = new StringBuilder();

		for (int i = 0; i < cardCount[0]; i++) {
			line.append(Const.BLC);
			line.append(Const.HLINE);
			line.append(Const.HLINE);
			line.append(Const.HLINE);
		}

		for (int i = 0; i < Const.CARD_SIZE_X - 5; i++) {
			line.append(Const.HLINE);
		}
		line.append(Const.BRC);

		for (int i = 0; i < 40 - ((cardCount[0] - 1) * 4 + Const.CARD_SIZE_X); i++) {
			line.append(Const.SPACE);
		}

		line.append(Const.BLC);

		for (int i = 0; i < Const.CARD_SIZE_X - 2; i++) {
			line.append(Const.HLINE);
		}

		line.append(Const.BRC);

		for (int i = 1; i < cardCount[1]; i++) {
			line.append(Const.HLINE);
			line.append(Const.HLINE);
			line.append(Const.HLINE);
			line.append(Const.BRC);
		}

		return line.toString();
	}

	public static String drawLabelLine(List<Card> pl1Cards, List<Card> pl2Cards, int[] cardCount) {
		StringBuilder line = new StringBuilder();
		String pl1LastCard = pl1Cards.get(cardCount[0] - 1).getValue(pl1Cards.get(cardCount[0] - 1)).getLabel();
		String pl2FirstCard = pl2Cards.get(0).getValue(pl2Cards.get(0)).getLabel();

		for (int i = 0; i < cardCount[0]; i++) {
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

		for (int i = 0; i < 40 - ((cardCount[0] - 1) * 4 + Const.CARD_SIZE_X); i++) {
			line.append(Const.SPACE);
		}

		line.append(Const.VLINE);
		line.append(pl2FirstCard);

		for (int i = pl2FirstCard.length(); i < 3; i++) {
			line.append(Const.SPACE);
		}

		for (int j = 0; j < 2; j++) {
			line.append(Const.SPACE);
		}

		for (int i = 0; i < cardCount[1]; i++) {
			for (int j = pl2Cards.get(i).getValue(pl2Cards.get(i)).getLabel().length() + 1; j < 4; j++) {
				line.append(Const.SPACE);
			}
			line.append(pl2Cards.get(i).getValue(pl2Cards.get(i)).getLabel());
			line.append(Const.VLINE);
		}
		return line.toString();
	}

	public static String drawColourLine(List<Card> pl1Cards, List<Card> pl2Cards, int[] cardCount) {
		StringBuilder line = new StringBuilder();
		char pl1LastCard = pl1Cards.get(cardCount[0] - 1).getColour().getColour();
		char pl2FirstCard = pl2Cards.get(0).getColour().getColour();

		for (int i = 0; i < cardCount[0]; i++) {
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

		for (int i = 0; i < 40 - ((cardCount[0] - 1) * 4 + Const.CARD_SIZE_X); i++) {
			line.append(Const.SPACE);
		}

		line.append(Const.VLINE);
		line.append(Const.SPACE);
		line.append(pl2FirstCard);

		for (int i = 0; i < Const.CARD_SIZE_X - 7; i++) {
			line.append(Const.SPACE);
		}

		for (int i = 0; i < cardCount[1]; i++) {
			line.append(Const.SPACE);
			line.append(pl2Cards.get(i).getColour().getColour());
			line.append(Const.SPACE);
			line.append(Const.VLINE);
		}
		return line.toString();
	}

	public static String drawEmptyLine(int[] cardCount) {
		StringBuilder line = new StringBuilder();

		for (int i = 0; i < cardCount[0]; i++) {
			line.append(Const.VLINE);
			line.append(Const.SPACE);
			line.append(Const.SPACE);
			line.append(Const.SPACE);
		}

		for (int i = 0; i < Const.CARD_SIZE_X - 5; i++) {
			line.append(Const.SPACE);
		}
		line.append(Const.VLINE);

		for (int i = 0; i < 40 - ((cardCount[0] - 1) * 4 + Const.CARD_SIZE_X); i++) {
			line.append(Const.SPACE);
		}

		line.append(Const.VLINE);

		for (int i = 0; i < Const.CARD_SIZE_X - 2; i++) {
			line.append(Const.SPACE);
		}

		line.append(Const.VLINE);

		for (int i = 1; i < cardCount[1]; i++) {
			line.append(Const.SPACE);
			line.append(Const.SPACE);
			line.append(Const.SPACE);
			line.append(Const.VLINE);
		}

		return line.toString();
	}
}