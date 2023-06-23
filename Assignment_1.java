import java.util.*;
public class Assignment_1
{
    // -------------------Question-1------------------------------//
    
    public static List<Integer> targetSum(int nums[], int target) {
        List<Integer> l = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])) {
                l.add(map.get(target-nums[i]));
                l.add(i);
                return l;
            }
            else {
                map.put(nums[i], i);
            }
        }
        return l;
    }
    
    // -------------------Question-2------------------------------//
    
    public static int removeOccurence(int nums[], int val) {
        int n = nums.length;
        int k = 0;
        for(int i = 0; i < n; i++) {
            if(nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
    
    // -------------------Question-3------------------------------//
    
    public static int search(int nums[], int target) {
        int si = 0, ei = nums.length-1;
        while(si <= ei) {
            int mid = (si+ei)/2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[mid] < target) {
                si = mid+1;
            }
            else {
                ei = mid-1;
            }
        }
        return si;
    }
    
    // -------------------Question-4------------------------------//
    
    public static int[] increasedArray(int digits[]) {
        int num = 0;
        for(int i : digits) {
            num=((num*10)+i);
        }
        num++;
        Stack<Integer> s = new Stack<>();
        while(num > 0) {
            s.add(num%10);
            num/=10;
        }
        int new_digits[] = new int[s.size()];
        int i = 0;
        while(!s.isEmpty()) {
            new_digits[i++] = s.pop();
        }
        return new_digits;
    }
    
    // -------------------Question-5------------------------------//
    
    public static void merge(int nums1[], int nums2[], int m, int n) {
        int i = m-1, j = n-1, k = m+n-1;
        while(i >= 0 && j >= 0) {
            if(nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                k--;
                i--;
            }
            else {
                nums1[k] = nums2[j];
                k--;
                j--;
            }
        }
        while(i >= 0) {
            nums1[k] = nums1[i];
            i--;
            k--;
        }
        while(j >= 0) {
            nums2[k] = nums2[j];
            j--;
            k--;
        }
    }
    
    // -------------------Question-6------------------------------//
    
    public static boolean isDuplicate(int nums[]) {
        HashSet<Integer> set = new HashSet<>();
        for(int i:nums) {
            if(set.contains(i)) {
                return true;
            }
            else {
                set.add(i);
            }
        }
        return false;
    }
        
    // -------------------Question-7------------------------------//
    
    public static void remove0(int nums[]) {
        int k = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
                k++;
            }
        }
    }
    // -------------------Question-8------------------------------//
    
    public static int[] findError(int nums[]) {
        int n = nums.length;
        int sum_n = (n*(n+1))/2;
        int sum_n2 = (n*(n+1)*(2*n+1))/6;
        int s = 0, s2 = 0;
        for(int i : nums) {
            s+=i;
            s2+=(i*i);
        }
        int diff = sum_n-s;
        int diff2 = sum_n2-s2;
        int sum = diff2/diff;
        int a = (sum+diff)/2;
        int b = sum-a;
        int error[] = {b,a};
        return error;
    }
    
	public static void main(String[] args) {
	    // -------------------Question-1------------------------------//
		System.out.println("----------Question-1----------");
		
		int nums[] = {2,7,11,15};
		System.out.println(targetSum(nums, 9));
		
		// -------------------Question-2------------------------------//
		System.out.println("----------Question-2----------");
		
		int nums2[] = {3,2,2,3};
	    
		System.out.println(removeOccurence(nums2, 3));
		for(int i:nums2) {
		    System.out.print(i + ",");
		}
		System.out.println();
		
		// -------------------Question-3------------------------------//
		System.out.println("----------Question-3----------");
		
		int nums3[] = {1,3,5,7};
		System.out.println(search(nums3, 4));
		
		// -------------------Question-4------------------------------//
		System.out.println("----------Question-4----------");
		
		int num4[] = {9,9,9};
	    int a[];
	    a = increasedArray(num4);
	    for(int i : a) {
	        System.out.print(i);
	    }
	    System.out.println();
	    
	    // -------------------Question-5------------------------------//
		System.out.println("----------Question-5----------");
		
		int nums5a[] = {1,2,3,0,0,0}, m = 3;
	    int nums5b[] = {2,5,6}, n = 3;
	    merge(nums5a, nums5b, m, n);
		for(int i : nums5a) {
		    System.out.print(i + ", ");
		}
		System.out.println();
		
		// -------------------Question-6------------------------------//
		System.out.println("----------Question-6----------");
		
		int nums6[] = {1,2,3,1};
		System.out.println(isDuplicate(nums6));
		
		
		// -------------------Question-7------------------------------//
		System.out.println("----------Question-7----------");
		
		int nums7[] = {0,1,0,3,12};
	    remove0(nums7);
		for(int i : nums7) {
		    System.out.print(i + ",");
		}
		System.out.println();
		
		// -------------------Question-8------------------------------//
		System.out.println("----------Question-8----------");
		
		int nums8[] = {1,2,2,4};
	    int error[] = findError(nums8);
		System.out.print(error[0]+",");
		System.out.print(error[1]);
		
		
		
	}
}
