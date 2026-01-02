import java.util.*;
class ED {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String,HashMap<String,Double>> adj=new HashMap<>();
        double[] ans=new double[queries.size()];
        for(int i=0;i<equations.size();i++)
        {
               String c1=equations.get(i).get(0);
               String c2=equations.get(i).get(1);
              adj.putIfAbsent(c1,new HashMap<>());
              adj.putIfAbsent(c2,new HashMap<>());
              adj.get(c1).put(c2,values[i]);
              adj.get(c2).put(c1,1.0/values[i]);
        }
        for(int i=0;i<queries.size();i++)
        {
               String cur=queries.get(i).get(0);
               String  des=queries.get(i).get(1);
               HashSet h=new HashSet<>();
               if(!adj.containsKey(cur) ||  !adj.containsKey(des))
               {
                  ans[i]=-1;
                  continue;
               }
               double p=dfs(cur,adj,des,h,1.0);
               ans[i]=p;

               

        }return ans;

        
    }
    double dfs(String cur,HashMap<String,HashMap<String,Double>> adj,String des,HashSet h,double p)
    {
          h.add(cur);
           if(cur.equals(des))
           {
               return p;
           }
           HashMap<String,Double> h1=adj.get(cur);

              for(String g:h1.keySet())
              {
                if(!h.contains(g))
                {
                    h.add(g);
                    double r1=dfs(g,adj,des,h,p*h1.get(g));
                   if(r1!=-1)
                   {
                    return r1;
                   }
                }
                   
              
        }return -1;
    }
    public static void main(String[] args) {
        ED ed=new ED();
        List<List<String>> equations=new ArrayList<>();
        equations.add(Arrays.asList("a","b"));
        equations.add(Arrays.asList("b","c"));
        double[] values={2.0,3.0};
        List<List<String>> queries=new ArrayList<>();
        queries.add(Arrays.asList("a","c"));
        queries.add(Arrays.asList("b","a"));
        queries.add(Arrays.asList("a","e"));
        queries.add(Arrays.asList("a","a"));
        queries.add(Arrays.asList("x","x"));
        double[] result=ed.calcEquation(equations,values,queries);
        System.out.println(Arrays.toString(result));
    }
}