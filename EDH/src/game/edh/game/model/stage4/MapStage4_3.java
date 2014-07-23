package game.edh.game.model.stage4;

import com.badlogic.gdx.maps.tiled.TiledMap;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.Map;
import game.edh.game.model.frame.MapChangeRect;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage4Flag;
import game.edh.game.model.frame.ModelGameChara.GameCharaDir;
import game.edh.game.model.stage4.objs.map43.Map43HakaObj;
import game.edh.game.model.stage4.objs.map43.Map43WallObj;

public class MapStage4_3 extends Map {
	public static final String NAME = "Stage43";

	boolean remLayer;

	public MapStage4_3(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setMap(Assets.map.get("stage4_3", TiledMap.class));
		setName(NAME);
		setInitPos(7, 1.5f);
		setInitDir(GameCharaDir.Down);

		MapChangeRect rect = new MapChangeRect(5, 0, 5, .5f, MapStage4.NAME);
		rect.setChangeParam(18, 14, GameCharaDir.Left);
		addMapChangeRect(rect);
		MapChangeRect rect2 = new MapChangeRect(6, 19.5f, 3, .5f,
				MapStage4_2.NAME);
		addMapChangeRect(rect2);
		
		MapObject haka = new Map43HakaObj(world);
		MapObject wall = new Map43WallObj(world);
		addObjes(haka, wall);

	}

	@Override
	public Map init() {
		// TODO 自動生成されたメソッド・スタブ
		addBackLayers("ground3");
		addFrontLayers("foreground2");
		return super.init();
	}

	@Override
	public Map load() {
		// TODO 自動生成されたメソッド・スタブ
		if (world.getFlag(Stage4Flag.HAKA_HANA))
			remLayer = true;
		else {
			addBackLayers("ground3");
			addFrontLayers("foreground2");
			remLayer = false;
		}

		return super.load();
	}

	@Override
	public void update(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		if (!remLayer && world.getFlag(Stage4Flag.HAKA_HANA)) {
			removeBackLayer("ground3");
			removeFrontLayers("foreground2");
			remLayer = true;
		}
	}
}
