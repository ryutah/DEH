package game.edh.game.model.stage2.event;

import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import game.edh.Assets;
import game.edh.EdhGame;
import game.edh.MusicHandler.EfftctType;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.event.ButtonModoru;
import game.edh.game.model.frame.event.ModelEvent;
import game.edh.game.model.frame.event.ModelEventObj;

public class EventMemo2 extends ModelEvent {
	boolean reverse;

	class Memo extends ModelEventObj {

		public Memo(ModelEvent parent, ObjType type) {
			super(parent, type);
			// TODO 自動生成されたコンストラクター・スタブ
			setDrawable(Assets.games.get("memo", TextureRegionDrawable.class));
			setCenter(true);
			setSize(6.5f);
			reverse = false;
		}
		
		@Override
		protected boolean flingAction(float velocityX, float velocityY) {
			// TODO 自動生成されたメソッド・スタブ
			float vX = Math.abs(velocityX);
			float vY = Math.abs(velocityY);

			if (vX >= 300 || vY >= 300) {
				if (!reverse) {
					setDrawable(Assets.games, "memo_back");
					reverse = true;
				} else {
					setDrawable(Assets.games, "memo");
					reverse = false;
				}
				EdhGame.music.playEffect(EfftctType.PAGE, false);
				return true;
			} else
				return false;
		}

		@Override
		protected void action(float x, float y) {
			// TODO 自動生成されたメソッド・スタブ
			if (reverse)
				world.textEvent("裏になにかのメモが書いてある", "”左　右　左　上 ”");
			else
				world.textEvent("手紙みたい", "”この森に慣れていない人にはあの場所は少し難しいかもしれません",
						"なにしろずっと同じ様な景色が続くので、歩いているうちに方向感覚を失ってしまいます",
						"私のところへお越しいただければご案内致しますので、１人では決して入らないで下さい ”");
		}
	}

	public EventMemo2(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		ModelEventObj obj = new Memo(this, ObjType.Image);
		ModelEventObj modoru = new ButtonModoru(this, ObjType.Button);
		addObjs(obj);
		addObjs(modoru);
	}

}
