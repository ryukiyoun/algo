package quicksort;

public class Main {
    public static void main(String[] args) throws Exception{
        int[] list = {21, 46, 19, 28, 4, 71, 2, 8, 4, 61, 82, 746, 18, 27, 461, 82, 7, 4, 6};

        QuickSort(list, 0, list.length - 1);

        for (int j : list) System.out.println(j);
    }

    public static void QuickSort(int[] list, int lo, int hi){
        if(lo >= hi) return;

        int sortIndex = partition(list, lo, hi);

        QuickSort(list, lo, sortIndex - 1);
        QuickSort(list, sortIndex + 1, hi);
    }

    public static int partition(int[] list, int lo, int hi){
        int pivotIndex = lo;
        int pivot = list[lo];
        lo++;

        while(true){
            while(lo <= hi){
                if(pivot < list[lo])
                    break;
                lo++;
            }

            while(hi >= lo){
                if(pivot > list[hi])
                    break;
                hi--;
            }

            if(hi < lo)
                break;

            swap(list, lo, hi);
        }
        swap(list, pivotIndex, hi);
        return hi;
    }

    public static void swap(int[] list, int targetL, int targetR){
        int temp = list[targetL];
        list[targetL] = list[targetR];
        list[targetR] = temp;
    }
}
