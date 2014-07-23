package game.edh.event.model;

import game.edh.event.model.Character.CharaDirection;
import game.edh.event.screen.EventScreen;

public class Event6 extends EventWorld {
	String[] texts1 = { "もう少しで何か大切な事を思い出せそうです", "きっとこの先にいる彼女に会えば…" };
	String[] texts2 = { "『…こんにちは、来てくれてありがとう\nとても嬉しいわ』",
			"『寒かったでしょう\n今日は家でゆっくりしましょう』",
			"『今日はもうお料理も用意してあるのよ\nきっと冷えきってるだろうと思って、あたたまるものを作ったの』",
			"『初めて作ったものなんだけど、結構上手にできたのよ\nぜひ感想をきかせてね』", "とても楽しそうに青い少女は話してきます",
			"しかし、何故か少女はざわざわと落ち着かない気持ちで話を聞いていました", "…そして少し表情を変えて青い少女が話しました" };
	String[] texts3 = { "『…そうだ、ちょっと言っておかなくちゃいけないことがあったの』",
			"『後でにすると忘れちゃいそうだから、今言っておくわ』", "『あのね、えっとね……』" };
	
	Character s, y;
	int eventNum;

	public Event6(EventScreen screen) {
		super(screen);
		// TODO 自動生成されたコンストラクター・スタブ
		setBackName("winter");
		s = new CharaS(this);
		s.setPosition(20, 0);
		s.setDirection(CharaDirection.LEFT);
		s.setState(CharaS.ARUKU);
		
		y = new CharaY(this);
		y.setPosition(2, 0);
		y.setDirection(CharaDirection.RIGHT);
		y.setState(CharaY.YOKOMUKI);
		y.setShow(true);
		
		addEventChara(s, y);
		text.setText(texts1);
	}

	@Override
	public void charaMoveEnd() {
		// TODO 自動生成されたメソッド・スタブ
		s.setState(CharaS.YOKOMUKI);
		startText();
	}

	@Override
	public void textEnd() {
		// TODO 自動生成されたメソッド・スタブ
		switch(eventNum) {
		case 0:
			text.setText(texts2);
			setState(EventState.Ready);
			break;
		case 1:
			text.setText(texts3);
			setState(EventState.Ready);
			break;
		case 2:
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
		switch(eventNum) {
		case 0:
			screen.showGroup();
			s.moveTo(8);
			setState(EventState.CharaChange);
			break;
		case 1:
			y.setState(CharaY.MIOROSU);
			startText();
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
