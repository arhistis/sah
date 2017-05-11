package display;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MoveListener implements ActionListener{
	private Display display;
	private int row,col;
	private int new_row, new_col;
	
	public MoveListener(int new_row, int new_col, int row, int col, Display d){
		this.display = d;
		this.row = row;
		this.col = col;
		this.new_col = new_col;
		this.new_row = new_row;
	}

	@Override
	public void actionPerformed(ActionEvent e1) {
		
		display.board[row][col].moveTo(new_row,new_col,row,col,display);
		
		
	}
}
