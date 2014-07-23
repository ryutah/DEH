package game.edh.game.model.stage2.objs.map23;

import game.edh.EdhGame;
import game.edh.MusicHandler.EfftctType;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage2Flag;
import game.edh.game.model.items.ItemsHandler;

public class Map23KirikabuObj extends MapObject {

	public Map23KirikabuObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(13, 6, 2, 1.5f);
		setCollision(true);
	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		if (!world.getFlag(Stage2Flag.KIRIKABU)) {
			if (world.getSelectItem() == ItemsHandler.HOUCHO) {
				EdhGame.music.playEffect(EfftctType.KIRU, false);
				world.textEvent("包丁を使って、なんとなく思いついた事をほってみた", "”おいしいのが食べたい！ ”");
				world.changeFlag(Stage2Flag.KIRIKABU, true);
			} else
				world.textEvent("切り株には文字が刻まれている…", "”今日のご飯はどうしようか？ ”");
		} else
			world.textEvent("切り株の文字が変わっている…", "”今日は２品作っちゃう！",
					"なすとトマトを塩とオリーブオイルで味つけしたのと…", "あと１つはひみつ！ ”");
	}

}
