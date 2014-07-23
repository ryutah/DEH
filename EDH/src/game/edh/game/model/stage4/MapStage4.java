package game.edh.game.model.stage4;

import com.badlogic.gdx.maps.tiled.TiledMap;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.Map;
import game.edh.game.model.frame.MapChangeRect;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.ModelGameChara.GameCharaDir;
import game.edh.game.model.stage4.objs.map4.Map4KanbanObj;

public class MapStage4 extends Map {
	public static final String NAME = "Stage4";

	public MapStage4(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setMap(Assets.map.get("stage4", TiledMap.class));
		setInitDir(GameCharaDir.Right);
		setInitPos(2, 11);
		setName(NAME);

		MapChangeRect rect = new MapChangeRect(19.5f, 10, .5f, 9,
				MapStage4_3.NAME);
		addMapChangeRect(rect);
		MapChangeRect rect2 = new MapChangeRect(19.5f, 1, .5f, 4,
				MapStage4_4.NAME);
		addMapChangeRect(rect2);
		
		MapObject kanban = new Map4KanbanObj(world);
		addObjes(kanban);
	}

}
