package capsule;

import java.time.LocalDate;
import java.time.Period;

import capsule.CapsuleConst.FormatOfDay;

public class Person
{
	private static Integer id = 0;
	private String name;
	private String gender;
	private String birthday;

	Person(String name, String gender, String birthday)
	{
		synchronized (id) {
			this.id = ++id;
			System.out.println( "id：" + this.id );
		}
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
	}

	/**
	 * 各ゲッター
	 * 
	 * @return ID・名前・性別・誕生日
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
		return String.valueOf( this.id ).concat( this.name ).concat( this.gender ).concat( this.birthday )
				.concat( String.valueOf( this.getAge() ) );
	}

	/**
	 * id作成.<br>
	 * 
	 * @param maxId
	 * @return idの最大値＋１
	 */
	synchronized private Integer createId()
	{
		return ++id;
	}

	/**
	 * equalsのオーバーライド
	 */
	@Override
	public boolean equals( Object obj )
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) {
			return false;
		}

		Person person = ( Person ) obj;
		// id
		if (id == null) {
			if (person.id != null) {
				return false;
			}
		} else if (!( id == person.id )) {
			return false;
		}
		// 名前
		if (name == null) {
			if (person.name != null) {
				return false;
			}
		} else if (!name.equals( person.name )) {
			return false;
		}
		// 性別
		if (gender == null) {
			if (person.gender != null) {
				return false;
			}
		} else if (!gender.equals( person.gender )) {
			return false;
		}
		// 誕生日
		if (birthday == null) {
			if (person.birthday != null) {
				return false;
			}
		} else if (!birthday.equals( person.birthday )) {
			return false;
		}

		return true;
	}

	/**
	 * ハッシュコードを計算.
	 */
	@Override
	public int hashCode()
	{
		// 31という数は、Java VM内部で計算するときに、乗算を高速なビットシフトに書き換えられるかららしい。
		final int prime = 31;
		int result = 1;
		// フィールドをハッシュコードに変換して定数を足して計算
		result = prime * result + ( ( name == null ) ? 0 : name.hashCode() );
		result = prime * result + ( ( gender == null ) ? 0 : gender.hashCode() );
		result = prime * result + ( ( birthday == null ) ? 0 : birthday.hashCode() );

		return result;
	}
}
