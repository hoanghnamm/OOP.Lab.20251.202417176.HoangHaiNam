public class TestPassingParameter
{
    public static void main(String[] args)
    {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
        DigitalVideoDisc [] arr ={ jungleDVD, cinderellaDVD};
        swap(arr);
        System.out.println("jungle dvd title: " + arr[0].getTitle());
        System.out.println("cinderella dvd title: "+ arr[1].getTitle());
        changeTitle( jungleDVD, cinderellaDVD.getTitle());
       System.out.println("jungle dvd title: "+ jungleDVD.getTitle());
    }
   public static void swap(DigitalVideoDisc[] arr)
   {
    DigitalVideoDisc tmp = arr[0];
    arr[0] = arr[1];
    arr[1] = tmp;

   }
    public static void changeTitle(DigitalVideoDisc dvd, String title)
    {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }
}