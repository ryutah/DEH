package game.edh.game.screen;

import game.edh.EdhGame;
import game.edh.game.model.frame.GameData;
import game.edh.game.model.stage4.Stage4World;
import game.edh.screen.LoadScreen;
import game.edh.screen.LoadScreen.NextScreen;

public class ScreenStage4 extends GameBaseScreen {

	public ScreenStage4(EdhGame game) {
		super(game);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public ScreenStage4(EdhGame game, GameData data) {
		super(game, data);
	}

	@Override
	void genWorldClass() {
		// TODO 自動生成されたメソッド・スタブ
		setWorldClass(new Stage4World(this));
	}

	@Override
	public void stageEnd() {
		// TODO 自動生成されたメソッド・スタブ
		countinueMusic();
		super.stageEnd();
		changeScreen(new LoadScreen(edh, NextScreen.EVENT8));
	}

	@Override
	void genWorldClass(GameData data) {
		// TODO 自動生成されたメソッド・スタブ
		setWorldClass(new Stage4World(this, data).load());
	}

}
