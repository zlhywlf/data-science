package zlhywlf.base.demo;

import java.util.function.Function;

/**
 * @author zlhywlf
 */
public interface IFacade<T, R> extends Function<T, R> {
    String description();
}
