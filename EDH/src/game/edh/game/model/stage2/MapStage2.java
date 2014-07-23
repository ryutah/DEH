package game.edh.game.model.stage2;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.Map;
import game.edh.game.model.frame.MapChangeRect;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage2Flag;
import game.edh.game.model.frame.ModelGameChara.GameCharaDir;
import game.edh.game.model.stage2.objs.map2.Map2GakeObj;
import game.edh.game.model.stage2.objs.map2.Map2Inu;
import game.edh.game.model.stage2.objs.map2.Map2JimenObj;
import game.edh.game.model.stage2.objs.map2.Map2MapChange;
import game.edh.game.model.stage2.objs.map2.Map2StageEndWall;

public class MapStage2 extends Map {
	public static final String NAME = "Stage2";

	boolean remLayer;
	boolean addLayer;

	public MapStage2(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setMap(Assets.map.get("stage2", TiledMap.class));
		setName(NAME);
		setInitPos(37, 15);
		setInitDir(GameCharaDir.Left);

		MapChangeRect mori = new Map2MapChange(world);
		addMapChangeRect(mori);

		MapChangeRect house = new MapChangeRect(39.5f, 9, .5f, 11,
				MapHouse2.NAME);
		addMapChangeRect(house);

		MapChangeRect stage2_2 = new MapChangeRect(7, 34.5f, 5, .5f,
				MapStage2_2.NAME);
		addMapChangeRect(stage2_2);

		MapChangeRect stage2_3 = new MapChangeRect(20, 0, 7, .5f,
				MapStage2_3.NAME);
		addMapChangeRect(stage2_3);

		Rectangle end = new Rectangle(0, 22, .5f, 4);
		setGameEndRect(end);

		MapObject wall = new MapObject(19, 19.8f, 8, .2f, "wall", world);
		wall.setCollision(true);
		MapObject jimen = new Map2JimenObj(world);
		MapObject gake = new Map2GakeObj(world);
		MapObject endWall = new Map2StageEndWall(world);
		MapObject inu = new Map2Inu(world);
		addObjes(wall, gake, endWall, jimen, inu);
	}

	@Override
	public Map init() {
		// TODO 自動生成されたメソッド・スタブ
		addBackLayers("stageend");
		return super.init();
	}

	@Override
	public Map load() {
		// TODO 自動生成されたメソッド・スタブ
		if (world.getFlag(Stage2Flag.PUT_RYOURI1)
				&& world.getFlag(Stage2Flag.PUT_RYOURI2)) {
			addBackLayers("ground3");
			addLayer = true;
		}

		if (!world.getFlag(Stage2Flag.NINGYO_PUT)) {
			addBackLayers("stageend");
			remLayer = false;
		} else
			remLayer = true;
		return super.load();
	}

	@Override
	public void update(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		super.update(delta);
		if (!addLayer) {
			if (world.getFlag(Stage2Flag.PUT_RYOURI1)
					&& world.getFlag(Stage2Flag.PUT_RYOURI2)) {
				addBackLayers("ground3");
				addLayer = true;
			}
		}

		if (!remLayer) {
			if (world.getFlag(Stage2Flag.NINGYO_PUT)) {
				removeBackLayer("stageend");
				remLayer = true;
			}
		}
	}

}
