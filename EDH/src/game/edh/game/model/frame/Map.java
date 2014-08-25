package game.edh.game.model.frame;

import game.edh.game.model.frame.ModelGameChara.GameCharaDir;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pools;

public abstract class Map {
	protected GameWorld world;

	TiledMap map;
	String name;
	int width, height;

	Vector2 initPos;
	Vector2 changePos;
	GameCharaDir initDir;
	GameCharaDir changeDir;

	Array<Rectangle> foundWall;
	Array<TiledMapTileLayer> backLayers;
	Array<TiledMapTileLayer> frontLayers;
	Array<MapObject> objs;
	Array<MapChangeRect> mapChange;
	Rectangle gameEnd;

	public Map(GameWorld world) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.world = world;
		objs = new Array<MapObject>();
		mapChange = new Array<MapChangeRect>();
		foundWall = new Array<Rectangle>();
		initPos = new Vector2();
		changePos = new Vector2();
		backLayers = new Array<TiledMapTileLayer>();
		frontLayers = new Array<TiledMapTileLayer>();
	}

	public Map init() {
		return this;
	}

	public Map load() {
		return this;
	}

	public void hideMap() {

	}

	public void showMap() {

	}

	public void update(float delta) {
		for (MapObject obj : objs) {
			obj.update(delta);
		}
	}

	boolean collision(Rectangle rect) {
		return collisionWall(rect) || collisionObj(rect);
	}

	public Vector2 checkCollision(Rectangle player, float moveX, float moveY) {
		Vector2 pos = Pools.obtain(Vector2.class);
		pos.set(0, 0);
		Rectangle rect = Pools.obtain(Rectangle.class);
		rect.set(player);
		rect.setPosition(rect.getX() + moveX, rect.getY() + moveY);
		if (!collision(rect)) {
			pos.set(moveX, moveY);
			Pools.free(rect);
			return pos;
		}

		rect.setX(player.getX());
		if (!collision(rect)) {
			pos.set(0, moveY);
			Pools.free(rect);
			return pos;
		}

		rect.setX(player.getX() + moveX);
		rect.setY(player.getY());
		if (!collision(rect)) {
			pos.set(moveX, 0);
			Pools.free(rect);
			return pos;
		}

		Pools.free(pos);
		return pos;
	}

	public void checkMapChange(Rectangle rect) {
		for (MapChangeRect change : mapChange) {
			if (rect.overlaps(change.getBounds())) {
				if (change.getChangePos() != null
						|| change.getChangeDir() != null) {
					changePos = change.getChangePos();
					changeDir = change.getChangeDir();
				} else {
					changePos = null;
					changeDir = null;
				}
				world.changeMap(change.getName());
				break;
			}
		}

		if (gameEnd != null) {
			if (rect.overlaps(gameEnd))
				world.stageEnd();
		}
	}

	boolean collisionWall(Rectangle rect) {
		float x1 = rect.getX();
		float y1 = rect.getY();
		float x2 = x1 + rect.getWidth();
		float y2 = y1 + rect.getHeight();

		Array<Rectangle> colliders = colliderPotencialWall(x1, y1, x2, y2);
		for (Rectangle collider : colliders) {
			if (collider.overlaps(rect)) {
				clearColliderWall();
				return true;
			}
		}

		clearColliderWall();
		return false;
	}

	boolean collisionObj(Rectangle rect) {
		for (MapObject obj : objs) {
			if (obj.collision && obj.getBounds().overlaps(rect)) {
				return true;
			}
		}
		return false;
	}

	public void checkObj(Rectangle rect) {
		for (MapObject obj : objs) {
			if (obj.check && obj.getBounds().overlaps(rect)) {
				obj.checkObj();
				break;
			}
		}
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected void setBounds(int width, int height) {
		this.width = width;
		this.height = height;
	}

	protected void setMap(TiledMap map) {
		this.map = map;
		TiledMapTileLayer back = (TiledMapTileLayer) map.getLayers().get(
				"ground");
		TiledMapTileLayer back2 = (TiledMapTileLayer) map.getLayers().get(
				"ground2");
		backLayers.addAll(back, back2);

		TiledMapTileLayer front = (TiledMapTileLayer) map.getLayers().get(
				"foreground");
		frontLayers.add(front);

		width = back.getWidth();
		height = back.getHeight();
	}

	protected void setInitPos(float x, float y) {
		initPos.set(x, y);
		// changePos.set(x, y);
	}

	protected void setInitDir(GameCharaDir dir) {
		this.initDir = dir;
		// changeDir = initDir;
	}

	public void addBackLayers(String name) {
		TiledMapTileLayer back = (TiledMapTileLayer) map.getLayers().get(name);
		backLayers.add(back);
	}

	public void addFrontLayers(String name) {
		TiledMapTileLayer front = (TiledMapTileLayer) map.getLayers().get(name);
		frontLayers.add(front);
	}

	public void removeBackLayer(String name) {
		TiledMapTileLayer back = (TiledMapTileLayer) map.getLayers().get(name);
		backLayers.removeValue(back, false);
	}

	public void removeFrontLayers(String name) {
		TiledMapTileLayer front = (TiledMapTileLayer) map.getLayers().get(name);
		frontLayers.removeValue(front, false);
	}

	public void addObj(MapObject obj) {
		objs.add(obj);
		world.addMapObj(obj);
	}

	public void addObjes(MapObject... objs) {
		for (MapObject obj : objs) {
			this.objs.add(obj);
		}
	}

	public void addMapChangeRect(MapChangeRect rect) {
		this.mapChange.add(rect);
	}

	public void setGameEndRect(Rectangle rect) {
		gameEnd = rect;
	}

	public void removeObjs(String name) {
		for (MapObject obj : objs) {
			if (name.equals(obj.getName())) {
				obj.remove();
				objs.removeValue(obj, false);
				world.removeMapObjd(obj);
				break;
			}
		}
	}

	public void removeObjs(MapObject obj) {
		obj.remove();
		objs.removeValue(obj, false);
		world.removeMapObjd(obj);
	}

	public Array<Rectangle> colliderPotencialWall(float x, float y, float x2,
			float y2) {
		int startX = (int) x;
		int startY = (int) y;
		int endX = (int) x2;
		int endY = (int) y2;

		TiledMapTileLayer wall = (TiledMapTileLayer) map.getLayers()
				.get("wall");

		for (int i = startX; i <= endX; i++) {
			for (int j = startY; j <= endY; j++) {
				Cell cell = wall.getCell(i, j);
				if (cell == null)
					continue;
				else {
					Rectangle rect = Pools.obtain(Rectangle.class);
					rect.set(i, j, 1, 1);
					foundWall.add(rect);
				}
			}
		}
		return foundWall;
	}

	void clearColliderWall() {
		Pools.freeAll(foundWall);
		foundWall.clear();
	}

	public Array<MapObject> getObjs() {
		return objs;
	}

	public MapObject getObj(String name) {
		MapObject obj = null;
		for (MapObject object : objs) {
			if (name.equals(object.getName())) {
				obj = object;
				break;
			}
		}

		return obj;
	}

	public String getName() {
		return name;
	}

	public Vector2 getInitPos() {
		return initPos;
	}

	public Vector2 getChangePos() {
		Vector2 v = changePos;
		changePos = null;
		return v;
	}

	public GameCharaDir getInitDir() {
		return initDir;
	}

	public GameCharaDir getChangeDir() {
		GameCharaDir d = changeDir;
		changeDir = null;
		return d;
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

	public TiledMap getMap() {
		return map;
	}

	public Array<TiledMapTileLayer> getBackLayers() {
		return backLayers;
	}

	public Array<TiledMapTileLayer> getFrontLabers() {
		return frontLayers;
	}
}
