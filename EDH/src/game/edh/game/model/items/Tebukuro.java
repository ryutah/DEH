package game.edh.game.model.items;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;

public class Tebukuro extends Items {

	public Tebukuro(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setItemId(ItemsHandler.TEBUKURO);
		setItemName("手袋");
		setItemMassage("てぶくろ\n\n手編みのてぶくろ\nとてもあたたかい…");
		setDrawable(Assets.games, "tebukuro");
	}

}
