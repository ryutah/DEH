package game.edh.game.model.stage2;

import game.edh.game.model.frame.GameData;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.GamesFlag;
import game.edh.game.screen.GameBaseScreen;

public class Stage2World extends GameWorld {

	public Stage2World(GameBaseScreen screen) {
		super(screen);
		// TODO 自動生成されたコンストラクター・スタブ
		setStageNum(2);
		setStartMap(new MapStage2(this).init());
		addMap(new MapMayoinomori(this).init());
		addMap(new MapMizuumi(this).init());
		addMap(new MapHouse2(this).init());
		addMap(new MapStage2_2(this).init());
		addMap(new MapStage2_3(this).init());
		
		String[] flags = GamesFlag.getFlags(2);
		for(int i = 0; i < flags.length; i++) {
			addFlag(flags[i]);
		}
	}
	
	public Stage2World(GameBaseScreen screen, GameData data) {
		super(screen, data);
		setStageNum(2);
		addMap(new MapStage2(this), data);
		addMap(new MapHouse2(this), data);
		addMap(new MapMayoinomori(this), data);
		addMap(new MapMizuumi(this), data);
		addMap(new MapStage2_2(this), data);
		addMap(new MapStage2_3(this), data);
	}

}
