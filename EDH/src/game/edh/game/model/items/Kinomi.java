package game.edh.game.model.items;

import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;

public class Kinomi extends Items {

	public Kinomi(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setItemName("きのみ");
		setItemId(ItemsHandler.KINOMI_4);
		setDrawable(Assets.games.get("kinomi4", TextureRegionDrawable.class));
		setItemMassage("きのみ \n\n テスト");
	}

}
