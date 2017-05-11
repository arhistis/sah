package launcher;
import java.awt.Color;
import java.io.IOException;

import display.Display;
import server.Server;

public class Game {
	private Display display;
	private Server server = null;
	
	
	public Game() throws IOException{
		display = new Display();
		
	}
}
