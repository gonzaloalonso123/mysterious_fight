package Main;
import javax.swing.JFrame;

public class MainFrame extends JFrame {

	MainFrame()
	{	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		GameEngine game = new GameEngine();
		
		add(game);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
}
