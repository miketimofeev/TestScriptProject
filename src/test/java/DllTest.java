import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.facilia.math.klu.KLU;

public class DllTest {
    private KLU klu;
    private double[] b;
    private double[] bi;

    @BeforeEach
    public void setUp() {
        klu = new KLU();
        b = new double[]{1, 2, 3};
        bi = new double[]{1, 2, 0};
    }

    @Test
    public void test() throws Exception {
        int[] ri = {0, 1, 2, 0, 1, 2, 0, 1, 2};
        int[] cp = {0, 3, 6, 9};

        double[] realAndComplexA = {1.0, 1.0, 4.0, 2.0, 7.0, 1.0, 2.0, 0.0, 5.0, 3.0, 8.0, 0.0, 3.0, 1.0, 6.0, 0.0,
                9.0, 0.0};


        double[] kluAnswer = b.clone();
        double[] kluAnsweri = bi.clone();

        Assertions.assertDoesNotThrow(() -> {
            klu.factorizeComplex(3, cp, ri, realAndComplexA);
            klu.solveComplex(kluAnswer, kluAnsweri);
        });
    }
}
