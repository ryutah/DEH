package game.edh.game.model.stage2.objs.house2;

import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage2Flag;

public class House2NingyoOnj extends MapObject {

	public House2NingyoOnj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(1.5f, 6, 1, 1);
		setCheck(false);
		setDrawable(Assets.games.get("ningyoAo", TextureRegionDrawable.class));

		if (world.getFlag(Stage2Flag.NINGYO_PUT))
			setDraw(true);
		else
			setDraw(false);
	}

	@Override
	public void update(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		if(!draw && world.getFlag(Stage2Flag.NINGYO_PUT))
			setDraw(true);
	}
}
