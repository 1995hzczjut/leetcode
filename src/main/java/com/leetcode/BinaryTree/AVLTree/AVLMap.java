package com.leetcode.BinaryTree.AVLTree;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BSTree Map
 *
 * @author Zhancong Huang
 * @date 10:33 2018/10/8
 */
public class AVLMap<K, V> implements Iterable<AVLEntry<K, V>> {

    private int size;

    /**
     * 只是一个引用（指针）
     */
    private AVLEntry<K, V> root;

    /**
     * 比的是key.
     */
    private Comparator<K> comparator;

    /**
     * 比较大小
     */
    @SuppressWarnings("unchecked")
    private int compare(K a, K b) {
        if (comparator != null) {
            return comparator.compare(a, b);
        } else {
            //K 实现了comparable接口。可以直接向上转型，没有实现自己会抛异常
            Comparable<K> c = (Comparable<K>) a;
            return c.compareTo(b);
        }
    }

    public AVLMap(Comparator<K> comparator) {
        this.comparator = comparator;
    }

    public AVLMap() {
    }

    public int size() {
        return size;
    }

    public Boolean isEmpty() {
        return size == 0;
    }

    /**
     * 插入方法
     */
    public V put(K key, V value) {
        //根节点为空，直接插入
        if (root == null) {
            root = new AVLEntry<>(key, value);
            size++;
            return value;
        }
        AVLEntry<K, V> p = root;
        while (p != null) {
            if (compare(key, p.key) == 0) {
                p.setValue(value);
                size++;
                break;
            } else if (compare(key, p.key) < 0) {
                if (p.left == null) {
                    p.left = new AVLEntry<>(key, value);
                    size++;
                    break;
                } else {
                    p = p.left;
                }
            } else {
                if (p.right == null) {
                    p.right = new AVLEntry<>(key, value);
                    size++;
                    break;
                } else {
                    p = p.right;
                }
            }
        }
        return value;
    }

    @Override
    public Iterator<AVLEntry<K, V>> iterator() {
        return new AVLIterator<>(root);
    }

    /**
     * 根据key查找Entry.跟插入的逻辑一样
     */
    private AVLEntry<K, V> getEntry(K key) {
        AVLEntry<K, V> p = root;
        while (p != null) {
            if (compare(key, p.key) == 0) {
                break;
            } else if (compare(key, p.key) < 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return p;
    }

    /**
     * map接口的get.
     */
    public V get(K key) {
        AVLEntry<K, V> p = getEntry(key);
        return p == null ? null : p.getValue();
    }

    /**
     * 查找是否包含key。O（logN）
     */
    public boolean containsKey(K key) {
        AVLEntry<K, V> p = getEntry(key);
        return p != null;
    }

    /**
     * 查找是否包含value。O（N）。是非常慢的。
     */
    public boolean containsValue(V value) {
        Iterator<AVLEntry<K, V>> iterator = this.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 最小的key的entry
     */
    public AVLEntry<K, V> getFirstEntry(AVLEntry<K, V> p) {
        if (p != null) {
            while (p.left != null) {
                p = p.left;
            }
        }
        return p;
    }

    /**
     * 最大的key的entry
     */
    public AVLEntry<K, V> getLastEntry(AVLEntry<K, V> p) {
        if (p != null) {
            while (p.right != null) {
                p = p.right;
            }
        }
        return p;
    }

    /**
     * remove.成功返回oldvalue
     */
    public V remove(K key) {
        AVLEntry<K, V> p = getEntry(key);
        if (p == null) {
            return null;
        }
        V oldValue = p.value;
        root = deleteEntry(root, key);
        size--;
        return oldValue;
    }

    /**
     * 涉及到引用的问题。弄清逻辑结构和物理结构
     * 注意这组参数是经典的组合，适合递归
     *
     * @param p   在p为根节点的子树里删除。代表一个子树
     * @param key
     * @return 返回的是子树的根节点的新的引用。可能根节点已经更新。
     */
    private AVLEntry<K, V> deleteEntry(AVLEntry<K, V> p, K key) {
        if (p == null) {
            return null;
        } else {
            if (compare(key, p.key) == 0) {
                //正好删除这个
                // 子树的根节点
                if (p.left == null && p.right == null) {
                    p = null;
                } else if (p.left != null) {
                    //引用变量的赋值。即指针的赋值
                    p = p.left;
                } else if (p.right != null) {
                    p = p.right;
                } else {
                    if (size % 2 == 0) {
                        AVLEntry<K, V> rightMin = getFirstEntry(p.right);
                        //直接换节点比较麻烦。
                        p.key = rightMin.key;
                        p.value = rightMin.value;
                        p.right = deleteEntry(p.right, key);
                    } else {
                        AVLEntry<K, V> leftMax = getLastEntry(p.right);
                        p.key = leftMax.key;
                        p.value = leftMax.value;
                        p.left = deleteEntry(p.left, key);
                    }
                }
            } else if (compare(key, p.key) < 0) {
                //要去p的左子树找了
                p.left = deleteEntry(p.left, key);
            } else {
                p.right = deleteEntry(p.right, key);
            }
        }

        return p;
    }


    /**
     * 层级输出
     */
    public void levelOrder(){
        Queue<AVLEntry<K, V>> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            //比较重要，一层的长度正好等于此时的队列size
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                AVLEntry<K, V> temp = queue.poll();
                System.out.print(temp.key + " ");
                if(temp.left != null){
                    queue.offer(temp.left);
                }
                if(temp.right != null){
                    queue.offer(temp.right);
                }
            }
            System.out.println();
        }
    }


}
