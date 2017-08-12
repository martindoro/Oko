package model.card;

import model.Const;

public enum Colour {
	SPADES(Const.SPADES), HEARTS(Const.HEARTS), DIAMONDS(Const.DIAMONDS), CLUBS(Const.CLUBS);

	private final char colour;

	Colour(char colour) {
		this.colour = colour;
	}

	public char getColour() {
		return this.colour;
	}
}
