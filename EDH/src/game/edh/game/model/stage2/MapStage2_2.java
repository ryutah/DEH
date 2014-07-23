package game.edh.game.model.stage2;

import com.badlogic.gdx.maps.tiled.TiledMap;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.Map;
import game.edh.game.model.frame.MapChangeRect;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.ModelGameChara.GameCharaDir;
import game.edh.game.model.stage2.objs.map22.Map22Taru2Obj;
import game.edh.game.model.stage2.objs.map22.Map22TaruObj;

public class MapStage2_2 extends Map {
	public static final String NAME = "Stage2_2";

	public MapStage2_2(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setMap(Assets.map.get("stage2_2", TiledMap.class));
		setName(NAME);
		setInitDir(GameCharaDir.Up);
		setInitPos(7, 2);

		MapChangeRect rect = new MapChangeRect(4, 0, 7, .5f, MapStage2.NAME);
		rect.setChangeParam(9, 33, GameCharaDir.Down);
		addMapChangeRect(rect);
		MapObject taru = new Map22TaruObj(world);
		MapObject taru2 = new Map22Taru2Obj(world);
		addObjes(taru, taru2);
	}
	
	@Override
	public Map init() {
		// TODO 自動生成されたメソッド・スタブ
		return super.init();
	}
}
