package launcher;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

import display.Display;
import display.MoveListener;
import display.SelectionListener;

public class Pawn extends Piece {

	public Pawn(int row, int column, Color color) {
		super(row, column, color);
	}
	
	@Override
	public void checkMove(int row, int col, Display display) {
		if(this.getColor() == Color.white && this.getRow()!=0){
			
			if(display.board[row - 1][col].getClass().getSimpleName().equals("Blank"))
			{
				display.buttons[row-1][col].setBackground(new Color(240,230,140));
				display.buttons[row-1][col].addActionListener(new MoveListener(row-1,col,row,col,display));
				display.buttons[row-1][col].setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, Color.red));
				
				if(this.getRow()==6 && display.board[row - 2][col].getClass().getSimpleName().equals("Blank")){
					display.buttons[row-2][col].setBackground(new Color(240,230,140));
					display.buttons[row-2][col].addActionListener(new MoveListener(row-2,col,row,col,display));
				}
			}
			
			if(this.getColumn()!=0)
				if(display.board[row-1][col-1] instanceof Piece && display.board[row-1][col-1].getClass().getSimpleName().equals("Blank")==false)
					if(((Piece) display.board[row-1][col-1]).getColor()==Color.black)
					{
						display.buttons[row-1][col-1].setBackground(new Color(240,230,140));
						display.buttons[row-1][col-1].addActionListener(new MoveListener(row-1,col-1,row,col,display));
					}
						
			if(this.getColumn()!=7)
				if(display.board[row-1][col+1] instanceof Piece  && display.board[row-1][col+1].getClass().getSimpleName().equals("Blank")==false)
					if(((Piece) display.board[row-1][col+1]).getColor()==Color.black)
					{
						display.buttons[row-1][col+1].setBackground(new Color(240,230,140));
						display.buttons[row-1][col+1].addActionListener(new MoveListener(row-1,col+1,row,col,display));
					}
		}
		
		if(this.getColor() == Color.black && this.getRow()!=7){
			
			if(display.board[row + 1][col].getClass().getSimpleName().equals("Blank"))
			{
				display.buttons[row+1][col].setBackground(new Color(240,230,140));
				display.buttons[row+1][col].addActionListener(new MoveListener(row+1,col,row,col,display));
				if(this.getRow()==1 && display.board[row + 2][col].getClass().getSimpleName().equals("Blank")){
					display.buttons[row+2][col].setBackground(new Color(240,230,140));
					display.buttons[row+1][col].addActionListener(new MoveListener(row+1,col,row,col,display));
				}
					
						
			}
			
			if(this.getColumn()!=0)
				if(display.board[row+1][col+1] instanceof Piece  && display.board[row+1][col+1].getClass().getSimpleName().equals("Blank")==false)
					if(((Piece) display.board[row+1][col-1]).getColor()==Color.black)
					{
						display.buttons[row+1][col-1].setBackground(new Color(240,230,140));
						display.buttons[row+1][col-1].addActionListener(new MoveListener(row+1,col-1,row,col,display));
					}
						
			if(this.getColumn()!=7)
				if(display.board[row+1][col+1] instanceof Piece  && display.board[row+1][col+1].getClass().getSimpleName().equals("Blank")==false)
					if(((Piece) display.board[row+1][col+1]).getColor()==Color.black)
					{
						display.buttons[row+1][col+1].setBackground(new Color(240,230,140));
						display.buttons[row+1][col+1].addActionListener(new MoveListener(row+1,col+1,row,col,display));
					}
		}
	}

	@Override
	public void moveTo(int new_row, int new_col,int row, int col, Display display) {
		display.board[new_row][new_col] = display.board[row][col];
		display.board[new_row][new_col].setRow(new_row);
		display.board[new_row][new_col].setColumn(new_col);
		display.board[row][col] = new Blank(row,col);
		display.buttons[new_row][new_col].setIcon(display.buttons[row][col].getIcon());
		display.buttons[row][col].setIcon(new ImageIcon("res/Blank.png"));
		if(display.turn==1)
			display.turn=0;
		else display.turn =1;
		display.updateActionListeners();
	}


}
