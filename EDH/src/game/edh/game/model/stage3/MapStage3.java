package game.edh.game.model.stage3;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.Map;
import game.edh.game.model.frame.MapChangeRect;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage3Flag;
import game.edh.game.model.frame.ModelGameChara.GameCharaDir;
import game.edh.game.model.stage3.objs.map3.Map3FlagWallObj;
import game.edh.game.model.stage3.objs.map3.Map3KanbajObj;

public class MapStage3 extends Map {
	public static final String NAME = "Stage3";
	boolean removeLayer;

	public MapStage3(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setMap(Assets.map.get("stage3", TiledMap.class));
		setInitDir(GameCharaDir.Right);
		setInitPos(3, 12);
		setName(NAME);

		MapChangeRect rect = new MapChangeRect(12, 26.5f, 4, .5f,
				MapStage3_2.NAME);
		MapChangeRect rect2 = new MapChangeRect(35.5f, 7, .5f, 11,
				MapStage3_3.NAME);
		addMapChangeRect(rect);
		addMapChangeRect(rect2);
		
		Rectangle end = new Rectangle(0, 8, .5f, 8);
		setGameEndRect(end);
		
		MapObject kanban = new Map3KanbajObj(world);
		MapObject wall = new Map3FlagWallObj(world);
		addObjes(kanban, wall);
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
		if(!world.getFlag(Stage3Flag.PUT_INU))
			addFrontLayers("foreground2");
		else
			removeLayer = true;
		return super.load();
	}

	@Override
	public void update(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		super.update(delta);
		if(!removeLayer && world.getFlag(Stage3Flag.PUT_INU)) {
			removeFrontLayers("foreground2");
			removeLayer = true;
		}
	}
}
