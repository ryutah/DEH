package game.edh.game.model.stage2.objs.mizuumi;

import game.edh.EdhGame;
import game.edh.MusicHandler.EfftctType;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.GamesFlag.Stage2Flag;
import game.edh.game.model.items.ItemsHandler;

public class MizuumiObj extends MapObject {

	public MizuumiObj(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		setBounds(7, 8, 2, 1);
	}

	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		if (!world.getFlag(Stage2Flag.FISH)) {
			if (!world.getFlag(Stage2Flag.SAO_SET)) {
				if (world.getSelectItem() == ItemsHandler.TSURIZAO) {
					EdhGame.music.playEffect(EfftctType.AWA, false);
					world.textEvent("釣り竿を使ってみた");
					world.removeItem(ItemsHandler.TSURIZAO);
					world.changeFlag(Stage2Flag.SAO_SET, true);
				} else
					world.textEvent("池がある", "…さかなとかいるのかな？");
			} else {
				if (!world.getFlag(Stage2Flag.PUT_RYOURI1))
					world.textEvent("まだ何も釣れないみたい", "少し時間がたったらまた来てみよう");
				else {
					world.textEvent("なにかかかってる！", "さかなを手に入れた", "他にも何か引っかかってる…",
							"鍵を手に入れた");
					world.addItem(ItemsHandler.SAKANA);
					world.addItem(ItemsHandler.KAGI);
					world.changeFlag(Stage2Flag.SAO_SET, false);
					world.changeFlag(Stage2Flag.FISH, true);
				}
			}
		} else
			world.textEvent("もう釣りはいいかな");
	}

}
