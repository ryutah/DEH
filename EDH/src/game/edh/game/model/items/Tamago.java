package game.edh.game.model.items;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;

public class Tamago extends Items {

	public Tamago(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setItemId(ItemsHandler.TAMAGO);
		setItemName("たまご");
		setItemMassage("たまご\n\nにわとりのたまご\n投げてぶつけると意外と痛い");
		setDrawable(Assets.games, "tamago");
	}

}
