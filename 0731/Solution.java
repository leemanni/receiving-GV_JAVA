package com.leemanni.erercise;

public class Solution {
	public static void main(String[] args) {
//		int[] progresses = { 93, 30, 55 };
		int[] progresses = { 95, 90, 99, 99, 80, 99};
//		int[] speeds = { 1, 30, 5 };
		int[] speeds = { 1, 1, 1, 1, 1, 1 };
		Solution s = new Solution();
		int [] answer = s.solution2(progresses, speeds);
		for (int i : answer) {
			System.out.println(i);
		}
	}

	public int[] solution2(int[] progresses, int[] speeds) {
		int index = 0;
		String rem = "";
		int key = 0;
		int keyIndex = 0;
		int outCheck =0;
		while (true) {
			if (progresses[index] < 100) {
				progresses[index] += speeds[index];
			}
			while (progresses[keyIndex] >= 100) {
				outCheck++;
				++key;
				if (keyIndex == progresses.length - 1) {
					rem += key;
					break;
				}
				keyIndex  = ++keyIndex % progresses.length;
			}
			rem += key > 0 ? key : "";
			key = 0;
			index = ++index % progresses.length;
			
			if (outCheck == progresses.length) {
				break;
			}
		}
		int [] answer = new int [rem.length()-1];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = Integer.parseInt(rem.charAt(i)+"");
		}
		return answer;
	}
}
