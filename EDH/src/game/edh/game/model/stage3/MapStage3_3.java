package game.edh.game.model.stage3;

import com.badlogic.gdx.maps.tiled.TiledMap;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.Map;
import game.edh.game.model.frame.MapChangeRect;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage3Flag;
import game.edh.game.model.frame.ModelGameChara.GameCharaDir;
import game.edh.game.model.stage3.objs.map33.Map33FlagWallObj;
import game.edh.game.model.stage3.objs.map33.Map33YukidarumaObj;

public class MapStage3_3 extends Map {
	public static final String NAME = "Stage3_3";
	boolean removeLayer;

	public MapStage3_3(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setMap(Assets.map.get("stage3_3", TiledMap.class));
		setName(NAME);
		setInitPos(2, 5.5f);
		setInitDir(GameCharaDir.Right);

		MapChangeRect rect = new MapChangeRect(.5f, 4, .5f, 7, MapStage3.NAME);
		rect.setChangeParam(33.5f, 13, GameCharaDir.Left);
		addMapChangeRect(rect);
		MapChangeRect rect2 = new MapChangeRect(13.5f, 6, .5f, 2,
				MapStage3_5.NAME);
		rect2.setChangeParam(1.5f, 2, GameCharaDir.Right);
		addMapChangeRect(rect2);

		MapObject wall = new Map33FlagWallObj(world);
		MapObject yukidaruma = new Map33YukidarumaObj(world);
		addObjes(yukidaruma, wall);
	}

	@Override
	public Map init() {
		// TODO 自動生成されたメソッド・スタブ
		addFrontLayers("foreground2");
		return super.init();
	}

	@Override
	public Map load() {
		// TODO 自動生成されたメソッド・スタブ
		if (!world.getFlag(Stage3Flag.PUT_INU))
			addFrontLayers("foreground2");
		else
			removeLayer = true;
		return super.load();
	}

	@Override
	public void update(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		super.update(delta);
		if (!removeLayer && world.getFlag(Stage3Flag.PUT_INU)) {
			removeFrontLayers("foreground2");
			removeLayer = true;
		}
	}
}
