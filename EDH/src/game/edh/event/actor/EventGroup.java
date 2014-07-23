package game.edh.event.actor;

import game.edh.Assets;
import game.edh.event.model.CharaS;
import game.edh.event.model.CharaY;
import game.edh.event.model.Character;
import game.edh.event.model.EventWorld;
import game.edh.event.screen.EventScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;

public class EventGroup extends Group {

	OrthographicCamera cam;
	Matrix4 matrix;
	public EventWorld world;
	EventScreen screen;
	Actor chara;
	TextureRegionDrawable tanshoku;

	boolean camMove;

	Image back;

	public EventGroup(EventWorld world, EventScreen screen) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.world = world;
		this.screen = screen;
		setBounds(0, 7.2f, 21.6f, 11f);

		cam = new OrthographicCamera();
		cam.setToOrtho(false, 10.8f, 19.2f);
		cam.position.set(21.6f - 5.4f, 9.6f, 0);

		matrix = new Matrix4();

		tanshoku = Assets.title.get("tanshoku", TextureRegionDrawable.class);
		getColor().a = 0;

		init();
	}

	void init() {
		String name = world.getBackName();
		setBackGround(name);

		Array<Character> charas = world.getCharas();
		for (int i = 0; i < charas.size; i++) {
			if (charas.get(i) instanceof CharaS) {
				SActor s = new SActor(world);
				addMainChara(s);
			} else if (charas.get(i) instanceof CharaY) {
				YActor y = new YActor(world);
				addCharacter(y);
			} else {
				CharaActor chara = new CharaActor(charas.get(i));
				addCharacter(chara);
			}
		}

		if (chara.getX() > 10.8f)
			cam.position.x = 21.6f - 5.4f;
		else
			cam.position.x = 5.4f;

		camMove = true;
	}

	public void setWidth(float width) {
		super.setWidth(width);
		back.setWidth(width);
		cam.position.set(width - 5.4f, 9.6f, 0);
	}

	public void setBackGround(String name) {
		Drawable back = Assets.event.getDrawable(name);
		this.back = new Image();
		addActor(this.back);

		this.back.setDrawable(back);
		float width = 10.8f;

		if (back.getMinWidth() > 432)
			width = 21.6f;

		this.back.setBounds(0, 0, width, 11);
	}

	public void changeEventWorld(EventWorld world, float time) {
		camMove = false;
		this.world = world;
		addAction(sequence(fadeOut(time), run(new Runnable() {

			@Override
			public void run() {
				// TODO 自動生成されたメソッド・スタブ
				clearChildren();
				camMove = true;
				init();
				EventGroup.this.world.startEvent();
				screen.changeWorldEnd();
				Gdx.app.log("Change", "");
			}
		})));
	}

	public void hide(float time) {
		addAction(sequence(fadeOut(time), run(new Runnable() {

			@Override
			public void run() {
				// TODO 自動生成されたメソッド・スタブ
				screen.hideGoupEnd();
			}
		})));
	}

	public void hide() {
		hide(.5f);
	}

	public void show() {
		addAction(fadeIn(.5f));
	}

	public void camMoving(boolean move) {
		camMove = move;
	}

	void camMove() {
		if (chara.getX() <= 10.8f) {
			cam.position.x -= .1f;
			if (cam.position.x <= 5.4f) {
				cam.position.x = 5.4f;
			}
		} else {
			cam.position.x += .1f;
			if (cam.position.x >= 16.2f) {
				cam.position.x = 16.2f;
			}
		}
	}

	public void addMainChara(Actor chara) {
		this.chara = chara;
		addActor(chara);
	}

	public void addCharacter(Actor chara) {
		addActor(chara);
	}

	@Override
	public void act(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		if (camMove)
			camMove();

		cam.update();
		super.act(delta);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO 自動生成されたメソッド・スタ
		matrix.set(batch.getProjectionMatrix());
		batch.setProjectionMatrix(cam.combined);
		batch.setColor(0, 0, 0, parentAlpha);
		tanshoku.draw(batch, 0, 0, 21.6f, 19.2f);
		super.draw(batch, parentAlpha);
		batch.setProjectionMatrix(matrix);
	}
}
