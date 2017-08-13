package model.card;

public class Card {
	private Colour colour;
	private Value value;

	public Colour getColour() {
		return colour;
	}

	public void setColour(Colour colour) {
		this.colour = colour;
	}

	public Value getValue(Card card) {
		return value;
	}

	public void setValue(Value value) {
		this.value = value;
	}
}
