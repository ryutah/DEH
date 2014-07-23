package game.edh.game.model.items;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;

public class Memo2 extends Items {

	public Memo2(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setItemId(ItemsHandler.MEMO2);
		setItemName("メモ２");
		setItemMassage("お料理メモ", "おさかなとにんじんを塩胡椒で炒めて、最後に卵を上に乗っける", "簡単！ボリューム満点！");
		setDrawable(Assets.games, "memo");
	}

}
