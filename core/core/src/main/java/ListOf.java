import java.util.List;
import java.util.stream.Collectors;

public class ListOf {
    public static void main(String[] args) {
        System.out.println(List.of().stream().collect(Collectors.toList()));
    }
}
