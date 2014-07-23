package game.edh.title.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import game.edh.Assets;
import game.edh.EdhGame;
import game.edh.frame.BaseScreen;
import game.edh.frame.BaseTable;
import game.edh.screen.LoadScreen;
import game.edh.screen.LoadScreen.NextScreen;

public class StageTitleTable extends BaseTable {
	TextureRegion noise;
	TextureRegion noise_line;
	Sprite noise_dot;

	float noiseState, noise_lineState, noise_dotState, state;

	float noiseX, noiseY;
	float noise_lineX, noise_lineY, randLineX, randLineY;

	boolean drawDot, drawLine;

	NextScreen stage;

	public StageTitleTable(BaseScreen screen, Table mainTable, int stageNum) {
		super(screen, mainTable);
		// TODO 自動生成されたコンストラクター・スタブ
		String text = "";
		switch (stageNum) {
		case 1:
			stage = NextScreen.EVENT1;
			text = "S P R I N G";
			break;
		case 2:
			stage = NextScreen.EVENT3;
			text = "S U M M E R";
			break;
		case 3:
			stage = NextScreen.EVENT5;
			text = "W I N T E R";
			break;
		case 4:
			stage = NextScreen.EVENT7;
			text = "IN A DREAM";
			break;
		}

		setBounds(0, 0, 432, 768);
		Label label = new Label(text, Assets.title, "TOfont");
		label.setFontScale(1.6f);
		label.setColor(Color.BLACK);
		add(label).fill();

		noise = Assets.title.get("noise", TextureRegionDrawable.class)
				.getRegion();
		noise_line = Assets.title
				.get("noise_line", TextureRegionDrawable.class).getRegion();
		noise_lineX = 10;
		TextureRegion dot = Assets.title.get("noise_dot",
				TextureRegionDrawable.class).getRegion();
		noise_dot = new Sprite(dot);

		addListener(new ActorGestureListener() {
			@Override
			public void tap(InputEvent event, float x, float y, int count,
					int button) {
				// TODO 自動生成されたメソッド・スタブ
				StageTitleTable.this.screen.changeScreen(new LoadScreen(
						StageTitleTable.this.screen.getEdh(), stage));
				EdhGame.music.stopEffect();
			}
		});
		
		float x = -1;
		float y = 0;
		float degree = MathUtils.atan2(y, x) * MathUtils.radiansToDegrees;
		Gdx.app.log("Degree", "" + degree);
		
		EdhGame.music.stopMusic();
	}

	@Override
	public void act(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		super.act(delta);

		state += delta;
		if (state >= .15f) {
			float x = MathUtils.random(-3, 3);
			float y = MathUtils.random(-3, 3);

			setPosition(x, y);

			state = 0;
		}
		updateNoise(delta);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO 自動生成されたメソッド・スタブ
		super.draw(batch, parentAlpha);
		drawNoise(batch, parentAlpha);
	}

	private void updateNoise(float delta) {
		noiseState += delta;
		if (noiseState >= .1f) {
			noiseX = MathUtils.random(-10, 0);
			noiseY = MathUtils.random(-10, 0);
			noiseState = 0;
		}

		if (drawDot) {
			noise_dotState += delta;
			if (noise_dotState >= .15f) {
				drawDot = false;
				noise_dotState = 0;
			}
		} else {
			if (MathUtils.random(50) > 49) {
				float x = MathUtils.random(10, 432);
				float y = MathUtils.random(20, 768);
				float scale = MathUtils.random(.8f, 1.5f);
				float width = 30 * scale;
				float height = 32 * scale;
				float rotate = MathUtils.random(180);

				noise_dot.setBounds(x, y, width, height);
				noise_dot.setRotation(rotate);
				drawDot = true;
			}
		}

		updateNoiseLine(delta);
	}

	private void updateNoiseLine(float delta) {
		noise_lineX += 2f;
		if (noise_lineX > 422)
			noise_lineX = 10;
		noise_lineY = MathUtils.random(-13, 13);

		if (drawLine) {
			noise_lineState += delta;
			if (noise_lineState >= .2f) {
				drawLine = false;
				noise_lineState = 0;
			}
		} else {
			if (MathUtils.random(50) > 49) {
				randLineX = MathUtils.random(10, 432);
				randLineY = MathUtils.random(13, 20);
				drawLine = true;
			}
		}
	}

	private void drawNoise(Batch batch, float parentAlpha) {
		batch.setColor(1, 1, 1, parentAlpha);
		batch.draw(noise, noiseX, noiseY, 450, 780);

		if (drawDot)
			noise_dot.draw(batch, parentAlpha);

		batch.draw(noise_line, noise_lineX, noise_lineY, 2f, 780);
		if (drawLine)
			batch.draw(noise_line, randLineX, randLineY, 4, 780);
	}

	@Override
	protected void showTable() {
		// TODO 自動生成されたメソッド・スタブ
		EdhGame.music.changeMusic(Assets.NOISE);
		EdhGame.music.playMusic();
	}

	@Override
	public void backPress() {
		// TODO 自動生成されたメソッド・スタブ
		
	}

}
