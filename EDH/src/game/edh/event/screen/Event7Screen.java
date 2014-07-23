package game.edh.event.screen;

import game.edh.Assets;
import game.edh.EdhGame;
import game.edh.event.actor.ActorNoise;
import game.edh.event.model.Event7;
import game.edh.frame.BaseScreen;
import game.edh.screen.LoadScreen;
import game.edh.screen.LoadScreen.NextScreen;

public class Event7Screen extends EventScreen {

	public Event7Screen(EdhGame game, boolean backTitle) {
		super(game, backTitle);
		// TODO 自動生成されたコンストラクター・スタブ
		setMusic(Assets.MORUDAU);
	}

	@Override
	void genEventWorld() {
		// TODO 自動生成されたメソッド・スタブ
		world = new Event7(this);
	}
	
	@Override
	void initEventGroups() {
		// TODO 自動生成されたメソッド・スタブ
		ActorNoise noise = new ActorNoise();
		mainTable.addActor(noise);
		noise.setZIndex(1);
	}

	@Override
	public BaseScreen nextScreen() {
		// TODO 自動生成されたメソッド・スタブ
		countinueMusic();
		return new LoadScreen(edh, NextScreen.STAGE4);
	}

}
