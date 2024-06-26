package JavaIO;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Properties;

public class LoginProp {
    private String propFile;

    public LoginProp(String propFile) {
        this.propFile = propFile;
    }

    //从属性文件中进行用户名密码验证登录
    public Boolean checkProp() throws Exception {
        try {
            //从控制台获得用户名和密码
            System.out.println("请输入用户名···");
            String username = new BufferedReader(
                    new InputStreamReader(System.in)).readLine();
            System.out.println("请输入密码···");
            String password = new BufferedReader(
                    new InputStreamReader(System.in)).readLine();
            Properties prop = new Properties();
            //加载属性文件
            prop.load(new FileInputStream(propFile));
            Enumeration em = prop.propertyNames();
            //hasMoreElements()  测试此枚举是否包含更多的元素
            while (em.hasMoreElements()) {
                String key = em.nextElement().toString();  //获取键值
                if (key.equals(username) && prop.getProperty(key).equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        LoginProp lp = new LoginProp("D:\\SSMS\\java\\Item\\Java Basics\\day001\\src\\JavaIO\\tt5.txt");
        try {
            if (lp.checkProp()) {
                System.out.println("登录成功！");
            } else
                System.out.println("用户名或密码错误！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

