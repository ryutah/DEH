package game.edh.game.model.items;

import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;

public class NingyoAka extends Items {

	public NingyoAka(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setItemId(ItemsHandler.NINGYOAKA);
		setItemName("人形");
		setDrawable(Assets.games.get("ningyoAka", TextureRegionDrawable.class));
		setItemMassage("赤い人形\n \nたぶん手作りの人形\nなんだか懐かしい気がする");
	}

}
