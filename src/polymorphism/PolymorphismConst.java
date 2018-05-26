package polymorphism;

public class PolymorphismConst
{
	/** 性別. */
	public enum Gender
	{
		MENS, WOMEN;
	}

	/** 条件. */
	public enum Conditions
	{
		/** 資格. */
		QUALIFICATION,
		/** 年齢. */
		AGE,
		/** 年齢. */
		GENDER;
	}

	/** 職業. */
	public enum WorkCategory
	{
		CabaretClubLady, GarlsBar, DeliveryHealtLady, SE, OTHER;
	}
}
