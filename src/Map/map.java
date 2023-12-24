package Map;
public interface map {

     boolean move(char direction);

    boolean move_up();
    boolean move_down();
    boolean move_left();
    boolean move_right();
    void performMove(int rowDelta, int colDelta);
}
