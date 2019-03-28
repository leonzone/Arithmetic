package arithmetic.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: reiserx
 * Date:2019/3/28
 * Des: 全排列
 */
public class FullyArranged {

    public void f(List<Integer> items, String itemStr) {
        if (items.size() == 1) {
            System.out.println(itemStr + items.get(0));
            return;
        }
        for (int i = 0; i < items.size(); i++) {
            List<Integer> tmpItem = new ArrayList<>();

            for (int j = 0; j < items.size(); j++) {
                if (i != j) {
                    tmpItem.add(items.get(j));
                }
            }
            f(tmpItem, itemStr+items.get(i) + "-->");
        }

    }


    public static void main(String[] args) {
        FullyArranged arranged = new FullyArranged();
        List<Integer> items = new ArrayList<>();
        items.add(1);
        items.add(2);
        items.add(3);
        items.add(4);
        items.add(5);
        arranged.f(items, "");
    }
}
