package game.edh.event.model;

import game.edh.Assets;
import game.edh.EdhGame;
import game.edh.event.model.Character.CharaDirection;
import game.edh.event.screen.EventScreen;

public class Event1 extends EventWorld {
	int eventNum;
	String[] texts1 = { "『ずっといっしょだよね…』", "………" };
	String[] texts2 = { "少女が目をさますと、知らない家にいました", "知らないというよりは、思いだせないというか",
			"なんだか不思議な感覚です", "とりあえず、どうしてこの場所にいるのか、昨日の記憶をたどってみようとしたのですが、",
			"どうも思い出せません" };
	String[] texts3 = { "窓から外を見てみると、木々が生い茂っています", "どうやらここは森の中にある小屋のようです" };
	String[] texts4 = { "このままここにいれば誰か来るのかもしれないのですが、",
			"どうにも気持ちが落ち着かないので、少女は森に出てみることにしました。" };

	Character s;

	public Event1(EventScreen screen) {
		// TODO 自動生成されたコンストラクター・スタブ
		super(screen);

		s = new CharaS(this);
		addEventChara(s);

		eventNum = 0;
		text.setText(texts1);

		s.setPosition(4, 0);
		s.setState(CharaS.KAGAMU);
		s.setDirection(CharaDirection.RIGHT);
		EdhGame.music.changeMusic(Assets.AKAIFUUSEN);

		setBackName("ie");
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
			text.setText(texts2);
			setState(EventState.Ready);
			break;
		case 1:
			text.setText(texts3);
			s.setState(CharaS.MIAGERU);
			s.setDirection(CharaDirection.LEFT);
			setState(EventState.Ready);
			break;
		case 2:
			text.setText(texts4);
			s.setState(CharaS.MIOROSU);
			setState(EventState.Ready);
			break;
		case 3:
			setState(EventState.Ready);
			break;
		}
	}

	@Override
	public void startEvent() {
		// TODO 自動生成されたメソッド・スタブ
		text.startText();
		setState(EventState.Text);
	}

	@Override
	void touchForReady() {
		// TODO 自動生成されたメソッド・スタブ
		switch (eventNum) {
		case 0:
			text.startText();
			screen.showGroup();
			EdhGame.music.playMusic();
			setState(EventState.Text);
			break;
		case 1:
			text.startText();
			setState(EventState.Text);
			break;
		case 2:
			text.startText();
			setState(EventState.Text);
			break;
		case 3:
			s.setState(CharaS.ARUKU);
			setState(EventState.CharaChange);
			s.moveTo(-8);
			break;
		}

		eventNum++;
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
