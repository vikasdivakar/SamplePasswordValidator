import com.pasword.validator.PasswordChecker;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PasswordCheckerTest {
    private String password;
    private static PasswordChecker passwordChecker;
    private boolean expected;

    public PasswordCheckerTest(String str, boolean expected) {
        this.password = str;
        this.expected = expected;
    }

    @BeforeClass
    public static void initialize() {
        passwordChecker = new PasswordChecker();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
                {"VIKAS12",false },
                { " vika12", true },
                { " VIKA12", false },
                { "", false },
                { "vikas", false },
                { "Vikas12", true   },
                {"Vikaskv@",true },
                { "Vikaskv123", true } };

        return Arrays.asList(data);
    }

    @Test
    public void test() {
        boolean output = passwordChecker.isValidPassword(this.password);
        assertEquals("Result", this.expected, output);

    }


}
