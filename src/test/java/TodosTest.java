import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodosTest {
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TestSearchInTodosWith1Match() {
        SimpleTask simpleTask = new SimpleTask(66, "Пойти на тренировку");

        String[] subtasks = {"Масло", "Картошка", "Хлеб"};
        Epic epic = new Epic(24, subtasks);

        Meeting meeting = new Meeting(
                569,
                "Распределение задач",
                "Курсовая",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);


        Task[] expected = {simpleTask};

        Task[] actual = todos.search("Пойти");


        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TestSearchInTodosWith2Matches() {
        SimpleTask simpleTask = new SimpleTask(66, "Перестать поглощать хлеб");

        String[] subtasks = {"масло", "картошка", "хлеб"};
        Epic epic = new Epic(24, subtasks);

        Meeting meeting = new Meeting(
                569,
                "Распределение задач",
                "Курсовая",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);


        Task[] expected = {simpleTask, epic};

        Task[] actual = todos.search("хлеб");


        Assertions.assertArrayEquals(expected, actual);
    }

}

