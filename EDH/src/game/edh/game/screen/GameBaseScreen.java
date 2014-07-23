package game.edh.game.screen;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import game.edh.Assets;
import game.edh.EdhGame;
import game.edh.actors.TimeLabel;
import game.edh.frame.BaseClickAction;
import game.edh.frame.BaseScreen;
import game.edh.game.actor.ActorEvent;
import game.edh.game.actor.ActorGameMap;
import game.edh.game.actor.ActorSelectItem;
import game.edh.game.actor.ActorText;
import game.edh.game.actor.ActorItemPanel;
import game.edh.game.model.frame.GameData;
import game.edh.game.model.frame.GameWorld;
import game.edh.game.model.items.Items;
import game.edh.screen.LoadScreen;
import game.edh.screen.LoadScreen.NextScreen;

public abstract class GameBaseScreen extends BaseScreen {
	GameWorld world;

	ActorGameMap map;
	ActorItemPanel panel;
	ActorText text;
	ActorEvent event;
	ActorSelectItem item;
	Touchpad pad;

	public GameBaseScreen(EdhGame game) {
		super(game);
		// TODO 自動生成されたコンストラクター・スタブ
		genWorldClass();
		initActors();
	}

	public GameBaseScreen(EdhGame game, GameData data) {
		super(game);
		genWorldClass(data);
		initActors();
	}

	abstract void genWorldClass();

	abstract void genWorldClass(GameData data);

	protected void setWorldClass(GameWorld world) {
		this.world = world;
	}

	void initActors() {
		map = new ActorGameMap(world);
		panel = new ActorItemPanel(world);
		text = new ActorText(world);
		event = new ActorEvent(world);
		Image back = new Image(Assets.games.get("gameback",
				TextureRegionDrawable.class));
		back.setBounds(0, 0, 432, 768);
		back.setTouchable(Touchable.disabled);
		item = new ActorSelectItem(world);

		pad = new Touchpad(20, Assets.games, "touchpad");
		pad.setPosition(216 - pad.getWidth() / 2, 50);

		Label time = new TimeLabel();
		time.setWrap(true);
		time.setPosition(320, 730);

		Label save = new Label("SAVE", Assets.title, "TOfont");
		save.addListener(new BaseClickAction(save) {

			@Override
			public void clickAction() {
				// TODO 自動生成されたメソッド・スタブ
				GameBaseScreen.this.world.save();
			}
		});
		save.setWrap(true);
		save.setPosition(40, 710);
		save.setColor(Color.BLACK);

		mainTable.addActor(map);
		mainTable.addActor(panel);
		mainTable.addActor(back);
		mainTable.addActor(time);
		mainTable.addActor(save);
		mainTable.addActor(pad);
		mainTable.addActor(item);

		mainTable.addListener(new ActorGestureListener(20, .4f, .4f, .15f) {
			@Override
			public void tap(InputEvent event, float x, float y, int count,
					int button) {
				// TODO 自動生成されたメソッド・スタブ
				if (!event.isStopped())
					world.tap();
			}

			@Override
			public boolean longPress(Actor actor, float x, float y) {
				// TODO 自動生成されたメソッド・スタブ
				return true;
			}

			@Override
			public void fling(InputEvent event, float velocityX,
					float velocityY, int button) {
				// TODO 自動生成されたメソッド・スタブ
				if (event.isStopped())
					return;

				if (velocityX >= 350) {
					panel.fling(false);;
				} else if (velocityX <= -350) {
					panel.fling(true);;
				}
			}
		});
	}

	public void textStart() {
		mainTable.addActor(text);
		text.toFront();
	}

	public void eventStart() {
		mainTable.addActor(event);
		event.setZIndex(1);
		event.startEvent();
	}

	public void endEvent() {
		event.endEvent();
	}

	public void changeMap(float time) {
		map.mapChange(time);
	}

	public void gameEnd() {
		if(EdhGame.settings.autoSave)
			world.save();
		changeScreen(new LoadScreen(edh, NextScreen.TITLE));
	}

	public void stageEnd() {
		EdhGame.deleteData();
	}

	public void selectItem(Items item) {
		this.item.setItem(item);
	}

	public void clearSelectItem() {
		item.clearItem();
	}

	@Override
	public void backPress() {
		// TODO 自動生成されたメソッド・スタブ
		if (panel.isShow())
			panel.hide();
		else
			world.backPress();
	}

	public ActorGameMap getMapActor() {
		return map;
	}

	@Override
	public void render(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		if (pad.isTouched())
			world.move(pad.getKnobPercentX(), pad.getKnobPercentY(), delta);
		else
			world.stop();
		world.update(delta);
		stage.act();
		stage.draw();
	}

	@Override
	public void hide() {
		// TODO 自動生成されたメソッド・スタブ
		super.hide();
		Assets.disStage();
	}

	@Override
	public void resize(int width, int height) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void pause() {
		// TODO 自動生成されたメソッド・スタブ
		if(EdhGame.settings.autoSave)
			world.save();
	}

	@Override
	public void resume() {
		// TODO 自動生成されたメソッド・スタブ

	}

}
