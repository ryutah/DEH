package game.edh;

import game.edh.frame.BaseScreen;
import game.edh.screen.LoadScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.Pools;

public class EdhGame extends Game {
	private Screen nextScreen;
	public Settings settings;
	public MusicHandler music;
	
	@Override
	public void create() {
		// TODO 自動生成されたメソッド・スタブ
		// Assets.load();
		music = new MusicHandler(this);
		Assets.initAssets();
		settings = load();
		setScreen(new LoadScreen(this, LoadScreen.NextScreen.Title));
		
		Gdx.app.log("LyfeCycle", "Create");
	}

	@Override
	public void render() {
		// TODO 自動生成されたメソッド・スタブ
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		if(nextScreen != null) {
			if(!((BaseScreen) getScreen()).isFade()){
				setScreen(nextScreen);
				nextScreen = null;
			}
		}
		super.render();
	}
	
	public void save() {
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
	
	public Settings load() {
		Json json = Pools.obtain(Json.class);
		try {
			String setting = Gdx.files.local(".DEHdata").readString();
			Gdx.app.log("Load", "" + json.prettyPrint(setting));
			return json.fromJson(Settings.class, setting);
		} catch (Exception e) {
			// TODO: handle exception
			return new Settings();
		} finally {
			Pools.free(json);
		}
	}
	
	public void setNextScreen(Screen screen) {
		nextScreen = screen;
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
		super.dispose();
		Gdx.app.log("LyfeCycle", "Dispose");
	}
	
}
