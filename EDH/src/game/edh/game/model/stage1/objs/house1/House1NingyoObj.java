package game.edh.game.model.stage1.objs.house1;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.GamesFlag.Stage1Flag;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.items.ItemsHandler;

import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class House1NingyoObj extends MapObject {

	public House1NingyoObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(12.5f, 2.5f, 1f, 1f);
		setDrawable(Assets.games.get("ningyoAka", TextureRegionDrawable.class));

		if (!world.getFlag(Stage1Flag.RYOURI)
				|| (world.getFlag(Stage1Flag.RYOURI) && world
						.getFlag(Stage1Flag.NINGYO_GET))) {
			setDraw(false);
			setCollision(false);
			setCheck(false);
		}
	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		if (!world.getFlag(Stage1Flag.NINGYO_GET)) {
			world.textEvent("なにか落ちている\nさっきまではなかった気がするけど…", "『人形』を手に入れた");
			world.addItem(ItemsHandler.NINGYOAKA);
			world.getMap().removeObjs(this);
			world.changeFlag(Stage1Flag.NINGYO_GET, true);
		}
	}

	@Override
	public void update(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		if (world.getFlag(Stage1Flag.RYOURI)
				&& !world.getFlag(Stage1Flag.NINGYO_GET)) {
			setDraw(true);
			setCheck(true);
		}
		super.update(delta);
	}
}
