package com.code.random;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 * 生成不重复的随机字符串
 * 
 * @author John
 *
 */
public class GenerateCoupon {

	static char[] CHRS = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6',
			'7', '8', '9' };

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Set<String> sets = generate(200000, 10);
		System.out.println("1 -> " + (System.currentTimeMillis() - start));
		FileWriter writer = null;
		try {
			writer = new FileWriter("C:\\Users\\John\\Desktop\\codes.txt");
			// writer = new BufferedWriter(
			// new OutputStreamWriter(new FileOutputStream(
			// "C:\\Users\\John\\Desktop\\codes.txt"), "gbk"));
			Iterator<String> it = sets.iterator();
			while (it.hasNext()) {
				writer.write(it.next() + "\r\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
			}
		}
		System.out.println("2 -> " + (System.currentTimeMillis() - start));
		System.out.println("----");
	}

	public static Set<String> generate(int n, int len) {
		Set<String> sets = new HashSet<String>(n);
		Random rand = new Random();
		//shuffle(rand);
		for (int i = 0; i < n; i++) {
			shuffle(rand);
			while (true) {
				char[] buff = new char[len];
				for (int j = 0; j < len; j++) {
					char c = CHRS[rand.nextInt(CHRS.length - j)];
					buff[j] = (char) c;
				}
				if (sets.add(new String(buff))) {
					break;
				}
				if(sets.size() == n){
					break;
				}
			}
		}
		return sets;
	}

	// 洗牌
	public static void shuffle(Random rand) {
		for (int i = CHRS.length; i > 1; i--) {
			int index = rand.nextInt(i);
			char tmp = CHRS[index];
			CHRS[index] = CHRS[i - 1];
			CHRS[i - 1] = tmp;
		}
	}

}
