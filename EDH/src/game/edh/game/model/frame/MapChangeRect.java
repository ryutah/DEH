package game.edh.game.model.frame;

import game.edh.game.model.frame.ModelGameChara.GameCharaDir;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class MapChangeRect {
	Rectangle rect;
	Vector2 changePos;
	GameCharaDir dir;
	String name;

	public MapChangeRect(float x, float y, float width, float height) {
		// TODO 自動生成されたコンストラクター・スタブ
		rect = new Rectangle(x, y, width, height);
		dir = null;
	}

	public MapChangeRect(float x, float y, float width, float height,
			String name) {
		rect = new Rectangle(x, y, width, height);
		this.name = name;
	}

	public void setBounds(float x, float y, float width, float height) {
		rect.set(x, y, width, height);
	}
	
	public void setChangeParam(float x, float y, GameCharaDir dir) {
		changePos = new Vector2();
		changePos.set(x, y);
		this.dir = dir;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Rectangle getBounds() {
		return rect;
	}
	
	public Vector2 getChangePos() {
		return changePos;
	}
	
	public GameCharaDir getChangeDir() {
		return dir;
	}

	public String getName() {
		return name;
	}
}
