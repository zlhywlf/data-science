package zlhywlf.base.demo.cal;

import org.springframework.stereotype.Component;
import zlhywlf.base.demo.model.CalData;

/**
 * @author zlhywlf
 */
@Component(CalBean.CAL_C)
public class CalStrategyByC implements ICalStrategy<CalData, Double> {
    @Override
    public Double apply(CalData calData) {
        System.out.println("====================CalStrategyByC====================");
        System.out.println(calData);
        return calData.getValue() * 2;
    }

    @Override
    public String getDescription() {
        return "CalStrategyByC";
    }
}
