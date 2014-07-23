package game.edh.event.model;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class Character {
	public enum CharaDirection {
		LEFT, RIGHT
	}

	EventWorld world;
	Vector2 position;
	CharaDirection dir;
	Drawable drawable;
	protected boolean show;
	protected int state;
	protected float stateTime;

	String name;
	float moveX;
	float width, height;
	boolean move;
	boolean moveLeft;

	public Character(EventWorld world) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.world = world;
		position = new Vector2();
		move = false;
	}

	public void setPosition(float x, float y) {
		position.set(x, y);
	}

	public void setDirection(CharaDirection dir) {
		this.dir = dir;
	}

	public void setState(int state) {
		this.state = state;
	}

	public void setShow(boolean show) {
		this.show = show;
	}

	public boolean getShow() {
		return show;
	}

	public void setDrawable(Drawable drawable) {
		this.drawable = drawable;
	}

	public Drawable getDrawable() {
		return drawable;
	}

	public void setSize(float width, float height) {
		this.width = width;
		this.height = height;
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

	public void update(float delta) {
		if (move)
			move(delta);
	}

	public void moveTo(float moveX) {
		this.moveX = moveX;

		if (moveX <= position.x) {
			moveLeft = true;
			if (Math.abs(position.x - moveX) >= 4) {
				position.x -= 4;
				move = true;
			} else
				position.x = moveX;
		} else {
			if (Math.abs(position.x - moveX) >= 4) {
				position.x += 4;
				move = true;
			} else
				position.x = moveX;
		}
	}

	private void move(float delta) {
		stateTime += delta;
		if (stateTime >= 1.5f) {
			if (moveLeft) {
				position.x -= 4;
				if (position.x <= moveX) {
					position.x = moveX;
					move = false;
					world.charaMoveEnd();
				}
			} else {
				position.x += 4;
				if (position.x >= moveX) {
					position.x = moveX;
					move = false;
					world.charaMoveEnd();
				}
			}

			stateTime = 0;
		}
	}

	public CharaDirection getDirection() {
		return dir;
	}

	public float getX() {
		return position.x;
	}

	public Vector2 getPosition() {
		return position;
	}

	public int getState() {
		return state;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
