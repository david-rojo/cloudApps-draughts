package cloudapps.draughts.models;

public class GameBuilder {
	
	private Board board;
	
	public GameBuilder() {
		board = new Board();
	}
	
//	private void setColor(Game game, Board board) {
//		if (this.color == Color.BLACK) {
//			board.put(new Coordinate(7, 0), new Pawn(Color.WHITE));
//			game.move(new Coordinate(7,0), new Coordinate(6, 1));
//			board.remove(new Coordinate(6, 1));
//		}
//	}
	
	private void setRow(Board board, int row, String string) {
		for (int j = 0; j < string.length(); j++) {
			Color color = this.getColor(string.charAt(j));
			if (color != null) {
				Piece piece = new Pawn(color);
				if (Character.isUpperCase(string.charAt(j)))
					piece = new Draught(color);
				board.put(new Coordinate(row, j), piece);
			}
		}	
	}

	private Color getColor(char character) {
		switch (character) {
		case 'b':
		case 'B':
			return Color.WHITE;
		case 'n':
		case 'N':
			return Color.BLACK;
		default:
			return null;
		}
	}

//	public GameBuilder color(Color color) {
//		this.color = color;
//		return this;
//	}

	public GameBuilder rows(String... strings) {
		assert strings != null;
		assert strings.length == Coordinate.getDimension();
		for (int i=0; i<strings.length; i++) {
			assert strings[i].length() == Coordinate.getDimension();
			this.setRow(this.board, i, strings[i]);
		}
		return this;
	}
	
	public Game build() {
		Game game = new Game(this.board);
		return game;
	}


}
