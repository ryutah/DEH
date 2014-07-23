package game.edh.game.model.items;

import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;

public class Kinomi1 extends Items {

	public Kinomi1(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setDrawable(Assets.games.get("kinomi1", TextureRegionDrawable.class));
		setItemId(ItemsHandler.KINOMI_1);
		setItemName("赤い果実");
		setItemMassage("赤いきのみ\n\n森の木でとれたきのみ\nたぶん食べられる…と思う");
	}

}
