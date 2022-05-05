package zlhywlf.base.demo.check;

import org.springframework.stereotype.Component;
import zlhywlf.base.demo.model.CalData;

/**
 * @author zlhywlf
 */
@Component
public class CheckDemo02 implements ICheckChain<CalData> {
    private ICheckChain<CalData> next;


    @Override
    public void setNext(ICheckChain<CalData> next) {
        this.next = next;
    }

    @Override
    public boolean handle(CalData data) {
        System.out.println("数据检查CheckDemo02");
        boolean b = data.getValue() <200;
        if (b) {
            if (next != null) {
                return next.handle(data);
            }
            return true;
        }
        return false;
    }
}
