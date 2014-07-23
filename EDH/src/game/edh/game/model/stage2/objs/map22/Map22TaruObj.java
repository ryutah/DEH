package game.edh.game.model.stage2.objs.map22;

import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.stage2.event.TaruEvent;

public class Map22TaruObj extends MapObject {

	public Map22TaruObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(6.5f, 6, 1, 1);
		setDrawable(Assets.games.get("taru", TextureRegionDrawable.class));
		setCollision(true);
	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		world.addEventObj(new TaruEvent(world));
	}

}
