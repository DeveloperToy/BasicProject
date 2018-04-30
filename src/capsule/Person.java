package capsule;

public class Person
{
	private String name;
	private String gender;
	private String birthday;

	Person(String name, String gender, String birthday)
	{
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;

		System.out.println( this.getPerson() );
	}

	/**
	 * 各ゲッター
	 * 
	 * @return 名前・性別・誕生日
	 */
	public String getName()
	{
		return this.name;
	}

	public String getGender()
	{
		return this.gender;
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
		return this.name.concat( "：" ).concat( this.gender ).concat( "：" ).concat( this.birthday );
	}
}
