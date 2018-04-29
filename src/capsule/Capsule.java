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
	// 基準年齢
	private static final int CHILD = 5;
	private static final int OLDER = 65;

	// 基準料金
	private int base = 100;

	// newすることでしか値を設定することができなくなった。
	private int age;

	Capsule(int age)
	{
		this.age = age;
	}

	/**
	 * 外から見える部分は簡単にする. <br>
	 * (＝使う側に知って欲しい部分)<br>
	 * ⇨使う人が触れる部分は必要な情報だけを抜き出す(＝抽象化する)ことでわかりやすくすること。
	 * <ul>
	 * <li>引数いらない。</li>
	 * <li>double型の値を返す。</li>
	 * <li>メソッド名から返ってくるものが「料金」を指していること。</li>
	 * </ul>
	 * 
	 * @return
	 */
	public double getCharge()
	{
		return getCalculation();
	}

	/**
	 * ①複雑な部分は隠す.<br>
	 * (＝使う側が知らなくて良い部分)
	 * 
	 * @return 計算結果
	 */
	private double getCalculation()
	{
		double result = 0;
		double rate = getDiscountRate( this.age );

		result = Math.round( this.base * rate );

		return result;
	}

	/**
	 * ②複雑な部分は隠す.<br>
	 * (＝使う側が知らなくて良い部分)
	 * 
	 * @return 割引率
	 */
	private double getDiscountRate( int age )
	{
		if (CHILD >= this.age) {
			return 0.0;
		}

		if (OLDER <= this.age) {
			return 0.5;
		}

		return 1.0;
	}
}
