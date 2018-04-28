package capsule;

public class Man
{
	private int age;
	private String attribute;

	Man(int age)
	{
		this.age = age;

		this.attribute = ageAttribute();
	}

	/**
	 * ゲッター.
	 * 
	 * @return カテゴリー
	 */
	public String getAttribute()
	{
		return this.attribute;
	}

	/**
	 * 年齢でカテゴリーを設定する。. ※女性の場合、下3桁で実年齢を表すようにする。.
	 * 
	 * @return カテゴリー
	 */
	private String ageAttribute()
	{
		if (1000 <= this.age) {
			return "wormen";
		}

		if (65 <= this.age) {
			return "older";
		}

		return "man";
	}
}
