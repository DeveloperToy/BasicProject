package polymorphism;

import polymorphism.PolymorphismConst.Conditions;

/**
 * 職業フォーマット.<br>
 * 
 * @author ykd
 */
public interface Worker
{
	// 仕事内容
	void work();

	// 条件・資格
	boolean checkPrecondition( Conditions... conditions );

	// 給料
	void salary( int... period );
}
