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
	 * 各ゲッター.<br>
	 * ※IDのみ、外部アクセス不可にする。
	 * 
	 * @return ID・名前・性別・誕生日
	 */
	private Integer getId()
	{
		return this.id;
	}

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

		Capsule changeOfFormat = new Capsule( FormatOfDay.NORMAL.getFormat() );
		LocalDate changeFormatBirthday = changeOfFormat.changeFormatLd( this.birthday );

		return Period.between( changeFormatBirthday, today ).getYears();
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

		Person p = ( Person ) obj;
		// id
		if (Person.id != null) {
			return false;
		} else if (!( Person.id == p.getId() )) {
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
