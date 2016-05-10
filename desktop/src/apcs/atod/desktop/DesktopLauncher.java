package apcs.atod.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import apcs.atod.world.ATODApp;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = 300;
		config.width = 300;
		config.resizable = false;
		config.title = "Project: ATOD";
		new LwjglApplication(new ATODApp(), config);
	}
}
