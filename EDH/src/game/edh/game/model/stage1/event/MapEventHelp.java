package game.edh.game.model.stage1.event;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.Map;
import game.edh.game.model.frame.ModelMapEvent;

public class MapEventHelp extends ModelMapEvent {

	public MapEventHelp(GameWorld world, Map map) {
		super(world, map);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public void startMapEvent() {
		// TODO 自動生成されたメソッド・スタブ
		world.textEvent("操作方法を説明しようか？");
	}

	@Override
	public void textEnd() {
		// TODO 自動生成されたメソッド・スタブ
		world.addEventObj(new EventHelp(world));
	}

}
