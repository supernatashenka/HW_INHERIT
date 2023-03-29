
import java.util.Objects;
public class Todos {

    public class Task {
        protected int id;

        public Task(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Task task = (Task) o;
            return id == task.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

    public class SimpleTask extends Task {
        protected String title;

        public SimpleTask(int id, String title) {
            super(id); // вызов родительского конструктора
            this.title = title; // заполнение своих полей
        }

        public String getTitle() {
            return title;
        }
    }


    public class Epic extends Task {

        protected String [] subtasks;


        public Epic ( int id, String[]Subtasks){
            super(id);


            /// String[] subtasks--- как заполнить свои данные
            // (не наследуемые от родительского класса), если это массив данных?


        }
    }


    public class Meeting extends Task {
        protected String topic;
        protected String project;
        protected String start;


        public Meeting(int id, String topic, String project, String start) {
            super(id);
            this.topic = topic;
            this.project = project;
            this.start = start;
        }
    }

    private Task[] tasks = new Task[0];
    private Task[] addToArray(Task[] current, Task task) {
        Task[] tmp = new Task[current.length + 1];
        for (int i = 0; i < current.length; i++) {
            tmp[i] = current[i];
        }
        tmp[tmp.length - 1] = task;
        return tmp;
    }
    public void add(Task task) { // <- вот здесь в параметре может лежать объект и вида SimpleTask, и вида Epic, и вида Meeting
        tasks = addToArray(tasks, task);
    }

    public Task[] findAll() {
        return tasks;
    }
}



