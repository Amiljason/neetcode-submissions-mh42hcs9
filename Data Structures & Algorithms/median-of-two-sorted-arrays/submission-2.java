class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int i=0,j=0;
        int[] arr=new int[m+n];
        int k=0;
        while(i<m && j<n){
            if(nums1[i]<nums2[j]){
                arr[k]=nums1[i];
                i++;
            }
            else if(nums1[i]>nums2[j]){
                arr[k]=nums2[j];
                j++;
            }
            else{
                arr[k]=nums1[i];
                k++;
                arr[k]=nums2[j];
                i++;
                j++;
            }
            k++;
        }
        while(i<m){
            arr[k]=nums1[i];
            i++;
            k++;
        }
        while(j<n){
            arr[k]=nums2[j];
            j++;
            k++;
        }
        if(arr.length%2==0){
            int mid=arr.length/2;
            int prev=mid-1;
            return (double)(arr[mid]+arr[prev])/2;
        }
        int mid=arr.length/2;
        return (double)arr[mid];
    }
}
