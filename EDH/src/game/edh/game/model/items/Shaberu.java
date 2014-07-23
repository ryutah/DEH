package game.edh.game.model.items;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;

public class Shaberu extends Items {

	public Shaberu(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setItemId(ItemsHandler.SHABERU);
		setItemName("シャベル");
		setItemMassage("シャベル\n\n土を掘れる\nおもちゃだけど手で掘るよりは楽そう");
		setDrawable(Assets.games, "shaberu");
	}

}
