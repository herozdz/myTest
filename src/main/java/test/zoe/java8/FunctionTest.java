package test.zoe.java8;

import java.util.function.Function;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 2019/2/21
 * Time: 15:20
 * To change this template use File | Settings | File Templates.
 */
public class FunctionTest {
    public static void main(String[] args) {
        double a = 0.06;
        double b = 0.11;
        double c = 0;
        double d = a + b + c;
        System.out.println("d-->"+d);
    }
    public void test()
    { Function<Integer,Integer> A= i->i+1;
        Function<Integer,Integer> B=i->i*i;
        System.out.println("F1:"+B.apply(A.apply(5)));
        System.out.println("F1:"+B.compose(A).apply(5));
        System.out.println("F2:"+A.apply(B.apply(5)));
        System.out.println("F2:"+B.andThen(A).apply(5)); }
/** F1:36 *//** F1:36 *//** F2:26 *//** F2:26 */

    public void test1(){
        Function<Integer,Integer> test1=i->i+1;
        Function<Integer,Integer> test2=i->i*i;
        System.out.println(calculate(test1,5));
        System.out.println(calculate(test2,5)); }

        public static Integer calculate(Function<Integer,Integer> test,Integer number){
            return test.apply(number);
        }
}