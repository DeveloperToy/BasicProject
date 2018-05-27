package polymorphism;

import capsule.Person;
import polymorphism.PolymorphismConst.Conditions;
import polymorphism.PolymorphismConst.Gender;

public abstract class NightWork implements Worker
{
	/** 年齢制限(下限). */
	private static final int MIN_AGE = 18;

	/**
	 * 条件チェック.<br>
	 * コンストラクタを作成する時点でチェックする ※チェック自体使う側が意識しなくていいようにする
	 * 
	 * @param conditions 条件
	 * @return true：チェックOK/false：チェックNG
	 */
	// @Override
	public static final boolean checkPrecondition( Person p, int maxAge )
	{
		return checkConditions( p, maxAge );
	}

	/**
	 * ナイトワークとしての必須条件をチェックする.<br>
	 * 
	 * @param conditions 必須条件
	 * @return true：チェックOK/false：チェックNG
	 */
	private static boolean checkConditions( Person p, int maxAge )
	{
		boolean flg = true;
		flg = checkAge( p.getAge(), maxAge );
		if (!flg) {
			return false;
		}

		flg = checkGender( p.getGender() );
		return flg;
	}

	/**
	 * 年齢チェック.<br>
	 * 
	 * @param age 年齢
	 * @return true：チェックOK/false：チェックNG
	 */
	private static boolean checkAge( int age, int maxAge )
	{
		if (MIN_AGE > age || maxAge < age) {
			System.out.println( "年齢制限で働けません。" );
			return false;
		}
		return true;
	}

	/**
	 * 性別チェック.<br>
	 * 
	 * @param gender 性別
	 * @return true：チェックOK/false：チェックNG
	 */
	private static boolean checkGender( Gender gender )
	{
		if (!Gender.WOMEN.equals( gender )) {
			System.out.println( "性別が異なります。" );
			return false;
		}
		return true;
	}
}
