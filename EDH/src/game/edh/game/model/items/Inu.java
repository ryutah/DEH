package game.edh.game.model.items;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;

public class Inu extends Items {

	public Inu(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setItemId(ItemsHandler.INU);
		setItemName("犬");
		setItemMassage("犬のぬいぐるみ", "手作りのぬいぐるみみたい\nとっても懐かしい気がする…");
		setDrawable(Assets.games, "inu");
	}

}
