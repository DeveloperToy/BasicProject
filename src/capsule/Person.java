package capsule;

public class Person
{
	private String name;
	private int age;
	private String birthday;

	Person(String name, int age, String birthday)
	{
		this.name = name;
		this.age = age;
		this.birthday = birthday;

		System.out.println( this.getPerson() );
	}

	/**
	 * 各ゲッター
	 * 
	 * @return 名前・年齢・誕生日
	 */
	public String getName()
	{
		return this.name;
	}

	public int getAge()
	{
		return this.age;
	}

	public String getBirthday()
	{
		return this.birthday;
	}

	/**
	 * 個人情報取得.
	 * 
	 * @return 個人情報
	 */
	private String getPerson()
	{
		return this.name.concat( "：" ).concat( String.valueOf( this.age ) ).concat( "：" ).concat( this.birthday );
	}
}
