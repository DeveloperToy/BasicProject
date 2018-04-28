package capsule;

public class Main
{
	public static void main( String[] args )
	{
		Person ataro = new Person( "AAA", 5, "2000/01/01" );
		Person btaro = new Person( "BBB", 65, "2005/05/01" );
		Person ctaro = new Person( "CCC", 20, "2015/10/01" );

		Capsule calcOfAtaro = new Capsule( ataro.getAge() );
		System.out.println( "ataro:" + calcOfAtaro.getCalculation() );

		Capsule calcOfBtaro = new Capsule( btaro.getAge() );
		System.out.println( "btaro:" + calcOfBtaro.getCalculation() );

		Capsule calcOfCtaro = new Capsule( ctaro.getAge() );
		System.out.println( "ctaro:" + calcOfCtaro.getCalculation() );
	}
}
