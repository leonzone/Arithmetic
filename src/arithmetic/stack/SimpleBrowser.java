package arithmetic.stack;

/**
 * @author: reiserx
 * Date:2019/3/28
 * Des:模仿浏览器前进、后退
 */
public class SimpleBrowser {


    private LinkedListBasedStack forwardStack = new LinkedListBasedStack();
    private LinkedListBasedStack backStack = new LinkedListBasedStack();
    String currentUrl;


    public void go(String url) {
        if (this.currentUrl != null) {
            this.backStack.push(this.currentUrl);
            this.forwardStack.clean();
        }
        loadUrl(url);
    }

    private void loadUrl(String url) {
        currentUrl = url;
    }

    public void goBack() {
        if (canGoBack()) {
            String url = backStack.pop();
            forwardStack.push(currentUrl);
            loadUrl(url);
        }
    }

    public void goForward() {
        if (canGoForward()) {
            String url = forwardStack.pop();
            backStack.push(url);
            loadUrl(url);
        }

    }

    public boolean canGoBack() {
        return backStack.size > 0;
    }

    public boolean canGoForward() {
        return forwardStack.size > 0;
    }

    public class LinkedListBasedStack {
        ListNode top = null;
        public int size = 0;

        public void push(String item) {
            ListNode newNode = new ListNode(item);
            if (top == null) {
                top = newNode;
            } else {
                newNode.next = top;
                top = newNode;
            }
            this.size++;
        }

        public String pop() {
            if (top == null) {
                return null;
            } else {
                ListNode node = top;
                top = top.next;
                if (this.size > 0) {
                    this.size--;
                }
                return node.val;
            }
        }

        public void clean() {
            top = null;
            size = 0;
        }
    }


    public class ListNode {

        public String val;
        public ListNode next;

        public ListNode(String x) {
            val = x;
            next = null;
        }
    }


    public static void main(String[] args) {
        SimpleBrowser simpleBrowser = new SimpleBrowser();

        simpleBrowser.go("http://www.baidu.com");
        simpleBrowser.go("http://news.baidu.com");
        simpleBrowser.go("http://news.baidu.com/lady");
        simpleBrowser.goBack();
        simpleBrowser.goBack();
        System.out.println(simpleBrowser.currentUrl);
        simpleBrowser.goForward();
        System.out.println(simpleBrowser.currentUrl);
        simpleBrowser.go("http://news.baidu.com/car");
        simpleBrowser.go("http://www.qq.com");
        simpleBrowser.goBack();
        simpleBrowser.goBack();
        System.out.println(simpleBrowser.currentUrl);
        simpleBrowser.goForward();
        System.out.println(simpleBrowser.currentUrl);
    }

}
