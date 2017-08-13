package model.card;

public enum Value {
	SEVEN(7, model.Const.SEVEN), EIGHT(8, model.Const.EIGHT), NINE(9, model.Const.NINE), TEN(10, model.Const.TEN), JACK(
			1, model.Const.JACK), QUEEN(1, model.Const.QUEEN), KING(2, model.Const.KING), ACE(11, model.Const.ACE);

	public final int value;
	private final String label;

	Value(int value, String label) {
		this.value = value;
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}

	public int getValue() {
		return this.value;
	}
}
