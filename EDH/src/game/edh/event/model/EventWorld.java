package game.edh.event.model;

import game.edh.event.screen.EventScreen;

import com.badlogic.gdx.utils.Array;

public abstract class EventWorld {
	public enum EventState {
		Text, CharaChange, Ready, End
	}

	Array<Character> charas;
	protected Texts text;
	protected EventState state;

	protected EventScreen screen;
	String backName;

	public EventWorld(EventScreen screen) {
		// TODO 自動生成されたコンストラクター・スタブ
		text = new Texts(this);
		charas = new Array<Character>();

		this.screen = screen;
	}

	public abstract void charaMoveEnd();

	public abstract void textEnd();

	public abstract void startEvent();

	public void update(float delta) {
		for (Character chara : charas) {
			chara.update(delta);
		}

		text.update(delta);
	}

	/**
	 * 画面タップ時の動作を設定する stateによって違う動作を行わせる
	 */
	public void touchWorld() {
		if (state == null)
			return;

		switch (state) {
		case Text:
			touchForText();
			break;
		case Ready:
			touchForReady();
			break;
		case CharaChange:
			touchForCharaChange();
			break;
		case End:
			touchForEnd();
			break;
		}
	}

	void touchForText() {
		text.changeText();
	}

	abstract void touchForReady();

	void touchForCharaChange() {

	}

	abstract void touchForEnd();

	public Texts getTextModel() {
		return text;
	}

	public EventState getState() {
		return state;
	}

	protected void setState(EventState state) {
		this.state = state;
	}

	protected void startText() {
		text.startText();
		setState(EventState.Text);
	}

	protected void setBackName(String name) {
		this.backName = name;
	}

	protected void addEventChara(Character... charas) {
		for (int i = 0; i < charas.length; i++) {
			this.charas.add(charas[i]);
		}
	}

	public Array<Character> getCharas() {
		return charas;
	}

	public Character getChara(String name) throws Exception {
		for (Character chara : charas) {
			if (chara.getName().equals(name))
				return chara;
		}
		throw new Exception("ErroR");
	}

	public String getBackName() {
		return backName;
	}
}
