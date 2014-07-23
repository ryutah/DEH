package game.edh.game.model.items;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;

public class Spice extends Items {

	public Spice(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setItemId(ItemsHandler.SPICE);
		setItemName("スパイス");
		setItemMassage("スパイス\n\n料理で使うスパイス\n料理以外で使うことってあるのかな？");
		setDrawable(Assets.games, "spice");
	}

}
