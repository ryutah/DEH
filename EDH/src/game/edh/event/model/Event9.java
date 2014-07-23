package game.edh.event.model;

import com.badlogic.gdx.Gdx;

import game.edh.event.model.Character.CharaDirection;
import game.edh.event.screen.EventScreen;

public class Event9 extends EventWorld {
	String[] texts1 = { "ひとりの女性が、自宅で目を覚ましました" };
	String[] texts2 = { "いつもと変わらない、見慣れた部屋です",
			"ですが、何故今日はその馴染みのある風景が、少しだけ新鮮に見えます",
			"飼い犬に餌をあげなきゃいけないし、来客があるので、その準備をしなくてはいけないし、今日は朝から大忙しです",
			"とりあえず、もてなしでだす料理はどうしようか考えることにして、",
			"なんとなく、森になにかいい食材でもないものかと思い、出かけることにしました。" };

	int eventNum;

	public Event9(EventScreen screen) {
		super(screen);
		// TODO 自動生成されたコンストラクター・スタブ
		Character s = new CharaS(this);
		setBackName("ie");
		s.setPosition(4, 0);
		s.setDirection(CharaDirection.LEFT);
		s.setState(CharaS.OTONA);
		addEventChara(s);

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
			setState(EventState.End);
			break;
		}
	}

	@Override
	public void startEvent() {
		// TODO 自動生成されたメソッド・スタブ
		startText();
		Gdx.app.log("Event9", "");
	}

	@Override
	void touchForReady() {
		// TODO 自動生成されたメソッド・スタブ
		switch (eventNum) {
		case 0:
			screen.showGroup();
			startText();
			break;
		default:
		}
		eventNum++;
	}

	@Override
	void touchForEnd() {
		// TODO 自動生成されたメソッド・スタブ
		screen.changeWorld(new Event10(screen));
		setState(EventState.Ready);
	}

}
