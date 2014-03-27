package game.edh.actors.event;

import game.edh.Assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class TestGroup extends Group {
	OrthographicCamera cam;
	private float width = 21.6f;
	private float height = 19.2f;
	
	private Matrix4 matrix;
	private TextureRegion region;
	public boolean move = false;
	
	private int direction;
	private final int LEFT = 0;
	private final int RIGHT = 1;
	
	public TestGroup() {
		// TODO 自動生成されたコンストラクター・スタブ
		cam = new OrthographicCamera();
		cam.setToOrtho(false, width / 2, height);
		matrix = new Matrix4();
		
		region = Assets.title.getRegion("spring");
		Image image = new Image(region);
		image.setBounds(0, 0, 21.6f, 12.8f);
		
		this.setBounds(0, 5.5f, width, 12.8f);
		addActor(image);
		
		direction = LEFT;
		Gdx.app.log("CAM", "(" + cam.position.x + ", " + cam.position.y + ")");
	}
	
	@Override
	public void act(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		if(move)
			camMove(delta);
		cam.update();
		super.act(delta);
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO 自動生成されたメソッド・スタブ
		matrix.set(batch.getProjectionMatrix());
		batch.setProjectionMatrix(cam.combined);
		super.draw(batch, parentAlpha);
		batch.setProjectionMatrix(matrix);
	}
	
	public void setMove() {
		this.move = true;
	}
	
	public void camMove(float delta) {
		if(direction == LEFT) {
			cam.position.add(10.0f * delta, 0, 0);
			if(cam.position.x >= 16.2f) {
				cam.position.x = 16.2f;
				direction = RIGHT;
				move = false;
			}
		} else {
			cam.position.add(-10.0f * delta, 0, 0);
			if(cam.position.x <= 5.4f) {
				cam.position.x = 5.4f;
				direction = LEFT;
				move = false;
			}
		}
		
		Gdx.app.log("Cam","" + cam.position.x);
	}
}
