package game.edh.game.model.items;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;

public class Houcho extends Items {

	public Houcho(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setItemId(ItemsHandler.HOUCHO);
		setItemName("ほうちょう");
		setItemMassage("ほうちょう\n\n料理で使うほうちょう\n子供が１人で使うのはとても危険");
		setDrawable(Assets.games, "houcho");
	}

}
