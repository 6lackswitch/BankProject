import Account.AccountPage;
import Account.Table;
import Account.TransactionForm;
import Account.TransactionsPage;
import Login.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Base.Util.fibonacciInt;

public class TransactionTest extends BaseTest {

    @Test
    public void transactionsTest() {
        String balance = new LoginPage(getDriver())
                .customerLogin()
                .loginAs("Harry Potter")
                .depositClick()
                .setTransaction(fibonacciInt())
                .getBalance();

        Assert.assertEquals(balance, fibonacciInt());

        balance = new AccountPage(getDriver())
                .withdrawlClick()
                .setTransaction(fibonacciInt())
                .getBalance();

        Assert.assertEquals(balance, "0");

        Table table = new AccountPage(getDriver())
                .transactionsClick()
                .getTable();

        Assert.assertEquals(table.getRows().size(), 2);

        new TransactionsPage(getDriver())
                .extractToCsv(table);
    }
}
