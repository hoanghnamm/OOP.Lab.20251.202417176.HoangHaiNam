package hust.soict.ict.aims.test;

import hust.soict.ict.aims.media.CompactDisc;
import hust.soict.ict.aims.media.DigitalVideoDisc;


public class MediaEqualsTest {
    
    public static void main(String[] args) {
        System.out.println("====== Media equals() Test Suite ======\n");
     
        testSameObjectReference();
        
      
        testEqualTitles();
        
     
        testDifferentTitles();
        
     
        testNullComparison();
        
      
        testDifferentMediaTypesSameTitle();
        
        
        testNullTitles();
     
        testDifferentType();
        
        
        testCaseSensitivity();
        
        System.out.println("\n====== Test Suite Complete ======");
    }
    
    private static void testSameObjectReference() {
        System.out.println("\n--- Test 1: Same Object Reference ---");
        DigitalVideoDisc dvd = new DigitalVideoDisc("Inception", "Thriller", 22.99f, 148, "Christopher Nolan");
        
        System.out.println("DVD1: " + dvd.getTitle());
        System.out.println("DVD1.equals(DVD1): " + dvd.equals(dvd));
        if (dvd.equals(dvd)) {
            System.out.println("✓ PASS: Object is equal to itself\n");
        } else {
            System.out.println("✗ FAIL: Object should be equal to itself\n");
        }
    }
    

    private static void testEqualTitles() {
        System.out.println("\n--- Test 2: Equal Titles (Different Objects) ---");
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Matrix", "Sci-Fi", 19.99f, 136, "Wachowski");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("The Matrix", "Action", 15.99f, 136, "Wachowski");
        
        System.out.println("DVD1: " + dvd1.getTitle() + " (ID: " + dvd1.getId() + ")");
        System.out.println("DVD2: " + dvd2.getTitle() + " (ID: " + dvd2.getId() + ")");
        System.out.println("DVD1.equals(DVD2): " + dvd1.equals(dvd2));
        if (dvd1.equals(dvd2)) {
            System.out.println("✓ PASS: Same titles are equal\n");
        } else {
            System.out.println("✗ FAIL: Same titles should be equal\n");
        }
    }
   
    private static void testDifferentTitles() {
        System.out.println("\n--- Test 3: Different Titles ---");
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Avatar", "Sci-Fi", 24.99f, 162, "James Cameron");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Titanic", "Drama", 19.99f, 194, "James Cameron");
        
        System.out.println("DVD1: " + dvd1.getTitle() + " (ID: " + dvd1.getId() + ")");
        System.out.println("DVD2: " + dvd2.getTitle() + " (ID: " + dvd2.getId() + ")");
        System.out.println("DVD1.equals(DVD2): " + dvd1.equals(dvd2));
        if (!dvd1.equals(dvd2)) {
            System.out.println("✓ PASS: Different titles are not equal\n");
        } else {
            System.out.println("✗ FAIL: Different titles should not be equal\n");
        }
    }
    

    private static void testNullComparison() {
        System.out.println("\n--- Test 4: Compare with null (NullPointerException Prevention) ---");
        DigitalVideoDisc dvd = new DigitalVideoDisc("Inception", "Thriller", 22.99f, 148, "Christopher Nolan");
        
        System.out.println("DVD: " + dvd.getTitle());
        System.out.println("DVD.equals(null): " + dvd.equals(null));
        if (!dvd.equals(null)) {
            System.out.println("✓ PASS: Media is not equal to null (no NullPointerException)\n");
        } else {
            System.out.println("✗ FAIL: Media should not be equal to null\n");
        }
    }

    private static void testDifferentMediaTypesSameTitle() {
        System.out.println("\n--- Test 5: Different Media Types with Same Title ---");
        DigitalVideoDisc dvd = new DigitalVideoDisc("Imagine: John Lennon", "Documentary", 14.99f, 104, "Andrew Solt");
        CompactDisc cd = new CompactDisc("Imagine: John Lennon", "Music", "John Lennon", 12.99f);
        
        System.out.println("DVD: " + dvd.getTitle() + " (Type: " + dvd.getClass().getSimpleName() + ")");
        System.out.println("CD: " + cd.getTitle() + " (Type: " + cd.getClass().getSimpleName() + ")");
        System.out.println("DVD.equals(CD): " + dvd.equals(cd));
        if (dvd.equals(cd)) {
            System.out.println("✓ PASS: Same title means equal regardless of type\n");
        } else {
            System.out.println("✗ FAIL: Same title should mean equal\n");
        }
    }

    private static void testNullTitles() {
        System.out.println("\n--- Test 6: Both with null Titles ---");
        DigitalVideoDisc dvd1 = new DigitalVideoDisc();
        DigitalVideoDisc dvd2 = new DigitalVideoDisc();
        
        System.out.println("DVD1 Title: " + dvd1.getTitle());
        System.out.println("DVD2 Title: " + dvd2.getTitle());
        System.out.println("DVD1.equals(DVD2): " + dvd1.equals(dvd2));
        if (dvd1.equals(dvd2)) {
            System.out.println("✓ PASS: Both null titles are equal\n");
        } else {
            System.out.println("✗ FAIL: Both null titles should be equal\n");
        }
    }
    

    private static void testDifferentType() {
        System.out.println("\n--- Test 7: Compare with Different Type (instanceof check) ---");
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", 19.95f, 88, "Roger Allers");
        String str = "The Lion King";
        
        System.out.println("DVD: " + dvd.getTitle());
        System.out.println("String: " + str);
        System.out.println("DVD.equals(String): " + dvd.equals(str));
        if (!dvd.equals(str)) {
            System.out.println("✓ PASS: Media is not equal to String type (instanceof works)\n");
        } else {
            System.out.println("✗ FAIL: Media should not equal String\n");
        }
    }
    
   
    private static void testCaseSensitivity() {
        System.out.println("\n--- Test 8: Case Sensitivity ---");
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Matrix", "Sci-Fi", 19.99f, 136, "Wachowski");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("the matrix", "Sci-Fi", 19.99f, 136, "Wachowski");
        
        System.out.println("DVD1: " + dvd1.getTitle());
        System.out.println("DVD2: " + dvd2.getTitle());
        System.out.println("DVD1.equals(DVD2): " + dvd1.equals(dvd2));
        if (!dvd1.equals(dvd2)) {
            System.out.println("✓ PASS: Titles are case-sensitive\n");
        } else {
            System.out.println("✗ FAIL: Titles should be case-sensitive\n");
        }
    }
}
