package display;


import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import launcher.Blank;
import launcher.Pawn;
import launcher.Piece;
import launcher.Tile;

public class Display {

	private JFrame frame;
	
	private String title = "Chess";
	public JButton[][] buttons = new JButton[8][8];
	public Tile[][] board = new Tile[8][8];
	public int turn = 0;
	
	public Display(){
		for(int i=0; i<8; i++)
			for(int j=0; j<8; j++)
				this.board[i][j]= new Blank(i,j);
		this.board[6][3]= new Pawn(6,3,Color.WHITE);
		this.board[5][4]= new Pawn(5,4,Color.BLACK);
		this.board[5][2]= new Pawn(5,2,Color.BLACK);
		createDisplay();
	}
	
	public void createDisplay(){
		frame = new JFrame(title);
		
		frame.setBounds(100,100,720,720);
		frame.setResizable(false);
		GridBagConstraints constraints= new GridBagConstraints();
        
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		frame.setLayout(new GridBagLayout());
		
		
		for(int row=0; row<8; row++)
			for(int col=0; col<8; col++)
			{
				ImageIcon image = new ImageIcon("res/Blank.png");
				buttons[row][col]= new JButton(image);
				buttons[row][col].setFocusable(false);
				
				buttons[row][col].setOpaque(true);
				buttons[row][col].setBorderPainted(false);
					
				
				if(board[row][col].getClass().getSimpleName().equals("Pawn"))
				{
					if(((Piece) board[row][col]).getColor()==Color.white)
						image = new ImageIcon("res/PawnWhite.png");
					else image = new ImageIcon("res/PawnBlack.png");
					buttons[row][col].setIcon(image);
					//buttons[row][col].addActionListener(new SelectionListener(this,row,col));
					
				}
				
				constraints.weightx=1;
				constraints.weighty=1;
				constraints.gridx=col;
				constraints.gridy=row;
				constraints.fill=GridBagConstraints.BOTH;
				frame.add(buttons[row][col], constraints);
			}
		
		frame.setVisible(true);
		updateActionListeners();
	}
	
	public void deselect(){

		for(int row=0; row<8; row++)
			for(int col=0; col<8; col++)
			{
				if( (row+col) % 2 == 1)
					buttons[row][col].setBackground(new Color(118,150,86));
				else
					buttons[row][col].setBackground(new Color(238,238,210));
			}
	}
	
	public void updateActionListeners(){
		deselect();
		for(int row=0; row<8; row++)
			for(int col=0; col<8; col++)
			{
				for( ActionListener al : buttons[row][col].getActionListeners() )
			    	buttons[row][col].removeActionListener( al );
				
				if(board[row][col].getClass().getSimpleName().equals("Blank")==false)
				{
					if( ((Piece)board[row][col]).getColor()==Color.white && turn==0)
						buttons[row][col].addActionListener(new SelectionListener(this,row,col));
					else if( ((Piece)board[row][col]).getColor()==Color.black && turn==1)
						buttons[row][col].addActionListener(new SelectionListener(this,row,col));
						
				}
				    
			}
	}
	
}
