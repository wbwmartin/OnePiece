import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Implement a load balancer for web servers. It provide the following functionality:
//
//        Add a new server to the cluster => add(server_id).
//        Remove a bad server from the cluster => remove(server_id).
//        Pick a server in the cluster randomly with equal probability => pick().
//
//        Example
//        At beginning, the cluster is empty => {}.
//
//        add(1)
//        add(2)
//        add(3)
//        pick()
//        >> 1         // the return value is random, it can be either 1, 2, or 3.
//        pick()
//        >> 2
//        pick()
//        >> 1
//        pick()
//        >> 3
//        remove(1)
//        pick()
//        >> 2
//        pick()
//        >> 3
//        pick()
//        >> 3

public class LoadBalancer {

    private Map<Integer, Integer> map;
    private List<Integer> servers;
    private int n;

    public LoadBalancer() {
        // do intialization if necessary
        map = new HashMap<>();
        servers = new ArrayList<>();
        n = 0;
    }

    /*
     * @param server_id: add a new server to the cluster
     * @return: nothing
     */
    public void add(int server_id) {
        // write your code here
        if (!map.containsKey(server_id)) {
            map.put(server_id, n);
            servers.add(server_id);
            n++;
        }
    }

    /*
     * @param server_id: server_id remove a bad server from the cluster
     * @return: nothing
     */
    public void remove(int server_id) {
        // write your code here
        if (map.containsKey(server_id)) {
            int last = servers.get(n - 1);
            int index = map.get(server_id);
            map.put(last, index);
            map.remove(server_id);
            servers.set(index, last);
            servers.remove(n - 1);
            n--;
        }
    }

    /*
     * @return: pick a server in the cluster randomly with equal probability
     */
    public int pick() {
        // write your code here
        int random = (int) (Math.random() * n);
        return servers.get(random);
    }

    public static void main(String[] args) {
        LoadBalancer lb = new LoadBalancer();
        lb.add(1);
        lb.add(2);
        lb.add(3);
        System.out.println(lb.pick());
        System.out.println(lb.pick());
        System.out.println(lb.pick());
        System.out.println(lb.pick());
        lb.remove(1);
        System.out.println(lb.pick());
        System.out.println(lb.pick());
        System.out.println(lb.pick());
    }
}
