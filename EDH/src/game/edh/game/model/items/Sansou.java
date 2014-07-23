package game.edh.game.model.items;

import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;

public class Sansou extends Items {

	public Sansou(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setItemId(ItemsHandler.KUSA);
		setDrawable(Assets.games.get("kusa", TextureRegionDrawable.class));
		setItemName("山草");
		setItemMassage("森で拾った山草\n\nさっき拾った山草\n料理にも使えるみたい");
	}

}
