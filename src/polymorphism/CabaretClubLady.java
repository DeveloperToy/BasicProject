package polymorphism;

import polymorphism.PolymorphismConst.Gender;

public class CabaretClubLady extends NightWork
{
	public CabaretClubLady(int age, Gender gender)
	{
		//親クラスのコンストラクタ作成
		super( age, gender );
		
		// 基本時給
		BASE_OF_WAGE = 2500;
		// 年齢上限
		MAX_AGE = 40;
		// 昇給対象勤続年数
		BASE_OF_PAY_RISE = 1;
		// 昇給率
		RATE_OF_PAY_RISE = 0.05f;
	}

	/**
	 * 仕事内容照会.<br>
	 */
	@Override
	public void work()
	{
		System.out.println( "キャバ嬢は、お客の隣で酒を飲みまくることが仕事です" );
	}

	/**
	 * 給料算出.<br>
	 * @param period
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
		int workOfDays = period[ i++ ];
		int workOfHour = period[ i ];
		int hw = BASE_OF_WAGE;

		if (BASE_OF_PAY_RISE <= years) {
			hw = Math.round( hw * ( 1 + years * RATE_OF_PAY_RISE ) );
		}
		System.out.println( "時給は、" + hw + "円です。" );

		salary = hw * workOfHour * workOfDays;
		System.out.println( "今月の給料は、" + salary + "円です。" );
	}
}
