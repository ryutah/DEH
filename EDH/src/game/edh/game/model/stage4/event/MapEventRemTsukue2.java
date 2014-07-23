package game.edh.game.model.stage4.event;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.ModelMapEvent;
import game.edh.game.model.frame.GamesFlag.Stage4Flag;

public class MapEventRemTsukue2 extends ModelMapEvent {

	public MapEventRemTsukue2(GameWorld world) {
		super(world, world.getMap());
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public void startMapEvent() {
		// TODO 自動生成されたメソッド・スタブ
		world.textEvent("テーブルに乗っているのは、２人で遊んだお人形", "赤いのが私で青いのがあの子",
				"この２人は姉妹で青い方がおねえちゃん", "犬のお人形は私とあの子２人で作った、この姉妹の飼い犬だった",
				"いっつも仲良しの素敵な姉妹…\n現実でもそうだと良かったのに");
	}

	@Override
	public void textEnd() {
		// TODO 自動生成されたメソッド・スタブ
		world.changeFlag(Stage4Flag.RIM_TSUKUE2, true);
		endMapEvent();
	}

}
