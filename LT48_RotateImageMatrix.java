public class LT48_RotateImageMatrix {

    public void rotate(int[][] matrix) {
        transpose(matrix);
        reflect(matrix);
    }
    public void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1 ; j < n; j++) {
                swap(matrix, i, j, j, i);
            }
        }
    }

    public void reflect(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                swap(matrix,i,j, i, n-j-1);
            }
        }
    }
    public void swap(int[][] m, int i1, int j1, int i2, int j2){
        int tmp = m[i1][j1];
        m[i1][j1] = m[i2][j2];
        m[i2][j2] = tmp;

    }
}
