package game.edh.game.model.frame;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class ModelGameChara {
	public enum GameCharaDir {
		Left, Right, Up, Down
	}

	public static int MOVE = 0;
	public static int STAND = 1;

	String name;
	boolean remove;

	Vector2 position;
	Vector2 moveSpeed;
	GameCharaDir dir;
	int state;
	Rectangle bounds;
	Rectangle check;

	GameWorld world;

	public ModelGameChara(GameWorld world) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.world = world;

		position = new Vector2();
		moveSpeed = new Vector2(5, 5);
		bounds = new Rectangle();
		bounds.setWidth(1);
		bounds.setHeight(1);
		check = new Rectangle();
		dir = GameCharaDir.Left;
		state = STAND;

		remove = false;
	}

	/**
	 * キャラクターを引数だけ移動させる
	 * @param moveX
	 * @param moveY
	 */
	public void move(float moveX, float moveY) {
		position.add(moveX, moveY);
		bounds.x += moveX;
		bounds.y += moveY;
		state = MOVE;
	}

	/**
	 * プレイヤーを停止させる
	 */
	public void stop() {
		state = STAND;
	}

	public void check() {

	}

	public void update(float delta) {

	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDirection(float degree) {
		if (Math.abs(degree) <= 45)
			dir = GameCharaDir.Right;
		else if (Math.abs(degree) >= 135)
			dir = GameCharaDir.Left;
		else if (degree > 45 && degree < 135)
			dir = GameCharaDir.Up;
		else if (degree < -45 && degree > -135)
			dir = GameCharaDir.Down;
	}

	public void setBounds(float x, float y, float width, float height) {
		bounds.set(x, y, width, height);
		position.set(x + bounds.width / 2, y + bounds.height / 2);
	}

	public void setPosition(float x, float y) {
		position.set(x, y);
		bounds.setPosition(x - bounds.width / 2, y - bounds.height / 2);
	}

	public void setDirection(GameCharaDir dir) {
		this.dir = dir;
	}

	public void setSpeed(float x, float y) {
		moveSpeed.set(x, y);
	}

	public String getName() {
		return name;
	}

	public Vector2 getPosition() {
		return position;
	}

	public Vector2 getSpeed() {
		return moveSpeed;
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public Rectangle getCheckBounds() {
		float x = bounds.x;
		float y = bounds.y;
		float width = bounds.width;
		float height = bounds.height;

		switch (dir) {
		case Left:
			check.set(x - .5f, y, width + .5f, height);
			break;
		case Right:
			check.set(x, y, width + .5f, height);
			break;
		case Up:
			check.set(x, y, width, height + .5f);
			break;
		case Down:
			check.set(x, y - .5f, width, height + .5f);
			break;
		}
		return check;
	}

	public int getState() {
		return state;
	}

	public GameCharaDir getDirection() {
		return dir;
	}
}
