package game.edh.game.model.items;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.GameWorld.GameState;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public abstract class Items {
	int itemId;
	String itemName;
	Drawable drawable;
	String[] itemMassage;

	protected GameWorld world;

	public Items(GameWorld world) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.world = world;
	}

	public void tap() {
		world.selectItem(this);
		Gdx.app.log("Tap", "");
	}

	public void longTap() {
		if (world.getState() == GameState.NOMAL
				|| world.getState() == GameState.EVENT)
			world.textEvent(itemMassage);
		Gdx.app.log("LongTap", "");
	}

	protected void setItemId(int itemId) {
		this.itemId = itemId;
	}

	protected void setItemName(String itemName) {
		this.itemName = itemName;
	}

	protected void setItemMassage(String... itemMassage) {
		this.itemMassage = itemMassage;
	}

	protected void setDrawable(Drawable drawable) {
		this.drawable = drawable;
	}

	protected void setDrawable(Skin skin, String name) {
		TextureRegionDrawable drawable = skin.get(name,
				TextureRegionDrawable.class);
		setDrawable(drawable);
	}

	public int getItemId() {
		return itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public String[] getItemMassage() {
		return itemMassage;
	}

	public Drawable getDrawable() {
		return drawable;
	}
}
