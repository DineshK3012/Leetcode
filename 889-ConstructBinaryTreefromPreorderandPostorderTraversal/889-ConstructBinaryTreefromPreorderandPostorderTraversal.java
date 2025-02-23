    public TreeNode ConstructFromPrePost(int[] preorder, int[] postorder)
    {
        return ConstructFromPrePost(preorder, postorder, 0, preorder.Length - 1, 0, postorder.Length - 1);
    }

    
    private TreeNode ConstructFromPrePost(int[] preorder, int[] postorder, int start1, int end1, int start2, int end2)
    {

        TreeNode root = null;

        if (start1 <= end1)
        {
            root = new TreeNode(preorder[start1]);

            if (start1 != end1)
            {
                if (preorder[start1+1] == postorder[end2 - 1])
                {
                    root.left = ConstructFromPrePost(preorder, postorder, start1 + 1, end1, start2, end2 - 1);
                }
                else
                {
                    int rightIndex = getIndexFromBack(preorder, end1, start1, postorder[end2 - 1]);
                    int leftIndex = getIndexFromFront(postorder, end2, start2, preorder[start1 + 1]);

                    root.left = ConstructFromPrePost(preorder, postorder, start1 + 1, rightIndex - 1, start2, leftIndex);
                    root.right = ConstructFromPrePost(preorder, postorder, rightIndex, end1, leftIndex + 1, end2 - 1);

                }
            }

        }
        return root;
    }


    private int getIndexFromBack(int[] arr, int end, int start, int searchValue)
    {
        for (int i = end; i >= start; i--)
        {
            if (arr[i] == searchValue) return i;
        }
        return -1;
    }

    private int getIndexFromFront(int[] arr, int end, int start, int searchValue)
    {
        for (int i = start; i <= end; i++)
        {
            if (arr[i] == searchValue) return i;
        }
        return -1;
    }
   