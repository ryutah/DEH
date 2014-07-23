package game.edh.game.model.stage3;

import com.badlogic.gdx.maps.tiled.TiledMap;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.Map;
import game.edh.game.model.frame.MapChangeRect;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage3Flag;
import game.edh.game.model.frame.ModelGameChara.GameCharaDir;
import game.edh.game.model.stage3.objs.map35.Map35FlagWallObj;

public class MapStage3_5 extends Map {
	public static final String NAME = "Stage3_5";
	boolean removeLayer;

	public MapStage3_5(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setMap(Assets.map.get("stage3_5", TiledMap.class));
		setName(NAME);
		setInitDir(GameCharaDir.Right);
		setInitPos(2, 15);

		MapChangeRect rect = new MapChangeRect(.5f, 12, .5f, 5,
				MapStage3_4.NAME);
		rect.setChangeParam(23, 7.5f, GameCharaDir.Left);
		addMapChangeRect(rect);

		MapChangeRect rect2 = new MapChangeRect(24.5f, 6, .5f, 6,
				MapHouse3.NAME);
		addMapChangeRect(rect2);

		MapChangeRect rect3 = new MapChangeRect(0, 1, .5f, 4, MapStage3_3.NAME);
		rect3.setChangeParam(11.5f, 6.5f, GameCharaDir.Left);
		addMapChangeRect(rect3);
		
		MapObject wall = new Map35FlagWallObj(world);
		addObjes(wall);
	}

	@Override
	public Map init() {
		// TODO 自動生成されたメソッド・スタブ
		addBackLayers("ground3");
		return super.init();
	}

	@Override
	public Map load() {
		// TODO 自動生成されたメソッド・スタブ
		if(!world.getFlag(Stage3Flag.PUT_INU))
			addBackLayers("ground3");
		else
			removeLayer = true;
		return super.load();
	}
	
	@Override
	public void update(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		super.update(delta);
		if(!removeLayer && world.getFlag(Stage3Flag.PUT_INU)) {
			removeBackLayer("ground3");
			removeLayer = true;
		}
	}
}
