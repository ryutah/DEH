package game.edh.game.model.stage4;

import com.badlogic.gdx.maps.tiled.TiledMap;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.Map;
import game.edh.game.model.frame.MapChangeRect;
import game.edh.game.model.frame.ModelGameChara.GameCharaDir;

public class MapStage4_2 extends Map {
	public static final String NAME = "Stage42";

	public MapStage4_2(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setMap(Assets.map.get("stage4_2", TiledMap.class));
		setInitPos(7.5f, 1.5f);
		setInitDir(GameCharaDir.Up);
		setName(NAME);
		
		MapChangeRect rect = new MapChangeRect(7, 11.5f, 3, .5f, MapHouse4.NAME);
		addMapChangeRect(rect);
		MapChangeRect rect2 = new MapChangeRect(3, 0, 9, .5f, MapStage4_3.NAME);
		rect2.setChangeParam(7.5f, 18, GameCharaDir.Down);
		addMapChangeRect(rect2);
	}

}
