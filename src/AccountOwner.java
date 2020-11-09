import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.lang.String;
import java.util.regex.Pattern;

public class AccountOwner {
    private String _firstName;
    private String _lastName;
    private String _salutation;
    private String _email;
    private long _phoneNumber;
    private MailingAddress _mailingAddress;

    public AccountOwner(String salutation, String firstname, String lastname, String email, long phoneNumber, MailingAddress mailingAddress){
        _firstName = firstname;
        _lastName = lastname;
        _salutation = validateSalutation(salutation);
        _email = validateEmailAddress(email);
        _phoneNumber = validatePhoneNumber(phoneNumber);
        _mailingAddress = mailingAddress;
    }

    public String getName(int displayType){
        switch (displayType) {
            case ATM.DEFAULT:
                return _firstName + " " + _lastName;
            case ATM.FORMAL:
                return _salutation + ". " + _lastName;
            case ATM.SORTABLE:
                return _lastName + ", " + _firstName;
            default:
                return _firstName + " " + _lastName;
        }
    }
    public String getFirstName(){
        return _firstName;
    }
    public String getLastName(){
        return _lastName;
    }
    public String getSalutation(){
        return _salutation;
    }
    public long getPhoneNumber(){
        return _phoneNumber;
    }
    public String getFormattedPhoneNumber(){
        String mask = "(###) ###-####";
        MaskFormatter maskFormatter = null;
        String phone = null;
        try {
            maskFormatter = new MaskFormatter(mask);
            maskFormatter.setValueContainsLiteralCharacters(false);
            maskFormatter.setMask("(###) ###-####");
            phone = maskFormatter.valueToString(_phoneNumber);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return phone;
    }
    public String getEmailAddress(){
        return _email;
    }
    public MailingAddress getMailingAddress(){
        return _mailingAddress;
    }


    public String validateEmailAddress(String emailAddress){
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        if (pattern.matcher(emailAddress).matches()){
            return emailAddress;
        }else{
            return null;
        }
    }
    public String validateSalutation(String salutation){
        _salutation = salutation;
        int length = _salutation.length();
        if (length <0){
            return null;
        }else if (_salutation == null){
            return null;
        }
        return _salutation;
    }
    public long validatePhoneNumber(long phoneNumber){
        _phoneNumber = phoneNumber;
        int length = Long.toString(_phoneNumber).length();
        if(length < 0){
            return 0L;
        }else if (length > 10){
            return 0L;
        }else {
            return _phoneNumber;
        }

    }

    public void setSalutation(String salutation){
        _salutation = validateSalutation(salutation);
    }
    public void setFirstName(String firstName){
        _firstName = firstName;
    }
    public void setLastName(String lastName){
        _lastName = lastName;
    }
    public void setEmailAddress(String email){
        _email = validateEmailAddress(email);
    }
    public void setPhoneNumber(long phoneNumber){
        _phoneNumber = validatePhoneNumber(phoneNumber);
    }
}
