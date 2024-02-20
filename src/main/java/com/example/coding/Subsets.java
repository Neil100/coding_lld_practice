package com.example.coding;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> powerSet = new ArrayList<>();

        createPowerSet(nums, 0, powerSet, new ArrayList<Integer>());
        return powerSet;
    }

    void createPowerSet(int[] nums, int index, List<List<Integer>> powerSet, List<Integer> solSet) {

        if(index==nums.length) {
            powerSet.add(solSet);
            return ;
        }

        solSet.add(nums[index]);
        int indexx = solSet.size()-1;

        createPowerSet(nums, index+1, powerSet, new ArrayList<>(solSet));

         solSet.remove(indexx);

        createPowerSet(nums, index+1, powerSet, new ArrayList<>(solSet));
        return;
    }
}
