package game.edh.game.model.stage2;

import com.badlogic.gdx.maps.tiled.TiledMap;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.Map;
import game.edh.game.model.frame.MapChangeRect;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.ModelGameChara.GameCharaDir;
import game.edh.game.model.stage2.objs.map23.Map23KirikabuObj;
import game.edh.game.model.stage2.objs.map23.Map23WaraObj;

public class MapStage2_3 extends Map {
	public static final String NAME = "Stage2_3";

	public MapStage2_3(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setMap(Assets.map.get("stage2_3", TiledMap.class));
		setName(NAME);
		setInitPos(11, 18);
		setInitDir(GameCharaDir.Down);

		MapChangeRect rect = new MapChangeRect(9, 19.5f, 6, .5f, MapStage2.NAME);
		rect.setChangeParam(23, 1.5f, GameCharaDir.Up);
		addMapChangeRect(rect);
		
		MapObject kirikabu = new Map23KirikabuObj(world);
		MapObject wara = new Map23WaraObj(world);
		addObjes(kirikabu, wara);
	}

}
