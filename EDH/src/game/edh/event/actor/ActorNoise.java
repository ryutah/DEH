package game.edh.event.actor;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import game.edh.Assets;

public class ActorNoise extends Actor {
	TextureRegion noise;
	TextureRegion noiseLine;
	Sprite noiseDot;
	
	float noiseState, noise_lineState, noise_dotState;

	float noiseX, noiseY;
	float noise_lineX, noise_lineY, randLineX, randLineY;

	boolean drawDot, drawLine;

	public ActorNoise() {
		// TODO 自動生成されたコンストラクター・スタブ
		noise = Assets.title.get("noise", TextureRegionDrawable.class)
				.getRegion();
		noiseLine = Assets.title
				.get("noise_line", TextureRegionDrawable.class).getRegion();
		noise_lineX = .1f;
		TextureRegion dot = Assets.title.get("noise_dot",
				TextureRegionDrawable.class).getRegion();
		noiseDot = new Sprite(dot);
	}
	
	@Override
	public void act(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		super.act(delta);
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

				noiseDot.setBounds(x, y, width, height);
				noiseDot.setRotation(rotate);
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
			noiseDot.draw(batch, parentAlpha);

		batch.draw(noiseLine, noise_lineX, noise_lineY, 2f, 780);
		if (drawLine)
			batch.draw(noiseLine, randLineX, randLineY, 4, 780);
	}
}
