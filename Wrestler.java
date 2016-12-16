public class Wrestler 
{
    private String name;
    private  int weight;


    /**
     * Constructor for objects of class Wrestler
     */
    public Wrestler( String theName, int theWeight)
        
    {
        name= theName;
        weight=theWeight;
    }
    
    public int getWeight()
    {
        // put your code here
        return weight;
    }
    
    public String getName()
    {
        // put your code here
        return name;
    }
    public String toString()
    {
        // put your code here
        return name + "  " +weight;
    }


	public boolean equals(Wrestler o)
	{
		return weight == o.getWeight() && name.equals(o.getName());
	}
    
     
    }