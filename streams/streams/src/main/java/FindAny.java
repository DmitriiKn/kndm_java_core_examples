import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 * Optional for null value returns NPE in fina
 */
public class FindAny {

    public static void main(String[] args) {
        mainLogic();
    }

    @AllArgsConstructor
    @Getter
    private static class Contact {
        private String number;
        private String name;
    }

    private static List<Contact> getData(){
        List<Contact> list = new ArrayList<>();
        list.add(new Contact(null, "Nikolay"));
        list.add(new Contact("12334", null));
        return list;
    }

    private static void mainLogic() {
        String name = getData().stream()
                //.filter(c -> c.getNumber().equals("12334")) -> NPE
                .filter(c -> "12334".equals(c.getNumber()))
                //.map(Contact::getName).findAny() -> NPE on Optional<null>
                .map(Contact::getName).map(Optional::ofNullable).findAny()
                .flatMap(Function.identity()).orElse("Vasia");
        System.out.println(name);
    }
}
