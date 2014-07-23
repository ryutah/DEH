package game.edh.game.model.stage4.event;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.ModelMapEvent;
import game.edh.game.model.frame.GamesFlag.Stage4Flag;

public class MapEventRemBed extends ModelMapEvent {

	public MapEventRemBed(GameWorld world) {
		super(world, world.getMap());
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public void startMapEvent() {
		// TODO 自動生成されたメソッド・スタブ
		world.textEvent("ここに泊まる時はこのベッドで寝てたっけ",
				"いつまでたってもお話してて寝ないから、あの子のパパに怒られて",
				"それでも話はやめないで\n小さな声でこそこそお喋りしてた");
	}

	@Override
	public void textEnd() {
		// TODO 自動生成されたメソッド・スタブ
		world.changeFlag(Stage4Flag.RIM_BED, true);
		endMapEvent();
	}

}
