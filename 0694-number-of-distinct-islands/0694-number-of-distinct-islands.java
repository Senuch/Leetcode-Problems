class Solution {
    public static StringBuilder psf = new StringBuilder();

  public static int numDistinctIslands(int[][] arr) {
    if (arr == null || arr.length < 1 || arr[0].length < 1)
      return 0;

    HashSet<String> set = new HashSet<String>();

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        psf = new StringBuilder();
        if (arr[i][j] == 1) {
          psf.append("o");
          funcall(arr, i, j);
          set.add(psf.toString());
        }
      }
    }

    return set.size();
  }

  private static void funcall(int[][] arr, int i, int j) {

    arr[i][j] = 0;
    if (i + 1 < arr.length && arr[i + 1][j] == 1) {
      psf.append("d");
      funcall(arr, i + 1, j);

    }
    if (i - 1 >= 0 && arr[i - 1][j] == 1) {
      psf.append("u");
      funcall(arr, i - 1, j);

    }
    if (j + 1 < arr[0].length && arr[i][j + 1] == 1) {
      psf.append("r");
      funcall(arr, i, j + 1);

    }
    if (j - 1 >= 0 && arr[i][j - 1] == 1) {
      psf.append("l");
      funcall(arr, i, j - 1);

    }
    psf.append("b");

  }
}