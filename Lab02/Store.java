import java.util.ArrayList;
public class Store
{
    private ArrayList<DigitalVideoDisc> store = new ArrayList<>();
    
    public void addDVD(DigitalVideoDisc a)
    {
        
        if(store.add(a))
        {
        System.out.println("The disc has been successfully added");
        }
        else
        { 
        System.out.println("Cannot find the disc.");
        }
    }
    public void removeDVD(DigitalVideoDisc a)
    {
        if(store.remove(a))
        {
        System.out.println("The disc has been successfully removed");
        }
        else
        {
        System.out.println("Cannot find the disc.");
        }
    }
}