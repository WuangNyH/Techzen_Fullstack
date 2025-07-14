public class test {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("Hello");
        changDate(str);
        System.out.println(str);
    }

    public static void changDate(StringBuilder str){
        str.append("World");
    }
}
