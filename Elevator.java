public class Elevator {
	
	public static final int MAX_FLOORS = 50;
	
	// upward floor queue
	private PriorityQueue<Integer> floors_up = new PriorityQueue<Integer>(MAX_FLOORS);
	
	// downward floor queue
	private PriorityQueue<Integer> floors_down = new PriorityQueue<Integer>(MAX_FLOORS, new Comparator<Integer>(){
		public int compare(Integer arg0, Integer arg1) {
			return arg1.compareTo(arg0);
		}
	});
	
	// effective floor queue
	private PriorityQueue<Integer> floors = floors_up;
	
	// current floor
	private int current = 0;

	public void userCallAt(int where) {
		setTarget(where);
	}
	
	public void setTarget(int target) {
		
		// ignore if target is current
		if (target == current) {
			return;
		}
		
		// add target to right queue
		if (floors == floors_up) {
			if (target < current) {
				floors_down.offer(target);
			} else {
				floors_up.offer(target);
			}
		} else {
			if (target > current) {
				floors_up.offer(target);
			} else {
				floors_down.offer(target);
			}
		}
		
		// swap queue to turn around the elevator
		if (floors.isEmpty()) {
			floors = (floors == floors_up ? floors_down : floors_up);
		}
	}
	
	public int getTarget() {
		
		if (!floors.isEmpty()) {
			return floors.peek();
		}
		
		if (floors_up.isEmpty() && floors_down.isEmpty()) {
			return current;
		}
		
		floors = (floors == floors_up ? floors_down : floors_up);
		return floors.peek();
	}
	
	public int getCurrent() {
		return current;
	}
	
	public void step(int target) {
		if (target > current) {
			current++;
		} else {
			current--;
		}
	}
	
	public void stop() {
		floors.poll();
	}
	
	public void move() {
		
		while (getCurrent() != getTarget()) {
			do {
				step(getTarget());
			} while (getCurrent() != getTarget());
			stop();
		}
		
	}
	
}