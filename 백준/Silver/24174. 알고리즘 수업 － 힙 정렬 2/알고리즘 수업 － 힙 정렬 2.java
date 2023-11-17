import java.io.*;
import java.util.*;

public class Main {

    static int count = 0;
    static int K = 0;

    public static void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
        count++;

        if (K == count) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < array.length; i++) {
                sb.append(array[i]).append(" ");
            }
            System.out.println(sb.toString());
            System.exit(0);
        }
    }

    static public void heapSort(int[] array) {
        buildMinHeap(array, array.length - 1);
        for (int i = array.length - 1; i >= 2; i--) {
            swap(array, 1, i);
            heapify(array, 1, i - 1);
        }
    }

    static public void buildMinHeap(int[] array, int n) {
        for (int i = n / 2; i >= 1; i--) {
            heapify(array, i, n);
        }
    }

    static public void heapify(int[] array, int k ,int n) {
        int left = 2*k;
        int right = 2*k + 1;

        int smaller = 0;

        if (right <= n) {
            if (array[left] < array[right]) {
                smaller = left;
            } else {
                smaller = right;
            }
        } else if (left <= n) {
            smaller = left;
        } else {
            return;
        }

        if(array[smaller] < array[k]) {
            swap(array, smaller, k);
            heapify(array, smaller, n);
        }

    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] array = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        heapSort(array);
        System.out.println("-1");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}