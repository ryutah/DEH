package game.edh.actors;

import java.util.Calendar;

import game.edh.Assets;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class TimeLabel extends Label {
	int min;
	int hou;

	public TimeLabel() {
		// TODO 自動生成されたコンストラクター・スタブ
		super("", Assets.title, "TOfont");

		min = Calendar.getInstance().get(Calendar.MINUTE);
		String minute;
		if(min < 10)
			minute = "0" + Integer.toString(min);
		else
			minute = Integer.toString(min);
		hou = Calendar.getInstance().get(Calendar.HOUR);

		setText(hou + ":" + minute);
		setColor(Color.BLACK);
	}

	@Override
	public void act(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		super.act(delta);
		if (min != Calendar.getInstance().get(Calendar.MINUTE)) {
			min = Calendar.getInstance().get(Calendar.MINUTE);
			String minute;
			if(min < 10)
				minute = "0" + Integer.toString(min);
			else
				minute = Integer.toString(min);
			hou = Calendar.getInstance().get(Calendar.HOUR);

			setText(hou + ":" + minute);
		}
	}
}
