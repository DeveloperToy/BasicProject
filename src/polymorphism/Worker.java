package polymorphism;

import polymorphism.Category.Conditions;

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
	void precondition( Conditions... conditions1 );

	// 給料
	void salary( int... period );
}
