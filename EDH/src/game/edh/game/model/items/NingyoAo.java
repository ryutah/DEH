package game.edh.game.model.items;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;

public class NingyoAo extends Items {

	public NingyoAo(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setItemId(ItemsHandler.NINGYOAO);
		setItemName("人形青");
		setItemMassage("女の子の人形\n\n青い服を着た女の子の人形\nこれも手作りかな");
		setDrawable(Assets.games, "ningyoAo");
	}

}
