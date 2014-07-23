package game.edh.game.model.stage1.event;

import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.event.ButtonModoru;
import game.edh.game.model.frame.event.ModelEvent;
import game.edh.game.model.frame.event.ModelEventObj;

public class EventMemo extends ModelEvent {

	class Memo extends ModelEventObj {

		public Memo(ModelEvent parent, ObjType type) {
			super(parent, type);
			// TODO 自動生成されたコンストラクター・スタブ
			setDrawable(Assets.games.get("memo", TextureRegionDrawable.class));
			setCenter(true);
			setSize(6.5f);
		}

		@Override
		protected void action(float x, float y) {
			// TODO 自動生成されたメソッド・スタブ
			world.textEvent("メモに何か書いてある", "「料理メモ」",
					"山草１つに、きのみを１つ、たまねぎを入れたら塩、胡椒を加えて出来上がり",
					"簡単だけどそこそこおいしい、お手軽料理！");
		}
	}

	public EventMemo(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		ModelEventObj obj = new Memo(this, ObjType.Image);
		ModelEventObj modoru = new ButtonModoru(this, ObjType.Button);
		addObjs(obj);
		addObjs(modoru);
	}

}
