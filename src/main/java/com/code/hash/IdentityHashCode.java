package com.code.hash;

class IdentityIntMap {
	private Object[] keys;
	private int[] values;
	private int prime;
	private int size;

	public IdentityIntMap(int size) {
		keys = new Object[size];
		values = new int[size];
		prime = findBiggestPrime(size);
		this.size = 0;
	}

	public int get(Object key) {
		int hash = System.identityHashCode(key) % prime;
		while (true) {
			Object testKey = keys[hash];
			if (testKey == null) {
				return -1;
			} else if (testKey == key) {
				return values[hash];
			} else {
				hash = (hash + 1) % prime;
			}
		}
	}

	public int put(Object key, int value, boolean replace) {
		int hash = System.identityHashCode(key) % prime;

		while (true) {
			Object testKey = keys[hash];
			if (testKey == null) {
				keys[hash] = key;
				values[hash] = value;
				size++;

				if (keys.length <= 4 * size) {
					resize(4 * keys.length);
				}
				return value;
			} else if (testKey != key) {
				hash = (hash + 1) % prime;
				continue;
			} else if (replace) {
				int old = values[hash];
				values[hash] = value;
				return old;
			}
		}
	}

	public int put(Object key, int value) {
		return put(key, value, true);
	}

	private void resize(int newSize) {
		int[] oldValues = values;
		Object[] oldKeys = keys;
		values = new int[newSize];
		keys = new Object[newSize];
		size = 0;

		prime = findBiggestPrime(newSize);

		for (int i = 0; i < oldKeys.length; i++) {
			if (oldKeys[i] != null) {
				put(oldKeys[i], oldValues[i], true);
			}
		}
	}

	public int findBiggestPrime(int value) {
		for (int i = PRIMES.length - 1; i >= 0; i--) {
			if (PRIMES[i] <= value) {
				return PRIMES[i];
			}
		}
		return 2;
	}

	public static final int[] PRIMES = { 1, /* 1<< 0 = 1 */
	2, /* 1<< 1 = 2 */
	3, /* 1<< 2 = 4 */
	7, /* 1<< 3 = 8 */
	13, /* 1<< 4 = 16 */
	31, /* 1<< 5 = 32 */
	61, /* 1<< 6 = 64 */
	127, /* 1<< 7 = 128 */
	251, /* 1<< 8 = 256 */
	509, /* 1<< 9 = 512 */
	1021, /* 1<<10 = 1024 */
	2039, /* 1<<11 = 2048 */
	4093, /* 1<<12 = 4096 */
	8191, /* 1<<13 = 8192 */
	16381, /* 1<<14 = 16384 */
	32749, /* 1<<15 = 32768 */
	65521, /* 1<<16 = 65536 */
	131071, /* 1<<17 = 131072 */
	262139, /* 1<<18 = 262144 */
	524287, /* 1<<19 = 524288 */
	1048573, /* 1<<20 = 1048576 */
	2097143, /* 1<<21 = 2097152 */
	4194301, /* 1<<22 = 4194304 */
	8388593, /* 1<<23 = 8388608 */
	16777213, /* 1<<24 = 16777216 */
	33554393, /* 1<<25 = 33554432 */
	67108859, /* 1<<26 = 67108864 */
	134217689, /* 1<<27 = 134217728 */
	268435399, /* 1<<28 = 268435456 */
	};
}

public class IdentityHashCode {

}
