package unionfind;

/**
 * Created by reiserx on 2017/12/10.
 */
public class UF {
    int count;
    int[] id;

    public UF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    public int getCount() {
        return count;
    }

    public boolean isconnected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        return p;
    }

    public void union(int p, int q) {

    }
}
