package game.edh.game.model.items;

import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;

public class Kagi extends Items {

	public Kagi(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setItemId(ItemsHandler.KAGI);
		setDrawable(Assets.games.get("key", TextureRegionDrawable.class));
		setItemName("工具箱の鍵");
		setItemMassage("何かの鍵\n　\nどこかに使えるところがありそう");
	}

}
