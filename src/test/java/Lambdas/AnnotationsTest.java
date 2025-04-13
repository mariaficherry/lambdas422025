package Lambdas;

import org.testng.annotations.Test;

import javax.swing.plaf.PanelUI;

public class AnnotationsTest {

    @Test
    public void suppressWarningsTest() {
        @SuppressWarnings("unused")
        int a = 9;
    }

    @VeryImportant
    @Test
    public void customAnnotationTest(){

    }
}
