package hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        
        for (int i = 0; i < nums.length; i++) {
            Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
            for (List<Integer> l : res) {
                for (int j = 0; j < l.size() + 1; j++) {
                    l.add(j, nums[i]);
                    ArrayList<Integer> t = new ArrayList<Integer>(l);
                    l.remove(j);
                    set.add(t);
                }
            }
            res = new ArrayList<List<Integer>>(set);
        }
        return res;
    }
}
// http://www.programcreek.com/2013/02/leetcode-permutations-ii-java/