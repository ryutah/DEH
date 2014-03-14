package game.edh;

import game.edh.frame.Shujinkou;
import game.edh.frame.Yuujin;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class EventTestGroup extends Group {
	OrthographicCamera cam;
	Matrix4 matrix;
	Image back;
	public Shujinkou shujinkou;
	public Yuujin yuujin;
	Vector3 v3;
	EventTest screen;
	
	boolean camMove = false;
	boolean talking = false;
	
	public final float scaleX = Gdx.graphics.getWidth() / 432f;
	public final float scaleY = Gdx.graphics.getHeight() / 768f;
	
	public EventTestGroup(EventTest screen) {
		// TODO 自動生成されたコンストラクター・スタブ
		cam = new OrthographicCamera();
		cam.setToOrtho(false, 10.8f, 19.2f);
		cam.position.set(21.6f - 5.4f, 9.6f, 0);
		cam.update();
		
		v3 = new Vector3();
		
		matrix = new Matrix4();
		back = new Image();
		back.setDrawable(Assets.event.getDrawable("winter"));
		back.setBounds(0, 7.2f, 21.6f, 11f);
		Gdx.app.log("Back", "" + back.getY());
		
		setBounds(0, 0, 21.6f, 19.2f);
		Gdx.app.log("Group", "" + getWidth());
		
		addActor(back);
		
		shujinkou = new Shujinkou(19.2f / 768, Shujinkou.ARUKU, Shujinkou.LEFT);
		shujinkou.setX(20);
		shujinkou.setY(8.4f);
		
		yuujin = new Yuujin(Yuujin.YOKOMUKI, Yuujin.RIGHT);
		yuujin.setPosition(1, 8.4f);
		
		addActor(shujinkou);
		addActor(yuujin);
		
		shujinkou.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO 自動生成されたメソッド・スタブ
				shujinkou.startMove(Shujinkou.LEFT);
				Gdx.app.log("Group", "Touch" + x + "," + y);
			}
		});
	}
	
	@Override
	public Actor hit(float x, float y, boolean touchable) {
		// TODO 自動生成されたメソッド・スタブ
		v3.set(x * scaleX, Gdx.graphics.getHeight() - (y * scaleY), 0);
		cam.unproject(v3);
		Gdx.app.log("Touch", v3.x + "," + v3.y);
		return super.hit(v3.x, v3.y, touchable);
	}
	
	public void camMove() {
		if(cam.position.x > 5.4f)
			cam.position.add(-.1f, 0, 0);
		else {
			cam.position.set(5.4f, 9.6f, 0);
			talking = true;
			camMove = false;
		}
	}
	
	@Override
	public void act(float delta) {
		// TODO 自動生成されたメソッド・スタブ
		if(shujinkou.getX() < 10.8f)
			camMove();
		if(shujinkou.getX() < 8.5f) {
			shujinkou.stopMove();
			shujinkou.setX(8.5f);
			setTouchable(Touchable.disabled);
		}
		
		cam.update();
		super.act(delta);
	}
	
	public boolean startTalking() {
		return talking;
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO 自動生成されたメソッド・スタブ
		matrix.set(batch.getProjectionMatrix());
		batch.setProjectionMatrix(cam.combined);
		super.draw(batch, parentAlpha);
		batch.setProjectionMatrix(matrix);
	}
}
