import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    @Test
    public void TestMatchesInSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");


        boolean actual = simpleTask.matches("родителям");
        Assertions.assertTrue(actual);
    }

    @Test
    public void TestMatchesInEpic() {
        String[] subtasks = {"Масло", "Соль", "Перец"};
        Epic epic = new Epic(68, subtasks);

        boolean actual = epic.matches("Соль");
        Assertions.assertTrue(actual);
    }

    @Test
    public void TestMatchesInMeeting() {

        Meeting meeting = new Meeting(65, "Распределить задачи", "Курсовая работа", "03/04/2023");


        boolean actual = meeting.matches("работа");
        Assertions.assertTrue(actual);
    }


}