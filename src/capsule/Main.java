package capsule;

public class Main
{
	public static void main( String[] args )
	{
		Man qjiro = new Man( 65 );
		Man schan = new Man( 1020 );
		Man taro = new Man( 20 );

		Capsule older = new Capsule( qjiro.getAttribute() );
		System.out.println( "qjiro:" + older.calc() );

		Capsule wormen = new Capsule( schan.getAttribute() );
		System.out.println( "schan:" + wormen.calc() );

		Capsule men = new Capsule( taro.getAttribute() );
		System.out.println( "taro:" + men.calc() );
	}
}
