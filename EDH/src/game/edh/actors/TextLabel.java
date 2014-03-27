package game.edh.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.Align;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

public class TextLabel extends Label {
	String[] text;
	private int nowText;
	public boolean canCange = true;
	private boolean isNextText = false;

	public TextLabel(CharSequence text, LabelStyle style) {
		super(text, style);
		// TODO 自動生成されたコンストラクター・スタブ
		nowText = 0;
		setWrap(true);
		setAlignment(Align.center);
	}
	
	public void setText(String ... texts) {
		text = new String[texts.length];
		for(int i = 0; i < texts.length; i++) {
			text[i] = texts[i];
		}
	
		changeText();
	}
	
	public void changeText() {
		if(canCange) {
			canCange = false;
			addAction(sequence(fadeOut(0.7f), run(new Runnable() {
			
				@Override
				public void run() {
					// TODO 自動生成されたメソッド・スタブ
					setText(text[nowText]);
					if(nowText == text.length - 1) 
						isNextText = false;
					else {
						isNextText = true;
						nowText++;
					}
				}
			}), fadeIn(0.7f), run(new Runnable() {
				
				@Override
				public void run() {
					// TODO 自動生成されたメソッド・スタブ
					canCange = true;
				}
			})));
		}
	}
	
	public boolean isNextText() {
		return isNextText;
	}
	
	public int getTextNumber() {
		Gdx.app.log("TextNumber", "" + (nowText + 1));
		return nowText + 1;
	}
}
