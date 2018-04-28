package capsule;

/**
 * カプセル化の実装.<br>
 * 属性(オブジェクトごとに持つインスタンス変数)と操作(メソッド)を１つにまとめたもの。<br>
 * ＜メリット＞
 * <ul>
 * <li>データをオブジェクト外に漏れることを防止できる</li>
 * <li>オブジェクト内で保持する不変な値を保護できる</li>
 * <li>クラスの実装を変更しても呼出し側は意識する必要ない。(＝影響を軽減する)</li>
 * </ul>
 * 
 * @author ykd
 */
public class Capsule
{
	private int base = 100;
	// newすることでしか値を設定することができなくなった。
	private int age;

	Capsule(int age)
	{
		this.age = age;
	}

	/**
	 * 簡単な計算をして返す.<br>
	 * 
	 * @return 計算結果
	 */
	public double getCalculation()
	{
		double result = 0;
		double rate = getDiscountRate( this.age );

		result = Math.round( this.base * rate );

		return result;
	}

	/**
	 * 割引率を取得する.
	 * 
	 * @return 割引率
	 */
	private double getDiscountRate( int age )
	{
		if (5 >= this.age) {
			return 0.0;
		}

		if (65 <= this.age) {
			return 0.5;
		}

		return 1.0;
	}
}
