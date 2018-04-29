package capsule;

public class CapsuleConst
{
	/**
	 * 列挙型の実装.<br>
	 * ＜メリット＞
	 * <ul>
	 * <li>変わらない(＝静的な)オブジェクト(値と振る舞い)として、扱うことができる</li>
	 * <li>システムを通じて安全性を高める</li>
	 * </ul>
	 * 
	 * ＜使い所＞<br>
	 * インタフェースと具象クラスを紐付ける時の引数などに使う。<br>
	 * ※単純な定数(0,1など)を表す場合、定数値(static final ***)を使う<br>
	 * <ul>
	 * <li>型の安全性が必要かどうか</li>
	 * <li>同一のコンテキストを持つ定数が複数必要かどうか</li>
	 * </ul>
	 * 
	 * @author ykd
	 *
	 */
	public enum FormatOfDay
	{
		NORMAL( "yyyy/MM/dd HH:mm:ss" ), LINE_SEPARATION( "yyyy-MM-dd HH:mm:ss" ), UNDERBAR_SEPARATION(
				"yyyy_MM_dd HH:mm:ss" );

		private String format;

		private FormatOfDay(String format)
		{
			this.format = format;
		}

		public String getFormat()
		{
			return this.format;
		}
	}
}
