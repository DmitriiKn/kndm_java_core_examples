public class NewSwitch {

    public static void main(String[] args) {
        mainLogic();
    }

    private static void mainLogic(){
        System.out.println(showTypeAndValueBySwitch("Котик"));
        System.out.println(showTypeAndValueBySwitch(10));
        System.out.println(showTypeAndValueBySwitch(new Object()));
        System.out.println(showTypeAndValueBySwitch(null));
    }

    private static String showTypeAndValueBySwitch(Object o) {
        switch (o){
            case null -> { return "may be NPE";}
            case String s -> { return "type: string, value: " + s; }
            case Integer i -> { return "type: integer, value: " + i; }
            default -> { return "type: unknown, value: " + o; }
        }
    }
}
