package game.edh.game.model.items;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;

public class Kanazuti extends Items {

	public Kanazuti(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setItemId(ItemsHandler.KANAZUTI);
		setItemName("かなずち");
		setItemMassage("金槌", "釘を打ったりする\n金槌というよりハンマーに見える");
		setDrawable(Assets.games, "kanazuti");
	}

}
