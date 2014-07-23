package game.edh.event.screen;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;

import game.edh.Assets;
import game.edh.EdhGame;
import game.edh.event.actor.EventGroup;
import game.edh.event.actor.SActor;
import game.edh.event.actor.WakuActor;
import game.edh.event.actor.YActor;
import game.edh.event.model.CharaS;
import game.edh.event.model.CharaY;
import game.edh.event.model.Character;
import game.edh.event.model.EventWorld;
import game.edh.frame.BaseScreen;
import game.edh.screen.LoadScreen;
import game.edh.screen.LoadScreen.NextScreen;
import game.edh.screen.TitleScreen.TableType;

/**
 * イベントシーンのベーススクリーン イベントで使用するActor等はgenActors()で 生成し、groupに追加する
 * 
 * @author ryuta
 * 
 */
public abstract class EventScreen extends BaseScreen {
	protected EventWorld world;
	protected EventGroup group;
	WakuActor waku;

	boolean backTitle;

	public EventScreen(EdhGame game, boolean backTitle) {
		super(game);
		// TODO 自動生成されたコンストラクター・スタブ
		genEventWorld();
		this.backTitle = backTitle;

		group = new EventGroup(world, this);
		waku = new WakuActor(world);
		Image backGround = new Image(Assets.event, "eventback");

		mainTable.addActor(group);
		mainTable.addActor(backGround);
		mainTable.addActor(waku);

		mainTable.addListener(new ActorGestureListener() {
			@Override
			public void tap(InputEvent event, float x, float y, int count,
					int button) {
				// TODO 自動生成されたメソッド・スタブ
				EventScreen.this.tap();
			}
		});

		initEventGroups();
	}
	
	public void tap() {
		world.touchWorld();
	}

	public void addCharacter(Character chara) {
		Actor actor = null;
		if (chara instanceof CharaS)
			actor = new SActor(world);
		else if (chara instanceof CharaY)
			actor = new YActor(world);

		group.addCharacter(actor);
	}

	@Override
	public void showScreen() {
		// TODO 自動生成されたメソッド・スタブ
		super.showScreen();
		world.startEvent();
	}

	public void showGroup() {
		group.show();
	}

	public void hideGroup() {
		group.hide();
	}
	
	public void hideGoupEnd() {
		
	}

	public void setCamMove(boolean move) {
		group.camMoving(move);
	}

	public void changeWorld(EventWorld world) {
		group.changeEventWorld(world, 1);
		waku.changeWorld(world);
		this.world = world;
	}
	
	public void changeWorld(EventWorld world, float time) {
		group.changeEventWorld(world, time);
		waku.changeWorld(world);
		this.world = world;
	}

	public void changeWorldEnd() {

	}

	/**
	 * EventWorldクラスの生成
	 */
	abstract void genEventWorld();

	/**
	 * イベントに使用するキャラクター等のActorの生成 groupインスタンスに登録するss groupインスタンスの背景の設定もここで行う
	 */
	void initEventGroups() {

	}

	public void eventEnd() {
		checkNextScreen();
	}

	public abstract BaseScreen nextScreen();

	@Override
	public void backPress() {
		// TODO 自動生成されたメソッド・スタブ
		if (backTitle)
			changeScreen(new LoadScreen(edh, TableType.ARCHIVE));
		else
			changeScreen(new LoadScreen(edh, NextScreen.TITLE));
	}

	@Override
	public void render(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		world.update(delta);
		stage.act();
		stage.draw();
	}

	@Override
	public void hide() {
		// TODO 自動生成されたメソッド・スタブ
		super.hide();
		Assets.disEvent();
	}

	void checkNextScreen() {
		if (backTitle)
			changeScreen(new LoadScreen(edh, TableType.ARCHIVE));
		else
			changeScreen(nextScreen());
	}

	@Override
	public void changeScreen(BaseScreen screen) {
		// TODO 自動生成されたメソッド・スタブ
		super.changeScreen(screen);
	}

	@Override
	public void resize(int width, int height) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void pause() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void resume() {
		// TODO 自動生成されたメソッド・スタブ

	}

}
