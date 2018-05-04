package capsule;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class Main
{
	private static Integer id;

	public static void main( String[] args )
	{
		// Personのオブジェクト
		Class<Person> personClass = Person.class;
		id = 0;
		// Personのインスタンス
		Person ataro = new Person( id, "AAA", "男", "2000/01/01 17:00:12" );
		Person btaro = new Person( ataro.getId(), "BBB", "男", "2005/05/01 12:30:45" );
		Person cko = new Person( btaro.getId(), "AAA", "男", "2000/01/01 17:00:12" );

		List<Person> personList = Arrays.asList( ataro, btaro, cko );

		for (Person person : personList) {
			try {
				// Methodでprivateメソッドにアクセスできるようにする
				Method method2 = personClass.getDeclaredMethod( "createId", Integer.class );
				method2.setAccessible( true );
				// 一旦、初期値を0で設定する
				Object obj2 = method2.invoke( person, id );
				id = ( int ) method2.invoke( person, id );

				Capsule chargeOfAtaro = new Capsule( person.getGender() );
				System.out.println( person.getName() + ":" + chargeOfAtaro.getCharge() );
				System.out.println( "年齢：" + person.getAge() );
				System.out.println( "個人情報：" + person.getPersonInfo() );
				System.out.println( "id：" + id );
				System.out.println( "obj2：" + obj2 );
				System.out.println( "空と比較equals：" + String.valueOf( id ).equals( "" ) );
				System.out.println( "IDと比較equals：" + obj2.toString().equals( String.valueOf( id ) ) );

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
