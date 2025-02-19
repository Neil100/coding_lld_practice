package com.example.coding;

public class Solution {

    public static void main(String[] str) {
        System.out.println("BBBBB");
        System.out.println('\n'-'0'+'0');
        System.out.println("AAAAA");
        /*
        Solution sol = new Solution();
        System.out.println(sol.reverse(1534236469));
        
        DecodeWays ways = new DecodeWays();
        System.out.println(ways.numDecodings("226"));
        
        MinMeetingRooms meetingRooms = new MinMeetingRooms();
        int[][] arr = {{1,10}, {4, 15}};
        System.out.println(meetingRooms.minMeetingRooms(arr));
         */
    }

    public int reverse(int x) {
        int sol = 0, temp;
        if(x==Integer.MIN_VALUE)
            return 0;
        int sign = x>=0?1:(-1);
        x=x*sign;
        while(x>0) {
            temp = sol;
            sol = (sol*10)+(x%10);
            if(sol!=temp/10)
                return 0;
            x = x/10;
        }
        return sol*sign;
    }
}