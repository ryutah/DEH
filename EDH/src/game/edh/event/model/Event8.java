package game.edh.event.model;

import game.edh.Assets;
import game.edh.event.model.Character.CharaDirection;
import game.edh.event.screen.EventScreen;

public class Event8 extends EventWorld {
	Character s, i;

	String[] texts1 = { "やっぱり今日もいない…", "もう遠くにいっちゃったのかな", "…ここに置いておけばきづいてくれるかな" };
	String[] texts2 = { "ばいばい\nあの子によろしくね", "ごめんねって言っておいて…" };
	int eventNum;

	public Event8(EventScreen screen) {
		super(screen);
		// TODO 自動生成されたコンストラクター・スタブ
		setBackName("past");
		s = new CharaS(this);
		s.setState(CharaS.KAGAMU);
		s.setPosition(5, 0);
		s.setDirection(CharaDirection.LEFT);

		i = new Character(this);
		i.setDrawable(Assets.event.getDrawable("inu"));
		i.setShow(false);
		i.setPosition(3, 0);
		i.setSize(1, 1);
		addEventChara(s, i);

		text.setText(texts1);
	}

	@Override
	public void charaMoveEnd() {
		// TODO 自動生成されたメソッド・スタブ
		setState(EventState.End);
		screen.changeWorld(new Event9(screen), 2);
	}

	@Override
	public void textEnd() {
		// TODO 自動生成されたメソッド・スタブ
		switch (eventNum) {
		case 0:
			text.setText(texts2);
			setState(EventState.Ready);
		case 1:
			setState(EventState.Ready);
			break;
		}
	}

	@Override
	public void startEvent() {
		// TODO 自動生成されたメソッド・スタブ
		screen.showGroup();
		screen.setCamMove(false);
		startText();
	}

	@Override
	void touchForReady() {
		// TODO 自動生成されたメソッド・スタブ
		switch (eventNum) {
		case 0:
			i.setShow(true);
			startText();
			break;
		case 1:
			s.setDirection(CharaDirection.RIGHT);
			s.setState(CharaS.ARUKU);
			s.moveTo(22);
			break;
		}
		eventNum++;
	}

	@Override
	void touchForEnd() {
		// TODO 自動生成されたメソッド・スタブ
	}

}
