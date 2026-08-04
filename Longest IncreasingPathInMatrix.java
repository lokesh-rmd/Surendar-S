class LongestPath {
    private final int[][] diff = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int R = matrix.length;
        int C = matrix[0].length;
        int[][] dp = new int[R][C];
        int maxlen = 1;

        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if (dp[row][col] == 0) {
                    maxlen = Math.max(maxlen, dfs(matrix, dp, R, C, row, col));
                }
            }
        }
        return maxlen;
    }

    private int dfs(int[][] matrix, int[][] dp, int R, int C, int row, int col) {
        if (dp[row][col] != 0) {
            return dp[row][col];
        }

        int adjMax = 0;
        for (int i = 0; i < 4; i++) {
            int ar = row + diff[i][0];
            int ac = col + diff[i][1];
            if (ar >= 0 && ar < R && ac >= 0 && ac < C && matrix[ar][ac] > matrix[row][col]) {
                adjMax = Math.max(adjMax, dfs(matrix, dp, R, C, ar, ac));
            }
        }
        
        dp[row][col] = 1 + adjMax;
        return dp[row][col];
    }
}
