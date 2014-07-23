package game.edh.game.model.stage1;

import game.edh.game.model.frame.GameData;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.GamesFlag;
import game.edh.game.model.frame.Map;
import game.edh.game.screen.GameBaseScreen;

public class Stage1World extends GameWorld {

	public Stage1World(GameBaseScreen screen) {
		super(screen);
		// TODO 自動生成されたコンストラクター・スタブ
		setStageNum(1);
		setStartMap(new MapStage1(this).init());
		addMap(new MapHouse1(this).init());

		String[] flags = GamesFlag.getFlags(1);
		for(int i = 0; i < flags.length; i++) {
			addFlag(flags[i]);
		}
	}
	
	public Stage1World(GameBaseScreen screen, GameData data) {
		super(screen, data);
		setStageNum(1);
		Map stage1 = new MapStage1(this);
		addMap(stage1, data);
		addMap(new MapHouse1(this), data);
	}
}
