package game.edh.game.actor;

import game.edh.Assets;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.event.EventRyouri;
import game.edh.game.model.frame.event.ModelEvent;
import game.edh.game.model.frame.event.ModelEventObj;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pools;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

public class ActorEvent extends Group {
	GameWorld world;
	ModelEvent event;
	Table group;

	OrthographicCamera cam;
	Matrix4 matrix;
	Vector3 v;

	float scaleX = Gdx.graphics.getWidth() / 432f;
	float scaleY = Gdx.graphics.getHeight() / 768f;

	public ActorEvent(GameWorld world) {
		// TODO 自動生成されたコンストラクター・スタブ
		setName("Event");
		this.world = world;

		cam = new OrthographicCamera();
		cam.setToOrtho(false, 10.8f, 19.2f);

		matrix = new Matrix4();
		v = new Vector3();

		getColor().a = 0;
		setBounds(0, 3.8f, 10.8f, 14f);
		setOrigin(5.4f, 7f);
	}

	public void localePos(Vector2 v) {
		Vector3 vec = Pools.obtain(Vector3.class);
		vec.set(v, 0);
		cam.unproject(vec);
		float x = vec.x;
		float y = (19.2f - vec.y) - getY();
		v.set(x, y);
		Pools.free(vec);
	}

	void setActors() {
		if (event instanceof EventRyouri) {
			group = new Table();
			group.setBounds(0, 550, 432, 120);
			Image image = new Image(Assets.title.get("tanshoku",
					TextureRegionDrawable.class));
			image.setFillParent(true);
			group.addActor(image);
			image.setColor(0, 0, 0, .5f);

			Table table = new Table();
			table.defaults().width(80).height(80).space(30);
			table.debug();
			ScrollPane pane = new ScrollPane(table);
			group.add(pane);

			Array<ModelEventObj> objs = ((EventRyouri) event).getTableObj();
			for (ModelEventObj obj : objs) {
				Actor comp = new EventImage(obj);
				table.add(comp);
			}

			getParent().addActor(group);
			group.setZIndex(2);
		}

		for (ModelEventObj obj : event.getObjs()) {
			Actor comp = null;

			switch (obj.getType()) {
			case Image:
				comp = new EventImage(obj);
				break;
			case Button:
				comp = new EventButton(obj);
				break;
			}

			addActor(comp);
		}
	}

	public void startEvent() {
		event = world.getEvent();
		event.addListener(this);
		setActors();
		addAction(fadeIn(.3f));
	}

	public void endEvent() {
		addAction(sequence(fadeOut(.3f), run(new Runnable() {

			@Override
			public void run() {
				// TODO 自動生成されたメソッド・スタブ
				ActorEvent.this.clearChildren();
				if (group != null) {
					group.remove();
					group = null;
				}
				remove();
				world.endEvent();
			}
		})));
	}

	@Override
	public void act(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		super.act(delta);
		cam.update();
	}

	@Override
	public Actor hit(float x, float y, boolean touchable) {
		// TODO 自動生成されたメソッド・スタブ
		float norX = x * scaleX;
		float norY = Gdx.graphics.getHeight() - (y * scaleY);
		v.set(norX, norY, 0);
		cam.unproject(v);
		return super.hit(v.x, v.y - 3.8f, touchable);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO 自動生成されたメソッド・スタブ
		matrix.set(batch.getProjectionMatrix());
		batch.setProjectionMatrix(cam.combined);
		super.draw(batch, parentAlpha);
		batch.setProjectionMatrix(matrix);
	}
}
