package game.edh.event.model;

import game.edh.event.model.Character.CharaDirection;
import game.edh.event.screen.EventScreen;

public class Event4 extends EventWorld {
	String[] texts1 = { "森を歩き、すっかり夕方になった頃、少女はまたあの場所にやってきました" };
	String[] texts2 = { "やはり青い少女はそこにいました", "『こんにちは\n今日も来てくれたのね』",
			"『最近は毎日あなたがここに来てくれるから、私とっても楽しいの』", "『今日は何をしようかしら』",
			"『お花を摘むのもいいし、それともパパに竿を借りて、池で釣りでもしてみましょうか』" };
	String[] texts3 = { "『でもまたお家でお人形で遊ぶのもいいし…ああ、やりたいことがいっぱいで困っちゃう\nねえ、あなたはどうしたい？』" };
	String[] texts4 = { "少女は、自分もなにか言おうとしたのですが、何故か声が出てきませんでした",
			"しかし青い少女は、まるで自分の話を聞いているかのように、こっちに耳を傾けています" };
	String[] texts5 = { "青い少女は微笑んで言いました", "『そうね、きっと今日中にできるものね』",
			"『じゃあまた私の家に行きましょうか』", "『そうだ、出来上がったらぜひあなたのお家に持って帰って』",
			"『あなた犬をほしがってたでしょう？\n本物ではないけれど、いっぱい可愛がってあげて』",
			"『…でもたまにはわたしにも会わせてね？』" };

	int eventNum;
	Character s;
	Character y;

	public Event4(EventScreen screen) {
		super(screen);
		// TODO 自動生成されたコンストラクター・スタブ
		s = new CharaS(this);
		s.setPosition(20, 0);
		s.setState(CharaS.ARUKU);
		s.setDirection(CharaDirection.LEFT);

		y = new CharaY(this);
		y.setDirection(CharaDirection.RIGHT);
		y.setState(CharaY.YOKOMUKI);
		y.setPosition(2, 0);
		y.setShow(true);

		addEventChara(s, y);

		setBackName("fall");
		text.setText(texts1);

		eventNum = 0;
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
			text.setText(texts4);
			setState(EventState.Ready);
			break;
		case 3:
			text.setText(texts5);
			setState(EventState.Ready);
			break;
		case 4:
			setState(EventState.End);
			break;
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
		case 2:
			s.setState(CharaS.MIOROSU);
			startText();
			break;
		case 3:
			y.setState(CharaY.YOKOMUKI);
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
