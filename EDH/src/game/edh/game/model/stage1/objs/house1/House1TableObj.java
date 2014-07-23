package game.edh.game.model.stage1.objs.house1;

import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage1Flag;
import game.edh.game.model.items.ItemsHandler;
import game.edh.game.model.stage1.MapStage1;
import game.edh.game.model.stage1.objs.map1.Map1Stage1EndWallObj;

public class House1TableObj extends MapObject {

	public House1TableObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(1, 4, 2, 4);
	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		if (!world.getFlag(Stage1Flag.PUT_NINGYO)) {
			if (world.getSelectItem() == ItemsHandler.NINGYOAKA) {
				world.removeItem(ItemsHandler.NINGYOAKA);
				world.clearSelectItem();

				MapObject obj = new MapObject(1.5f, 7, 1, 1, "ningyou", world);
				obj.setDrawable(Assets.games.get("ningyoAka",
						TextureRegionDrawable.class));
				world.getMap().addObj(obj);
				world.textEvent("人形を机の上に置いた", "…何かを思い出したような気がした");
				world.changeFlag(Stage1Flag.PUT_NINGYO, true);
				world.getMap(MapStage1.NAME).removeObjs(Map1Stage1EndWallObj.NAME);
				world.getMap(MapStage1.NAME).removeBackLayer("gameend");
			} else
				world.textEvent("ここには何かが置いてあった気がする…");
		} else {
			world.textEvent("机の上に人形が乗っている", "まだ何か足りない気がするけど、今はこれ以上思い出せそうにない…");
		}
	}

}
