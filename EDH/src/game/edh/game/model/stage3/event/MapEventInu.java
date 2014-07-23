package game.edh.game.model.stage3.event;

import com.badlogic.gdx.Gdx;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.Map;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.ModelMapEvent;
import game.edh.game.model.frame.GamesFlag.Stage3Flag;

public class MapEventInu extends ModelMapEvent {
	MapObject inu;

	public MapEventInu(GameWorld world, Map map) {
		super(world, map);
		// TODO 自動生成されたコンストラクター・スタブ
		inu = map.getObj("inu");
		if (inu != null)
			Gdx.app.log("Event", inu.getName());
	}

	@Override
	public void startMapEvent() {
		// TODO 自動生成されたメソッド・スタブ
		world.textEvent("『だいぶ思い出せてきたかな』", "『最後に僕の足元を調べてみて…』",
				"『君は知らないだろうけど、僕はここにずっといたんだ』", "『でも、君がそんな事を気にする必要はないよ』",
				"『今まで起きたことも、これから起こることも、全部ただの夢だから』", "『…さようなら、もうこんなところにきちゃだめだよ』");
	}

	@Override
	public void textEnd() {
		// TODO 自動生成されたメソッド・スタブ
		inu.setDraw(false);
		inu.setCollision(false);
		inu.setCheck(false);
		world.changeFlag(Stage3Flag.DELETE_INU, true);
		endMapEvent();
	}

}
