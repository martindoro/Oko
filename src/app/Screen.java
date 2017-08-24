package app;

import java.util.ArrayList;
import java.util.List;

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
		for (int i = 0; i < Const.FREE_SPACE - (p1.length() + p1Value.length()); i++) {
			line.append(Const.SPACE);
		}
		line.append(p2);

		return line.toString();
	}

	public static void drawPlayerInput() {
		System.out.println();
		System.out.println("***DO YUO WANT ANOTHER CARD ?***");
		System.out.println("*     y = yes       n = no     *");
		System.out.println("********************************");
	}

	public static String andTheWinnerIs(List<Player> listOfPlayers) {
		List<Player> winnersList = new ArrayList<Player>();
		listOfPlayers.sort((p1, p2) -> (new Integer(p1.getCardsValue())).compareTo(p2.getCardsValue()));
		for (Player p : listOfPlayers) {
			switch (p.getCardsValue()) {
			case 16:
			case 17:
			case 18:
			case 19:
			case 20:
			case 21:
				winnersList.add(p);
				break;
			case 22:
				if (p.getCards().size() == 2) {
					winnersList.add(p);
				}
				break;
			}
		}
		if (winnersList.size() != 0) {
			return winnersList.get(winnersList.size() - 1).getName().toString();
		} else {
			return "Nobody! - all players burned";
		}
	}
}
