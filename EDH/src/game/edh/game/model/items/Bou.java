package game.edh.game.model.items;

import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;

public class Bou extends Items {

	public Bou(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setItemId(ItemsHandler.BOU);
		setItemName("木の棒");
		setItemMassage("木の棒\n\n丈夫そうな木の棒だ");
		setDrawable(Assets.games.get("bou", TextureRegionDrawable.class));
	}

}
