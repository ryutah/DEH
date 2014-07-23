package game.edh.game.model.stage4.event;

import game.edh.EdhGame;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.Map;
import game.edh.game.model.frame.ModelMapEvent;
import game.edh.game.model.stage4.MapHouseLast;

public class MapEventRyouri extends ModelMapEvent {

	public MapEventRyouri(GameWorld world, Map map) {
		super(world, map);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public void startMapEvent() {
		// TODO 自動生成されたメソッド・スタブ
		world.textEvent("料理をテーブルに置いた", "そうだった…", "２人で遊ぶ時は、いつもここでご飯を食べてたっけ");
	}

	@Override
	public void textEnd() {
		// TODO 自動生成されたメソッド・スタブ
		world.changeMap(MapHouseLast.NAME, 2f);
		endMapEvent();
		EdhGame.music.stopMusic();
	}

}
