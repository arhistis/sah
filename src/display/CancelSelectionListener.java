package display;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

	public class CancelSelectionListener implements ActionListener {
	private Display display;
	
	public CancelSelectionListener(Display d){
		this.display = d;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		display.updateActionListeners();
		
	}
}
