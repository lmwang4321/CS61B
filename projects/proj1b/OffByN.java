public class OffByN implements CharacterComparator{

    private int n;
    public OffByN(int N){
        n = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        if(x==y) return false;
        int a = x;
        int b = y;
        if(b-a == n) {
            return true;
        }else {
            return false;
        }
    }
}
