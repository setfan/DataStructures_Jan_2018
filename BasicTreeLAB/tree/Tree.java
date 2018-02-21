package tree;

import java.util.*;
import java.util.function.Consumer;

public class Tree<T> {
    private T value;
    private List<Tree<T>> chilrden;

    public Tree(T value, Tree<T>... children) {
        this.value = value;
        this.chilrden = Arrays.asList(children);

    }

    public String print(int indent, StringBuilder builder) {

        for (int i = 0; i < indent; i++) {
             builder.append("  ");
        }
        builder.append(this.value).append("\n");

        for (Tree<T> child : chilrden) {
            child.print(indent+1, builder);
        }

        return builder.toString();
    }

    public void each(Consumer<T> consumer) {
        consumer.accept(this.value);

        for (Tree<T> child : chilrden) {
            child.each(consumer);
        }
    }

    public Iterable<T> orderDFS() {

        List<T> result = new ArrayList<>();
        
        this.dfs(result);

        return result;
    }

    private void dfs(List<T> result) {

        for (Tree<T> elem : this.chilrden) {
            elem.dfs(result);
        }

        result.add(this.value);
    }

    public Iterable<T> orderBFS() {
        List<T> result = new ArrayList<>();
        Deque<Tree<T>> queue = new ArrayDeque<>();
        queue.add(this);

        while (!queue.isEmpty()){
            Tree<T> current = queue.poll();
            queue.addAll(current.chilrden);

            result.add(current.value);
        }

        return result;
    }

}