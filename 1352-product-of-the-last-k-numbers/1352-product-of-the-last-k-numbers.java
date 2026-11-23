import java.util.ArrayList;

class ProductOfNumbers {

    ArrayList<Integer> prefix;

    public ProductOfNumbers() {
        prefix = new ArrayList<>();
        prefix.add(1);
    }

    public void add(int num) {

        if (num == 0) {
            prefix.clear();
            prefix.add(1);
        } 
        else {
            int lastProduct = prefix.get(prefix.size() - 1);
            prefix.add(lastProduct * num);
        }
    }

    public int getProduct(int k) {

        int n = prefix.size();

        if (k >= n) {
            return 0;
        }

        int totalProduct = prefix.get(n - 1);
        int previousProduct = prefix.get(n - 1 - k);

        return totalProduct / previousProduct;
    }
}


/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */