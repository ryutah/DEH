package game.edh.game.model.items;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;

public class Sakana extends Items {

	public Sakana(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setItemId(ItemsHandler.SAKANA);
		setItemName("さかな");
		setItemMassage("さかな\n\n湖で釣れたさかな\n結構大きいけど、なんて名前のさかなかはわからない");
		setDrawable(Assets.games, "sakana");
	}

}
