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
@Component(ComBean.COM_01)
public class Composite01 implements IComposite<CalData, Double> {
    @Resource
    private Map<String, ICalStrategy<CalData, Double>> map;
    @Resource(name = ComBean.COM_02)
    private IComposite<CalData, Double> com02;


    @Override
    public Double apply(CalData calData) {
        System.out.println("Composite01: ====================apply01 + apply02 + com02====================");
        // 叶子节点直接计算
        System.out.println("Composite01: ====================apply01====================");
        Double apply01 = map.get(CalConf.CAL_BY_C_PLUS).apply(calData);
        System.out.println("Composite01: ====================apply02====================");
        Double apply02 = map.get(CalConf.CAL_BY_C_PLUS).apply(calData);
        // 下一级枝干节点
        System.out.println("Composite01: ====================com02Res====================");
        Double com02Res = com02.apply(calData);
        return apply01 + apply02 + com02Res;
    }

}
