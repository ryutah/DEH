package game.edh.game.model.frame;

import game.edh.game.actor.ActorText;

public class ModelText {
	String[] text;
	String[] bufText;
	int textNum;
	boolean change;
	float state;

	GameWorld world;
	ActorText listner;

	public ModelText(GameWorld world) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.world = world;
	}

	public void update(float delta) {
		if (change) {
			state += delta;
			if (state >= .6f) {
				change = false;
				state = 0;
			}
		}

		if(bufText != null && text == null) {
			setText(bufText);
			bufText = null;
		}
	}

	public void setListener(ActorText listner) {
		this.listner = listner;
	}

	public void setText(String... texts) {
		if (text != null && textNum < text.length) {
			bufText = texts;
		} else {
			text = texts;
			change = true;
			if (listner != null)
				listner.startText();
		}
	}

	public void changeText() {
		if (!change) {
			if (textNum < text.length - 1) {
				change = true;
				textNum++;
			} else {
				world.textEnd();
				text = null;
				textNum = 0;
				if (listner != null && bufText == null)
					listner.endText();
			}
		}
	}

	public CharSequence getText() {
		if (text != null && textNum < text.length)
			return text[textNum];
		else
			return "";
	}
}
