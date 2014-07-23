package game.edh.game.model.items;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;

public class Hana extends Items {

	public Hana(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setItemId(ItemsHandler.HANA);
		setItemName("花");
		setItemMassage("お花\n\nきれいなお花");
		setDrawable(Assets.games, "hana");
	}

}
