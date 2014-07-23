package game.edh.game.model.stage4;

import com.badlogic.gdx.maps.tiled.TiledMap;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.Map;
import game.edh.game.model.frame.MapChangeRect;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.ModelGameChara.GameCharaDir;
import game.edh.game.model.stage4.objs.map44.Map44HanaObj;

public class MapStage4_4 extends Map {
	public static final String NAME = "stage44";

	public MapStage4_4(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setMap(Assets.map.get("stage4_4", TiledMap.class));
		setName(NAME);
		setInitPos(1.5f, 13);
		setInitDir(GameCharaDir.Right);
		MapChangeRect rect = new MapChangeRect(0, 8, .5f, 12, MapStage4.NAME);
		rect.setChangeParam(18, 2, GameCharaDir.Left);
		addMapChangeRect(rect);
		
		MapObject hana = new Map44HanaObj(world);
		addObjes(hana);
	}

}
