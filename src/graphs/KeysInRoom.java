package graphs;

import java.util.*;


class Solution
{
    static int count=0;
    static void dfs( int curr, int vis[], List<List<Integer>>rooms)
    {
        vis[curr]=1;
        count++;

        for( int conn : rooms.get(curr) )
        {
            if( vis[conn]==0)
            {
                vis[conn]=1;
                dfs( conn, vis, rooms);
            }
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms)
    {
        count=0;
        int n = rooms.size();
        int vis[]= new int[n];
        dfs( 0, vis, rooms);
        if( count ==n )
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
