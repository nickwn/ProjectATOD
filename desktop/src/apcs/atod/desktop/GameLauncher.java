package apcs.atod.desktop;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GameLauncher {

	public static void main(String[] args) throws Exception {
//		SplashScreen splash = new SplashScreen();
		JFrame jFrame = new JFrame();
		int answer = JOptionPane.showConfirmDialog(jFrame, "Would you like to play Project ATOD in fullscreen?");
		if (answer == JOptionPane.YES_OPTION) {
			DesktopLauncher.init(true);
		} else if (answer == JOptionPane.NO_OPTION) {
			DesktopLauncher.init(false);
		} else {
			
		}
	}
}
