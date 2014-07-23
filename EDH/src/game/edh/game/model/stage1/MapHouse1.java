package game.edh.game.model.stage1;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.Map;
import game.edh.game.model.frame.MapChangeRect;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage1Flag;
import game.edh.game.model.frame.ModelGameChara.GameCharaDir;
import game.edh.game.model.stage1.objs.house1.House1KouguBakoObj;
import game.edh.game.model.stage1.objs.house1.House1MemoObj;
import game.edh.game.model.stage1.objs.house1.House1NabeObj;
import game.edh.game.model.stage1.objs.house1.House1NikkiObj;
import game.edh.game.model.stage1.objs.house1.House1NingyoObj;
import game.edh.game.model.stage1.objs.house1.House1SaihouBakoObj;
import game.edh.game.model.stage1.objs.house1.House1RyoriTableObj;
import game.edh.game.model.stage1.objs.house1.House1SaraObj;
import game.edh.game.model.stage1.objs.house1.House1TableObj;
import game.edh.game.model.stage1.objs.house1.House1TsuboObj;

public class MapHouse1 extends Map {
	public static String NAME = "HOUSE1";

	public MapHouse1(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setMap(Assets.map.get("house", TiledMap.class));
		setName(NAME);
		setInitPos(5, 2);

		MapChangeRect change = new MapChangeRect(3, 0, 4, 1, MapStage1.NAME);
		addMapChangeRect(change);
		setInitDir(GameCharaDir.Up);

		MapObject memo = new House1MemoObj(world);
		MapObject memo2 = new House1NikkiObj(world);
		MapObject kougubako = new House1KouguBakoObj(world);
		MapObject saihou = new House1SaihouBakoObj(world);
		MapObject ryori = new House1RyoriTableObj(world);
		MapObject ryouri = new House1NabeObj(world);
		MapObject table = new House1TableObj(world);
		MapObject tubo = new House1TsuboObj(world);
		MapObject ningyo = new House1NingyoObj(world);
		MapObject sara = new House1SaraObj(world);

		addObjes(memo, memo2, kougubako, saihou, ryori, ryouri, table, tubo,
				ningyo, sara);
	}

	@Override
	public Map init() {
		// TODO 自動生成されたメソッド・スタブ
		return super.init();
	}

	@Override
	public Map load() {
		// TODO 自動生成されたメソッド・スタブ
		if (world.getFlag(Stage1Flag.PUT_NINGYO)) {
			MapObject obj = new MapObject(1.5f, 7, 1, 1, "ningyou", world);
			obj.setDrawable(Assets.games.get("ningyoAka",
					TextureRegionDrawable.class));
			addObjes(obj);
		}

		return super.load();
	}

}
