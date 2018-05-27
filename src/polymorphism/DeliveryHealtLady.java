package polymorphism;

import capsule.Person;
import polymorphism.PolymorphismConst.WorkCategory;

public class DeliveryHealtLady extends NightWork
{
	/** 道具 */
	private String item;

	public DeliveryHealtLady(String item)
	{
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
	 * 給料算出.<br>
	 * ※使う側には影響出ないようにする
	 * 
	 * @param p 個人情報
	 */
	@Override
	public void getSalary( Person p )
	{
		calculateSalary( p.getWorkOfYearOrTimes(), p.getWorkOfDayOrTimes() );
	}

	/**
	 * 給料計算.<br>
	 * ※処理に変更が入ってもいいように別メソッドにする
	 * 
	 * @param times 勤務総回数
	 * @param workTimesOfMonth 今月の勤務回数
	 */
	private void calculateSalary( int times, int workTimesOfMonth )
	{
		int salary = 0;
		int baseOfWage = WorkCategory.DeliveryHealtLady.getBaseOfWage();

		if (WorkCategory.DeliveryHealtLady.getBaseOfPayRise() <= times) {
			int upRate = Math.round( times / WorkCategory.DeliveryHealtLady.getBaseOfPayRise() );
			baseOfWage = Math.round( baseOfWage * ( 1 + WorkCategory.DeliveryHealtLady.getRateOfPayRise() * upRate ) );
		}
		System.out.println( "1回あたりの給料は、" + baseOfWage + "円です。" );

		salary = baseOfWage * workTimesOfMonth;
		System.out.println( "今月の給料は、" + salary + "円です。" );
	}
}
