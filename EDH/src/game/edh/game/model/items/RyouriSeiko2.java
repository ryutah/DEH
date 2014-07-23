package game.edh.game.model.items;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;

public class RyouriSeiko2 extends Items {

	public RyouriSeiko2(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setDrawable(Assets.games, "ryouri");
		setItemId(ItemsHandler.RYOURI_SEIKO2);
		setItemName("料理2");
		setItemMassage("料理\n \nさっき作った料理\n美味しそうだけど、今は食べる気がしない");
	}

}
