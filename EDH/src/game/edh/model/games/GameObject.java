package game.edh.model.games;

import com.badlogic.gdx.math.Rectangle;

public abstract class GameObject {
	Rectangle bounds;
	public World world;

	public int state;
	public final int NOT_CLEAR = 0;
	public final int CLEAR = 1;

	public GameObject(float x, float y, float width, float height, World world) {
		// TODO 自動生成されたコンストラクター・スタブ
		bounds = new Rectangle(x, y, width, height);
		this.world = world;
		state = 0;
	}
	
	public void init() {
		this.state = NOT_CLEAR;
	}

	public Rectangle getBounds() {
		return bounds;
	}
	
	protected void changeState(int state) {
		this.state = state;
	}

	public abstract void eventOcer();
}
