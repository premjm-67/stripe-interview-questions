import java.util.*;
public class PL {
        public int minimumTime(int n, int[][] relations, int[] times) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++)
        {
            adj.add(new ArrayList<>());


        }
        int[] dp=new int[n+1];
        int[] deg=new int[n+1];
        for(int i=0;i<times.length;i++)
        {
            dp[i+1]=times[i];
        }
        for(int i=0;i<relations.length;i++)
        {
              int u=relations[i][0];
              int v=relations[i][1];
              adj.get(u).add(v);
              deg[v]=deg[v]+1;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<=n;i++)
        {
               if(deg[i]==0)
               {
                       q.add(i);
               }
        }
        while(!q.isEmpty())
        {
             int cur=q.poll();
             for(int v:adj.get(cur))
             {
                  dp[v]=Math.max(dp[v],dp[cur]+times[v-1]);
                  deg[v]-=1;
                  if(deg[v]==0)
                  {
                       q.add(v);
                  }
             }
        }
        int ans=0;
        for(int r:dp)
        {
             ans=Math.max(ans,r);
        }return ans;
    }
    public static void main(String[] args) {
        PL pl=new PL();
        int n=3;
        int[][] relations={{1,3},{2,3}};
        int[] times={3,2,5};
        System.out.println(pl.minimumTime(n, relations, times));

        
    }
    
}
