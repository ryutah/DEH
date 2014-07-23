package game.edh.game.model.stage2;

import com.badlogic.gdx.maps.tiled.TiledMap;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.Map;
import game.edh.game.model.frame.MapChangeRect;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.ModelGameChara.GameCharaDir;
import game.edh.game.model.stage2.objs.mayoinomori.MayoinomoriKanban;
import game.edh.game.model.stage2.objs.mayoinomori.MayoinomoriMapChange;
import game.edh.game.model.stage2.objs.mayoinomori.MayoinomoriMapChange2;
import game.edh.game.model.stage2.objs.mayoinomori.MayoinomoriMapChange3;

public class MapMayoinomori extends Map {
	public static final String NAME = "Mayoinomori";
	
	public boolean step1, stap2, stap3, stap4;

	public MapMayoinomori(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setMap(Assets.map.get("mayoinomori", TiledMap.class));
		setName(NAME);
		setInitDir(GameCharaDir.Up);
		setInitPos(7, 1);
		
		MapChangeRect left = new MayoinomoriMapChange3(this);
		MapChangeRect right = new MayoinomoriMapChange2(this);
		MapChangeRect up = new MayoinomoriMapChange(world, this);
		MapChangeRect down = new MapChangeRect(6, 0, 3, .5f, MapStage2.NAME);
		down.setChangeParam(31, 33, GameCharaDir.Down);
		
		addMapChangeRect(left);
		addMapChangeRect(right);
		addMapChangeRect(up);
		addMapChangeRect(down);
		
		MapObject kanban = new MayoinomoriKanban(world);
		addObjes(kanban);
	}



}
