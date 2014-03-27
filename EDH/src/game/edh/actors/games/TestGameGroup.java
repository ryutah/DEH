package game.edh.actors.games;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapLayers;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTile.BlendMode;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.tiles.AnimatedTiledMapTile;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pools;

public class TestGameGroup extends Group {
	TiledMap map;
	public OrthogonalTiledMapRenderer render;
	OrthographicCamera cam;
	Matrix4 matrix;
	float width = 350f * 14f / 150f;
	boolean leftMove;
	boolean rightMove;

	public TestGameActor actor;
	Rectangle[][] wall;
	Array<Rectangle> walls;

	public TestGameGroup() {
		// TODO 自動生成されたコンストラクター・スタブ
		// setBounds(0, 0, 10.8f, 19.2f);
		map = new TmxMapLoader().load("stage1.tmx");
		render = new OrthogonalTiledMapRenderer(map, 1f / 16f);
		cam = new OrthographicCamera();
		cam.setToOrtho(false, 10.8f, 19.2f);
		// cam.translate(0, -3.8f, 0);
		matrix = new Matrix4();
		Gdx.app.log("Cam", "" + cam.position.x + "," + cam.position.y);

		wall = new Rectangle[36][28];
		walls = new Array<Rectangle>();
		TiledMapTileLayer layer = (TiledMapTileLayer) map.getLayers().get(
				"wall");
		for (int i = 0; i < 36; i++) {
			for (int j = 0; j < 28; j++) {
				Cell cell = layer.getCell(i, j);
				if (cell == null) {
					wall[i][j] = null;
				} else {
					wall[i][j] = new Rectangle(i, j, 1, 1);
				}
				
				

//				 if (cell != null) {
//				 Gdx.app.log("Cell", i + ", " + j);
//				 walls.add(new Rectangle(i, j , 1f, 1f));
//				 }
			}
		}

		Gdx.app.log("Walls", walls.size + "");

		actor = new TestGameActor();
		setBounds(0, 0, 36f, 28f);

		addActor(actor);
	}

	public void move(float x, float y, float delta) {
		float moveX;
		float moveWidth;
		float moveY;
		float moveHeight;
		if (x == 0 && y == 0) {
			actor.move(0, 0, delta);
			return;
		}

		Gdx.app.log("", x * delta + "");

		moveX = actor.getX() + (x * delta * 5f);
		moveWidth = actor.getWidth();
		moveY = actor.getY() + (y * delta * 5f);
		moveHeight = actor.getHeight() / 2f;
		Gdx.app.log("Actor", actor.getX() + ", " + actor.getY());
		Gdx.app.log("Move", moveX + " , " + moveY + " / " + moveWidth + ", "
				+ moveHeight);

		Rectangle move = new Rectangle(moveX, moveY, moveWidth, moveHeight);

		if (checkCollision(move)) {
			actor.move(x, y, delta);
		} else {
			actor.move(0, 0, delta);
		}
		Vector2 vector = Pools.obtain(Vector2.class);
		move.getCenter(vector);
		Gdx.app.log("center", vector.x + ", " + vector.y);
		Pools.free(vector);
	}

	public boolean checkCollision(Rectangle rect) {
		 int x = Math.round(rect.getX()) - 1;
		 if(x < 0)
		 x = 0;
		 int y = Math.round(rect.getY()) - 1;
		 if(y < 0)
		 y = 0;
		 int x2 = Math.round(x + rect.getWidth()) + 1;
		 if(x2 > 35)
		 x2 = 35;
		 int y2 = Math.round(y + rect.getHeight()) + 1;
		 if(y2 > 27)
		 y2 = 27;
		
		 Gdx.app.log("cell", x + ", " + y + " / " + x2 + ", " + y2);
		
		 for (int i = x; i <= x2; i++) {
		 for (int j = y; j <= y2; j++) {
		 if(wall[i][j] == null)
		 continue;
		
		 if(rect.overlaps(wall[i][j])) {
//			 ((TiledMapTileLayer) map.getLayers().get("wall")).setCell(i, j, null);
//			 wall[i][j] = null;
		 return false;
		 }
		 }
		 }

		// for (int i = 0; i < walls.size; i++) {
		// if (rect.overlaps(walls.get(i))) {
		// Gdx.app.log("Collision",
		// walls.get(i).getX() + ", " + (walls.get(i).getY()));
		// return false;
		// }
		// }

		return true;
	}

	@Override
	public void act(float delta) {
		// TODO 自動生成されたメソッド・スタブ

		super.act(delta);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO 自動生成されたメソッド・スタブ
		batch.end();
		cam.update();
		camMove(0, 0);
		render.setView(cam);

		render.getSpriteBatch().setColor(1, 1, 1, parentAlpha);
		render.getSpriteBatch().begin();
		// render.getSpriteBatch().setProjectionMatrix(cam.combined);
		render.renderTileLayer((TiledMapTileLayer) map.getLayers()
				.get("ground"));
		render.renderTileLayer((TiledMapTileLayer) map.getLayers().get(
				"ground2"));
		render.renderTileLayer((TiledMapTileLayer) map.getLayers().get("clear"));
		//render.renderTileLayer((TiledMapTileLayer) map.getLayers().get("wall"));
		render.getSpriteBatch().end();
		batch.begin();
		matrix.set(batch.getProjectionMatrix());
		batch.setProjectionMatrix(cam.combined);
		super.draw(batch, parentAlpha);
		batch.end();
		render.getSpriteBatch().begin();
		render.renderTileLayer((TiledMapTileLayer) map.getLayers().get(
				"foreground"));
		render.getSpriteBatch().end();
		batch.begin();
		batch.setProjectionMatrix(matrix);
	}

	public void camMove(float x, float y) {
		cam.position.x = actor.getOriginX();
		cam.position.y = actor.getOriginY();

		TiledMapTileLayer layer = (TiledMapTileLayer) map.getLayers().get(
				"ground");
		// Gdx.app.log("layer", layer.getWidth() + "," + layer.getHeight());
		if (cam.position.x <= 5.4f)
			cam.position.x = 5.4f;
		if (cam.position.x >= layer.getWidth() - 5.4f)
			cam.position.x = layer.getWidth() - 5.4f;

		if (cam.position.y <= 5.8f)
			cam.position.y = 5.8f;
		if (cam.position.y >= layer.getHeight() - 8.2f)
			cam.position.y = layer.getHeight() - 8.2f;
		// Gdx.app.log("move", "" + x);
	}
}
