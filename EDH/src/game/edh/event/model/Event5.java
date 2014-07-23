package game.edh.event.model;

import game.edh.event.model.Character.CharaDirection;
import game.edh.event.screen.EventScreen;

public class Event5 extends EventWorld {
	String[] texts1 = { "今度は家の中ではなく、森の中で目覚めました", "雪の積もった、冬の森のなかです",
			"見ているだけでも凍えてしまいそうな景色なのですが、なぜかちっとも寒くありません" };
	String[] texts2 = { "それでもやっぱり、こんなところで一人ぼっちでいるのはあまり気分のいいものではありません",
			"とりあえず、いつもの家を目指して、少女は少し足早に森を進んでいきました" };

	Character s;
	int eventNum;
	
	public Event5(EventScreen screen) {
		super(screen);
		// TODO 自動生成されたコンストラクター・スタブ
		setBackName("winter");

		s = new CharaS(this);
		s.setPosition(12, 0);
		s.setDirection(CharaDirection.RIGHT);
		s.setState(CharaS.KAGAMU);
		addEventChara(s);
	}

	@Override
	public void charaMoveEnd() {
		// TODO 自動生成されたメソッド・スタブ
		screen.eventEnd();
	}

	@Override
	public void textEnd() {
		// TODO 自動生成されたメソッド・スタブ
		switch(eventNum) {
		case 0:
			setState(EventState.Ready);
			s.setState(CharaS.MIAGERU);
			text.setText(texts2);
			break;
		case 1:
			setState(EventState.Ready);
		}
	}

	@Override
	public void startEvent() {
		// TODO 自動生成されたメソッド・スタブ
		screen.showGroup();
		text.setText(texts1);
		startText();
		
	}

	@Override
	void touchForReady() {
		// TODO 自動生成されたメソッド・スタブ
		switch(eventNum) {
		case 0:
			startText();
			break;
		case 1:
			s.moveTo(25);
			s.setState(CharaS.HASHIRU);
			setState(EventState.CharaChange);
		}
		eventNum++;
	}

	@Override
	void touchForEnd() {
		// TODO 自動生成されたメソッド・スタブ

	}

}
