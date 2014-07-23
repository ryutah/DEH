package game.edh.event.model;

import com.badlogic.gdx.utils.StringBuilder;

public class Texts {
	EventWorld world;

	String[] texts;
	StringBuilder text;
	float stateTime;
	int textNum;
	int charNum;
	boolean textUpdate;

	public Texts(EventWorld world) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.world = world;
		stateTime = 0;
		text = new StringBuilder();
	}

	public void setText(String... texts) {
		this.texts = texts;
		textNum = 0;
		charNum = 0;
	}
	
	public void startText() {
		text.delete(0, text.length);
		textUpdate = true;
	}

	public void update(float delta) {
		this.stateTime += delta;
		if (stateTime >= .08f) {
			updateText();
			stateTime = 0;
		}
	}

	void updateText() {
		if (textUpdate) {
			charNum++;
			text.append(texts[textNum].subSequence(charNum - 1, charNum));
			
			if(charNum == texts[textNum].length()) {
				textUpdate = false;
				checkNext();
			}
		}
	}
	
	void checkNext() {
		if(textNum == texts.length - 1) {
			world.textEnd();
		}
	}
	
	/**
	 * テキスト表示中は最後の文字まで一気に表示、
	 * もしくは、次の文字に移行する
	 */
	public void changeText() {
		if(textUpdate) {
			text.delete(0, text.length);
			text.append(texts[textNum]);
			charNum = texts[textNum].length();
			textUpdate = false;
			checkNext();
		} else {
			text.delete(0, text.length);
			textNum++;
			charNum = 0;
			textUpdate = true;
		}
	}
	
	public CharSequence getText() {
		return text;
	}
	
	public boolean getTextEnd() {
		return charNum == texts[textNum].length();
	}
}
