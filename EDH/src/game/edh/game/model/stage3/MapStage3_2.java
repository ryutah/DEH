package game.edh.game.model.stage3;

import com.badlogic.gdx.maps.tiled.TiledMap;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.Map;
import game.edh.game.model.frame.MapChangeRect;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.ModelGameChara.GameCharaDir;
import game.edh.game.model.stage3.objs.map32.Map32JimenObj;
import game.edh.game.model.stage3.objs.map32.Map32KakashiObj;
import game.edh.game.model.stage3.objs.map32.Map32KirikabuObj;
import game.edh.game.model.stage3.objs.map32.Map32MarutaObj;

public class MapStage3_2 extends Map {
	public static String NAME = "Stage3_2";

	public MapStage3_2(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setMap(Assets.map.get("stage3_2", TiledMap.class));
		setName(NAME);
		setInitPos(3, 1.5f);
		setInitDir(GameCharaDir.Up);

		MapChangeRect rect = new MapChangeRect(1, .5f, 5, .5f, MapStage3.NAME);
		rect.setChangeParam(13.5f, 25.5f, GameCharaDir.Down);
		addMapChangeRect(rect);

		MapChangeRect rect2 = new MapChangeRect(20, .5f, 5, .5f,
				MapStage3_4.NAME);
		addMapChangeRect(rect2);
		
		MapObject maruta = new Map32MarutaObj(world);
		MapObject kirikabu = new Map32KirikabuObj(world);
		MapObject kakashi = new Map32KakashiObj(world);
		MapObject jimen = new Map32JimenObj(world);
		addObjes(maruta, kirikabu, kakashi, jimen);
	}

}
