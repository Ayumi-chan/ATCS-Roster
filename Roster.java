

public class Roster
{
    // pointer to linked list of wrestlers on the roster sorted 
    // by weight (lighest to heaviest)
   
	private ListNode<Wrestler> teamList;


    public Roster()
    {
        teamList=null;
    }


/**
     * precondition: the teamList field is null, or it points to the first node of a linked list
     * the list is sorted according to the weight
     * postcondition:  returns the pointer to the node in the linked list for the wrestler               *whose weight is closest to the given weight without going over.   Returns null if there *are no wrestlers or none whos weight is less than or equal to the given weight
     */

   

    public ListNode<Wrestler> wrestlerBefore( int weight)
    {
    	for (ListNode<Wrestler> n = teamList, prev = null; n != null; prev = n, n = n.getNext())
		{
			if (n.getValue().getWeight() >= weight)
			{
				return prev;
			}
		}
    	
    	if (getLast().getWeight() <= weight)
    	{
    		return getLastListNode();
    	}
		
		return null;
    }
/**
     * precondition: the teamList field is null or it points to the 
     * first node of a linked list
     * 
     * postcondition: w has been added to the list in sorted order (by weight)
     */
    
  //ok
    public void addWrestler(Wrestler w)
    {
    	ListNode<Wrestler> prev = null;
    	ListNode<Wrestler> n = teamList;
		
		if (size() == 0 || w.getWeight() <= n.getValue().getWeight())
		{
			teamList = new ListNode<Wrestler>(w, teamList);
		}
		
		else
		{			
			while (true)
			{
				if (n.getNext() == null)
				{
					break;
				}
				else
				{
					
					prev = n;	
					n = n.getNext();
					
					if (prev.getValue().getWeight() <= w.getWeight() && 
							w.getWeight() <= n.getValue().getWeight())
					{
						prev.setNext(new ListNode<Wrestler>(w, n));
						return;
					}
					
					
				}

			}
			
			n.setNext(new ListNode<Wrestler>(w, null));
			
		}
    }
    
  //ok



    //works
    public Wrestler remove(Wrestler w)
    {
    	try
    	{
    		if (getFirst().equals(w))
    		{
    			return removeFirst();
    			
    		}
    		else if (getLast().equals(w))
    		{
    			return removeLast();
    		}
    		else
    		{
    			try
    			{
    				for (ListNode<Wrestler> n = teamList, prev = null; n != null; prev = n, n = n.getNext())
    				{
    					if (n.getValue().equals(w))
    					{
    						prev.setNext(n.getNext());
    						return w;
    					}
    				}
    				
    				return w;
    			}
    			catch (NullPointerException e)
    			{
    				return null;
    			}
    		}
    	}
    	catch (NullPointerException e)
    	{
    		return null;
    	}
     }


/**
     * Displays wrestlers less than weight
     */
    
    //ok


   
    public void smallerList(int weight)
    {
    	try
    	{
    		for (ListNode<Wrestler> n = teamList; n.getValue().getWeight() < weight; n = n.getNext())
    		{
    			System.out.print(n + " | ");
    		}
    		
    		System.out.println();
    	}
    	
    	catch (NullPointerException e){
    		
    	}
    	
    	
    }
  //ok
    
    public ListNode<Wrestler> getLastListNode()
   	{
       	ListNode<Wrestler> x = null;
   		for (ListNode<Wrestler> n = teamList; n != null; n = n.getNext())
   		{
   			x = n;
   		}
   		
   		return x;
   	}

    public Wrestler getFirst() {

		return teamList.getValue();
	}
    
    public Wrestler removeFirst() {
		try
		{
			Wrestler n = teamList.getValue();
			teamList = teamList.getNext();
			return n;
		}
		catch (NullPointerException e)
		{
			return null;
		}
	}

	public Wrestler removeLast() 
	{
		ListNode<Wrestler> n = teamList;
		ListNode<Wrestler> prev = null;
		while (true)
		{
			if (n.getNext() == null)
			{
				break;
			}
			else
			{
				prev = n;
				n = n.getNext();
			}

		}
		
	
		try
		{
			Wrestler x = n.getValue();
			prev.setNext(null);
			return x;
		}
		catch (NullPointerException e)
		{
			return removeFirst();
		}
	}
	
	//ok
	public Wrestler getLast() {
		
		Wrestler x = null;
		for (ListNode<Wrestler> n = teamList; n != null; n = n.getNext())
		{
			x = n.getValue();
		}
		
		return x;
	}

	public int size() {
		// TODO Auto-generated method stub
		
		int i = 0;
		for (ListNode<Wrestler> n = teamList; n != null; n = n.getNext())
		{
			++i;
		}
		
		return i;
	}
    
	public String toString()
	{
		StringBuilder str = new StringBuilder();
		str.append("[");
		for (ListNode<Wrestler> n = teamList; n != null; n = n.getNext())
		{
			str.append(n.getValue());
			if (n.getNext() != null)
			{
				str.append(" ");
			}
		}
		str.append("]");
		return str.toString();
	}
	
	 public static void main(String[] args) {
			// TODO Auto-generated method stub
			Roster r = new Roster();
			r.addWrestler(new Wrestler("Joe", 150));
			r.addWrestler(new Wrestler("Tim", 152));
			r.addWrestler(new Wrestler("Ray", 175));
			r.addWrestler(new Wrestler("Don", 121));
			r.addWrestler(new Wrestler("Dan", 124));
			r.addWrestler(new Wrestler("Juan", 224));
			Wrestler tc = new Wrestler ("TC", 185);
			
			
			r.addWrestler(tc);
			System.out.println(r);
			//System.out.println(r);
			System.out.println("Wrestler before 100 lbs: " +r.wrestlerBefore(100));
			System.out.println("Wrestler before 160 lbs: " +r.wrestlerBefore(160));
			System.out.println("Wrestler before 300 lbs: " +r.wrestlerBefore(300));

			System.out.println("Remove TC? " +r.remove(tc));
			System.out.println();
		
			System.out.println();
			System.out.println(r);
			
			System.out.println("Wrestlers less than 190 lbs:");
			r.smallerList(190);
			
			
		}
}






