package game.edh.game.actor;

import game.edh.game.model.frame.MapObject;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

public class ActorMapObj extends Actor {
	MapObject obj;
	boolean objDraw;

	public void setObj(MapObject obj) {
		this.obj = obj;
		float x = obj.getBounds().x;
		float y = obj.getBounds().y;
		float width = obj.getBounds().width;
		float height = obj.getBounds().height;
		setBounds(x, y, width, height);
		objDraw = obj.draw;
		if(objDraw)
			setColor(1, 1, 1, 1);
	}

	public MapObject getObj() {
		return obj;
	}

	@Override
	public void act(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		if (obj.remove)
			remove();

		if (objDraw && !obj.draw) {
			addAction(sequence(fadeOut(.3f), run(new Runnable() {

				@Override
				public void run() {
					// TODO 自動生成されたメソッド・スタブ
					objDraw = false;
				}
			})));
		}

		if (!objDraw && obj.draw) {
			objDraw = true;
			addAction(fadeIn(.3f));
		}
		super.act(delta);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO 自動生成されたメソッド・スタブ
		if (objDraw) {
			float alpha = parentAlpha < getColor().a ? parentAlpha
					: getColor().a;
			batch.setColor(1, 1, 1, alpha);
			obj.getDrawable().draw(batch, getX(), getY(), getWidth(),
					getHeight());
		}
		super.draw(batch, parentAlpha);
	}
}
