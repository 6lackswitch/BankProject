import Account.AccountPage;
import Login.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Base.Util.fibonacciInt;

public class TransactionTest extends BaseTest {

    @Test
    public void transactionsTest() {
        String balance = new LoginPage()
                .customerLogin()
                .loginAs("Harry Potter")
                .depositClick()
                .setTransaction(fibonacciInt())
                .withdrawlClick()
                .setTransaction(fibonacciInt())
                .getBalance();
        Assert.assertEquals(balance, "0");
        AccountPage
                .getInstance()
                .transactionsClick()
                .table()
                .extractToCsv();
    }
}
