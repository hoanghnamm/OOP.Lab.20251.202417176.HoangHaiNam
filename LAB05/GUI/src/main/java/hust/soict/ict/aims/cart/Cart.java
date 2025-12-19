package hust.soict.ict.aims.cart;

import hust.soict.ict.aims.media.Media;
import java.util.ArrayList;

public class Cart {

    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media media) throws IllegalArgumentException {
        if (media == null) {
            throw new IllegalArgumentException("Media cannot be null");
        }
        if (itemsOrdered.contains(media)) {
            throw new IllegalArgumentException("Media already in cart: " + media.getTitle());
        }
        itemsOrdered.add(media);
        System.out.println("Added: " + media.getTitle());
    }

    public void removeMedia(Media media) throws IllegalArgumentException {
        if (media == null) {
            throw new IllegalArgumentException("Media cannot be null");
        }
        if (!itemsOrdered.contains(media)) {
            throw new IllegalArgumentException("Media not found in cart: " + media.getTitle());
        }
        itemsOrdered.remove(media);
        System.out.println("Removed: " + media.getTitle());
    }

    public float totalCost() {
        float total = 0;
        for (Media m : itemsOrdered) {
            total += m.getCost();
        }
        return total;
    }

    public void showCart() {
        System.out.println("===== Cart Items =====");
        for (Media m : itemsOrdered) {
            System.out.println(m.getTitle() + " - " + m.getCost());
        }
        System.out.println("Total cost: " + totalCost());
    }

    public void sortByTitleThenCost() {
        java.util.Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Sorted by Title (A-Z), then by Cost (descending)");
    }

   
    public void sortByCostThenTitle() {
        java.util.Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Sorted by Cost (descending), then by Title (A-Z)");
    }

   
    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        float total = 0;
        int i = 1;
        for (Media m : itemsOrdered) {
            System.out.println(i + ". " + m.toString());
            total += m.getCost();
            i++;
        }
        System.out.println("Total cost: " + total + " $");
        System.out.println("***************************************************");
    }
    public Media searchByTitle(String title) {
        for (Media m : itemsOrdered) {
            if (m.getTitle().equals(title)) {
                return m;
            }
        }
        return null;
    }

    public Media searchById(int id) {
        for (Media m : itemsOrdered) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }

 
    public int getQuantity() {
        return itemsOrdered.size();
    }

   
    public void emptyCart() {
        itemsOrdered.clear();
    }

    public ArrayList<Media> getItemsOrdered() {
        return new ArrayList<>(itemsOrdered);
    }
}