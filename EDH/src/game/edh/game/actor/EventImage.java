package game.edh.game.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.utils.Pools;
import game.edh.game.model.frame.event.ModelEventObj;

public class EventImage extends Image implements EventComponent {
	ModelEventObj obj;

	public EventImage(ModelEventObj obj) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.obj = obj;

		addListener(new ActorGestureListener(20, 0.4f, 0.5f, 0.15f) {
			@Override
			public void tap(InputEvent event, float x, float y, int count,
					int button) {
				// TODO 自動生成されたメソッド・スタブ
				event.stop();
				if (getParent() instanceof ActorEvent) {
					Vector2 v = Pools.obtain(Vector2.class);
					v.set(x, y);
					((ActorEvent) getParent()).localePos(v);
					v.sub(getX(), getY());
					Gdx.app.log("ActorPos", getX() + ", " + getY());
					EventImage.this.obj.tap(v.x, v.y);

					Gdx.app.log("Tap", v.x + ", " + v.y);
					Pools.free(v);
				} else
					EventImage.this.obj.tap(x, y);
			}
			
			@Override
			public boolean longPress(Actor actor, float x, float y) {
				// TODO 自動生成されたメソッド・スタブ
				EventImage.this.obj.longTap();
				return super.longPress(actor, x, y);
			}

			@Override
			public void fling(InputEvent event, float velocityX,
					float velocityY, int button) {
				// TODO 自動生成されたメソッド・スタブ
				if (EventImage.this.obj.fling(velocityX, velocityY))
					event.stop();
				super.fling(event, velocityX, velocityY, button);
			}
		});

		setSkins();
	}

	@Override
	public Actor hit(float x, float y, boolean touchable) {
		// TODO 自動生成されたメソッド・スタブ
		return super.hit(x, y, touchable);
	}

	@Override
	public void act(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		super.act(delta);
		setDrawable(obj.getDrawable());
	}

	@Override
	public void setSkins() {
		// TODO 自動生成されたメソッド・スタブ
		setDrawable(obj.getDrawable());
		if (obj.getDrawable() == null) {
			Gdx.app.log("NULL", "");
		}

		float scale = getDrawable().getMinHeight()
				/ getDrawable().getMinWidth();
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
