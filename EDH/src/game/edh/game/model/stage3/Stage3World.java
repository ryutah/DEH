package game.edh.game.model.stage3;

import game.edh.game.model.frame.GameData;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.GamesFlag;
import game.edh.game.screen.GameBaseScreen;

public class Stage3World extends GameWorld {
	public Stage3World(GameBaseScreen screen) {
		super(screen);
		setStageNum(3);
		setStartMap(new MapStage3(this).init());
		addMap(new MapStage3_2(this).init());
		addMap(new MapStage3_3(this).init());
		addMap(new MapStage3_4(this).init());
		addMap(new MapStage3_5(this).init());
		addMap(new MapHouse3(this).init());
		
		String[] flags = GamesFlag.getFlags(3);
		setFlags(flags);
	}

	public Stage3World(GameBaseScreen screen, GameData data) {
		super(screen, data);
		// TODO 自動生成されたコンストラクター・スタブ
		setStageNum(3);
		
		addMap(new MapStage3(this), data);
		addMap(new MapStage3_2(this), data);
		addMap(new MapStage3_3(this), data);
		addMap(new MapStage3_4(this), data);
		addMap(new MapStage3_5(this), data);
		addMap(new MapHouse3(this), data);
	}

}
