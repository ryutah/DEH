package game.edh.game.model.items;

import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;

public class RyouriShippai extends Items {

	public RyouriShippai(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setDrawable(Assets.games.get("ryouri", TextureRegionDrawable.class));
		setItemId(ItemsHandler.RYOURI_SHIPPAI);
		setItemName("料理失敗");
		setItemMassage("料理\n \nさっき作った料理\n美味しそうだけど、私は今は食べたくない");
	}

}
