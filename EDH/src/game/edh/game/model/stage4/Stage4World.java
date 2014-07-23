package game.edh.game.model.stage4;

import game.edh.Assets;
import game.edh.game.model.frame.GameData;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.GamesFlag;
import game.edh.game.screen.GameBaseScreen;

public class Stage4World extends GameWorld {
	public Stage4World(GameBaseScreen screen) {
		// TODO 自動生成されたコンストラクター・スタブ
		super(screen);
		setStartMap(new MapStage4(this).init());
		addMap(new MapStage4_2(this).init());
		addMap(new MapStage4_3(this).init());
		addMap(new MapStage4_4(this).init());
		addMap(new MapHouse4(this).init());
		addMap(new MapHouseLast(this).init());
		setStageNum(4);
		
		setFlags(GamesFlag.getFlags(4));
		screen.setMusic(Assets.MORUDAU);
	}

	public Stage4World(GameBaseScreen screen, GameData data) {
		super(screen, data);
		// TODO 自動生成されたコンストラクター・スタブ
		setStageNum(4);
		
		addMap(new MapStage4(this), data);
		addMap(new MapStage4_2(this), data);
		addMap(new MapStage4_3(this), data);
		addMap(new MapStage4_4(this), data);
		addMap(new MapHouse4(this), data);
		addMap(new MapHouseLast(this), data);
		
		if(data.mapName.equals(MapHouseLast.NAME))
			screen.setMusic(Assets.KAREHA);
		else
			screen.setMusic(Assets.MORUDAU);
	}
}
