package od2023.onehundred;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main28 {

    /*

    任务调度

    现有一个CPU 和 一些任务需要处理，已提前获知某个任务的ID，优先级，所需执行时间 和 到达时间
    CPU同时只能运行一个任务，请编写一个任务调度程序

    输入有若干行，每一行有四个数字，分别为任务ID, 任务优先级， 执行时间 和 到达时间

    输出，按照任务执行结束的顺序  任务ID，任务结束时间

     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedList<Task> list = new LinkedList<>();

        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if ("".equals(s)) break;
            Integer[] arr = Arrays.stream(s.split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            Task task = new Task(arr[0], arr[1], arr[2], arr[3]);
            list.add(task);
        }

        getResult(list);
    }

    /**
     *
     * 优先队列
     * @param tasks 任务列表
     */
    public static void getResult(LinkedList<Task> tasks) {
        PriorityQueue<Task> pq =
                new PriorityQueue<>(
                        (a, b) -> a.priority != b.priority ? b.priority - a.priority : a.arrived - b.arrived);

        pq.offer(tasks.removeFirst());
        int curTime = pq.peek().arrived; // curTime记录当前时刻

        while (tasks.size() > 0) {
            Task curtTask = pq.peek(); // 当前正在运行的任务curtTask
            Task nextTask = tasks.removeFirst(); // 下一个任务nextTask

            int curtTask_endTime = curTime + curtTask.need; // 当前正在运行任务的“理想”结束时间

            if (curtTask_endTime > nextTask.arrived) { // 如果当前正在运行任务的理想结束时间  超过了  下一个任务的开始时间
                curtTask.need -= nextTask.arrived - curTime; // 先不看优先级，先将当前任务可以运行的时间减去
                curTime = nextTask.arrived;
            } else { // 如果当前正在运行任务的理想结束时间  没有超过  下一个任务的开始时间，则当前任务可以执行完
                pq.poll(); // 当前任务出队
                System.out.println(curtTask.id + " " + curtTask_endTime); // 打印执行完的任务的id和结束时间
                curTime = curtTask_endTime;

                if (nextTask.arrived > curtTask_endTime) { // 如果当前任务结束时，下一次任务还没有达到，那么存在CPU空转(即idle)
                    while (pq.size() > 0) { // 此时，我们应该从优先队列中取出最优先的任务出来执行，逻辑同上
                        Task idleTask = pq.peek();
                        int idleTask_endTime = curTime + idleTask.need;

                        if (idleTask_endTime > nextTask.arrived) {
                            idleTask.need -= nextTask.arrived - curTime;
                            break;
                        } else {
                            pq.poll();
                            System.out.println(idleTask.id + " " + idleTask_endTime);
                            curTime = idleTask_endTime;
                        }
                    }
                    curTime = nextTask.arrived;
                }
            }

            pq.offer(nextTask);
        }

        // 所有任务都加入优先队列后，我们就可以按照优先队列的安排，顺序取出任务来执行了
        while (pq.size() > 0) {
            Task pollTask = pq.poll();
            int pollTask_endTime = curTime + pollTask.need;
            System.out.println(pollTask.id + " " + pollTask_endTime);
            curTime = pollTask_endTime;
        }
    }

    static class Task {
        int id; // 任务id
        int priority; // 任务优先级
        int need; // 任务执行时长
        int arrived; // 任务到达时刻

        public Task(int id, int priority, int need, int arrived) {
            this.id = id;
            this.priority = priority;
            this.need = need;
            this.arrived = arrived;
        }
    }

}
