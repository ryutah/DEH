package game.edh.game.model.stage4.objs.house4;

import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage4Flag;

public class House4SaraObj extends MapObject {

	public House4SaraObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(16.5f, 6, 1, 1);
		setCheck(false);
		setDrawable(Assets.games.get("sara", TextureRegionDrawable.class));
		if (!world.getFlag(Stage4Flag.PUT_RYORI))
			setDraw(false);
	}

	@Override
	public void update(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		if (!draw && world.getFlag(Stage4Flag.PUT_RYORI))
			setDraw(true);
	}
}
