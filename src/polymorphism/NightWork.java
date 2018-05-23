package polymorphism;

public abstract class NightWork implements Worker
{
	/** 年齢制限 */
	private static final int MIN_AGE = 18;
	/** 性別 */
	private static final String WOMEN = "WOMEN";

	/**
	 * 年齢チェック.<br>
	 * 
	 * @param age
	 *            年齢
	 */
	protected void checkAge( int age )
	{
		if (MIN_AGE > age) {
			System.out.println( "年齢制限で働けません。" );
		}
	}

	/**
	 * 性別チェック.<br>
	 * 
	 * @param gender
	 *            性別
	 */
	protected void checkGender( String gender )
	{
		if (!WOMEN.equals( gender )) {
			System.out.println( "性別が異なります。" );
		}
	}
}
