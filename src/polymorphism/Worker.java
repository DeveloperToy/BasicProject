package polymorphism;

import capsule.Person;
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

	// 給料
	void getSalary( Person p );
}
