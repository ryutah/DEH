package game.edh.game.model.stage3;

import com.badlogic.gdx.maps.tiled.TiledMap;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.Map;
import game.edh.game.model.frame.MapChangeRect;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.ModelGameChara.GameCharaDir;
import game.edh.game.model.stage3.objs.map34.Map34IkeObj;
import game.edh.game.model.stage3.objs.map34.Map34JimenObj;
import game.edh.game.model.stage3.objs.map34.Map34ModelInu;

public class MapStage3_4 extends Map {
	public static final String NAME = "Stage3_4";

	public MapStage3_4(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setMap(Assets.map.get("stage3_4", TiledMap.class));
		setName(NAME);
		setInitDir(GameCharaDir.Down);
		setInitPos(10.5f, 17.5f);

		MapChangeRect rect = new MapChangeRect(5, 18.5f, 11, .5f,
				MapStage3_2.NAME);
		rect.setChangeParam(22.5f, 1.5f, GameCharaDir.Up);
		addMapChangeRect(rect);

		MapChangeRect rect2 = new MapChangeRect(24.5f, 1, .5f, 13,
				MapStage3_5.NAME);
		addMapChangeRect(rect2);
		
		MapObject inu = new Map34ModelInu(world);
		MapObject ike = new Map34IkeObj(world);
		MapObject jimen = new Map34JimenObj(world);
		
		addObjes(inu, ike, jimen);
	}
}
