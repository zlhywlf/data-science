package zlhywlf.base.demo.com;

import org.springframework.stereotype.Component;
import zlhywlf.base.demo.model.CalData;
import zlhywlf.base.demo.cal.ICalStrategy;
import zlhywlf.base.demo.com.conf.CalConf;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author zlhywlf
 */
@Component(ComBean.COM_02)
public class Composite02 implements IComposite<CalData, Double> {
    @Resource
    private Map<String, ICalStrategy<CalData, Double>> map;


    @Override
    public Double apply(CalData calData) {
        System.out.println("Composite02: ====================apply01 * apply02====================");
        // 叶子节点直接计算
        Double apply01 = map.get(CalConf.CAL_BY_JAVA).apply(calData);
        Double apply02 = map.get(CalConf.CAL_BY_JAVA).apply(calData);
        return apply01 * apply02;
    }

}
