package game.edh.game.model.stage2.event;

import game.edh.Assets;
import game.edh.EdhGame;
import game.edh.MusicHandler.EfftctType;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.GamesFlag.Stage2Flag;
import game.edh.game.model.frame.event.ButtonModoru;
import game.edh.game.model.frame.event.ModelEvent;
import game.edh.game.model.frame.event.ModelEventObj;
import game.edh.game.model.items.ItemsHandler;

public class TaruEvent extends ModelEvent {
	class Taru extends ModelEventObj {

		public Taru(ModelEvent parent, ObjType type) {
			super(parent, type);
			// TODO 自動生成されたコンストラクター・スタブ
			setSize(2);
			setCenterY(true);
			setDrawable(Assets.games, "taru");
		}

		@Override
		protected void action(float x, float y) {
			// TODO 自動生成されたメソッド・スタブ
			if (!world.getFlag(Stage2Flag.MEMO_GET)) {
				world.addItem(ItemsHandler.MEMO2);
				world.changeFlag(Stage2Flag.MEMO_GET, true);
				world.textEvent("中に何か入ってる", "メモを手に入れた");
			} else
				world.textEvent("何も入ってないみたい");
		}
	}

	class Taru2 extends ModelEventObj {
		boolean bre;

		public Taru2(ModelEvent parent, ObjType type) {
			super(parent, type);
			// TODO 自動生成されたコンストラクター・スタブ
			setSize(2);
			setCenterY(true);

			if (world.getFlag(Stage2Flag.TARU_BREAK)) {
				bre = true;
				setDrawable(Assets.games, "taru_b");
			} else {
				bre = false;
				setDrawable(Assets.games, "taru");
			}
		}

		@Override
		protected void action(float x, float y) {
			if (!bre) {
				if (world.getSelectItem() == ItemsHandler.KANAZUTI) {
					EdhGame.music.playEffect(EfftctType.ONO, false);
					bre = true;
					world.changeFlag(Stage2Flag.TARU_BREAK, true);
					world.textEvent("たるをおもいっきり叩いた");
					setDrawable(Assets.games, "taru_b");
				} else
					world.textEvent("たるがある", "ふたはしっかりと閉まっていて開きそうにない");
			} else {
				if(!world.getFlag(Stage2Flag.TAMAGO_GET)) {
					world.addItem(ItemsHandler.TAMAGO);
					world.changeFlag(Stage2Flag.TAMAGO_GET, true);
					world.textEvent("中を調べてみた", "たまごを手に入れた");
				} else
					world.textEvent("もう何も入っていない");
			}
		}

	}

	public TaruEvent(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		ModelEventObj taru = new Taru(this, ObjType.Image);
		ModelEventObj taru2 = new Taru2(this, ObjType.Image);

		ModelEventObj modoru = new ButtonModoru(this, ObjType.Button);

		taru.setX(3.4f);
		taru2.setX(5.4f);

		addObjs(taru);
		addObjs(taru2);
		addObjs(modoru);
	}

}
