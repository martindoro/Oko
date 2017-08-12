package app;

import handler.CardHandler;
import model.Const;

public class Start {
	public static void main(String[] args) {
		System.out.println("Štart hry...");
		Player player = new Player();
		Player computer = new Player();
		player.setCards(CardFactory.getInstance().createCard(Const.DIAMONDS, Const.EIGHT));
		computer.setCards(CardFactory.getInstance().createCard(Const.HEARTS, Const.KING));
		player.setCards(CardFactory.getInstance().createCard(Const.CLUBS, Const.TEN));
		computer.setCards(CardFactory.getInstance().createCard(Const.SPADES, Const.JACK));
		player.setCards(CardFactory.getInstance().createCard(Const.SPADES, Const.QUEEN));
		computer.setCards(CardFactory.getInstance().createCard(Const.DIAMONDS, Const.TEN));
		player.setCards(CardFactory.getInstance().createCard(Const.DIAMONDS, Const.ACE));
		computer.setCards(CardFactory.getInstance().createCard(Const.HEARTS, Const.SEVEN));

		CardHandler.drawCards(player, computer);
	}
}
