package hust.soict.ict.aims.store;

import java.util.ArrayList;

import hust.soict.ict.aims.media.Media;

public class Store {
    public static final int MAX_ITEMS = 100;
    private ArrayList<Media> itemsInStore = new ArrayList<>();


    public void addMedia(Media media) throws IllegalArgumentException, RuntimeException {
        if (media == null) {
            throw new IllegalArgumentException("Media cannot be null");
        }
        if (itemsInStore.size() >= MAX_ITEMS) {
            throw new RuntimeException("Store is full (max " + MAX_ITEMS + " items). Cannot add more media.");
        }
        if (itemsInStore.contains(media)) {
            throw new IllegalArgumentException("Media already exists in store: " + media.getTitle());
        }
        itemsInStore.add(media);
        System.out.println("The media \"" + media.getTitle() + "\" has been added to the store.");
    }


    public void removeMedia(Media media) throws IllegalArgumentException {
        if (media == null) {
            throw new IllegalArgumentException("Media cannot be null");
        }
        if (!itemsInStore.contains(media)) {
            throw new IllegalArgumentException("The media \"" + media.getTitle() + "\" is not found in the store.");
        }
        itemsInStore.remove(media);
        System.out.println("The media \"" + media.getTitle() + "\" has been removed from the store.");
    }


    public void printStore() {
        System.out.println("***********************STORE***********************");
        int i = 1;
        for (Media m : itemsInStore) {
            System.out.println((i++) + ". " + m.toString());
        }
        System.out.println("***************************************************");
    }


    public Media searchMediaByTitle(String title) {
        for (Media m : itemsInStore) {
            if (m.getTitle().equals(title)) {
                return m;
            }
        }
        return null;
    }

    public ArrayList<Media> getItemsInStore() {
        return new ArrayList<>(itemsInStore);
    }
}