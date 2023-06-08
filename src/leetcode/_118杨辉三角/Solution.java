package leetcode._118杨辉三角;

import java.util.ArrayList;
import java.util.List;

//生成杨辉三角前m行
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            if(i == 0){
                list.add(1);
            }else if(i == 1){
                list.add(1);
                list.add(1);
            }else {
                for(int j=0;j<=res.get(i-1).size();j++){
                    if(j ==0){
                        list.add(1);
                    }else if(j==res.get(i-1).size()){
                        list.add(1);
                    }else {
                        list.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
                    }
                }
            }
            res.add(list);
        }

        return res;
    }
}
