package game.edh.game.model.stage2.objs.map22;

import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage2Flag;
import game.edh.game.model.stage2.event.TaruEvent;

public class Map22Taru2Obj extends MapObject {
	boolean breaked;

	public Map22Taru2Obj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(7.5f, 6, 1, 1);
		setCollision(true);

		if (world.getFlag(Stage2Flag.TARU_BREAK)) {
			setDrawable(Assets.games.get("taru_b", TextureRegionDrawable.class));
			breaked = true;
		} else {
			setDrawable(Assets.games.get("taru", TextureRegionDrawable.class));
			breaked = false;
		}
	}

	@Override
	public void update(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		if (!breaked) {
			if (world.getFlag(Stage2Flag.TARU_BREAK)) {
				setDrawable(Assets.games.get("taru_b",
						TextureRegionDrawable.class));
				breaked = true;
			}
		}
	}
	
	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		world.addEventObj(new TaruEvent(world));
	}
}
