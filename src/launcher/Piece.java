package launcher;

import java.awt.Color;

import display.Display;

abstract public class Piece extends Tile {
	private Color color;
	
	public Piece(int row, int column, Color color) {
		super(row, column);
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	abstract public void checkMove(int row, int column, Display display);
	abstract public void moveTo(int new_row, int new_col, int row, int col, Display display);

}

	
