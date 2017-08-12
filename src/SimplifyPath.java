import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class SimplifyPath {

	// iterative
    public static String simplifyPath(String path) {
        StringBuilder res = new StringBuilder();
        res.append("/");
        String[] stubs = path.split("/+");
        List<String> paths = new ArrayList<String>();
        for (String s: stubs) {
            if (s.equals("..")) {
                if (paths.size() > 0) {
                    paths.remove(paths.size() - 1);
                }
            } else if (!s.equals(".") && !s.equals("")) {
                paths.add(s);
            }
        }
        for (String p: paths) {
            res.append(p + "/");
        }
        if (res.length() > 1) {
            res.deleteCharAt(res.length() - 1);
        }
        return res.toString();
    }
    
    public static String simplifyPath2(String path) {
        if (path == null || path.length() == 0) {
            return "";
        }
        String[] table = path.split("/+");
        Stack<String> stack = new Stack<String>();
        StringBuilder res = new StringBuilder();
        for (String s: table) {
            if (s.equals(".") || s.equals("")) {
            	System.out.println("yes");
                continue;
            }
            if (s.equals("..")) {
                if (stack.empty()) {
                    continue;
                } else {
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
        }
        while (!stack.empty()) {
            res.insert(0, "/" + stack.pop());
        }
        if (res.length() == 0) {
            res.append('/');
        }
        return res.toString();
    }
    
    // unit test
    public static void main(String[] args) {
    	String path = "/a/./b/../../c/";
    	System.out.println(simplifyPath2(path)); //"/c"
    }
}
