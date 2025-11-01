import java.util.ArrayList;
import java.util.List;

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

    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        if (qtyOrdered + dvdList.length < MAX_NUMBERS_ORDERED) {
            for (int i = 0; i < dvdList.length; i++) {
                itemsOrdered.add(dvdList[i]);
            }
            qtyOrdered++;
            System.out.println( dvdList.length + " discs have been added successfully");
            System.out.println("Total cost: " + totalCost());
        }
        if (qtyOrdered + dvdList.length > MAX_NUMBERS_ORDERED) {
            if (qtyOrdered > MAX_NUMBERS_ORDERED) {
                System.out.println("The cart is full!!!");
            } 
            else 
            {
                System.out.println("Can only add" + (MAX_NUMBERS_ORDERED-qtyOrdered) + " dvds more.");
                for (int i = 0; i < dvdList.length; i++) {
                    itemsOrdered.add(dvdList[i]);
                }
                qtyOrdered++;
                System.out.println("The discs have been added");
                System.out.println("Total cost: " + totalCost());
            }
        }
    }
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2)
    {
        if(qtyOrdered >=MAX_NUMBERS_ORDERED)
        {
            System.out.println("The cart is full!!!");
        }
        if(qtyOrdered +2 <=MAX_NUMBERS_ORDERED)
        {
            itemsOrdered.add(dvd1);
            itemsOrdered.add(dvd2);
            qtyOrdered= qtyOrdered+2;
            System.out.println("2 discs have been added successfully");
            System.out.println("Cost: " + totalCost());
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
}