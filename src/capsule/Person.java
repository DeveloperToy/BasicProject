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

	private String getPerson()
	{
		return this.name.concat( "：" ).concat( String.valueOf( this.age ) ).concat( "：" ).concat( this.birthday );
	}
}
