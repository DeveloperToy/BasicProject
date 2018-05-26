package capsule;

import java.util.Arrays;
import java.util.List;

import polymorphism.CabaretClubLady;
import polymorphism.PolymorphismConst.Conditions;
import polymorphism.PolymorphismConst.Gender;
import polymorphism.PolymorphismConst.WorkCategory;
import polymorphism.DeliveryHealtLady;
import polymorphism.GarlsBarLady;
import polymorphism.NightWork;

public class Main
{
	public static void main( String[] args )
	{
		// Personのインスタンス
		int index = 0;
		List<Person> personList = Arrays.asList(
				// 職業NG
				new Person( "AAA", Gender.WOMEN, "2000/01/01 17:00:12", WorkCategory.SE, 1, 20, 8 ),
				// GarlsBar年齢上限：NG
				new Person( "BBB", Gender.WOMEN, "1987/05/01 12:30:45", WorkCategory.GarlsBar, 1, 20, 8 ),
				// DeliveryHealtLady年齢上限：NG
				new Person( "CCC", Gender.WOMEN, "1982/05/01 12:30:45", WorkCategory.DeliveryHealtLady, 20, 20, 0 ),
				// CabaretClubLady年齢上限：NG
				new Person( "DDD", Gender.WOMEN, "1977/01/01 17:00:12", WorkCategory.CabaretClubLady, 2, 20, 8 ),
				// All年齢下限：OK
				new Person( "EEE", Gender.WOMEN, "2000/01/01 17:00:12", WorkCategory.DeliveryHealtLady, 99, 15, 0 ),
				// GarlsBar年齢上限：OK
				new Person( "FFF", Gender.WOMEN, "1988/05/01 12:30:45", WorkCategory.GarlsBar, 2, 20, 8 ),
				// DeliveryHealtLady年齢上限：OK
				new Person( "GGG", Gender.WOMEN, "1983/05/01 12:30:45", WorkCategory.DeliveryHealtLady, 100, 30, 0 ),
				// CabaretClubLady年齢上限：OK
				new Person( "HHH", Gender.WOMEN, "1978/01/01 17:00:12", WorkCategory.CabaretClubLady, 3, 20, 8 ),
				// All：OK
				new Person( "III", Gender.WOMEN, "1998/05/01 12:30:45", WorkCategory.DeliveryHealtLady, 250, 20, 0 ),
				// 性別：NG
				new Person( "JJJ", Gender.MENS, "1998/05/01 12:30:45", WorkCategory.GarlsBar, 250, 20, 0 ) );

		for (Person person : personList) {

			System.out.println( "/////////////////////////////////////////////" );
			System.out.println( "名前：" + person.getName() );
			System.out.println( "年齢：" + person.getAge() );
			// ////////////////////////
			// // カプセル化用
			// ////////////////////////
			// System.out.println( "[名前]空と比較equals：" + person.getName().equals( "" ) );
			// System.out.println( "[名前]名前と比較equals：" + person.getName().equals(
			// personList.get( index ).getName() ) );
			// System.out.println( "[PERSON]NULLと比較equals：" + person.equals( null ) );
			// System.out.println( "[PERSON]equals：" + person.equals( personList.get( index
			// ) ) );
			// index++;

			////////////////////////
			// ポリモフィズム用
			////////////////////////
			// 対象外の職業
			if (WorkCategory.SE.equals( person.getWork() ) || WorkCategory.OTHER.equals( person.getWork() )) {
				System.out.println( "対象外の職業です" );
				continue;
			}

			// 職業：キャバクラ
			if (WorkCategory.CabaretClubLady.equals( person.getWork() )) {
				CabaretClubLady ccLady = new CabaretClubLady( person.getAge(), person.getGender() );
				inquiryNightWork( ccLady, person );
			}

			// 職業：ガールズバー
			if (WorkCategory.GarlsBar.equals( person.getWork() )) {
				GarlsBarLady gbLady = new GarlsBarLady( person.getAge(), person.getGender() );
				inquiryNightWork( gbLady, person );
			}

			// 職業：デリヘル
			if (WorkCategory.DeliveryHealtLady.equals( person.getWork() )) {
				String item = "コスチューム";
				DeliveryHealtLady dhLady = new DeliveryHealtLady( person.getAge(), person.getGender(), item );
				inquiryNightWork( dhLady, person );
			}
		}
	}

	/**
	 * 職業照会.<br>
	 * 
	 * @param nw 職業
	 * @param p 個人情報
	 */
	private static void inquiryNightWork( NightWork nw, Person p )
	{
		if (!nw.checkPrecondition( Conditions.AGE, Conditions.GENDER )) {
			System.out.println( p.getWork().toString() + "：条件がNGでした" );
		} else {
			nw.work();
			nw.salary( p.getWorkOfYearOrTimes(), p.getWorkOfDayOrTimes(), p.getWorkOfHour() );
		}
	}
}
