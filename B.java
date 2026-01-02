import java.util.*;
public class B


{
      List<String> d=new ArrayList<>();
      public  List<String> braces(String s)
       {
           ArrayList<List<Character>> ad=new ArrayList<>();
           int i=0;
           while(i<s.length())
           {
                 if(s.charAt(i)=='{')
                 {
                       i++;
                       ArrayList<Character> b=new ArrayList<>();
                         int j=i;
                       while(s.charAt(j)!='}')
                       {
                                   b.add(s.charAt(j));
                                   j++;  
                       }
                       Collections.sort(b);
                       ad.add(new ArrayList<>(b));
                       i=j+1;
            
                 }
                 else{
                        ArrayList<Character> c=new ArrayList<>();
                        c.add(s.charAt(i));
                        ad.add(new ArrayList<>(c));
                        i++;

                 }
           }
           StringBuilder k=new StringBuilder();
           back(ad,0,k);
           return d;
       }
       void back(List<List<Character>> a,int i,StringBuilder r)
       {
           if(i==a.size())
           {
                d.add(r.toString());
                return;
           }
           for(char f:a.get(i))
           {
                r.append(f);
                back(a,i+1,r);
                r.deleteCharAt(r.length()-1);
           }
       }
       public static void main(String[] args) {
             B s=new B();
            List<String> f=s.braces("x{yz}w");
            System.out.println(f);

            
       }
}