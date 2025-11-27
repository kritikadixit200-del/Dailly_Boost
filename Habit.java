public class Habit {
private String name;
private String time;
private boolean completed;

public Habit(String name, String time) {
this.name = name;
this.time = time;
this.completed = false;
}

public String getName() { return name; }
public String getTime() { return time; }
public boolean isCompleted() { return completed; }

public void markCompleted() { completed = true; }
public void resetHabit() { completed = false; }

public String toString() {
return name + " @ " + time + " - " + (completed ? "Completed" : "Pending");
}
}
