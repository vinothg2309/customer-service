import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class EncodeDecode {

    public static  void main(String[] args) {
        /*byte[] underscored = "root_user".getBytes(StandardCharsets.UTF_8);
        System.out.println(Base64.getUrlDecoder().decode(underscored));

        byte[] dashed = "root_pwd".getBytes(StandardCharsets.UTF_8);
        System.out.println(Base64.getUrlDecoder().decode(dashed));*/
        String encodedEmail = new String(Base64.getEncoder().encode(
               "root_user".getBytes(StandardCharsets.UTF_8)));
        System.out.println(encodedEmail);

        String encodedPwd = new String(Base64.getEncoder().encode(
                "root_pwd".getBytes(StandardCharsets.UTF_8)));
        System.out.println(encodedPwd);
    }
}
