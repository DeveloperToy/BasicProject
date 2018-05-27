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
		CabaretClubLady( 40, 1, 0.05f, 2500 ),
		GarlsBar( 30, 2, 0.025f, 2000 ),
		DeliveryHealtLady( 35, 100, 0.1f, 10000 ),
		SE( 65, 2, 0.002f, 2500 ),
		OTHER( 50, 2, 0.001f, 1500 );

		// 年齢上限
		private int maxAge;
		// 昇給対象勤続年数
		private int baseOfPayRise;
		// 昇給率
		private float rateOfPayRise;
		// 基本時給
		private int baseOfWage;

		private WorkCategory(int maxAge, int baseOfPayRise, float rateOfPayRise, int baseOfWage)
		{
			this.maxAge = maxAge;
			this.baseOfPayRise = baseOfPayRise;
			this.rateOfPayRise = rateOfPayRise;
			this.baseOfWage = baseOfWage;
		}

		public int getMaxAge()
		{
			return maxAge;
		}

		public int getBaseOfPayRise()
		{
			return baseOfPayRise;
		}

		public float getRateOfPayRise()
		{
			return rateOfPayRise;
		}

		public int getBaseOfWage()
		{
			return baseOfWage;
		}

	}
}
