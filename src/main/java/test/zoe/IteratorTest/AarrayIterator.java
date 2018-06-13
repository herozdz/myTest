package test.zoe.IteratorTest;

/**
 * Created with IntelliJ IDEA.
 * User: zoudezhu
 * Date: 2018/2/23
 * Time: 14:41
 * To change this template use File | Settings | File Templates.
 */
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * 演示Iterator和Iterable接口，并说明怎样编写一个用于对象数组的简单迭代器。
 */
public class AarrayIterator<T> implements Iterable<T>, Iterator<T> {
    private final static String[] names = {"rose", "petunia", "tulip"};
    public static void main(String[] args) {
        AarrayIterator<String> arrayIterator = new AarrayIterator<String>(names);
        // Java 5,6的方式
        for (String s : arrayIterator) {
            System.out.println(s);
        }
        // Java 8的形式
        //arrayIterator.forEach(System.out::println);
    }
    /**
     * 要遍历的数据
     **/
    protected T[] data;
    protected int index = 0;
    /**
     * 构造一个AarryIterator对象。
     *
     * @param data 被迭代的对象数组
     */
    public AarrayIterator(final T[] data) {
        setData(data);
    }
    /**
     * 设置（重置）数组为给定的数组，重置迭代器。
     * 参数d代表被迭代的数组对象。
     *
     * @param d 被迭代的数组对象
     */
    public void setData(final T[] d) {
        this.data = d;
        index = 0;
    }
    /**
     * 如果不是末尾，返回true，例如，if next()语句将成功执行。
     * 否则返回false,执行if next()语句会抛出异常。
     *
     * @return
     */
    public boolean hasNext() {
        return index < data.length;
    }
    /**
     * 返回该数据的下一个元素
     *
     * @return
     */
    public T next() {
        if (hasNext()) {
            return data[index++];
        }
        throw new NoSuchElementException("only " + data.length + " elements");
    }
    public void remove() {
        throw new UnsupportedOperationException("This demo Iterator does not implement the remove method");
    }
    /**
     * Iterator的方法
     *
     * @return
     */
    public Iterator<T> iterator() {
        index = 0;
        return this;
    }
}
