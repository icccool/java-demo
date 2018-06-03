package com.code.concurrency.connectionpool;

import java.util.LinkedList;

public class ConnectionPool {

	private LinkedList<Connection> pool = new LinkedList<Connection>();

	public ConnectionPool(int initialSize) {
		if (initialSize > 0) {
			for (int i = 0; i < initialSize; i++) {
				pool.add(new Connection());
			}
		}
	}

	public void releaseConnection(Connection conn) {
		if (conn != null) {
			synchronized (pool) {
				pool.addLast(conn);
				pool.notifyAll();
			}
		}
	}
	
	/***
	 * 默认时间拿不到链接 返回null
	 *  
	 * @param mills
	 * @return
	 * @throws InterruptedException
	 */
	public Connection getConnection(long mills) throws InterruptedException {
		synchronized (pool) {
			if (mills <= 0) {
				while (pool.isEmpty()) {
					pool.wait();
				}
				return pool.removeFirst();
			} else {
				long future = System.currentTimeMillis() + mills;
				long remaining = mills;
				while(pool.isEmpty() && remaining > 0) {
					pool.wait(remaining);
					remaining = future - System.currentTimeMillis();
				}
				Connection result = null;
				if(!pool.isEmpty()) {
					result = pool.removeFirst();
				}
				return result;
			}
		}
	}
}
