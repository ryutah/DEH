package game.edh.game.model.items;

import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;

public class Tsurizao extends Items {

	public Tsurizao(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setItemId(ItemsHandler.TSURIZAO);
		setItemName("釣り竿");
		setItemMassage("釣り竿\n\n普通の釣り竿\n魚を釣るのかな");
		setDrawable(Assets.games.get("tsurizao", TextureRegionDrawable.class));
	}

}
