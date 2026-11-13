class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        int ele1 = 0;
        int ele2 = 0;
        int c1 = 0;
        int c2 = 0;
        for (int num : nums) {
            if (ele1 == num) {
                c1++;
            } else if (ele2 == num) {
                c2++;
            } else if (c1 == 0) {
                ele1 = num;
                c1 = 1;
            } else if (c2 == 0) {
                ele2 = num;
                c2 = 1;
            } else {
                c1--;
                c2--;
            }
        }
        c1 = 0;
        c2 = 0;
        for (int i : nums) {
            if (ele1 == i) {
                c1++;
            } else if (ele2 == i) {
                c2++;
            }
        }
        if (c1 > n / 3) {
            ans.add(ele1);
        }
        if (c2 > n / 3) {
            ans.add(ele2);
        }
        return ans;
    }
}