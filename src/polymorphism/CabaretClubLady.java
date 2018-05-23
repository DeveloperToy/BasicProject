package polymorphism;

import polymorphism.Category.Conditions;

public class CabaretClubLady extends NightWork
{
	/** 時給 */
	private static final int HOURLY_WAGE = 2500;
	/** 昇給対象勤続年数 */
	private static final int LENGTH_OF_SERVICE = 1;
	/** 昇給率 */
	private static final float RATE = 0.05f;

	/** 年齢 */
	private int age;
	/** 性別 */
	private String gender;

	public CabaretClubLady(int age, String gender)
	{
		this.age = age;
		this.gender = gender;
	}

	@Override
	public void work()
	{
		System.out.println( "キャバ嬢は、お客の隣で酒を飲みまくることです" );
	}

	/**
	 * 条件
	 */
	@Override
	public void precondition( Conditions... conditions1 )
	{
		for (Conditions c : conditions1) {
			if (Conditions.AGE.equals( c )) {
				checkAge( age );
			}
			if (Conditions.GENDER.equals( c )) {
				checkGender( gender );
			}
		}
	}

	/**
	 * 給料.<br>
	 * <ul>
	 * <li>第0引数：勤務年数</li>
	 * <li>第1引数：勤務時間</li>
	 * <li>第2引数：月別勤務日数</li>
	 * </ul>
	 */
	@Override
	public void salary( int... period )
	{
		int salary = 0;
		int i = 0;
		int years = period[ i++ ];
		int workHour = period[ i++ ];
		int workDays = period[ i ];
		int hw = HOURLY_WAGE;

		if (LENGTH_OF_SERVICE < years) {
			hw = Math.round( hw * years * RATE );
		}
		System.out.println( "時給は、" + hw + "円です。" );

		salary = hw * workHour * workDays;
		System.out.println( "今月の給料は、" + salary + "円です。" );
	}
}
