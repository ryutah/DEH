package game.edh.game.model.stage4.event;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.ModelMapEvent;
import game.edh.game.model.frame.GamesFlag.Stage4Flag;

public class MapEventRemInu extends ModelMapEvent {

	public MapEventRemInu(GameWorld world) {
		super(world, world.getMap());
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public void startMapEvent() {
		// TODO 自動生成されたメソッド・スタブ
		world.textEvent("名前もつけてあげられなかったけど、ホントはあの日考えてあげるつもりだった", "あの子との思い出は",
				"あの日あなたといっしょに置いてきてしまって", "もう夢の中でしか思い出すことはなくなった…");
	}

	@Override
	public void textEnd() {
		// TODO 自動生成されたメソッド・スタブ
		world.changeFlag(Stage4Flag.RIM_INU, true);
		endMapEvent();
	}

}
