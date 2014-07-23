package game.edh.game.model.frame;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Pools;

public class ModelInu extends MapObject {
	public enum InuDir {
		Up, Down, Left, Rignt
	}
	
	Vector2 origin;
	InuDir dir;
	
	public ModelInu(GameWorld world) {
		super(world);
		// TODO 自動生成されたコンストラクター・スタブ
		origin = new Vector2();
		setBounds(0, 0, 1, 1);
		dir = InuDir.Up;
		
		setCollision(true);
		
		setDraw(true);
	}
	
	@Override
	public void checkObj() {
		// TODO 自動生成されたメソッド・スタブ
		super.checkObj();
		checkDir();
	}
	
	void checkDir() {
		Vector2 player = Pools.obtain(Vector2.class);
		Vector2 vector = Pools.obtain(Vector2.class);
		
		player.set(world.getPlayer().getPosition());
		vector.set(player.sub(origin).nor());
		
		float x = vector.x;
		float y = vector.y;
		float degree = MathUtils.atan2(y, x) * MathUtils.radiansToDegrees;
		
		if(Math.abs(degree) <= 45)
			dir = InuDir.Rignt;
		if(degree > 45 && degree < 135)
			dir = InuDir.Up;
		if(Math.abs(degree) >= 135)
			dir = InuDir.Left;
		if(degree < -45 && degree > -135)
			dir = InuDir.Down;
		
		Pools.free(player);
		Pools.free(vector);
	}
	
	public void setDir(InuDir dir) {
		this.dir = dir;
	}
	
	@Override
	public void setPosition(float x, float y) {
		// TODO 自動生成されたメソッド・スタブ
		super.setPosition(x, y);
		origin.set(x + .5f, y + .5f);
	}
	
	public InuDir getDir() {
		return dir;
	}

}
