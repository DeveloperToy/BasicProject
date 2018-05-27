package polymorphism;

import capsule.Person;
import polymorphism.PolymorphismConst.WorkCategory;

public class GarlsBarLady extends NightWork
{
	/**
	 * 仕事内容照会.<br>
	 */
	@Override
	public void work()
	{
		System.out.println( "ガールズバーは、カウンター越しにドリンクを飲みながら喋ることが仕事です" );
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
		// privateメソッドで、余計な変更は吸収する
		calculateSalary( p.getWorkOfYearOrTimes(), p.getWorkOfDayOrTimes(), p.getWorkOfHour() );
	}

	/**
	 * 給料計算.<br>
	 * ※処理に変更が入ってもいいように別メソッドにする
	 * 
	 * @param years 勤務年数
	 * @param workOfDays 勤務日数
	 * @param workOfHour 勤務時間
	 */
	private void calculateSalary( int years, int workOfDays, int workOfHour )
	{
		int salary = 0;
		int hw = WorkCategory.GarlsBar.getBaseOfWage();

		if (WorkCategory.GarlsBar.getBaseOfPayRise() <= years) {
			hw = Math.round( hw * ( 1 + years * WorkCategory.GarlsBar.getRateOfPayRise() ) );
		}
		System.out.println( "時給は、" + hw + "円です。" );

		salary = hw * workOfHour * workOfDays;
		System.out.println( "今月の給料は、" + salary + "円です。" );
	}

}
