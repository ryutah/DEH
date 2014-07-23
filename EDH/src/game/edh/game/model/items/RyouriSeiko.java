package game.edh.game.model.items;

import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;

public class RyouriSeiko extends Items {

	public RyouriSeiko(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setDrawable(Assets.games.get("ryouri", TextureRegionDrawable.class));
		setItemId(ItemsHandler.RYOURI_SEIKO);
		setItemName("料理成功");
		setItemMassage("料理\n \nさっき作った料理\n美味しそうだけど、今は食べる気がしない");

	}

}
