package game.edh.game.model.stage3;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.Map;
import game.edh.game.model.frame.MapChangeRect;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.ModelGameChara.GameCharaDir;
import game.edh.game.model.stage3.objs.house3.House3BedObj;
import game.edh.game.model.stage3.objs.house3.House3InuObj;
import game.edh.game.model.stage3.objs.house3.House3KouguBakoObj;
import game.edh.game.model.stage3.objs.house3.House3NikkiObj;
import game.edh.game.model.stage3.objs.house3.House3RyouruObj;
import game.edh.game.model.stage3.objs.house3.House3SaihoubakoObj;
import game.edh.game.model.stage3.objs.house3.House3RyoriTableObj;
import game.edh.game.model.stage3.objs.house3.House3SaraObj;
import game.edh.game.model.stage3.objs.house3.House3TableObj;
import game.edh.game.model.stage3.objs.house3.House3TanaObj;
import game.edh.game.model.stage3.objs.house3.House3TsuboObj;

public class MapHouse3 extends Map {
	public static final String NAME = "House3";

	public MapHouse3(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setMap(Assets.map.get("house", TiledMap.class));
		setName(NAME);
		setInitPos(5.5f, 2);
		setInitDir(GameCharaDir.Up);

		MapChangeRect rect = new MapChangeRect(4, .5f, 3, .5f, MapStage3_5.NAME);
		rect.setChangeParam(23, 9.5f, GameCharaDir.Left);
		addMapChangeRect(rect);

		MapObject ningyoA = new MapObject(1.5f, 7, 1, 1, "ningyoAka", world);
		ningyoA.setDrawable(Assets.games.get("ningyoAka",
				TextureRegionDrawable.class));

		MapObject ningyoB = new MapObject(1.5f, 6, 1, 1, "nintyoAo", world);
		ningyoB.setDrawable(Assets.games.get("ningyoAo",
				TextureRegionDrawable.class));

		MapObject inu = new House3InuObj(world);

		MapObject kougu = new House3KouguBakoObj(world);
		MapObject nikki = new House3NikkiObj(world);
		MapObject ryouri = new House3RyouruObj(world);
		MapObject saihou = new House3SaihoubakoObj(world);
		MapObject rTable = new House3RyoriTableObj(world);
		MapObject table = new House3TableObj(world);
		MapObject tana = new House3TanaObj(world);
		MapObject tsubo = new House3TsuboObj(world);
		MapObject bed = new House3BedObj(world);
		MapObject sara = new House3SaraObj(world);

		addObjes(bed, kougu, nikki, ryouri, saihou, rTable, table, tana,
				ningyoA, ningyoB, inu, tsubo, sara);
	}

}
