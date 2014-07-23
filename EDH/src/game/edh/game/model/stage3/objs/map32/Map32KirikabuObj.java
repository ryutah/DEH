package game.edh.game.model.stage3.objs.map32;

import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import game.edh.Assets;
import game.edh.EdhGame;
import game.edh.MusicHandler.EfftctType;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.GamesFlag.Stage3Flag;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.items.ItemsHandler;

public class Map32KirikabuObj extends MapObject {

	public Map32KirikabuObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(5, 27, 2, 2);
		if (!world.getFlag(Stage3Flag.KIRIKABU))
			setDrawable(Assets.games.get("kirikabu_yuki",
					TextureRegionDrawable.class));
		else
			setDrawable(Assets.games.get("kirikabu",
					TextureRegionDrawable.class));
		setCollision(true);
	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		if (!world.getFlag(Stage3Flag.KIRIKABU)) {
			if (world.getSelectItem() == ItemsHandler.TEBUKURO) {
				EdhGame.music.playEffect(EfftctType.HARAU, false);
				world.textEvent("手袋をつけて切り株の雪を払った");
				setDrawable(Assets.games.get("kirikabu",
						TextureRegionDrawable.class));
				world.changeFlag(Stage3Flag.KIRIKABU, true);
			} else
				world.textEvent("切り株がある", "雪で覆われているが、とても冷たくて触れない");
		} else {
			world.textEvent("文字が刻まれている", "『地面の真ん中、ほってみて！』");
		}
		super.checkObj();
	}
}
