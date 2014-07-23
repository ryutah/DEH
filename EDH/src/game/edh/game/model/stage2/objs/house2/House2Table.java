package game.edh.game.model.stage2.objs.house2;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage2Flag;
import game.edh.game.model.items.ItemsHandler;

public class House2Table extends MapObject {

	public House2Table(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(1, 4, 2, 4);
	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		if (world.getFlag(Stage2Flag.NINGYO_PUT)) {
			world.textEvent("テーブルの上に２つの人形が置かれている", "どちらの人形もとても見覚えがある…");
		} else {
			if (world.getSelectItem() == ItemsHandler.NINGYOAO) {
				world.removeItem(ItemsHandler.NINGYOAO);
				world.changeFlag(Stage2Flag.NINGYO_PUT, true);
				world.textEvent("人形をテーブルの上に置いた", "また何かを思い出した気がする…");
			} else
				world.textEvent("テーブルの上には人形が１体置かれている", "やっぱり何か足りないような…");

		}
	}
}
