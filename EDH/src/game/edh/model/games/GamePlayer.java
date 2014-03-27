package game.edh.model.games;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class GamePlayer {
	enum Direction {
		Left, Right, Up, Down
	}

	public final int STAND = 0;
	public final int WALK = 1;

	private Direction dir;
	private int state;

	float scale;
	public float xPos;
	public float yPos;
	public float width;
	public float height;

	Rectangle bounds;
//	Rectangle checkBounds;
	Vector2 walk;
	Vector2 position;

	public GamePlayer(float x, float y) {
		// TODO 自動生成されたコンストラクター・スタブ
		dir = Direction.Left;
		state = STAND;

		xPos = x;
		yPos = y;
		width = 1f;
		height = 1f;

		bounds = new Rectangle();
//		checkBounds = new Rectangle();
		position = new Vector2(xPos - width * .5f, yPos - height * .5f);
		bounds.set(xPos, yPos, width, height * .5f);

		walk = new Vector2(2.0f, 2.0f);
	}

	public void move(float x, float y, float delta) {
		this.state = WALK;

		float moveX = walk.x * x * delta;
		float moveY = walk.y * y * delta;
		
		position.add(moveX, moveY);
		xPos += moveX;
		yPos += moveY;
		updateBounds();

		if (moveX >= 0) {
			if (Math.abs(moveX) <= Math.abs(moveY)) {
				if (moveY <= 0)
					dir = Direction.Down;
				else
					dir = Direction.Up;
			} else {
				dir = Direction.Right;
			}
		} else {
			if (Math.abs(moveX) <= Math.abs(moveY)) {
				if (moveY <= 0)
					dir = Direction.Down;
				else
					dir = Direction.Up;
			} else {
				dir = Direction.Left;
			}
		}
	}

	public void stop() {
		state = STAND;
	}

	private void updateBounds() {
		bounds.setCenter(position);
	}
	
//	public void updateCheckBounds() {
//		switch (dir) {
//		case Left:
//			checkBounds.set(xPos - .5f, yPos, width, height + 1f);
//			break;
//			
//		case Right:
//			checkBounds.set(xPos, yPos, width + .5f, height + 1f);
//			break;
//			
//		case Up:
//			checkBounds.set(xPos, yPos, width, height + 1.5f);
//			break;
//			
//		case Down:
//			checkBounds.set(xPos, yPos - .5f, width, height + 1f);
//		}
//	}

	public int getState() {
		return state;
	}

	public Direction getDirection() {
		return dir;
	}
	
	public float getX() {
		return xPos;
	}
	
	public float getY() {
		return yPos;
	}
	
	public Vector2 getOrigin() {
		return position;
	}
	
	public void setPosition(float x, float y) {
		bounds.setPosition(x, y);
		position.set(x + width / 2, y + height / 2);
	}
	
	public void setBounds(Rectangle rect) {
		bounds.set(rect);
		position.set(rect.getX() + width / 2, rect.getY() + height / 2);
	}
	
	public Rectangle getBounds() {
		return bounds;
	}
	
//	public Rectangle getCheckBounds() {
//		return checkBounds;
//	}
}