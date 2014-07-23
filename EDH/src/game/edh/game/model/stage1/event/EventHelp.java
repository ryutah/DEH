package game.edh.game.model.stage1.event;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.event.ModelEvent;
import game.edh.game.model.frame.event.ModelEventObj;

public class EventHelp extends ModelEvent {

	class Yes extends ModelEventObj {

		public Yes(ModelEvent parent) {
			super(parent, ObjType.Button);
			// TODO 自動生成されたコンストラクター・スタブ
			setSize(3);
			setButtonStyle(Assets.games, "b_yes");
			setPosition(2, 2);
		}

		@Override
		protected void action(float x, float y) {
			// TODO 自動生成されたメソッド・スタブ
			((EventHelp) parent).endEvent(true);
		}
	}

	class No extends ModelEventObj {

		public No(ModelEvent parent) {
			super(parent, ObjType.Button);
			// TODO 自動生成されたコンストラクター・スタブ
			setSize(3);
			setButtonStyle(Assets.games, "b_no");
			setPosition(5.8f, 2);
		}

		@Override
		protected void action(float x, float y) {
			// TODO 自動生成されたメソッド・スタブ
			((EventHelp) parent).endEvent(false);
		}
	}

	public EventHelp(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		addObjs(new Yes(this));
		addObjs(new No(this));
	}

	public void endEvent(boolean yes) {
		world.removeEventObj();
		if (yes) {
			world.textEvent("画面中央下のパッドで歩くことができる", "その右にある黒い丸は現在選択中のアイテムを表示するよ",
					"アイテムは、画面フリックで表示されるパネルから選択してね",
					"パネルはパックボタンやフリックでしまうことができるんだ",
					"あと、パネルに表示されているアイテムを長押しすれば、あまり役に立たないアイテム説明が見れるよ",
					"あとは、僕に話しかけたように、画面をタップすれば自分の周りを調べることができる",
					"気になるところがあったら調べてみてね", "そこにある黄色い花にはなにかありそうだよ");
		} else
			world.textEvent("そこにある黄色い花はなにかありそうだよ\nまだ調べてなかったら、確かめてみて");
	}
}
