package game.edh.game.model.stage2.objs.mizuumi;

import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage2Flag;

public class MizuumiTsurizaoObj extends MapObject {

	public MizuumiTsurizaoObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(7.5f, 8.5f, 1, 1);
		setDrawable(Assets.games.get("mTsurizao",
				TextureRegionDrawable.class));
		setCheck(false);

		if (!world.getFlag(Stage2Flag.SAO_SET))
			setDraw(false);
	}

	@Override
	public void update(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		if (!draw && world.getFlag(Stage2Flag.SAO_SET))
			setDraw(true);
		if (draw && !world.getFlag(Stage2Flag.SAO_SET))
			setDraw(false);
	}
}
