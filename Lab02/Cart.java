import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cart {

    public static final int MAX_NUMBERS_ORDERED = 20;
    List<DigitalVideoDisc> itemsOrdered = new ArrayList<>();
    private int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc a) {
        if (MAX_NUMBERS_ORDERED - qtyOrdered < 3 && MAX_NUMBERS_ORDERED-qtyOrdered>0) {
            int b = MAX_NUMBERS_ORDERED - qtyOrdered;
            System.out.println("The cart is almost full, there are " + b + " slots left.");
        }
        if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full!!!");
        }
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(a);
            qtyOrdered++;
            System.out.println("The disc has been added.");
            System.out.println("Cost: " + totalCost());
        }
    }

    public float totalCost() {
        float sum = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            sum += itemsOrdered.get(i).getCost();
        }
        return sum;
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc a) {
        if (qtyOrdered <= 0) {
            System.out.println("Cannot remove.");
        }
        if (qtyOrdered > 0) {
            itemsOrdered.remove(a);
            System.out.println("Successfully removed!!!");
        }
    }
    public void printCart()
    {
        System.out.println("***********************CART*********************** ");
        System.out.println("Ordered Items:");
        for(int i = 0; i<qtyOrdered; i++)
        {
            System.out.println((i+1)+". "+ itemsOrdered.get(i).getTitle()+ "-"+ itemsOrdered.get(i).getDirector()+"-"+ itemsOrdered.get(i).getCategory()+"-"+ itemsOrdered.get(i).length()+" mins- "+ itemsOrdered.get(i).getCost()+"$");
        }
        System.out.println("Total cost: "+ totalCost()+"$");
    }
    public void searchCart()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the id of the book you want to search: ");
        int a = sc.nextInt();
        int check = 0;
        for(int i =0; i<qtyOrdered ; i++)
        {
            if(itemsOrdered.get(i).getId()== a)
            {
                System.out.println("We have found your book:");
                System.out.println( itemsOrdered.get(i).getTitle()+ "-"+ itemsOrdered.get(i).getDirector()+"-"+ itemsOrdered.get(i).getCategory()+"-"+ itemsOrdered.get(i).length()+" mins- "+ itemsOrdered.get(i).getCost()+"$");
                check = 1;
                break;
            }
        }
        if(check ==0)
        {
            System.out.println("We cannot find the book.");
        }
        sc.close();
    }

}