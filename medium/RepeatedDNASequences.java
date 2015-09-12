package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 187 Repeated DNA Sequences
 * https://leetcode.com/problems/repeated-dna-sequences/
 * 
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
 * for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * 
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 * 
 * For example,
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * Return: ["AAAAACCCCC", "CCCCCAAAAA"].
 */
public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<String>();
        if (s == null || s.length() < 11)   return res;
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);
        
        int hash = 0;
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> unique = new HashSet<Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i < 9) {
                hash = (hash << 2) + map.get(c);
            } else {
                hash = (hash << 2) + map.get(c);
                hash &= (1 << 20) - 1;
                if (set.contains(hash) && !unique.contains(hash)) {
                    res.add(s.substring(i - 9, i + 1));
                    unique.add(hash);
                } else {
                    set.add(hash);
                }
            }
        }
        return res;
    }
}
// http://blog.csdn.net/xudli/article/details/43666725