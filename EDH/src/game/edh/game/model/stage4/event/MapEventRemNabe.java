package game.edh.game.model.stage4.event;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.ModelMapEvent;
import game.edh.game.model.frame.GamesFlag.Stage4Flag;

public class MapEventRemNabe extends ModelMapEvent {

	public MapEventRemNabe(GameWorld world) {
		super(world, world.getMap());
		// TODO 自動生成されたコンストラクター・スタブ

	}

	@Override
	public void startMapEvent() {
		// TODO 自動生成されたメソッド・スタブ
		world.textEvent("この家に来る時は、あの子がいつもお料理を作ってくれた",
				"いっしょに森で食べ物をとってきて、たまに私もお手伝いした",
				"あの日作ってくれるはずだった料理…私が子供すぎたから食べられなかった",
				"もう少し大人になれていたら、あの日もいっしょにご飯を食べられたのかな…");
	}

	@Override
	public void textEnd() {
		// TODO 自動生成されたメソッド・スタブ
		world.changeFlag(Stage4Flag.RIM_NABE, true);
		endMapEvent();
	}

}
