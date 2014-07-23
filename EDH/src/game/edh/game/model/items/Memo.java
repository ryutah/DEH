package game.edh.game.model.items;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;

public class Memo extends Items {

	public Memo(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setItemId(ItemsHandler.MEMO);
		setItemMassage("料理メモ", "たまねぎ、にんじん、きのこをバターで炒めてね",
				"鍋に入れたら塩と胡椒で味を整えてできあがり！", "お魚を入れるともっとおいしくなるわ！",
				"きのこはたっぷり２つ入れると具だくさんでいいかもね");
		setItemName("メモ");
		setDrawable(Assets.games, "memo");
	}

}
