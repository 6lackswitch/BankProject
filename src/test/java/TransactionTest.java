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
        String balance = LoginPage.getInstance()
                .customerLogin()
                .loginAs("Harry Potter")
                .depositClick()
                .setTransaction(fibonacciInt())
                .getBalance();

        Assert.assertEquals(balance, fibonacciInt());

        balance = AccountPage.getInstance()
                .withdrawlClick()
                .setTransaction(fibonacciInt())
                .getBalance();

        Assert.assertEquals(balance, "0");

        Table table = AccountPage
                .getInstance()
                .transactionsClick()
                .getTable();

        Assert.assertEquals(table.getRows().size(), 2);

        TransactionsPage.getInstance()
                .extractToCsv(table);
    }
}
