import javax.security.auth.login.AccountNotFoundException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Random;
import java.lang.String;
import java.math.BigDecimal;

public class BankAccount {
    private AccountOwner _accountOwner;
    private int _accountNum;
    private BigDecimal _balance;

    public BankAccount(AccountOwner accountOwner, double balance){
        _accountOwner = accountOwner;
        _balance = validateBalance(balance);
        _accountNum = NumGenerator(8) ;
    }

    private static int NumGenerator(int n){
        int m = (int) Math.pow(10, n-1);
        return m + new Random().nextInt(9*m);
    }
    public AccountOwner getAccountOwner(){
        return _accountOwner;
    }
    public String getMaskedAccountNumber(){
        String acctStr = Integer.toString(_accountNum);
        String acctMasked = "";
        int length = acctStr.length();
        for (int i=0; i < length-4; i++)
            acctMasked += "*";
        return  acctMasked + acctStr.substring(length-5,length-1);
    }
    public String getFormattedBalance(){
        DecimalFormat df = new DecimalFormat("$#,###,###,###,##0.00");
        return df.format(_balance);
    }
    public long getAccountNumber(){
        return _accountNum;
    }

    public java.math.BigDecimal validateBalance (double balance){
        if (balance < 0){
            return BigDecimal.ZERO;
        } else {
            return BigDecimal.valueOf(balance);
        }
    }
    public java.math.BigDecimal getBalance(){
        return _balance;
    }

    public int deposit(double amount){
        if (amount < 0){
            return ATM.INVALID_AMOUNT;
        }else {
            _balance = _balance.add(BigDecimal.valueOf(amount));
            return ATM.SUCCESS;
        }
    }
    public int withdraw(double amount){
        BigDecimal amt = BigDecimal.valueOf(amount);
        if (amount < 0 ){
            return ATM.INVALID_AMOUNT;
        }else if (amt.compareTo(_balance) == 1){
            return ATM.INSUFFICIENT_FUNDS;
        } else {
            _balance = _balance.subtract(BigDecimal.valueOf(amount));
            return ATM.SUCCESS;
        }
    }
    public int transfer(long account, double amount){
        BigDecimal amt = BigDecimal.valueOf(amount);
        if (amount < 0){
            return ATM.INVALID_AMOUNT;
        }else if(amt.compareTo(_balance) >= 0){
            return ATM.INSUFFICIENT_FUNDS;
        }else {
            BankAccount destination = ATM.lookup(account);
            if (destination == null) {
                return ATM.ACCOUNT_NOT_FOUND;
            } else {
                _balance = _balance.subtract(BigDecimal.valueOf(amount));
                destination.deposit(amount);
                return ATM.SUCCESS;
            }
        }
    }
}
