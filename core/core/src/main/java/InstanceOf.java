public class InstanceOf {

    public static void main(String[] args) {
        mainLogic();
    }

    private static void mainLogic(){
        System.out.println(showTypeAndValue("Котик"));
        System.out.println(showTypeAndValueBySwitch("Котик"));
        System.out.println(showTypeAndValueBySwitch(10));
        System.out.println(showTypeAndValueBySwitch(new Object()));
    }

    private static String showTypeAndValue(Object o) {
        if (o instanceof String s) {
            return "type: string, value: " + s;
        }/*....*/
        return  "unknown";
    }

    private static String showTypeAndValueBySwitch(Object o) {
        switch (o){
            case String s -> {return "type: string, value: " + s;}
            case Integer i -> {return "type: integer, value: " + i;}
            default -> {return "type: unknown, value: " + o;}
        }
    }
}
