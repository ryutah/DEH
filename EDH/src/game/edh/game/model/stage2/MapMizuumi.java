package game.edh.game.model.stage2;

import com.badlogic.gdx.maps.tiled.TiledMap;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.Map;
import game.edh.game.model.frame.MapChangeRect;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.ModelGameChara.GameCharaDir;
import game.edh.game.model.stage2.objs.mizuumi.MizuumiObj;
import game.edh.game.model.stage2.objs.mizuumi.MizuumiTsurizaoObj;

public class MapMizuumi extends Map {
	public static final String NAME = "Mizuumi";

	public MapMizuumi(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setMap(Assets.map.get("mizuumi", TiledMap.class));
		setName(NAME);
		setInitDir(GameCharaDir.Down);
		setInitPos(7, 13);

		MapChangeRect change = new MapChangeRect(0, 14, 14, .3f, MapStage2.NAME);
		change.setChangeParam(31, 33, GameCharaDir.Down);
		addMapChangeRect(change);

		MapObject mizuumi = new MizuumiObj(world);
		MapObject sao = new MizuumiTsurizaoObj(world);
		addObjes(mizuumi, sao);
	}


}
