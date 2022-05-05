package zlhywlf.base.demo.check;

/**
 * @author zlhywlf
 */
public interface ICheckChain<T> {
    void setNext(ICheckChain<T> next);

    boolean handle(T data);
}
