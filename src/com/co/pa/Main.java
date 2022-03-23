package com.co.pa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
	    int[] A = {5, 19, 8, 1};
        System.out.printf(solution(A) + "");
    }


    public static int solution(int[] A){
        int filters = 0;
        float totalPollution = 0;
        List<Float> listPollution = new ArrayList<>();

        for(int i = 0; i < A.length; i++) {
            listPollution.add(Float.valueOf(A[i]));
            totalPollution += A[i];
        }
        float currentPollution = totalPollution;
        totalPollution /= 2;

        Collections.sort(listPollution, Collections.reverseOrder());

        int i = 0;
        while(currentPollution > totalPollution){
            float value = listPollution.get(i) / 2;
            currentPollution -= value;
            listPollution.set(i, value);
            filters++;
            Collections.sort(listPollution, Collections.reverseOrder());
        }

        return filters;
    }
}
