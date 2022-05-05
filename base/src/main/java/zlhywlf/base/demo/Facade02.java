package zlhywlf.base.demo;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import zlhywlf.base.demo.check.ICheckChain;
import zlhywlf.base.demo.com.ComBean;
import zlhywlf.base.demo.com.IComposite;
import zlhywlf.base.demo.model.CalData;
import zlhywlf.base.demo.model.ResData;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Map;

/**
 * @author zlhywlf
 */
@Component
@Lazy
public class Facade02 implements IFacade<CalData, ResData> {
    @Resource(name = ComBean.COM_01)
    private IComposite<CalData, Double> com;
    @Resource
    private Map<String, ICheckChain<CalData>> checkChains;
    private ICheckChain<CalData> checkChain;

    @PostConstruct
    void initCheck() {
        ArrayList<ICheckChain<CalData>> iCheckChainsList = new ArrayList<>(2);
        for (String k : checkChains.keySet()) {
            System.out.println(k);
            iCheckChainsList.add(checkChains.get(k));
        }

        for (int i = 0; i < iCheckChainsList.size(); i++) {
            if (i == 0) {
                checkChain = iCheckChainsList.get(0);
            } else {
                ICheckChain<CalData> current = iCheckChainsList.get(i - 1);
                ICheckChain<CalData> next = iCheckChainsList.get(i);
                current.setNext(next);
            }
        }
    }

    @Override
    public String description() {
        return "计算测试01";
    }

    @Override
    public ResData apply(CalData calData) {
        ResData resData = new ResData("数据格式有误");
        boolean handle = checkChain.handle(calData);
        if (handle) {
            Double apply = com.apply(calData);
            resData = new ResData("计算结果是:" + apply);
        }
        return resData;
    }
}
