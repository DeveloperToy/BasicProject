package polymorphism;

import polymorphism.PolymorphismConst.Gender;

public class DeliveryHealtLady extends NightWork
{
	/** 道具 */
	private String item;

	public DeliveryHealtLady(int age, Gender gender, String item)
	{
		//親クラスのコンストラクタ作成
		super( age, gender );

		// 基本時給
		BASE_OF_WAGE = 10000;
		// 年齢上限
		MAX_AGE = 35;
		// 昇給対象回数
		BASE_OF_PAY_RISE = 100;
		// 昇給率
		RATE_OF_PAY_RISE = 0.1f;
		// 仕事道具
		this.item = item;
	}

	/**
	 * 仕事内容照会.<br>
	 */
	@Override
	public void work()
	{
		System.out.println( "デリヘル嬢は、お客を癒すことが仕事です" );
		System.out.println( "お客の要望によっては、仕事道具（" + item + "）を使います。" );
	}

	/**
	 * 給料.<br>
	 * @param period
	 * <ul>
	 * <li>第0引数：勤務回数</li>
	 * <li>第1引数：今月の回数</li>
	 * </ul>
	 */
	@Override
	public void salary( int... period )
	{
		int salary = 0;
		int i = 0;
		int times = period[ i++ ];
		int workTimesOfMonth = period[ i ];
		int baseOfWage = BASE_OF_WAGE;

		if (BASE_OF_PAY_RISE <= times) {
			int upRate = Math.round( times / BASE_OF_PAY_RISE );
			baseOfWage = Math.round( baseOfWage * ( 1 + RATE_OF_PAY_RISE * upRate ) );
		}
		System.out.println( "1回あたりの給料は、" + baseOfWage + "円です。" );

		salary = baseOfWage * workTimesOfMonth;
		System.out.println( "今月の給料は、" + salary + "円です。" );
	}
}
