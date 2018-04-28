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
	private String attribute;

	Capsule(String attribute)
	{
		this.attribute = attribute;
	}

	/**
	 * 簡単な計算をして返す.<br>
	 * 
	 * @return 計算結果
	 */
	public int calc()
	{
		int result = 0;
		int charge = chargeCase( this.attribute );

		result = this.base * charge;

		return result;
	}

	/**
	 * カテゴリーによって、変更する.
	 * 
	 * @param attribute
	 *            年齢・性別
	 * @return カテゴリー別に基準値
	 */
	private int chargeCase( String attribute )
	{
		int charge = 0;

		switch (attribute) {
		case "older":
			charge = 5;
			break;
		case "wormen":
			charge = 2;
			break;
		default:
			charge = 10;
		}

		return charge;
	}
}
