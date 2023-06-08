package top.knos.jdk21.SequencedCollections;

import java.util.*;

/**
 * 一个具有明确定义的出现顺序，支持两端操作，并可反转的集合。顺序集合的元素具有遍历顺序，其中元素从第一个元素到最后一个元素形成一个线性排列的概念。对于任意两个元素，一个元素要么在另一个元素之前（更靠近第一个元素），要么在其之后（更靠近最后一个元素）。（注意，这个定义并不意味着元素在计算机内存中的物理位置等实际位置。）
 * 从 Collection 接口继承的多个方法需要按照集合的遍历顺序操作元素。例如，迭代器方法提供从第一个元素开始的元素，依次遍历到最后一个元素。其他需要按照遍历顺序操作元素的方法包括：forEach、parallelStream、spliterator、stream 以及所有的 toArray 方法重载。
 * 此接口提供在集合两端添加、检索和删除元素的方法。
 * 此接口还定义了 reversed 方法，提供此集合的反向排序视图。在反向排序视图中，首元素和尾元素的概念是颠倒的，后继元素和前驱元素的概念也是颠倒的。此集合的第一个元素是反向排序视图的最后一个元素，反之亦然。此集合中某个元素的后继元素在反向视图中是其前驱元素，反之亦然。所有尊重集合遍历顺序的方法都会像遍历顺序被反转一样操作。例如，反向视图的迭代器方法会按照从此集合的最后一个元素到第一个元素的顺序报告元素。reversed 方法的可用性及其对所有适用方法的排序语义的影响，使得可以方便地按照正向或反向顺序迭代、搜索、复制和流式处理此集合的元素。
 * 此类是 Java 集合框架的成员。
 *
 */
public interface SequencedCollection_CN<E> extends Collection<E> {
    /**
     * 返回此集合的反向排序视图。返回视图中元素的遍历顺序是此集合元素遍历顺序的反转。反向排序影响所有受顺序影响的操作，包括返回视图的视图集合的操作。如果集合实现允许修改此视图，则修改会“写入”到基础集合中。对基础集合的更改可能会在此反向视图中可见，也可能不可见，这取决于实现。
     */
    java.util.SequencedCollection<E> reversed();

    /**
     * 将一个元素添加为此集合的第一个元素（可选操作）。操作成功完成后，给定的元素将成为此集合的成员，并且它将是遍历顺序中的第一个元素。
     */
    default void addFirst(E e) {
        throw new UnsupportedOperationException();
    }

    /**
     * 将一个元素添加为此集合的最后一个元素（可选操作）。操作成功完成后，给定的元素将成为此集合的成员，并且它将是遍历顺序中的最后一个元素。
     */
    default void addLast(E e) {
        throw new UnsupportedOperationException();
    }

    /**
     * 获取此集合的第一个元素。
     */
    default E getFirst() {
        return this.iterator().next();
    }

    /**
     * 获取此集合的最后一个元素。
     */
    default E getLast() {
        return this.reversed().iterator().next();
    }

    /**
     * 移除并返回此集合的第一个元素（可选操作）。
     */
    default E removeFirst() {
        var it = this.iterator();
        E e = it.next();
        it.remove();
        return e;
    }

    /**
     * 移除并返回此集合的最后一个元素（可选操作）。
     */
    default E removeLast() {
        var it = this.reversed().iterator();
        E e = it.next();
        it.remove();
        return e;
    }
}
