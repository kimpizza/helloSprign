import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        for (int i = 0; i < list.size(); i++) {
            list.remove(i);
            System.out.println(list.size());
        }    updateList(Collections.unmodifiableList(list));

        System.out.println(list);
    }
}
