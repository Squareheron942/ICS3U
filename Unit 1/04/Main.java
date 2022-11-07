public class Main {
    public static void main(String[] args) {
        String quote = "My name is Walter Hartwell White. I live at 308 Negra Arroyo Lane, Albuquerque, New Mexico";
        System.out.println(quote);
        String[] splitquote = quote.split("\\s+");
        for (int i = 0; i < splitquote.length; i++) {
            System.out.println(splitquote[i]);
        }
    }
}