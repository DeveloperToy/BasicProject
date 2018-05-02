package capsule;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import capsule.CapsuleConst.FormatOfDay;

public class Main
{
	public static void main( String[] args )
	{
		// Personのオブジェクト
		Class<Person> personClass = Person.class;

		// Personのインスタンス
		Person[] personList = { new Person( "AAA", "男", "2000/01/01 17:00:12" ),
				new Person( "BBB", "男", "2005/05/01 12:30:45" ), new Person( "CCC", "女", "2015/10/01 20:55:20" ) };

		for (Person person : personList) {
			try {
				// Methodでprivateメソッドにアクセスできるようにする
				Method method = personClass.getDeclaredMethod( "createkey", String.class );
				method.setAccessible( true );

				Object obj = method.invoke( person, person.getPersonInfo() );

				Capsule chargeOfAtaro = new Capsule( person.getGender() );
				System.out.println( person.getName() + ":" + chargeOfAtaro.getCharge() );
				System.out.println( "年齢：" + person.getAge() );
				System.out.println( "個人情報：" + person.getPersonInfo() );
				System.out.println( "key：" + obj.toString() );
				System.out.println( "equals：" + obj.equals( "" ) );
				System.out.println( "equals：" + obj.equals( method.invoke( person, person.getPersonInfo() ) ) );

			} catch (NoSuchMethodException | SecurityException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			} catch (IllegalAccessException | InvocationTargetException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
	}
}
