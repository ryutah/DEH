package game.edh.event.model;

import game.edh.event.model.Character.CharaDirection;
import game.edh.event.screen.EventScreen;

public class Event7 extends EventWorld {
	String[] texts1 = { "もうあえなくなっちゃうの？", "『…しばらく会えないかもしれないわ』",
			"ずっといっしょじゃなかったの？", "『ごめんなさい…』" };
	String[] texts2 = { "うそつき！うそつき！\nあなたなんてきらい！", "だいっきらい！！", "『……お願いそんなこといわないで』" };

	int eventNum;
	Character s;

	public Event7(EventScreen screen) {
		super(screen);
		// TODO 自動生成されたコンストラクター・スタブ
		setBackName("past");
		s = new CharaS(this);
		s.setPosition(8, 0);
		s.setDirection(CharaDirection.LEFT);
		s.setState(CharaS.YOKOMUKI);
		
		Character y = new CharaY(this);
		y.setDirection(CharaDirection.RIGHT);
		y.setPosition(2, 0);
		y.setState(CharaY.MIOROSU);
		y.setShow(true);
		addEventChara(s, y);
		
		text.setText(texts1);
	}

	@Override
	public void charaMoveEnd() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void textEnd() {
		// TODO 自動生成されたメソッド・スタブ
		if(eventNum == 0) {
			text.setText(texts2);
			setState(EventState.Ready);
		} else if(eventNum == 1) {
			setState(EventState.End);
		}
	}

	@Override
	public void startEvent() {
		// TODO 自動生成されたメソッド・スタブ
		startText();
		screen.showGroup();
	}

	@Override
	void touchForReady() {
		// TODO 自動生成されたメソッド・スタブ
		switch(eventNum) {
		case 0:
			startText();
			s.setState(CharaS.MIOROSU);
			break;
		}
		eventNum++;
	}

	@Override
	void touchForEnd() {
		// TODO 自動生成されたメソッド・スタブ
		screen.eventEnd();
	}

}
