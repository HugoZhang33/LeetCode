public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int[] heap = new int[k];
        for (int i=0; i<k; i++) {
            heap[i] = nums[i];
            raise(heap, i);
        }
        for (int i=k; i<nums.length; i++) {
            add(heap, nums[i]);
        }
        return heap[0];
    }
    
    private void sink(int[] heap) {
        int parent = 0;
        int left   = 1;
        int right  = 2;
        while (left < heap.length) {
            int min = heap[left];
            int next = left;
            if (right < heap.length) {
                min = Math.min(heap[left], heap[right]);
                next = heap[left] <= heap[right] ? left : right;
            }
            if (heap[parent] > heap[next]) {
                int tmp = heap[next];
                heap[next] = heap[parent];
                heap[parent] = tmp;
            }
            parent = next;
            left = parent*2 +1;
            right = parent*2 +2;
        }
    }
    
    private void raise(int[] heap, int index) {
        while ((index-1) / 2 >= 0) {
            int parent = (index-1) / 2;
            if (heap[parent] >= heap[index]) {
                int tmp = heap[index];
                heap[index] = heap[parent];
                heap[parent] = tmp;
            }
            if (parent == 0)
                break;
            index = (index-1) / 2;
        }
    }
    
    private void add(int[] heap, int v) {
        if (v > heap[0]) {
            heap[0] = v;
            sink(heap);
        }
    }
}