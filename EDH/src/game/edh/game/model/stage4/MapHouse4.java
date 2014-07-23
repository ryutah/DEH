package game.edh.game.model.stage4;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.Map;
import game.edh.game.model.frame.MapChangeRect;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.ModelGameChara.GameCharaDir;
import game.edh.game.model.stage4.objs.house4.House4BedObj;
import game.edh.game.model.stage4.objs.house4.House4KouguBakoObj;
import game.edh.game.model.stage4.objs.house4.House4NabeObj;
import game.edh.game.model.stage4.objs.house4.House4NikkiObj;
import game.edh.game.model.stage4.objs.house4.House4RyoriTableObj;
import game.edh.game.model.stage4.objs.house4.House4SaihoubakoObj;
import game.edh.game.model.stage4.objs.house4.House4SaraObj;
import game.edh.game.model.stage4.objs.house4.House4TableObj;
import game.edh.game.model.stage4.objs.house4.House4TanaObj;
import game.edh.game.model.stage4.objs.house4.House4TsuboObj;

public class MapHouse4 extends Map {
	public static final String NAME = "house4";

	public MapHouse4(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setMap(Assets.map.get("house", TiledMap.class));
		setName(NAME);
		setInitPos(5.5f, 2);
		setInitDir(GameCharaDir.Up);

		MapChangeRect rect = new MapChangeRect(4, 0, 3, .5f, MapStage4_2.NAME);
		rect.setChangeParam(8, 10, GameCharaDir.Down);
		addMapChangeRect(rect);

		MapObject bed = new House4BedObj(world);
		MapObject hako = new House4KouguBakoObj(world);
		MapObject nabe = new House4NabeObj(world);
		MapObject nikki = new House4NikkiObj(world);
		MapObject ryori = new House4RyoriTableObj(world);
		MapObject saihou = new House4SaihoubakoObj(world);
		MapObject table = new House4TableObj(world);
		MapObject tana = new House4TanaObj(world);
		MapObject tubo = new House4TsuboObj(world);
		MapObject sara = new House4SaraObj(world);
		MapObject ningyoAka = new MapObject(1.5f, 7, 1, 1, "nAka", world);
		ningyoAka.setDrawable(Assets.games.get("ningyoAka",
				TextureRegionDrawable.class));
		MapObject ningyoAo = new MapObject(1.5f, 6, 1, 1, "nAo", world);
		ningyoAo.setDrawable(Assets.games.get("ningyoAo",
				TextureRegionDrawable.class));
		MapObject inu = new MapObject(1.5f, 5, 1, 1, "inu", world);
		inu.setDrawable(Assets.games.get("inu", TextureRegionDrawable.class));

		addObjes(bed, hako, nabe, nikki, ryori, saihou, table, tana, tubo,
				ningyoAka, ningyoAo, inu, sara);
	}

}
