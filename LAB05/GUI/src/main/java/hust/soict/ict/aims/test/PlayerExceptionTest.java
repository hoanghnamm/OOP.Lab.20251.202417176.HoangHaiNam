package hust.soict.ict.aims.test;

import hust.soict.ict.aims.exception.PlayerException;
import hust.soict.ict.aims.media.CompactDisc;
import hust.soict.ict.aims.media.DigitalVideoDisc;
import hust.soict.ict.aims.media.Track;


public class PlayerExceptionTest {
    
    public static void main(String[] args) {
        System.out.println("====== PlayerException Test Suite ======\n");
        

        testValidDVD();
        

        testInvalidDVD();
        

        testValidCompactDisc();
        

        testInvalidTrackInCompactDisc();
        
       
        testValidTrack();
        
      
        testInvalidTrack();
        
        System.out.println("\n====== Test Suite Complete ======");
    }
    

    private static void testValidDVD() {
        System.out.println("\n--- Test 1: Valid DVD (length > 0) ---");
        DigitalVideoDisc dvd = new DigitalVideoDisc("Inception", "Thriller", 22.99f, 148, "Christopher Nolan");
        try {
            System.out.println("DVD Length: " + dvd.getLength() + " minutes");
            dvd.play();
            System.out.println("✓ DVD played successfully!\n");
        } catch (PlayerException e) {
            System.err.println("✗ Error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    
    private static void testInvalidDVD() {
        System.out.println("\n--- Test 2: Invalid DVD (length = 0) ---");
        DigitalVideoDisc dvd = new DigitalVideoDisc("Broken Movie", "Unknown", 9.99f, 0, "Unknown");
        try {
            System.out.println("DVD Length: " + dvd.getLength() + " minutes");
            dvd.play();
        } catch (PlayerException e) {
            System.err.println("\n=== EXCEPTION CAUGHT ===");
            System.err.println("getMessage(): " + e.getMessage());
            System.err.println("toString(): " + e.toString());
            System.err.println("getClass().getSimpleName(): " + e.getClass().getSimpleName());
            System.err.println("Stack Trace:");
            e.printStackTrace();
            System.err.println("=======================\n");
            System.out.println("✓ Exception properly caught and handled!\n");
        }
    }
    
    private static void testValidCompactDisc() {
        System.out.println("\n--- Test 3: Valid CompactDisc with valid tracks ---");
        CompactDisc cd = new CompactDisc("Abbey Road", "Rock", "The Beatles", 14.99f);
        cd.addTrack(new Track("Come Together", 259));
        cd.addTrack(new Track("Something", 183));
        cd.addTrack(new Track("Here Comes the Sun", 185));
        
        try {
            System.out.println("CD Length: " + cd.getLength() + " seconds");
            cd.play();
            System.out.println("✓ CD played successfully!\n");
        } catch (PlayerException e) {
            System.err.println("✗ Error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private static void testInvalidTrackInCompactDisc() {
        System.out.println("\n--- Test 4: CompactDisc with invalid track (length = 0) ---");
        CompactDisc cd = new CompactDisc("Broken CD", "Unknown", "Unknown Artist", 9.99f);
        cd.addTrack(new Track("Good Track", 180));
        cd.addTrack(new Track("Broken Track", 0));  // Invalid track
        cd.addTrack(new Track("Another Track", 200));
        
        try {
            System.out.println("CD Length: " + cd.getLength() + " seconds");
            cd.play();
        } catch (PlayerException e) {
            System.err.println("\n=== EXCEPTION CAUGHT IN COMPACT DISC ===");
            System.err.println("getMessage(): " + e.getMessage());
            System.err.println("toString(): " + e.toString());
            System.err.println("getClass().getSimpleName(): " + e.getClass().getSimpleName());
            System.err.println("Full Stack Trace:");
            e.printStackTrace();
            System.err.println("========================================\n");
            System.out.println("✓ Exception in CD track properly caught!\n");
        }
    }
    
    private static void testValidTrack() {
        System.out.println("\n--- Test 5: Valid Track (length > 0) ---");
        Track track = new Track("Imagine", 183);
        try {
            System.out.println("Track Length: " + track.getLength() + " seconds");
            track.play();
            System.out.println("✓ Track played successfully!\n");
        } catch (PlayerException e) {
            System.err.println("✗ Error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private static void testInvalidTrack() {
        System.out.println("\n--- Test 6: Invalid Track (length = 0) ---");
        Track track = new Track("Broken Song", 0);
        try {
            System.out.println("Track Length: " + track.getLength() + " seconds");
            track.play();
        } catch (PlayerException e) {
            System.err.println("\n=== EXCEPTION CAUGHT ===");
            System.err.println("getMessage(): " + e.getMessage());
            System.err.println("toString(): " + e.toString());
            System.err.println("getClass().getSimpleName(): " + e.getClass().getSimpleName());
            System.err.println("Stack Trace:");
            e.printStackTrace();
            System.err.println("=======================\n");
            System.out.println("✓ Exception properly caught and handled!\n");
        }
    }
}
