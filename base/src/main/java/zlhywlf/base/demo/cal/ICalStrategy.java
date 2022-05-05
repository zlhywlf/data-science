package zlhywlf.base.demo.cal;

import java.util.function.Function;

/**
 * 计算策略
 *
 * @author zlhywlf
 */
public interface ICalStrategy<T, R> extends Function<T, R> {
    String getDescription();
}
