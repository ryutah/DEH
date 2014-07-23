package game.edh.game.actor;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Pools;

import game.edh.game.model.frame.event.ModelEventObj;

public class EventButton extends Button implements EventComponent {
	ModelEventObj obj;

	public EventButton(ModelEventObj obj) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.obj = obj;
		
		addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO 自動生成されたメソッド・スタブ
				event.stop();
				event.stop();
				Vector2 v = Pools.obtain(Vector2.class);
				v.set(x, y);
				((ActorEvent) getParent()).localePos(v);
				v.sub(getX(), getY());
				EventButton.this.obj.tap(v.x, v.y);
				Pools.free(v);
			}
		});

		setSkins();
	}

	@Override
	public void setSkins() {
		// TODO 自動生成されたメソッド・スタブ
		setStyle(obj.getButtonStyle());

		float scale = getStyle().up.getMinHeight()
				/ getStyle().up.getMinWidth();
		float width = obj.getSize();
		float height = obj.getSize() * scale;

		float x = 0;
		float y = 0;

		if (obj.centerX)
			x = 5.4f - width / 2;
		else
			x = obj.getX();

		if (obj.centerY)
			y = 7f - height / 2;
		else
			y = obj.getY();

		setBounds(x, y, width, height);
	}

}
