package c332030.utils.data.constant;

public class ConstantWeb {

    public static final String ROOT = "/";
    public static final String TO = "toUrl";

    // File Extension name
    public static final String HTML = ".html";
    public static final String HTM = ".htm";

    public static final String JSP = ".jsp";

    public static final String JS = ".js";
    public static final String CSS = ".css";

    public static final String JPG = ".jpg";
    public static final String GIF = ".gif";
    public static final String PNG = ".png";
    public static final String ICO = ".ico";

    public static final String DOMAIN = "c332030.com";


    public static class Request {

        public static final String USE = "username";
        public static final String PWD = "password";
    }
    
    public static class Cookies{
        public static final Integer MAX_AGE = 24 * 60 * 60 * 7; // 一周

        public static final String LOGIN_INFO_KEY = "c332030.redis.Login";
    }

    // Session Name
    public static class Session {
        public static final String User = "User";
        
        public static final String Message = "Message";
        
        public static final String RequestId = "Request";
        public static final String RequestIdBak = "RequestBak";
    }

    // JSON Key
    public static class Json {
        public static final String Status = "Status";
        public static final String Failure = "Failure";
        public static final String Success = "Success";

        public static final String URL = "url";
    }

    // Action Name
    public static class Action {
        public static final String Index = "Index";

        public static final String User = "User";
        public static final String UserLogin = "User-Login";
        public static final String UserLoginOut = "User-LoginOut";
        public static final String UserInsert = "User-Insert";

        public static final String Login = "Login";
        public static final String LoginEx = "Login.action";

        public static final String VerifyLogin = "VerifyLogin";
        public static final String VerifyLoginEx = "VerifyLogin.action";

        public static final String Main = "Main";

        public static final String Error = "Error";

        public static final String Test = "Test";

        public static final String Close = "Close";
    }

    // JSP
    public static class Jsp {
        public static final String Index = "index.jsp";

        public static final String Login = "login.jsp";

        public static final String Error = "error.jsp";
    }

    // HTML
    public static class Html {

        public static final String TO = "to";

        public static final String Index = "index";
        public static final String IndexEx = "index.html";

        public static final String Login = "login";
        public static final String LoginEx = "login.html";

        public static final String Main = "main";
        public static final String MainEx = "main.html";

        public static final String Error = "error";
        public static final String ErrorEx = "error.html";

        public static final String Close = "close";
        public static final String CloseEx = "close.html";
    }
}
