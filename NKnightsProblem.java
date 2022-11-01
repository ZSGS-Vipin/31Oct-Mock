class knightProbability
{
     static int[] dx = {1,2,2,1,-1,-2,-2,-1};
   static int[] dy = {2,1,-1,-2,-2,-1,1,2};
    public static double findProb(int N, int start_x, int start_y, int step)
    {
       double dp[][][] = new double[N][N][step+1];
        for(int i = 0; i < N;i++)
        {
            for(int j = 0; j < N;j++)
            {
                dp[i][j][0]=1;
            }
        }
        for(int s=1;s<=step;s++)
        {
            for(int x = 0; x < N;x++)
            {
                for(int y = 0; y < N; y++)
                {
                    double prob = 0;
                    for(int i = 0; i < 8;i++)
                    {
                        int newx = x+dx[i];
                        int newy = y+dy[i];
                        if(inside(N,newx,newy))
                        {
                            prob+=dp[newx][newy][s-1]/8.0;
                        }
                    }
                    dp[x][y][s]=prob;
                }
            }
        }
        return dp[start_x][start_y][step];
    }
    public static boolean inside(int N, int x, int y)
    {
        return x>=0 && x<N && y>=0 && y<N;
    }

    public static void main(String[] args) {
        System.out.println(findProb(2,1,0,2));
    }
}
