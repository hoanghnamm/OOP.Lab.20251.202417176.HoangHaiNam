
public class DigitalVideoDisc
{
    private static int nbDigitalVideoDisc = 0;

    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    private int id;

    public DigitalVideoDisc(String title, String category, String director, int length,float cost)
    {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;

        nbDigitalVideoDisc++;
        this.id = nbDigitalVideoDisc;
    }
    public DigitalVideoDisc(String category)
    {
        super();
        this.category=category;
    }

public void setTitle(String title)
{
    this.title = title;
}
public void setCategory(String category)
{
    this.category= category;
}
public void setDirector(String director)
{
    this.director = director;
}
public void setLength(int length)
{
    this.length = length;

}
public void setCost(float cost)
{
    this.cost = cost;
}
    
public String getTitle()
{
    return title;
}
public String getCategory()
{
    return category;
}
public String getDirector()
{
    return director;
}
public int length()
{
    return length;
}
public float getCost()
{
    return cost;
}
public int getId()
{
    return id;
}

}