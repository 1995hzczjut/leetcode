package com.leetcode.BinaryTree;

import java.util.Stack;

/**
 * when you iterate through the preorder traversal string, for each char:

 case 1: you see a number c, means you begin to expand a new tree rooted with c, you push it to stack

 case 2.1: you see a #, while top of stack is a number, you know this # is a left null child, put it there as a mark for next coming node k to know it is being the right child.

 case 2.2: you see a #, while top of stack is #, you know you meet this # as right null child, you now cancel the sub tree (rooted as t, for example) with these two-# children. But wait, after the cancellation, you continue to check top of stack is whether # or a number:

 ---- if a number, say u, you know you just cancelled a node t which is left child of u. You need to leave a # mark to the top of stack. So that the next node know it is a right child.

 ---- if a #, you know you just cancelled a tree whose root, t, is the right child of u. So you continue to cancel sub tree of u, and the process goes on and on.
 *
 * @author Zhancong Huang
 * @date 18:11 2019/6/7
 */
public class _331 {

    public static boolean isValidSerialization(String preorder) {
        // using a stack, scan left to right
        // case 1: we see a number, just push it to the stack
        // case 2: we see #, check if the top of stack is also #
        // if so, pop #, pop the number in a while loop, until top of stack is not #
        // if not, push it to stack
        // in the end, check if stack size is 1, and stack top is #
        if (preorder == null) {
            return false;
        }
        Stack<String> st = new Stack<>();
        String[] strs = preorder.split(",");
        for (int pos = 0; pos < strs.length; pos++) {
            String curr = strs[pos];
            while (curr.equals("#") && !st.isEmpty() && st.peek().equals(curr)) {
                //此时代表栈中最顶层的非#节点对应的子树左右子树都是空，我们应该把这个子树全排除掉
                //所以pop两次
                st.pop();
                if (st.isEmpty()) {
                    return false;
                }
                st.pop();
            }
            //curr是#代表的是之前3个值
            st.push(curr);
        }
        return st.size() == 1 && st.peek().equals("#");
    }

    public static void main(String[] args) {
        System.out.println(isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }
}
