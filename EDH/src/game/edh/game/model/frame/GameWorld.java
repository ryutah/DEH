package game.edh.game.model.frame;

import game.edh.EdhGame;
import game.edh.MusicHandler.EfftctType;
import game.edh.game.model.frame.ModelGameChara.GameCharaDir;
import game.edh.game.model.frame.event.ModelEvent;
import game.edh.game.model.items.Items;
import game.edh.game.model.items.ItemsHandler;
import game.edh.game.screen.GameBaseScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pools;

public abstract class GameWorld {
	public enum GameState {
		NOMAL, EVENT, MAPEVENT, TEXT, MAPCHANGE, READY, END
	}

	GameBaseScreen screen;

	Map map;
	Array<Map> another;
	ModelGameChara player;
	ModelItems items;
	Flags flag;
	ModelText texts;
	ModelEvent event;
	ModelMapEvent mapEvent;
	GameData data;

	String nextMap;
	int stageNum;
	int selectItem;
	boolean itemGet;
	GameState state;
	GameState befState;

	public GameWorld(GameBaseScreen screen) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.screen = screen;

		data = new GameData();
		items = new ModelItems(this);
		flag = new Flags();
		another = new Array<Map>();
		texts = new ModelText(this);
		state = GameState.NOMAL;
		player = new ModelGameChara(this);
		ItemsHandler.setWorld(this);
		selectItem = ItemsHandler.NONE;
	}

	public GameWorld(GameBaseScreen screen, GameData data) {
		this.screen = screen;

		this.data = data;
		items = new ModelItems(this);
		flag = new Flags();
		another = new Array<Map>();
		texts = new ModelText(this);
		state = GameState.NOMAL;
		player = new ModelGameChara(this);
		ItemsHandler.setWorld(this);

		items.setItems(data.items);
		flag.setFlags(data.flags);
		flag.setFlagsName(data.flagName);

		selectItem = ItemsHandler.NONE;
	}

	public GameWorld load() {
		map.load();
		for (Map map : another)
			map.load();

		player.setPosition(data.playerX, data.playerY);

		return this;
	}

	public void save() {
		data.save(this);
		EdhGame.saveFile(data);
	}

	protected void setStageNum(int stageNum) {
		this.stageNum = stageNum;
	}

	/**
	 * 開始時のマップを設定する
	 * 
	 * @param map
	 */
	protected void setStartMap(Map map) {
		this.map = map;
		player.setPosition(map.getInitPos().x, map.getInitPos().y);
		player.setDirection(map.getInitDir());
	}

	/**
	 * 画面切り替えの際に使われるマップを追加する
	 * 
	 * @param map
	 */
	protected void addMap(Map map) {
		another.add(map);
	}

	protected void addMap(Map map, GameData data) {
		String name = data.mapName;
		if (map.getName().equals(name))
			setStartMap(map);
		else
			addMap(map);
	}

	public void update(float delta) {
		map.update(delta);
		player.update(delta);
		texts.update(delta);

		if (state == GameState.MAPCHANGE || state == GameState.END) {
			float x = 0;
			float y = 0;
			switch (player.getDirection()) {
			case Down:
				y = -1;
				break;
			case Left:
				x = -1;
				break;
			case Right:
				x = 1;
				break;
			case Up:
				y = 1;
				break;
			}

			player.move(x * player.getSpeed().x * delta, y
					* player.getSpeed().y * delta);
		}
	}

	public void tap() {
		switch (state) {
		case NOMAL:
			check();
			break;
		case TEXT:
			texts.changeText();
			break;
		default:

		}
	}

	public void backPress() {
		switch (state) {
		case EVENT:
			removeEventObj();
			break;
		default:
			screen.gameEnd();
			break;
		}
	}

	/**
	 * プレイヤーを移動させる
	 * 
	 * @param x
	 * @param y
	 * @param delta
	 */
	public void move(float x, float y, float delta) {
		if (state == GameState.NOMAL) {
			float degree = MathUtils.atan2(y, x) * MathUtils.radiansToDegrees;
			player.setDirection(degree);

			float moveX = x * delta * player.getSpeed().x;
			float moveY = y * delta * player.getSpeed().y;

			if (!collision(moveX, moveY)) {
				player.move(moveX, moveY);
				map.checkMapChange(player.getBounds());

			} else
				player.move(0, 0);
		}
	}

	/**
	 * プレイヤーを停止させる
	 */
	public void stop() {
		player.stop();
	}

	boolean collision(float moveX, float moveY) {
		Rectangle bufPlayer = Pools.obtain(Rectangle.class);
		bufPlayer.set(player.getBounds());
		bufPlayer.x += moveX;
		bufPlayer.y += moveY;

		boolean collision = map.collision(bufPlayer);
		Pools.free(bufPlayer);

		return collision;
	}

	void check() {
		Rectangle check = player.getCheckBounds();
		map.checkObj(check);
	}

	/**
	 * マップ名で指定されたマップに切り替える
	 * 
	 * @param mapName
	 */
	public void changeMap(String mapName) {
		nextMap = mapName;
		state = GameState.MAPCHANGE;
		map.hideMap();
		screen.changeMap(.3f);
	}

	public void changeMap(String mapName, float time) {
		nextMap = mapName;
		state = GameState.MAPCHANGE;
		map.hideMap();
		screen.changeMap(time);
	}

	public void changeMapEnd() {
		map.showMap();
		state = GameState.NOMAL;
	}

	public void changeMapModel() {
		Map buf = map;

		for (Map next : another) {
			if (nextMap.equals(next.getName())) {
				map = next;
				another.removeValue(next, false);
				another.add(buf);
				break;
			}
		}

		Vector2 pos = buf.getChangePos();
		GameCharaDir dir = buf.getChangeDir();

		if (pos == null || dir == null) {
			pos = map.getInitPos();
			dir = map.getInitDir();
		}

		state = GameState.READY;
		player.setPosition(pos.x, pos.y);
		player.setDirection(dir);
	}

	public void stageEnd() {
		state = GameState.END;
		int num = getStageNum() - 1;
		if (!EdhGame.settings.clearStage[num])
			stageEndEvents();
		else
			screen.stageEnd();
	}

	void stageEndEvents() {
		textEvent("アーカイブが追加されました");
		EdhGame.settings.clearStage(getStageNum());
		EdhGame.save();
	}

	/**
	 * テキストイベントを実行する
	 * 
	 * @param texts
	 */
	public void textEvent(String... texts) {
		screen.textStart();
		this.texts.setText(texts);
		befState = state;
		state = GameState.TEXT;
	}

	/**
	 * テキストイベントを終了する
	 */
	public void textEnd() {
		state = befState;
		if (itemGet) {
			EdhGame.music.playEffect(EfftctType.ITEMGET, false);
			itemGet = false;
		}

		if (state == GameState.MAPEVENT && mapEvent != null)
			mapEvent.textEnd();
		else if (state == GameState.END)
			screen.stageEnd();
	}

	/**
	 * ゲーム内のオブジェクト等を調べた際に発生する特殊な イベントを追加し、ゲームロジックをEventに切り替える
	 * 
	 * @param event
	 */
	public void addEventObj(ModelEvent event) {
		this.event = event;
		state = GameState.EVENT;
		screen.eventStart();
		Gdx.app.log("Event", "");
	}

	public void addMapEvent(ModelMapEvent mapEvent) {
		this.mapEvent = mapEvent;
		state = GameState.MAPEVENT;
		mapEvent.startMapEvent();
	}

	/**
	 * イベントを終了し、ゲームロジックをNomalにする
	 */
	public void removeEventObj() {
		event = null;
		screen.endEvent();
	}

	public void endMapEvent() {
		state = GameState.NOMAL;
		mapEvent = null;
	}

	public void endEvent() {
		if (state != GameState.TEXT)
			state = GameState.NOMAL;
		else
			befState = GameState.NOMAL;

	}

	/**
	 * 取得したアイテムを追加する
	 * 
	 * @param itemId
	 */
	public void addItem(int itemId) {
		items.addItem(itemId);
		itemGet = true;
	}

	public void addMapObj(MapObject obj) {
		screen.getMapActor().addMapObj(obj);
	}

	public void removeMapObjd(MapObject obj) {
		screen.getMapActor().removeMapObj(obj);
	}

	/**
	 * アイテムを削除する
	 * 
	 * @param itemId
	 */
	public void removeItem(int itemId) {
		items.removeItem(itemId);
		if (itemId == getSelectItem())
			clearSelectItem();
	}

	/**
	 * アイテムを削除する
	 * 
	 * @param itemName
	 */
	public void removeItem(String itemName) {
		items.removeItem(itemName);
	}

	/**
	 * 選択中のアイテムを変更する
	 * 
	 * @param itemId
	 */
	public void selectItem(Items item) {
		EdhGame.music.playEffect(EfftctType.SUZU, false);
		this.selectItem = item.getItemId();
		screen.selectItem(item);
	}

	public void clearSelectItem() {
		selectItem = ItemsHandler.NONE;
		screen.clearSelectItem();
	}

	/**
	 * ゲームで使用するフラグを変更する
	 * 
	 * @param flagName
	 */
	public void changeFlag(String flagName) {
		flag.changeFlag(flagName);
	}

	/**
	 * ゲームで使用するフラグを第二引数に変更する
	 * 
	 * @param flagName
	 * @param flag
	 */
	public void changeFlag(String flagName, boolean flag) {
		this.flag.changeFlag(flagName, flag);
	}

	public GameState getState() {
		return state;
	}

	public int getStageNum() {
		return stageNum;
	}

	public Map getMap() {
		return map;
	}

	public Map getMap(String name) {
		Map foundmap = null;
		if (name.equals(this.map.getName()))
			foundmap = this.map;
		else {
			for (Map map : another) {
				if (name.equals(map.getName())) {
					foundmap = map;
					break;
				}
			}
		}

		return foundmap;
	}

	/**
	 * 現在選択中のアイテムを取得する
	 * 
	 * @return
	 */
	public int getSelectItem() {
		return selectItem;
	}

	public Items getItem(int itemId) {
		return items.getItem(itemId);
	}

	/**
	 * 取得したアイテム情報を保存しているモデルクラスを取得する
	 * 
	 * @return
	 */
	public ModelItems getItems() {
		return items;
	}

	/**
	 * ゲームプレイヤーのモデルクラスを取得する
	 * 
	 * @return
	 */
	public ModelGameChara getPlayer() {
		return player;
	}

	public void setFlags(String[] flags) {
		for (int i = 0; i < flags.length; i++) {
			addFlag(flags[i]);
		}
	}

	/**
	 * 引数名のフラグを追加する
	 * 
	 * @param name
	 */
	public void addFlag(String name) {
		flag.addFlag(name);
	}

	public Flags getFlags() {
		return flag;
	}

	/**
	 * 引数で指定されたフラグを取得する
	 * 
	 * @param flagName
	 * @return
	 */
	public boolean getFlag(String flagName) {
		return flag.getFlag(flagName);
	}

	/**
	 * テキストを操作するモデルクラスを取得する
	 * 
	 * @return
	 */
	public ModelText getText() {
		return texts;
	}

	/**
	 * イベントを操作するモデルクラスを取得する
	 * 
	 * @return
	 */
	public ModelEvent getEvent() {
		return event;
	}
}
