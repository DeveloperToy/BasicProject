package polymorphism;

import polymorphism.PolymorphismConst.Conditions;
import polymorphism.PolymorphismConst.Gender;

public abstract class NightWork implements Worker
{
	/**
	 * 共通フィールド.
	 */
	/** 年齢. */
	 protected int age;
	/** 性別. */
	 protected Gender gender;

	/**
	 * 固定値.
	 */
	/** 年齢制限(下限). */
	private static final int MIN_AGE = 18;

	/**
	 * 職業別フィールド.
	 */
	/** 年齢制限(上限). */
	protected int MAX_AGE;
	/** 基本給. */
	protected int BASE_OF_WAGE;
	/** 昇給基準. */
	protected int BASE_OF_PAY_RISE;
	/** 昇給率. */
	protected float RATE_OF_PAY_RISE;

	/**
	 * コンストラクタ.<br>
	 * @param age 年齢
	 * @param gender 性別
	 */
	protected NightWork(int age, Gender gender)
	{
		this.age = age;
		this.gender = gender;
	}
	
	/**
	 * 条件チェック.<br>
	 * @param conditions 条件
	 * @return true：OK/false：NG
	 */
	@Override
	public boolean checkPrecondition( Conditions... conditions )
	{
		boolean flg = true;
		for (Conditions c : conditions) {
			if (Conditions.AGE.equals( c )) {
				flg = checkAge( age );
				if (!flg) {
					return flg;
				}
			}
			if (Conditions.GENDER.equals( c )) {
				flg = checkGender( gender );
			}
		}
		return flg;
	}

	/**
	 * 年齢チェック.<br>
	 * 
	 * @param age 年齢
	 * @return true：チェックOK/false：チェックNG
	 */
	private boolean checkAge( int age )
	{
		if (MIN_AGE > age || MAX_AGE < age) {
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
	private boolean checkGender( Gender gender )
	{
		if (!Gender.WOMEN.equals( gender )) {
			System.out.println( "性別が異なります。" );
			return false;
		}
		return true;
	}
}
