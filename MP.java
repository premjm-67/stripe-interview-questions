import java.util.HashMap;

public class MP {
       public int bestClosingTime(String customers) {
        int open=0;
        HashMap<Integer,Integer> h=new HashMap<>();
        for(int i=0;i<customers.length();i++)
        {
               if(customers.charAt(i)=='Y')
               {
                      open++;
               }
        }
        h.put(0,open);
        int min=open;
        for(int i=0;i<customers.length();i++)
        {
               if(customers.charAt(i)=='Y')
               {
                   open-=1;
                   h.put(i+1,open);
                   min=Math.min(min,h.get(i+1));
                   
               }
               else
               {
                  open+=1;
                  h.put(i+1,open);
                  min=Math.min(min,h.get(i+1));
               }
        }
        for(int i:h.keySet())
        {
               if(h.get(i)==min)
               {
                  return i;
               }
        }return 0;
        
    }
    public static void main(String[] args) {
        
        MP mp = new MP();
        System.out.println()
    }
}
