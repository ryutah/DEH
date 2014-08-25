package game.edh;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "DEH";
		cfg.width = 432;
		cfg.height = 768;

		new LwjglApplication(new EdhGame(), cfg);
	}
}
