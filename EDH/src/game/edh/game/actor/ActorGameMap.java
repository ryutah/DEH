package game.edh.game.actor;

import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.frame.Map;
import game.edh.game.model.frame.MapObject;
import game.edh.game.model.frame.ModelInu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pools;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

public class ActorGameMap extends Group {
	Map map;
	GameWorld world;
	ActorPlayer player;
	ActorInu inu;
	Array<ActorMapObj> objs;

	float width, height;

	OrthographicCamera cam;
	OrthogonalTiledMapRenderer render;
	Matrix4 matrix;

	public ActorGameMap(GameWorld world) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.world = world;
		map = world.getMap();

		cam = new OrthographicCamera();
		cam.setToOrtho(false, 10.8f, 19.2f);
		render = new OrthogonalTiledMapRenderer(map.getMap(), 1 / 16f);
		matrix = new Matrix4();

		setBounds(0, 0, 10.8f, 19.2f);

		objs = new Array<ActorMapObj>();

		player = new ActorPlayer(world);
		addActor(player);
		Gdx.app.log("", "" + player.getOriginX() + ", ");

		initMap();
	}

	public void mapChange(float time) {
		addAction(sequence(fadeOut(time), run(new Runnable() {

			@Override
			public void run() {
				// TODO 自動生成されたメソッド・スタブ
				clearMap();
				world.changeMapModel();
				map = world.getMap();
				render.setMap(map.getMap());
				initMap();
				Gdx.app.log("Change", "");
			}
		}), delay(.15f), fadeIn(time), run(new Runnable() {

			@Override
			public void run() {
				// TODO 自動生成されたメソッド・スタブ
				world.changeMapEnd();
			}
		})));
	}

	void camMove() {
		cam.position.x = player.getOriginX();
		if (cam.position.x <= 5.4f)
			cam.position.x = 5.4f;
		if (cam.position.x >= width - 5.4f && width >= 5.4f)
			cam.position.x = width - 5.4f;

		cam.position.y = player.getOriginY();
		if (cam.position.y <= 5.8f)
			cam.position.y = 5.8f;
		if (cam.position.y >= height - 8.2f && height >= 8.2f)
			cam.position.y = height - 8.2f;
	}

	void initMap() {
		width = map.getWidth();
		height = map.getHeight();

		addMapObjs();
		addActor(player);
	}

	void clearMap() {
		for (ActorMapObj actor : objs) {
			removeActor(actor);
		}

		if (inu != null) {
			removeActor(inu);
			Pools.free(inu);
			inu = null;
		}

		removeActor(player);
		Pools.freeAll(objs);
		objs.clear();
	}

	void addMapObjs() {
		for (MapObject obj : map.getObjs()) {
			if (obj instanceof ModelInu) {
				inu = Pools.obtain(ActorInu.class);
				inu.setModel((ModelInu) obj);
				addActor(inu);
			}

			if (obj.getDrawable() != null) {
				ActorMapObj actor = Pools.obtain(ActorMapObj.class);
				actor.setObj(obj);
				addActor(actor);
				objs.add(actor);
			}
		}
	}

	public void addMapObj(MapObject obj) {
		ActorMapObj actor = Pools.obtain(ActorMapObj.class);
		actor.setObj(obj);
		addActor(actor);
		objs.add(actor);
	}

	public void removeMapObj(MapObject obj) {
		for (ActorMapObj actor : objs) {
			if (actor.getObj().equals(obj)) {
				removeActor(actor);
				objs.removeValue(actor, false);
				Pools.free(actor);
			}
		}
	}

	void drawBackGround() {
		render.getSpriteBatch().begin();
		for (TiledMapTileLayer layer : map.getBackLayers()) {
			render.renderTileLayer(layer);
		}
		render.getSpriteBatch().end();
	}

	void drawForeGround() {
		render.getSpriteBatch().begin();
		for (TiledMapTileLayer layer : map.getFrontLabers()) {
			render.renderTileLayer(layer);
		}
		render.getSpriteBatch().end();
	}

	@Override
	public void act(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		super.act(delta);
		camMove();
		cam.update();
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO 自動生成されたメソッド・スタブ
		batch.end();
		render.setView(cam);

		float alpha = parentAlpha < getColor().a ? parentAlpha : getColor().a;

		render.getSpriteBatch().setColor(1, 1, 1, alpha);

		drawBackGround();

		batch.begin();
		matrix.set(batch.getProjectionMatrix());
		batch.setProjectionMatrix(cam.combined);
		super.draw(batch, parentAlpha);
		batch.end();

		drawForeGround();

		batch.setProjectionMatrix(matrix);
		batch.begin();
	}
}
