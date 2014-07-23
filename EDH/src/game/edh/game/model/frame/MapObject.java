package game.edh.game.model.frame;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class MapObject {
	Rectangle bounds;
	String name;
	Drawable drawable;
	public boolean collision;
	public boolean draw;
	public boolean check;
	public boolean remove;

	protected GameWorld world;

	public MapObject(GameWorld world) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.world = world;
		bounds = new Rectangle();
		check = true;
	}

	public MapObject(float x, float y, float width, float height, String name,
			GameWorld world) {
		// TODO 自動生成されたコンストラクター・スタブ
		bounds = new Rectangle(x, y, width, height);
		this.name = name;
		this.world = world;
		check = true;
	}
	
	public void update(float delta) {
		
	}

	public void checkObj() {

	}

	public void setBounds(float x, float y, float width, float height) {
		bounds.set(x, y, width, height);
	}
	
	public void setPosition(float x, float y) {
		bounds.setPosition(x, y);
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setCollision(boolean collision) {
		this.collision = collision;
	}
	
	public void setCheck(boolean check) {
		this.check = check;
	}
	
	public void setDraw(boolean draw) {
		this.draw = draw;
	}
	
	public void setDrawable(Drawable drawable) {
		this.drawable = drawable;
		draw = true;
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public String getName() {
		return name;
	}
	
	public Drawable getDrawable() {
		return drawable;
	}
	
	public void remove() {
		remove = true;
	}
}
