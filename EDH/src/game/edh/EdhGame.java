package game.edh;

import game.edh.frame.BaseScreen;
import game.edh.game.model.frame.GameData;
import game.edh.screen.LoadScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Pools;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class EdhGame extends Game {
	public static Stage stage;
	public static GameData gameData;
	public static Settings settings;
	public static MusicHandler music;

	@Override
	public void create() {
		// TODO 自動生成されたメソッド・スタブ
		music = new MusicHandler(this);
		Assets.initAssets();
		settings = load();
		loadFile();

		Gdx.app.log("LyfeCycle", "Create");
		stage = new Stage(new StretchViewport(432, 768));
		Gdx.input.setInputProcessor(stage);
		Gdx.input.setCatchBackKey(true);

		stage.addListener(new InputListener() {
			@Override
			public boolean keyUp(InputEvent event, int keycode) {
				// TODO 自動生成されたメソッド・スタブ
				if (keycode == Keys.BACK || keycode == Keys.BACKSPACE)
					((BaseScreen) getScreen()).backPress();

				return false;
			}
		});

		setScreen(new LoadScreen(this, LoadScreen.NextScreen.TITLE));
	}

	@Override
	public void render() {
		// TODO 自動生成されたメソッド・スタブ
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		music.update();
		super.render();
	}

	public static void save() {
		Json json = Pools.obtain(Json.class);
		String setting = json.toJson(settings);
		try {
			Gdx.files.local(".DEHdata").writeString(setting, false);
			Gdx.app.log("Save", "" + json.prettyPrint(setting));
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			Pools.free(json);
		}
	}

	public static void saveFile(GameData data) {
		gameData = data;
		Json json = Pools.obtain(Json.class);
		String file = json.toJson(data);
		Gdx.files.local(".GameData").writeString(file, false);
//		Gdx.app.log("SaveFile", json.prettyPrint(file));
		Pools.free(json);
	}

	public static Settings load() {
		Json json = Pools.obtain(Json.class);
		try {
			String setting = Gdx.files.local(".DEHdata").readString();
			return json.fromJson(Settings.class, setting);
		} catch (Exception e) {
			// TODO: handle exception
			return new Settings();
		} finally {
			Pools.free(json);
		}
	}

	public static void loadFile() {
		Json json = Pools.obtain(Json.class);
		try {
			json = Pools.obtain(Json.class);
			String file = Gdx.files.local(".GameData").readString();
//			Gdx.app.log("LoadData", json.prettyPrint(file));
			gameData = json.fromJson(GameData.class, file);
		} catch (Exception e) {
			gameData = null;
		} finally {
			Pools.free(json);
		}
	}

	public static void deleteData() {
		try{
			Gdx.files.local(".GameData").delete();
			gameData = null;
		} catch(Exception e) {

		}
	}

	public static void deleteFile() {
		Gdx.files.local(".DEHdata").delete();
	}

	@Override
	public void setScreen(Screen screen) {
		// TODO 自動生成されたメソッド・スタブ
		super.setScreen(screen);
	}

	@Override
	public void resume() {
		// TODO 自動生成されたメソッド・スタブ
		getScreen().resume();
		Gdx.app.log("LyfeCycle", "Resume");
	}

	@Override
	public void pause() {
		// TODO 自動生成されたメソッド・スタブ
		getScreen().pause();
		Gdx.app.log("LyfeCycle", "Pause");
	}

	@Override
	public void dispose() {
		// TODO 自動生成されたメソッド・スタブ
		getScreen().dispose();
		Assets.dispose();
		stage.dispose();
		super.dispose();
		Gdx.app.log("LyfeCycle", "Dispose");
	}

}
