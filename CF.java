import java.util.*;

class Tuple
{
       int node;
       int cost;
       int step;
       Tuple(int i,int j,int k)
       {
             node=i;
             cost=j;
             step=k;
       }
}
class CF{
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }        
        for(int i=0;i<flights.length;i++)
        {
              adj.get(flights[i][0]).add(new int[]{flights[i][1],flights[i][2]});
        }
        
        int[][] dist=new int[n][k+2];
        for(int[] row:dist){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        dist[src][0]=0;
        
        PriorityQueue<Tuple> p=new PriorityQueue<>((a,b)->{
              if(a.cost==b.cost)
              {
                  return Integer.compare(a.step,b.step);
              }
               else
               {
                   return Integer.compare(a.cost,b.cost);
               }
        });
         
        p.add(new Tuple(src,0,0));
        while(!p.isEmpty())
        {
              Tuple cur=p.poll();
              int n2=cur.node;
              int mon=cur.cost;
              int s=cur.step;
              
              if(mon > dist[n2][s]) 
              {
                 continue;
              }
              
              if(n2 == dst) 
              {
                return mon;
              }
              
              if(s > k) 
              {
                continue;
              }
              
              for(int[] ar:adj.get(n2))
              {
                     int n1=ar[0];
                     int val=ar[1];
                     
                     if(mon+val < dist[n1][s+1])
                     {
                          dist[n1][s+1]=mon+val;
                          p.add(new Tuple(n1,mon+val,s+1));
                     }
              }
        }
        
        return -1;
    }
    public static void main(String[] args) {
        CF cf=new CF();
        int n=3;
        int[][] flights={{0,1,100},{1,2,100},{0,2,500}};
        int src=0;
        int dst=2;
        int k=1;
        System.out.println(cf.findCheapestPrice(n,flights,src,dst,k));
    }
}