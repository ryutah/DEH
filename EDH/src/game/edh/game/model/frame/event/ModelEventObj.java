package game.edh.game.model.frame.event;

import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.GameWorld.GameState;
import game.edh.game.model.frame.event.ModelEvent.ObjType;

public class ModelEventObj {
	float x, y, size;
	public boolean centerX, centerY;
	ObjType type;
	ButtonStyle button;
	Drawable drawable;

	protected GameWorld world;
	protected ModelEvent parent;

	public ModelEventObj(ModelEvent parent, ObjType type) {
		// TODO 自動生成されたコンストラクター・スタブ
		world = parent.getWorld();
		this.parent = parent;
		this.type = type;
		centerX = centerY = false;
	}

	public void tap(float x, float y) {
		if (world.getState() == GameState.EVENT)
			action(x, y);
		else
			world.tap();
	}

	public boolean fling(float velocityX, float velocityY) {
		if (world.getState() == GameState.EVENT)
			return flingAction(velocityX, velocityY);

		return false;
	}

	protected boolean flingAction(float velocityX, float velocityY) {
		if (Math.abs(velocityX) >= 300 || Math.abs(velocityY) >= 300) {
			defaultFlingAction();
			return true;

		}
		return false;
	}

	void defaultFlingAction() {
		world.textEvent("特に何もおこらない");
	}

	protected boolean longTapAction() {
		defaultLongTapAction();
		return true;
	}

	void defaultLongTapAction() {
		world.textEvent("よく見てみたけど、何もなさそう");
	}

	protected void action(float x, float y) {

	}

	public boolean longTap() {
		if (world.getState() == GameState.EVENT)
			return longTapAction();

		return false;
	}

	public void setPosition(float x, float y) {
		centerX = centerY = false;
		this.x = x;
		this.y = y;
	}

	public void setX(float x) {
		centerX = false;
		this.x = x;
	}

	public void setY(float y) {
		centerY = false;
		this.y = y;
	}

	public void setCenter(boolean center) {
		centerX = centerY = center;
	}

	public void setCenterX(boolean center) {
		centerX = center;
	}

	public void setCenterY(boolean center) {
		centerY = center;
	}

	public void setSize(float size) {
		this.size = size;
	}

	public void setDrawable(Drawable drawable) {
		this.drawable = drawable;
	}

	public void setDrawable(Skin skin, String name) {
		drawable = skin.get(name, TextureRegionDrawable.class);
	}

	public void setButtonStyle(ButtonStyle button) {
		this.button = button;
	}

	public void setButtonStyle(Skin skin, String name) {
		button = skin.get(name, ButtonStyle.class);
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getSize() {
		return size;
	}

	public ObjType getType() {
		return type;
	}

	public Drawable getDrawable() {
		return drawable;
	}

	public ButtonStyle getButtonStyle() {
		return button;
	}
}
