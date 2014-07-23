package game.edh.event.model;

import game.edh.event.model.Character.CharaDirection;
import game.edh.event.screen.EventScreen;

public class Event3 extends EventWorld {
	int eventNum;
	String[] texts1 = { "少女はまた同じ家で目を覚ましました", "あの青い少女と森の中で出会ったことは思い出せるのですが、",
			"その後のことは思い出せませんでした", "そもそもあれは本当に昨日の事だったのでしょうか" };
	String[] texts2 = { "あたりを見渡してみましたが、やっぱり家の中には誰も居ないようです",
			"…なんとなくですが、以前よりもこの家が慣れ親しんだものに感じられました" };
	String[] texts3 = { "またあの子に会えるかもしれない…", "そう考え、少女はまたあの場所に行ってみることにしました" };

	Character s;

	public Event3(EventScreen screen) {
		super(screen);
		// TODO 自動生成されたコンストラクター・スタブ
		s = new CharaS(this);
		s.setPosition(4, 0);
		s.setDirection(CharaDirection.LEFT);
		s.setState(CharaS.KAGAMU);
		addEventChara(s);

		setBackName("ie");
		text.setText(texts1);
	}

	@Override
	public void charaMoveEnd() {
		// TODO 自動生成されたメソッド・スタブ
		screen.eventEnd();
	}

	@Override
	public void textEnd() {
		// TODO 自動生成されたメソッド・スタブ
		switch (eventNum) {
		case 0:
			s.setState(CharaS.MIAGERU);
			text.setText(texts2);
			setState(EventState.Ready);
			break;

		case 1:
			s.setState(CharaS.YOKOMUKI);
			text.setText(texts3);
			setState(EventState.Ready);
			break;

		case 2:
			setState(EventState.Ready);
			break;
		}
	}

	@Override
	public void startEvent() {
		// TODO 自動生成されたメソッド・スタブ
		screen.showGroup();
		startText();
	}

	@Override
	public void touchWorld() {
		// TODO 自動生成されたメソッド・スタブ
		switch (state) {
		case CharaChange:
			break;
		case Text:
			text.changeText();
			break;
		case Ready:
			switch (eventNum) {
			case 0:
				startText();
				break;
			case 1:
				startText();
				break;
			case 2:
				s.setState(CharaS.ARUKU);
				s.moveTo(-6);
				setState(EventState.CharaChange);
				break;
			}
			eventNum++;
			break;
		case End:
			break;
		}
	}

	@Override
	void touchForText() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	void touchForReady() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	void touchForCharaChange() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	void touchForEnd() {
		// TODO 自動生成されたメソッド・スタブ

	}

}
