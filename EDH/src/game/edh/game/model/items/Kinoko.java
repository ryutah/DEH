package game.edh.game.model.items;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;

public class Kinoko extends Items {

	public Kinoko(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setItemId(ItemsHandler.KINOKO);
		setItemName("きのこ");
		setItemMassage("きのこ\n\n丸太に生えていたきのこ\n冬の森はあんまり食べ物が取れないから結構貴重");
		setDrawable(Assets.games, "kinoko");
	}

}
