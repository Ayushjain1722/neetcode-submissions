class Task {
    int freq;
    char taskName;
    int timeNextAvl;
    Task(int freq, char taskName, int time) {
        this.freq = freq;
        this.taskName = taskName;
        this.timeNextAvl = time;
    }
}
class TaskComparator implements Comparator<Task> {
    @Override
    public int compare(Task a, Task b) {
        return b.freq - a.freq;
    }
}
class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0;i<tasks.length;i++) {
            if (map.containsKey(tasks[i])) {
                map.put(tasks[i], map.get(tasks[i]) + 1);
            } else {
                map.put(tasks[i], 1);
            }
        }
        PriorityQueue<Task> pq = new PriorityQueue<>(new TaskComparator());
        for (Character ch: map.keySet()) {
            pq.add(new Task(map.get(ch), ch, 0));
        }
        Queue<Task> q = new LinkedList<>();
        int time = 0;
        while (pq.size() != 0 || !q.isEmpty()) {
            time++;
            if (pq.size() != 0) {
                Task task = pq.poll();
                task.freq--;
                if (task.freq > 0) {
                    task.timeNextAvl = time + n;
                    q.add(task);
                }
            }
            
            while (!q.isEmpty() && q.peek().timeNextAvl == time) {
                Task queueTask = q.poll();
                pq.add(queueTask);
            }
        }

        return time;
    }
}
