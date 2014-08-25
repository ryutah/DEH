package game.edh.game.actor;

import game.edh.Assets;
import game.edh.EdhGame;

import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;

public class ActorTouchPad extends Touchpad {
	public final float defaultPadPosX = 216;
	public final float defaultPadPosY = 114;
	public final float defaultPadSize = 128;
	final float defaultKnobSize = 35;

	float x, y;

	public ActorTouchPad() {
		// TODO 自動生成されたコンストラクター・スタブ
		super(20, Assets.title);
		changeParams();

//		setCenterPosition(defaultPadPosX, defaultPadPosY);
//		setOrigin(getWidth() / 2, getHeight() / 2);
//		x = defaultPadPosX;
//		y = defaultPadPosY;
	}

	public void changeParams() {
		setPadX(EdhGame.settings.padX);
		setPadY(EdhGame.settings.padY);
		setSize(EdhGame.settings.padSize);
	}

	public void setSize(float rate) {
		setSize(rate * defaultPadSize, rate * defaultPadSize);
		getStyle().knob.setMinWidth(defaultKnobSize * rate);
		getStyle().knob.setMinHeight(defaultKnobSize * rate);

		setPadX(x);
		setPadY(y);
	}

	public void setPadX(float x) {
		setCenterPosition(x, y);
		this.x = x;
	}

	public void setPadY(float y) {
		setCenterPosition(x, y);
		this.y = y;
	}
}
