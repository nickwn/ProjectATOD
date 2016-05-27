package apcs.atod.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import apcs.atod.world.ATODApp;



public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Project: ATOD";
		config.fullscreen = true;
		new LwjglApplication(new ATODApp(), config);
	}
}
