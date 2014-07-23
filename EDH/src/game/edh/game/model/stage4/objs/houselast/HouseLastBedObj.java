package game.edh.game.model.stage4.objs.houselast;

import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage4Flag;
import game.edh.game.model.stage4.event.MapEventRemBed;

public class HouseLastBedObj extends MapObject {
	public static final String NAME = "bed";

	public HouseLastBedObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setName(NAME);
		setBounds(9, 11, 2, 2);
		setDrawable(Assets.games.get("bed", TextureRegionDrawable.class));
		if (world.getFlag(Stage4Flag.RIM_BED)) {
			setDraw(false);
			setCollision(false);
			setCheck(false);
		} else
			setCollision(true);
	}

	@Override
	public void update(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		if (draw && world.getFlag(Stage4Flag.RIM_BED)) {
			setDraw(false);
			setCollision(false);
			setCheck(false);
		}
	}
	
	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		world.addMapEvent(new MapEventRemBed(world));
	}
}
