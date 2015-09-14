public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;
        int k = (m+n) / 2;
        if ((m+n) % 2 == 0) {
            return (findKth(A, 0, m-1, B, 0, n-1, k-1) + findKth(A, 0, m-1, B, 0, n-1, k)) / 2.0;
        } else {
            return findKth(A, 0, m-1, B, 0, n-1, k);
        }
    }
    
    // k is the kth element in m+n we need to find
    // in fact, we need to skip the pre k elements and the k+1 is what we want, beacuse k means index of array
    private int findKth(int[] A, int astart, int aend, int[] B, int bstart, int bend, int k) {
        if (astart > aend) {
            return B[bstart+k];
        }
        if (bstart > bend) {
            return A[astart+k];
        }
        if (k==0) {
            return Math.min(A[astart], B[bstart]);
        }
        
        int alen = aend-astart+1;
        int blen = bend-bstart+1;
        int amid = k*alen / (alen+blen);
        int bmid = k-amid-1;
        amid += astart;
        bmid += bstart;
        
        if (A[amid] < B[bmid]) {
            k = k-(amid-astart+1);
            astart = amid+1;
            bend   = bmid;
        } else {
            k = k-(bmid-bstart+1);
            bstart = bmid+1;
            aend   = amid;
        }
        
        return findKth(A, astart, aend, B, bstart, bend, k);
    }
}