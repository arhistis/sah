package launcher;

import display.Display;

abstract public class Tile {
	private int row, column;
	private boolean available; 
	
	public Tile(int row, int column) {
		super();
		this.row = row;
		this.column = column;
		this.available = false;
	}
	
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}
	
	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	abstract public void checkMove(int row, int column, Display display);
	abstract public void moveTo(int new_row, int new_col, int row, int col, Display display);
	
}
