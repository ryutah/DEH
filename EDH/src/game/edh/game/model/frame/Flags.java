package game.edh.game.model.frame;

import com.badlogic.gdx.Gdx;

public class Flags {
	boolean[] flag;
	String[] flagName;

	public Flags() {
		// TODO 自動生成されたコンストラクター・スタブ
		flag = new boolean[0];
		flagName = new String[0];
	}

	public void addFlag(String flagName) {

		if (flag.length == 0) {
			flag = new boolean[1];
			this.flagName = new String[1];
			flag[0] = false;
			this.flagName[0] = flagName;
		} else {
			boolean[] bufFlag = flag;
			String[] bufFlagName = this.flagName;

			int len = flag.length;

			flag = new boolean[len + 1];
			this.flagName = new String[len + 1];

			System.arraycopy(bufFlag, 0, flag, 0, len);
			System.arraycopy(bufFlagName, 0, this.flagName, 0, len);

			flag[len] = false;
			this.flagName[len] = flagName;
		}
	}

	public void removeFlag(String flagName) {
		if (flag.length <= 1) {
			flag = new boolean[0];
			this.flagName = new String[0];
		} else {
			boolean[] bufFlag = flag;
			String[] bufFlagName = this.flagName;

			int len = flag.length;

			flag = new boolean[len - 1];
			this.flagName = new String[len - 1];

			int num = 0;
			while (num < len) {
				if (flagName.equals(bufFlagName[num])) {
					num++;
					break;
				} else {
					flag[num] = bufFlag[num];
					this.flagName[num] = bufFlagName[num];
					num++;
				}
			}

			while (num < len) {
				flag[num - 1] = bufFlag[num];
				this.flagName[num - 1] = bufFlagName[num];
				num++;
			}
		}
	}

	public void changeFlag(String flagName) {
		for (int i = 0; i < flag.length; i++) {
			if (flagName.equals(this.flagName[i])) {
				flag[i] = !flag[i];
				Gdx.app.log("Flag", flagName + " " + flag[i]);
				break;
			}
		}
	}

	public void changeFlag(String flagName, boolean flag) {
		for (int i = 0; i < this.flag.length; i++) {
			if (flagName.equals(this.flagName[i])) {
				this.flag[i] = flag;
				Gdx.app.log("Flag", flagName + " " + this.flag[i]);
				break;
			}
		}
	}

	public void setFlags(boolean[] flags) {
		this.flag = flags;
	}

	public void setFlagsName(String[] flagsName) {
		this.flagName = flagsName;
	}

	public boolean getFlag(String flagName) {
		for (int i = 0; i < flag.length; i++) {
			if (flagName.equals(this.flagName[i]))
				return flag[i];
		}

		return false;
	}

	public boolean[] getFlags() {
		return flag;
	}

	public String[] getFlagsName() {
		return flagName;
	}
}
