import java.util.*;
public class Days{
    boolean leap;
    void checkLeapYear(int year)
    {
        if((year%4==0 && year%100!=0) || (year%400==0))
            leap=true;
        else
            leap=false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter year: ");
        int year = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter month (number or name): ");
        String monthInput = sc.nextLine().trim().toLowerCase();

        int month = -1;
        switch(monthInput) {
            case "1": case "jan": case "january": month = 1; break;
            case "2": case "feb": case "february": month = 2; break;
            case "3": case "mar": case "march": month = 3; break;
            case "4": case "apr": case "april": month = 4; break;
            case "5": case "may": month = 5; break;
            case "6": case "jun": case "june": month = 6; break;
            case "7": case "jul": case "july": month = 7; break;
            case "8": case "aug": case "august": month = 8; break;
            case "9": case "sep": case "september": month = 9; break;
            case "10": case "oct": case "october": month = 10; break;
            case "11": case "nov": case "november": month = 11; break;
            case "12": case "dec": case "december": month = 12; break;
            default:
                System.out.println("Invalid month.");
                return;
        }

        Days d = new Days();
        d.checkLeapYear(year);

        int days;
        switch(month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                days = 31;
                break;
            case 4: case 6: case 9: case 11:
                days = 30;
                break;
            case 2:
                days = d.leap ? 29 : 28;
                break;
            default:
                System.out.println("Invalid month.");
                return;
        }
        System.out.println("Number of days: " + days);
    }
}