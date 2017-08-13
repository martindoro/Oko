package app;

import java.util.List;

import model.Const;

public class Screen {
	private static Screen instance;
	private static Player player;
	private static Player computer;
	private List<StringBuilder> lines;

	public static Screen getInstance() {
		if (instance == null) {
			instance = new Screen();
		}
		return instance;
	}

	public static String drawScreenLabel(Player player, Player computer) {
		String p1 = "PLAYER";
		String p2 = "COMPUTER";
		String p1Value = " (cards value is " + Integer.toString(player.getCardsValue()) + ")";
		String p2Value = " (cards value is " + Integer.toString(computer.getCardsValue()) + ")";
		StringBuilder line = new StringBuilder();

		line.append(p1);
		line.append(p1Value);
		for (int i = 0; i < 40 - (p1.length() + p1Value.length()); i++) {
			line.append(Const.SPACE);
		}
		line.append(p2);
		line.append(p2Value);

		return line.toString();
	}
}
