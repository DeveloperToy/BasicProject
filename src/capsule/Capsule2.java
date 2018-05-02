package capsule;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import capsule.CapsuleConst.FormatOfDay;

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
public class Capsule2
{
	private String cod;

	Capsule2(String cod)
	{
		this.cod = cod;
	}

	/**
	 * 
	 * @return
	 * @throws ParseException
	 */

	/**
	 * ①外から見える部分は簡単にする. <br>
	 * (＝使う側に知って欲しい部分)<br>
	 * ⇨使う人が触れる部分は必要な情報だけを抜き出す(＝抽象化する)ことでわかりやすくすること。
	 * <ul>
	 * <li>引数2つ(StringとEnum)が必要。</li>
	 * <li>LocalDateTime型の値を返す。</li>
	 * <li>メソッド名から返ってくるものが「型が変わったこと」を指していること。</li>
	 * </ul>
	 * 
	 * @param birthday
	 * @return
	 */
	public LocalDateTime changeFormatLdt( String birthday )
	{
		return getLocalDateTimeOfBirthDay( birthday, this.cod );
	}

	/**
	 * ②複雑な部分は隠す.<br>
	 * (＝使う側が知らなくて良い部分)
	 * 
	 * @return フォーマット変換後の誕生日
	 * @throws ParseException
	 */
	private LocalDateTime getLocalDateTimeOfBirthDay( String birthday, String cod )
	{
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern( cod );
		LocalDateTime localBirthday = LocalDateTime.parse( birthday, fmt );

		return localBirthday;
	}

	/**
	 * ①フォーマット変更(日付ベース).<br>
	 * 
	 * @param birthday
	 * @return
	 */
	public LocalDate changeFormatLd( String birthday )
	{
		return getLocalDateOfBirthDay( birthday, this.cod );
	}

	/**
	 * ②複雑な部分は隠す.(日付ベース)<br>
	 * 
	 * @param birthday
	 * @param cod
	 * @return
	 */
	private LocalDate getLocalDateOfBirthDay( String birthday, String cod )
	{
		LocalDateTime dateTime = this.getLocalDateTimeOfBirthDay( birthday, cod );
		LocalDate date = dateTime.toLocalDate();
		return date;

	}
}
