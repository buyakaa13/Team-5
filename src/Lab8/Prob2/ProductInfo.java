package Lab8.Prob2;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductInfo {
    enum SortMethod {BYPRICE, BYTITLE};
    public void mysort(List<Product> products, SortMethod method) {
        Collections.sort(products, (e1,e2) ->
        {

            if(method == SortMethod.BYTITLE) {
                return e1.getTitle().compareTo(e2.getTitle());
            } else {
                return Double.compare(e1.getPrice(), e2.getPrice());
            }

        });
    }

    public void myModelSort(List<Product> products, SortMethod method) {

        Collections.sort(products, (e1,e2) ->
        {
            if(method == SortMethod.BYTITLE) {
                int titleCompare = e1.getTitle().compareTo(e2.getTitle());
                if (titleCompare != 0) {
                    return titleCompare;
                }
                return Integer.compare(e1.getModel(), e2.getModel());
            } else {
                return Double.compare(e1.getPrice(), e2.getPrice());
            }

        });
    }
}
