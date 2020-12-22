package sample;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @org.junit.jupiter.api.Test
    void findFoodkaffe() {
        Controller controller = new Controller();
        assertEquals("src\\sample\\opskifter\\kaffe.txt",controller.FindFood("kaffe"));
    }
    @org.junit.jupiter.api.Test
    void findFoodnotfromlist() {
        Controller controller = new Controller();
        assertEquals("src\\sample\\opskifter\\foodnotfound.txt",controller.FindFood("Gustav"));
    }
    @org.junit.jupiter.api.Test
    void findFoodte() {
        Controller controller = new Controller();
        assertEquals("src\\sample\\opskifter\\te.txt",controller.FindFood("te"));
    }
    @org.junit.jupiter.api.Test
    void findFoodFail() {
        Controller controller = new Controller();
        assertEquals("src\\sample\\opskifter\\kaffe.txt",controller.FindFood("Kaffe"));
    }

}