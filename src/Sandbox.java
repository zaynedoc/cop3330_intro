public class Sandbox {
    public static void main(String[] args) {
        String str = "World";
        int x = " Hello ".length();
        int y = str.length();

        System.out.println( x + y + "".length() + " ".length() );

        int count = 0;
        String[] words = {"Hello", "World"};

        for(int i = 0; i < words.length; i++)
            if( words[i] == null && words[i].length() > 1 )
                count++;

        System.out.println(count);
    }
}
