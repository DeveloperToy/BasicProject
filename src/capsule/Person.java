package capsule;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.Period;

import capsule.CapsuleConst.FormatOfDay;

public class Person
{
	// keyの変換タイプ
	private static final String MD5 = "MD5";

	private String name;
	private String gender;
	private String birthday;

	Person(String name, String gender, String birthday)
	{
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
	}

	/**
	 * 各ゲッター
	 * 
	 * @return 名前・性別・誕生日
	 */
	public String getName()
	{
		return this.name;
	}

	public String getGender()
	{
		return this.gender;
	}

	public String getBirthday()
	{
		return this.birthday;
	}

	/**
	 * フィールドは追加しないから誕生日と本日日付をもとに年齢を出す.
	 * 
	 * @return 年齢
	 */
	public Integer getAge()
	{
		LocalDate today = LocalDate.now();

		Capsule2 changeOfFormat = new Capsule2( FormatOfDay.NORMAL.getFormat() );
		LocalDate changeFormatBirthday = changeOfFormat.changeFormatLd( this.birthday );

		return Period.between( changeFormatBirthday, today ).getYears();
	}

	/**
	 * 個人情報取得.
	 * 
	 * @return 個人情報
	 */
	public String getPersonInfo()
	{
		return this.name.concat( this.gender ).concat( this.birthday ).concat( String.valueOf( this.getAge() ) );
	}

	/**
	 * key作成.<br>
	 * ※このプロジェクトでは、apatchライブラリがないから使えない。<br>
	 * RandomStringUtils.randomAlphanumeric
	 * 
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	private String createkey( String personInfo ) throws NoSuchAlgorithmException
	{
		MessageDigest md5 = MessageDigest.getInstance( MD5 );
		// 個人情報のバイト数を使って、固定長のハッシュ値に変換
		md5.update( personInfo.getBytes() );
		// digest()は、変換完了後に、呼び出す最終処理
		String md5Key = md5ToString( md5.digest() );
		return md5Key;
	}

	/**
	 * 変換はググって少し改良.<br>
	 * 
	 * @param byteArray
	 * @return 変換後のkey
	 */
	private String md5ToString( byte[] byteArray )
	{
		String md5Key = null;
		for (int num : byteArray) {
			if (num < 0) {
				// マイナスの場合、符号なし整数に変換する
				num += 256;
			}
			// 16進数（16進数）のASCII数字の文字列に変換
			String hex = Integer.toHexString( num );
			if (hex.length() == 1) {
				hex = "0" + hex;
			}
			md5Key += hex;
		}
		return md5Key;
	}

	/**
	 * equals
	 */
	@Override
	public boolean equals( Object obj )
	{
		if (obj == null) {
			return false;
		}

		if (!this.equals( obj )) {
			return false;
		}

		if (!( obj instanceof Person ))
			return false;
		Person person = ( Person ) obj;

		if (!( this.getPersonInfo() == person.getPersonInfo() )
				&& !this.getPersonInfo().equals( person.getPersonInfo() )) {
			return false;
		}

		return true;
	}

}
