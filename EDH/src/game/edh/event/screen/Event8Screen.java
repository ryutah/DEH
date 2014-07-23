package game.edh.event.screen;

import com.badlogic.gdx.scenes.scene2d.Group;

import game.edh.Assets;
import game.edh.EdhGame;
import game.edh.event.actor.ActorNoise;
import game.edh.event.actor.CresitGroup;
import game.edh.event.model.Event8;
import game.edh.event.model.EventWorld;
import game.edh.frame.BaseScreen;
import game.edh.screen.LoadScreen;
import game.edh.screen.LoadScreen.NextScreen;

public class Event8Screen extends EventScreen {
	ActorNoise noise;
	boolean cresit;

	public Event8Screen(EdhGame game, boolean backTitle) {
		super(game, backTitle);
		// TODO 自動生成されたコンストラクター・スタブ
		countinueMusic();
		if (EdhGame.music.getNowMusic() != Assets.KAREHA)
			setMusic(Assets.KAREHA);
	}

	@Override
	public void tap() {
		// TODO 自動生成されたメソッド・スタブ
		if (!cresit)
			super.tap();
		else
			checkNextScreen();
	}

	@Override
	void genEventWorld() {
		// TODO 自動生成されたメソッド・スタブ
		world = new Event8(this);
	}

	@Override
	void initEventGroups() {
		// TODO 自動生成されたメソッド・スタブ
		noise = new ActorNoise();
		mainTable.addActor(noise);
		noise.setZIndex(1);
	}

	@Override
	public void changeWorld(EventWorld world) {
		// TODO 自動生成されたメソッド・スタブ
		super.changeWorld(world);
	}

	@Override
	public void changeWorldEnd() {
		// TODO 自動生成されたメソッド・スタブ
		if (noise != null) {
			mainTable.removeActor(noise);
			noise = null;
		}
	}

	@Override
	public BaseScreen nextScreen() {
		// TODO 自動生成されたメソッド・スタブ
		return new LoadScreen(edh, NextScreen.TITLE);
	}

	public void endGame() {
		group.hide(2.0f);
		EdhGame.music.stopMusic();
	}

	@Override
	public void hideGoupEnd() {
		// TODO 自動生成されたメソッド・スタブ
		Group group = new CresitGroup();
		mainTable.removeActor(this.group);
		cresit = true;
		mainTable.addActor(group);
		group.setZIndex(0);
		EdhGame.music.changeMusic(Assets.THAIKOV);
		EdhGame.music.playMusic();
	}
}
