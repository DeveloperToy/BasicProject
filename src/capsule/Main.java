package capsule;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class Main
{
	public static void main( String[] args )
	{
		// Personのインスタンス
		int index = 0;
		List<Person> personList = Arrays.asList( new Person( "AAA", "男", "2000/01/01 17:00:12" ),
				new Person( "BBB", "男", "2005/05/01 12:30:45" ), new Person( "AAA", "男", "2000/01/01 17:00:12" ) );

		for (Person person : personList) {

			Capsule chargeOfAtaro = new Capsule( person.getGender() );
			System.out.println( person.getName() + ":" + chargeOfAtaro.getCharge() );
			System.out.println( "年齢：" + person.getAge() );
			System.out.println( "個人情報：" + person.getPersonInfo() );
			System.out.println( "[名前]空と比較equals：" + person.getName().equals( "" ) );
			System.out.println( "[名前]名前と比較equals：" + person.getName().equals( personList.get( index ).getName() ) );
			System.out.println( "[ID]空と比較equals：" + person.getName().equals( "" ) );
			System.out.println( "[ID]名前と比較equals：" + person.equals( personList.get( index ) ) );
			index++;
		}
	}
}
