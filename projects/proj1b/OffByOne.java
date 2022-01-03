public class OffByOne implements CharacterComparator{
    @Override
    public boolean equalChars(char x, char y) {
        if(x==y) return false;
        int a = x;
        int b = y;
        if(b-a == 2) {
            return true;
        }else {
            return false;
        }
    }
}
