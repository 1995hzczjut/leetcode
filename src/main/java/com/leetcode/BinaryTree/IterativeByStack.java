package com.leetcode.BinaryTree;

import javafx.geometry.Pos;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

//https://blog.csdn.net/iwshuang/article/details/52013773
//这两个遍历死记也要记住
//1219 把树看成1个root, 做右子树看成整体，一个三角形。把while看成递归
/**
 * 94 144
 *
 * @author Zhancong Huang
 * @date 22:07 2019/3/15
 */
public class IterativeByStack {
    //中序遍历,记忆
    public static List<Integer> Inorder(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        //这里没有先push，下面有的
        TreeNode cur = root;
        //这个循环开始，cur 指向的是新的树的root， 可以看成递归
        while (!stack.isEmpty() || cur != null) {
            //把左边那一绺全扔进去
            //经历到这个结点，但现在用不到，用一个东西存起来
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                //cur = null 代表这个左子树没了。按照中序拿到父节点。cur一个结点代表一棵树
                //处理父节点
                cur = stack.pop();
                list.add(cur.val);
                //父节点处理完了，处理右子树。递归处理,cur指针指过去再循环开始就可以了
                cur = cur.right;
            }
        }
        return list;
    }

    //先序遍历.cur是根节点，代表一颗树
    // while if if
    //先序栈里先有东西，中序没有
    public static List<Integer> Preorder(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        stack.push(cur);
        //1229 注意这个While条件。上面要加额外条件对应一个树是\的形状，栈永远是空的
        //这里不需要，因为cur一致是pop的，思考只有一个节点，写成上面一样IDE都提示死循环了
        while(!stack.isEmpty()){
            //4.20：一定要把cur看成一颗树，while看成递归的过程，栈顶永远是待处理的树
            cur = stack.pop();
            list.add(cur.val);
            if(cur.right!=null)stack.push(cur.right);
            if(cur.left!=null)stack.push(cur.left);
        }
        return list;

    }


    /**
     * 后序。跟先序就两处不同
     */
    public static List<Integer> Postorder(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        stack.push(cur);
        while (!stack.isEmpty()) {
            cur = stack.pop();
            //与中序不同的地方，在于list是addFirst.
            //可以从递归的角度理解
            result.add(0, cur.val);
            //这里顺序也反了
            if(cur.left!=null)stack.push(cur.left);
            if(cur.right!=null)stack.push(cur.right);
        }
        return result;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode raw2_1 = new TreeNode(2);
        TreeNode raw2_2 = new TreeNode(3);
        TreeNode raw3_1 = new TreeNode(4);
        TreeNode raw3_3 = new TreeNode(5);
        TreeNode raw3_4 = new TreeNode(6);
        TreeNode raw4_5 = new TreeNode(7);
        root.left = raw2_1;
        root.right = raw2_2;
        raw2_1.left = raw3_1;
        raw2_2.left = raw3_3;
        raw2_2.right = raw3_4;
        raw3_3.left = raw4_5;
       // System.out.println(Inorder(root));
        System.out.println(Preorder(root));//[1, 2, 4, 3, 5, 7, 6]
        System.out.println(Postorder(root));
    }

}
