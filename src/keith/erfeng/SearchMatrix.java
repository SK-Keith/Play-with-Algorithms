package erfeng;

/**
 * @author MX.Y
 * @DATE 2022-04-16 14:06
 */
public class SearchMatrix {

    public boolean searchMatrix1(int[][] matrix, int target) {
        int index = 0;
        int rowLength = matrix.length;
        int colength = matrix[0].length;
        for(int i = 0;i<rowLength;i++) {
            if(target <= matrix[i][colength-1] || index + 1 >= rowLength) {
                break;
            }
            index++;
        }
        System.out.println("index:" + index);
        for(int j = 0;j<colength;j++) {
            if(target == matrix[index][j]) {
                return true;
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int index = 0;
        int rowLength = matrix.length;
        int colength = matrix[0].length;
        for(int i = 0;i<rowLength;i++) {
            if(target <= matrix[i][colength-1] || index + 1 >= rowLength) {
                break;
            }
            index++;
        }
        int left = 0, right = colength -1;
        while(left <= right) {
            int mid = left + (right - left) >> 1;
            if (matrix[index][mid] == target) {
                return true;
            } else if(matrix[index][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        SearchMatrix s = new SearchMatrix();
        System.out.println(s.searchMatrix(matrix, 13));

    }
}
