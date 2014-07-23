package game.edh.game.model.stage1;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.Map;
import game.edh.game.model.frame.MapChangeRect;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage1Flag;
import game.edh.game.model.frame.ModelGameChara.GameCharaDir;
import game.edh.game.model.stage1.objs.map1.Map1Inu;
import game.edh.game.model.stage1.objs.map1.Map1KagiObj;
import game.edh.game.model.stage1.objs.map1.Map1Kanban1Obj;
import game.edh.game.model.stage1.objs.map1.Map1Kanban2Obj;
import game.edh.game.model.stage1.objs.map1.Map1KinomiObj;
import game.edh.game.model.stage1.objs.map1.Map1SansouObj;
import game.edh.game.model.stage1.objs.map1.Map1Stage1EndWallObj;

public class MapStage1 extends Map {
	public static final String NAME = "STAGE1";

	public MapStage1(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setMap(Assets.map.get("stage1", TiledMap.class));
		setInitPos(30, 20);
		setInitDir(GameCharaDir.Left);

		MapChangeRect house = new MapChangeRect(35, 19, 1, 5, MapHouse1.NAME);
		addMapChangeRect(house);

		Rectangle rect = new Rectangle(0, 3, 1, 4);
		setGameEndRect(rect);

		MapObject kanban = new Map1Kanban1Obj(25, 22, 2, 2, "kanban", world);
		MapObject kinomi2 = new Map1KinomiObj(world);
		MapObject kanban2 = new Map1Kanban2Obj(world);
		MapObject inu = new Map1Inu(world);
		inu.setPosition(28, 18);

		addObjes(inu, kanban, kinomi2, kanban2);

		setName(NAME);
	}

	@Override
	public Map init() {
		// TODO 自動生成されたメソッド・スタブ
		MapObject kinomi = new Map1SansouObj(30, 10, 2, 2, "kinomi", world);
		MapObject kagi = new Map1KagiObj(world);
		MapObject end = new Map1Stage1EndWallObj(world);
		MapObject hashi = new MapObject(19, 4, 1, 4, "hashi", world);
		hashi.setCollision(true);

		addObjes(kagi, kinomi, hashi, end);

		addBackLayers("gameend");
		return super.init();
	}

	@Override
	public Map load() {
		// TODO 自動生成されたメソッド・スタブ
		if (!world.getFlag(Stage1Flag.SANSOU)) {
			MapObject kinomi = new Map1SansouObj(30, 10, 2, 2, "kinomi", world);
			addObjes(kinomi);
		}

		if (!world.getFlag(Stage1Flag.KAGI_GET)) {
			MapObject kagi = new Map1KagiObj(world);
			addObjes(kagi);
		}

		if (!world.getFlag(Stage1Flag.NIKKI)) {
			MapObject hashi = new MapObject(19, 4, 1, 4, "hashi", world);
			addObjes(hashi);
		} else {
			addBackLayers("flagback");
			addFrontLayers("flagfore");
		}

		if (!world.getFlag(Stage1Flag.PUT_NINGYO)) {
			MapObject end = new Map1Stage1EndWallObj(world);
			addObjes(end);
			addBackLayers("gameend");
		}
		return super.load();
	}


}
