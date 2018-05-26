package capsule;

import java.time.LocalDate;
import java.time.Period;
import java.util.concurrent.atomic.AtomicInteger;

import capsule.CapsuleConst.FormatOfDay;
import polymorphism.PolymorphismConst;
import polymorphism.PolymorphismConst.Gender;
import polymorphism.PolymorphismConst.WorkCategory;

public class Person
{
	// Atomicに変えて、読み込みして比較するまでの間に読み込んだ値が書き換わったりすることはないようにする
	private static AtomicInteger tmpId = new AtomicInteger( 1 );

	private Integer id = 0;
	private String name;
	private Gender gender;
	private String birthday;

	// ポリモフィズム用フィールド
	private WorkCategory work;
	private int workOfYearOrTimes;
	private int workOfDayOrTimes;
	private int workOfHour;

	Person(String name, Gender gender, String birthday, WorkCategory work, int workOfYearOrTimes, int workOfDayOrTimes,
			int workOfHour)
	{
		synchronized (tmpId) {
			this.id = tmpId.getAndIncrement();
			System.out.println( "id：" + this.id );
		}
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.work = work;
		this.workOfYearOrTimes = workOfYearOrTimes;
		this.workOfDayOrTimes = workOfDayOrTimes;
		this.workOfHour = workOfHour;
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

	public Gender getGender()
	{
		return this.gender;
	}

	public String getBirthday()
	{
		return this.birthday;
	}

	public WorkCategory getWork()
	{
		return work;
	}

	public int getWorkOfYearOrTimes()
	{
		return workOfYearOrTimes;
	}

	public int getWorkOfDayOrTimes()
	{
		return workOfDayOrTimes;
	}

	public int getWorkOfHour()
	{
		return workOfHour;
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
		if (p.id != null) {
			return false;
		} else if (!( p.id == p.getId() )) {
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
		result = prime * result + ( ( work == null ) ? 0 : work.hashCode() );

		return result;
	}
}
