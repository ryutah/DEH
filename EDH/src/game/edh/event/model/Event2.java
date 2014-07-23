package game.edh.event.model;

import game.edh.event.model.Character.CharaDirection;
import game.edh.event.screen.EventScreen;

public class Event2 extends EventWorld {
	Character s, y;

	int eventNum;

	String[] texts1 = { "橋を越えて、少女は再び森のなかを歩き始めました。",
			"橋の前にあった看板によれば、そのうち街につきそうなものなのですが、", "歩いても歩いても、いっこうに街が見えてきません",
			"それどころか、どんどん森の奥に入って行っているような気さえします",
			"けれども、なぜか少女にはそれが不思議なことではない気がしました。", "見慣れた道を散歩しているような気さえしてきます。",
			"なのに、なんだか不安でいっぱいでした", "知らないところにいるからではなく、このまま歩いていればつくであろう場所に対してです",
			"でもそこに行くのをずっと楽しみにしていたような…", "そんな不思議な気持ちで少女は歩いていきました…" };
	String[] texts2 = { "森を抜け、一本の木がある開けた場所につきました。",
			"やっぱりそこも少女にとって見覚えのある、だけど知らない場所でした", "木のそばをよく見てみると、青い服をきた少女がいました" };
	String[] texts3 = { "『まあ、こんなところに私以外の女の子が来るなんて思わなかったわ』", "青い少女が話しかけてきました",
			"『ねえ、あなたの家もこの森にあるの？", "私のお家はこの先にあるのよ』" };
	String[] texts4 = { "『街に遊びに行ったりしたいんだけど、遠いからなかなか行けなくて…』",
			"『ねえ、もしよかったら暇な時でいいからこの場所に来て私と遊んでくれないかしら？』",
			"その言葉につられるように、少女はうなずきました", "なぜかそうしなければいけないような気がして…",
			"『遊んでくれるのね…ありがとう』", "青い少女はとても嬉しそうでした", "『ねえ、今から私の家にこない？",
			"これから森で山草をとって料理を作ろうと思っていたの』", "青い少女はとてもとても嬉しそうでした" };

	public Event2(EventScreen screen) {
		super(screen);
		// TODO 自動生成されたコンストラクター・スタブ
		s = new CharaS(this);
		y = new CharaY(this);

		addEventChara(s, y);

		eventNum = 0;
		s.setPosition(18, 0);
		s.setState(CharaS.ARUKU);
		s.setDirection(CharaDirection.LEFT);

		y.setPosition(2, 0);
		y.setState(CharaY.YOKOMUKI);
		y.setDirection(CharaDirection.RIGHT);
		y.setShow(false);

		setState(EventState.Text);
		setBackName("summer");
	}

	@Override
	public void charaMoveEnd() {
		// TODO 自動生成されたメソッド・スタブ
		if (eventNum == 1) {
			s.setState(CharaS.YOKOMUKI);
			text.startText();
			setState(EventState.Text);
		}
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
			text.setText(texts4);
			setState(EventState.Ready);
			break;
		case 3:
			setState(EventState.End);
		}
	}

	@Override
	public void startEvent() {
		// TODO 自動生成されたメソッド・スタブ
		text.setText(texts1);
		text.startText();
	}

	@Override
	public void touchWorld() {
		// TODO 自動生成されたメソッド・スタブ
		switch (state) {
		case Text:
			text.changeText();
			break;
		case CharaChange:
			break;
		case End:
			screen.eventEnd();
			break;
		case Ready:
			switch (eventNum) {
			case 0:
				screen.showGroup();
				s.moveTo(8);
				setState(EventState.CharaChange);
				break;
			case 1:
				y.setShow(true);
				text.startText();
				setState(EventState.Text);
				break;
			case 2:
				y.setState(CharaY.MIOROSU);
				text.startText();
				setState(EventState.Text);
				break;
			}

			eventNum++;
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
