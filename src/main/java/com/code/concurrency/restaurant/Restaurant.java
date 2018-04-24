package com.code.concurrency.restaurant;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.code.concurrency.CachedThreadPool;

class Meal {
	private final int orderNum;

	public Meal(int orderNum) {
		this.orderNum = orderNum;
	}

	public String toString() {
		return "Meal " + orderNum;
	}

}

class WaitPerson implements Runnable {

	private Restaurant restaurant;

	public WaitPerson(Restaurant restanrant) {
		this.restaurant = restanrant;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				synchronized (this) {
					if (restaurant.meal == null) {
						wait(); // for chef to produce a meal.
					}
				}

				System.out.println("WaitPerson got " + restaurant.meal);
				synchronized (restaurant.chef) {
					restaurant.meal = null;
					restaurant.chef.notifyAll();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Chef implements Runnable {

	Restaurant restaurant;
	private int count = 0;

	public Chef(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				synchronized (this) {
					if (restaurant.meal != null) {
						wait();
					}
				}
				if (++count == 10) {
					System.out.println("Out of food , closing");
					restaurant.exec.shutdownNow();
				}
				System.out.println("order up.");
				synchronized (restaurant.waitPerson) {
					restaurant.meal = new Meal(count);
					restaurant.waitPerson.notifyAll();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

public class Restaurant {
	ExecutorService exec = Executors.newCachedThreadPool();
	Meal meal;
	WaitPerson waitPerson = new WaitPerson(this);
	Chef chef = new Chef(this);

	public Restaurant() {
		exec.execute(chef);
		exec.execute(waitPerson);
	}

	public static void main(String[] args) {
		new Restaurant();
	}
}
