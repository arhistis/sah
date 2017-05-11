package display;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import launcher.Pawn;
import launcher.Piece;

public class SelectionListener implements ActionListener{
	
	private Display display;
	private int row,col;
	
	public SelectionListener(Display d,int row, int col){
		this.display = d;
		this.row = row;
		this.col = col;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		display.board[row][col].checkMove(row,col,display);
		for( ActionListener al : display.buttons[row][col].getActionListeners() )
	    	display.buttons[row][col].removeActionListener( al );
		display.buttons[row][col].addActionListener(new CancelSelectionListener(display));
		
	}
	
}
