package game.edh.actors.games;

import game.edh.model.games.World;
import game.edh.model.games.stage1.Stage1;
import game.edh.screen.GameScreen;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.scenes.scene2d.Group;

public class GameGroup extends Group {
	enum Stage {
		Stage1
	}

	World world;
	Stage stage;
	GameScreen screen;
	TiledMap map;
	OrthogonalTiledMapRenderer render;
	OrthographicCamera cam;
	Matrix4 matrix;

	public GameGroup(GameScreen screen, Stage stage) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.screen = screen;

		switch (stage) {
		case Stage1:
			world = new Stage1(this);
			// mapインスタンスをAssetsから取得
			break;
		}

		cam = new OrthographicCamera(10.8f, 19.2f);
		matrix = new Matrix4();

		render = new OrthogonalTiledMapRenderer(map);
		render.setView(cam);
	}

	public GameGroup init() {

		return this;
	}

	public void textEvent(String... texts) {
		screen.textEvent(texts);
	}

	public void getItem() {

	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO 自動生成されたメソッド・スタブ
		cam.update();
		matrix.set(batch.getProjectionMatrix());
		batch.end();

		Batch mapbatch = render.getSpriteBatch();
		TiledMapTileLayer ground = (TiledMapTileLayer) map.getLayers().get(
				"ground");
		TiledMapTileLayer ground2 = (TiledMapTileLayer) map.getLayers().get(
				"ground2");
		TiledMapTileLayer foreground = (TiledMapTileLayer) map.getLayers().get(
				"foreground");

		mapbatch.getColor().a = parentAlpha;
		mapbatch.begin();
		render.renderTileLayer(ground);
		render.renderTileLayer(ground2);
		mapbatch.end();

		batch.setProjectionMatrix(cam.combined);
		batch.begin();
		super.draw(batch, parentAlpha);
		batch.end();

		mapbatch.begin();
		render.renderTileLayer(foreground);
		mapbatch.end();

		batch.setProjectionMatrix(matrix);
		batch.begin();
	}
}
