package game.edh.game.model.stage2;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.Map;
import game.edh.game.model.frame.MapChangeRect;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.ModelGameChara.GameCharaDir;
import game.edh.game.model.stage2.objs.house2.House2HouchoObj;
import game.edh.game.model.stage2.objs.house2.House2KouguBakoObj;
import game.edh.game.model.stage2.objs.house2.House2NabeObj;
import game.edh.game.model.stage2.objs.house2.House2NikkiObj;
import game.edh.game.model.stage2.objs.house2.House2NingyoOnj;
import game.edh.game.model.stage2.objs.house2.House2RyouriTable;
import game.edh.game.model.stage2.objs.house2.House2SaihoubakoObj;
import game.edh.game.model.stage2.objs.house2.House2Sara1Obj;
import game.edh.game.model.stage2.objs.house2.House2Sara2Obj;
import game.edh.game.model.stage2.objs.house2.House2Table;
import game.edh.game.model.stage2.objs.house2.House2TanaObj;
import game.edh.game.model.stage2.objs.house2.House2TsuboObj;

public class MapHouse2 extends Map {
	public static final String NAME = "House2";

	public MapHouse2(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setMap(Assets.map.get("house", TiledMap.class));
		setName(NAME);
		setInitPos(5, 2);
		setInitDir(GameCharaDir.Up);

		MapChangeRect rect = new MapChangeRect(4, 0, 3, .5f, MapStage2.NAME);
		addMapChangeRect(rect);

		MapObject ningyoA = new MapObject(1.5f, 7, 1, 1, "kishi", world);
		ningyoA.setDrawable(Assets.games.get("ningyoAka",
				TextureRegionDrawable.class));
		MapObject table = new House2Table(world);
		MapObject nikki = new House2NikkiObj(world);
		MapObject kougu = new House2KouguBakoObj(world);
		MapObject saihou = new House2SaihoubakoObj(world);
		MapObject sara1 = new House2Sara1Obj(world);
		MapObject sara2 = new House2Sara2Obj(world);
		MapObject ryouri = new House2RyouriTable(world);
		MapObject tana = new House2TanaObj(world);
		MapObject nabe = new House2NabeObj(world);
		MapObject tsubo = new House2TsuboObj(world);
		MapObject houcho = new House2HouchoObj(world);
		MapObject ningyo = new House2NingyoOnj(world);

		addObjes(table, nikki, kougu, saihou, sara1, sara2, ryouri,
				tana, nabe, tsubo, houcho, ningyo, ningyoA);
	}

	@Override
	public Map init() {
		// TODO 自動生成されたメソッド・スタブ
		return super.init();
	}

	@Override
	public Map load() {
		// TODO 自動生成されたメソッド・スタブ
		return super.load();
	}

}
