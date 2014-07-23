package game.edh.game.model.stage4.objs.map43;

import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage4Flag;
import game.edh.game.model.items.ItemsHandler;

public class Map43HakaObj extends MapObject {

	public Map43HakaObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(6.5f, 8.5f, 2, 2);
		setCollision(true);

		if (world.getFlag(Stage4Flag.HAKA_HANA))
			setDrawable(Assets.games.get("haka_hana",
					TextureRegionDrawable.class));
		else
			setDrawable(Assets.games.get("haka", TextureRegionDrawable.class));

	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		if (!world.getFlag(Stage4Flag.HAKA_HANA)) {
			if (world.getSelectItem() == ItemsHandler.HANA) {
				world.removeItem(ItemsHandler.HANA);
				world.textEvent("お墓に花を添えた");
				world.changeFlag(Stage4Flag.HAKA_HANA, true);
				setDrawable(Assets.games.get("haka_hana",
						TextureRegionDrawable.class));
			} else
				world.textEvent("お墓がある", "名前が書いてあるみたいだけど、文字がかすれていて読めない");
		} else
			world.textEvent("お墓だ\nさっき花を添えた");
	}
}
