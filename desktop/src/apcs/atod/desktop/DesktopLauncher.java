package apcs.atod.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import apcs.atod.world.ATODApp;
<<<<<<< HEAD
=======
//import apcs.atod.test.*;
>>>>>>> fe85903eae532e3544ef487e0a9e47704b350689

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Project: ATOD";
		new LwjglApplication(new ATODApp(), config);
	}
}
