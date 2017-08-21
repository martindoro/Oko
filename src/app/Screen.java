package app;

import model.Const;

public class Screen {
	private static Screen instance;

	public static Screen getInstance() {
		if (instance == null) {
			instance = new Screen();
		}
		return instance;
	}

	public static String drawScreenLabel(Player player) {
		String p1 = "PLAYER";
		String p2 = "COMPUTERS";
		String p1Value = " (" + Integer.toString(player.getCardsValue()) + " pts)";

		StringBuilder line = new StringBuilder();

		line.append(p1);
		line.append(p1Value);
		for (int i = 0; i < 35 - (p1.length() + p1Value.length()); i++) {
			line.append(Const.SPACE);
		}
		line.append(p2);

		return line.toString();
	}

	public static void drawPlayerInput() {
		System.out.println("*******************");
		System.out.println("* y = yes  n = no *");
		System.out.println("*******************");
	}
}
