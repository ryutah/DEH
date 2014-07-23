package game.edh.game.model.stage4.objs.houselast;

import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage4Flag;
import game.edh.game.model.stage4.event.MapEventRemTsukue2;

public class HouseLastTableObj extends MapObject {
	public static final String NAME = "tsukue2";

	public HouseLastTableObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setName(NAME);
		setBounds(8, 4, 2, 5);
		setDrawable(Assets.games.get("tsukue2", TextureRegionDrawable.class));

		if (world.getFlag(Stage4Flag.RIM_TSUKUE2)) {
			setDraw(false);
			setCollision(false);
			setCheck(false);
		} else
			setCollision(true);
	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		world.addMapEvent(new MapEventRemTsukue2(world));
	}
	
	@Override
	public void update(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		if(draw && world.getFlag(Stage4Flag.RIM_TSUKUE2)) {
			setDraw(false);
			setCollision(false);
			setCheck(false);
		}
	}
}
