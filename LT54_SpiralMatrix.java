import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LT54_SpiralMatrix {
    public static void main(String[] args) {
        LT54_SpiralMatrix driver= new LT54_SpiralMatrix();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> result_expected = Arrays.asList(1,2,3,6,9,8,7,4,5);
        List<Integer> result_actual = driver.spiralOrder(matrix);
        boolean result= result_actual.equals(result_expected);
        System.out.println(result);
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        //starting position of all 4 direction should be initial here.
        int left=0,top=0, right=matrix[0].length-1,bottom=matrix.length-1;
        //intial start from left top corner till last element mean right value.
        int direction=0;
        while (left<=right && top<=bottom){

            if(direction==0){
                //it mean left to right and top will be increase after it done
                for(int i=left; i<=right;i++){
                    result.add(matrix[top][i]);
                }
                top++;

            }else if(direction==1){
                for(int i=top; i<=bottom;i++){
                    result.add(matrix[i][right]);
                }
                right--;
            }else if(direction==2){
                for(int i=right; i>=left;i--){
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }else if(direction==3){
                for(int i=bottom; i>=top;i--){
                    result.add(matrix[i][left]);
                }
                left++;
            }
            //System.out.println(result);
            direction = (direction+1) % 4;
        }
        return result;
    }
}
