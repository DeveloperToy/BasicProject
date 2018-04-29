package capsule;

import capsule.CapsuleConst.FormatOfDay;

public class Main
{
	public static void main( String[] args )
	{
		Person ataro = new Person( "AAA", 5, "2000/01/01 17:00:12" );
		Person btaro = new Person( "BBB", 65, "2005-05-01 12:30:45" );
		Person ctaro = new Person( "CCC", 20, "2015_10_01 20:55:20" );

		Capsule chargeOfAtaro = new Capsule( ataro.getAge() );
		System.out.println( "ataro:" + chargeOfAtaro.getCharge() );

		Capsule chargeOfBtaro = new Capsule( btaro.getAge() );
		System.out.println( "btaro:" + chargeOfBtaro.getCharge() );

		Capsule chargeOfCtaro = new Capsule( ctaro.getAge() );
		System.out.println( "ctaro:" + chargeOfCtaro.getCharge() );

		Capsule2 changeOfFormat = new Capsule2( FormatOfDay.NORMAL );
		System.out.println( "ataro:" + changeOfFormat.changeFormat( ataro.getBirthday() ) );

		changeOfFormat = new Capsule2( FormatOfDay.LINE_SEPARATION );
		System.out.println( "btaro:" + changeOfFormat.changeFormat( btaro.getBirthday() ) );

		changeOfFormat = new Capsule2( FormatOfDay.UNDERBAR_SEPARATION );
		System.out.println( "ctaro:" + changeOfFormat.changeFormat( ctaro.getBirthday() ) );
	}
}
