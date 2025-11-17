package kgyy.com.keith.heap.e;

// 自顶向下的归并排序, 含优化
public class MergeSort2 {

    // 我们的算法类不允许产生任何实例
    private MergeSort2(){}

    // 将arr[l...mid]和arr[mid+1...r]两部分进行归并
    // 其中aux为完成merge过程所需要的辅助空间
    private static void merge(Comparable[] arr, int l, int mid, int r) {
        System.out.println("merge" + l);
        Comparable[] aux = new Comparable[arr.length];
        System.arraycopy(arr, l, aux, l, r-l+1);

        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l, j = mid+1;
        for( int k = l ; k <= r; k ++ ){

            if( i > mid ){  // 如果左半部分元素已经全部处理完毕
                arr[k] = aux[j]; j ++;
            }
            else if( j > r ){   // 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i]; i ++;
            }
            else if( aux[i].compareTo(aux[j]) < 0 ){  // 左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i]; i ++;
            }
            else{  // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j]; j ++;
            }
        }
    }

    // 递归使用归并排序,对arr[l...r]的范围进行排序
    // 其中aux为完成merge过程所需要的辅助空间
    private static void sort(Comparable[] arr, int l, int r) {
        if( r <= l ){
            return;
        }

        int mid = (l+r)/2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);

        merge(arr, l, mid, r);
    }

    public static void sort(Comparable[] arr){

        int n = arr.length;
        sort(arr,0, n-1);
    }

    // 测试 MergeSort
    public static void main(String[] args) {

        int N = 100;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("com.keith.heap.e.MergeSort2", arr);

        SortTestHelper.printArray(arr);
    }
}
