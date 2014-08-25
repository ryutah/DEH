package game.edh.event.model;

import game.edh.Assets;
import game.edh.event.model.Character.CharaDirection;
import game.edh.event.screen.Event8Screen;
import game.edh.event.screen.EventScreen;

public class Event10 extends EventWorld {
	String[] texts1 = { "幼い頃は、よくこの森で遊んでいたらしいのですが、どうもよく覚えていません",
			"春のにぎわいを見せる森の景色は、新鮮なような懐かしいような、綺麗で目を奪われてしまいます",
			"森を進んでいくうちに、少し開けた場所にたどり着きました" };
	String[] texts2 = { "他よりも足の低い草が生え、ちょうど真ん中あたりには一本の木が生えています",
			"ふと、木の根元あたりに何かあるのに気づきました" };
	String[] texts3 = { "とても汚れた、犬の人形がありました", "周りの美しい景色とはまるで似合わない姿です",
			"…なのに、なぜか目が離せず、女性はその人形を見つめていました……",
			"全く記憶に無いその人形を、いつまでもいつまでも見つめていました", "   " };

	Character s, i;
	int eventNum;

	public Event10(EventScreen screen) {
		super(screen);
		// TODO 自動生成されたコンストラクター・スタブ
		setBackName("spring");
		s = new CharaS(this);
		s.setPosition(6, 0);
		s.setDirection(CharaDirection.RIGHT);
		s.setState(CharaS.OTONA);

		i = new Character(this);
		i.setDrawable(Assets.event.getDrawable("inu"));
		i.setSize(1, 1);
		i.setPosition(3, 0);
		i.setShow(false);
		addEventChara(s, i);

		text.setText(texts1);
	}

	@Override
	public void charaMoveEnd() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void textEnd() {
		// TODO 自動生成されたメソッド・スタブ
		switch (eventNum) {
		case 0:
			text.setText(texts2);
			setState(EventState.Ready);
			break;
		case 1:
			text.setText(texts3);
			setState(EventState.Ready);
			break;
		case 2:
			((Event8Screen)screen).endGame();
			setState(EventState.End);
		}
	}

	@Override
	public void startEvent() {
		// TODO 自動生成されたメソッド・スタブ
		startText();
	}

	@Override
	void touchForReady() {
		// TODO 自動生成されたメソッド・スタブ
		switch (eventNum) {
		case 0:
			screen.showGroup();
			startText();
			break;
		case 1:
			i.setShow(true);
			startText();
			break;
		}
		eventNum++;
	}

	@Override
	void touchForEnd() {
		// TODO 自動生成されたメソッド・スタブ
	}

}
