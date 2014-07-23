package game.edh.game.model.stage4;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;

import game.edh.Assets;
import game.edh.EdhGame;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.Map;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.ModelGameChara.GameCharaDir;
import game.edh.game.model.stage4.objs.houselast.HouseLastBedObj;
import game.edh.game.model.stage4.objs.houselast.HouseLastInu;
import game.edh.game.model.stage4.objs.houselast.HouseLastKouguBakoObj;
import game.edh.game.model.stage4.objs.houselast.HouseLastNabeObj;
import game.edh.game.model.stage4.objs.houselast.HouseLastNingyoAkaObj;
import game.edh.game.model.stage4.objs.houselast.HouseLastNingyoAoObj;
import game.edh.game.model.stage4.objs.houselast.HouseLastNingyoInuObj;
import game.edh.game.model.stage4.objs.houselast.HouseLastTable2Obj;
import game.edh.game.model.stage4.objs.houselast.HouseLastTableObj;
import game.edh.game.model.stage4.objs.houselast.HouseLastTana1Obj;
import game.edh.game.model.stage4.objs.houselast.HouseLastTana2Obj;
import game.edh.game.model.stage4.objs.houselast.HouseLastWallObj;

public class MapHouseLast extends Map {
	public static final String NAME = "last";

	float state;
	boolean playMusic;

	public MapHouseLast(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setMap(Assets.map.get("stage4_house", TiledMap.class));
		setInitPos(24, 5.5f);
		setInitDir(GameCharaDir.Up);
		setName(NAME);

		MapObject bed = new HouseLastBedObj(world);
		MapObject inu = new HouseLastInu(world);
		MapObject hako = new HouseLastKouguBakoObj(world);
		MapObject nabe = new HouseLastNabeObj(world);
		MapObject table1 = new HouseLastTableObj(world);
		MapObject table2 = new HouseLastTable2Obj(world);
		MapObject tana1 = new HouseLastTana2Obj(world);
		MapObject tana2 = new HouseLastTana1Obj(world);
		MapObject wall1 = new HouseLastWallObj(world, 0);
		MapObject wall2 = new HouseLastWallObj(world, 1);
		MapObject nAka = new HouseLastNingyoAkaObj(world);
		MapObject nAo = new HouseLastNingyoAoObj(world);
		MapObject nInu = new HouseLastNingyoInuObj(world);

		addObjes(bed, inu, hako, nabe, table1, table2, tana1, tana2, wall1,
				wall2, nAka, nAo, nInu);

		Rectangle rect = new Rectangle(0, 5, .5f, 3);
		setGameEndRect(rect);
	}

	@Override
	public void update(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		if (!playMusic) {
			state += delta;
			if (state >= 2.4f) {
				EdhGame.music.playMusic();
				playMusic = true;
			}
		}
		super.update(delta);
	}

	@Override
	public void showMap() {
		// TODO 自動生成されたメソッド・スタブ
		if (EdhGame.music.getNowMusic() != Assets.KAREHA) {
			EdhGame.music.changeMusic(Assets.KAREHA);
		}
		super.showMap();
	}

	@Override
	public Map load() {
		// TODO 自動生成されたメソッド・スタブ
		if (EdhGame.music.getNowMusic() == Assets.KAREHA)
			playMusic = true;
		return super.load();
	}
}
