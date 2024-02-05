import dk.roninit.Book;
import dk.roninit.ItemElement;
import dk.roninit.ShoppingCartVisitor;
import dk.roninit.ShoppingCartVisitorImpl;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ItemElement[] items = new ItemElement[]{new Book(20, "1234"),new Book(100, "5678")};
        int total = calculatePrice(items);
        System.out.println("Total Cost = "+total);

    }


    private static int calculatePrice(ItemElement[] items) {
        ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
        int sum=0;
        for(ItemElement item : items){
            sum = sum + item.accept(visitor);
        }
        return sum;
    }
}
