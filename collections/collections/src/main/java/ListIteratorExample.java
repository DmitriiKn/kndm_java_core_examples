import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * For add an element to List on iteration should use
 * ListIterator<T> and it's method add(T)
 */
public class ListIteratorExample {
    public static void main(String[] args) {
        mainLogic();
    }

    private static List<String> getData(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("1.5");
        list.add("2");
        list.add("2.5");
        return list;
    }

    private static void mainLogic() {
        List<String> list = getData();
        System.out.println("before: " + list);
        ListIterator<String> iterator = list.listIterator();
        while (iterator.hasNext()){
            String str = iterator.next();
            if (str.equals("2")){
                iterator.add("3");
            }
        }
        System.out.println("after: " + list);

    }
}
